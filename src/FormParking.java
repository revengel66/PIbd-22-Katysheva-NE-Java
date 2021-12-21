import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class FormParking{
    private JPanel MainPanel;
    private JPanel rightPanel;
    private JButton ParkTracVehButton;
    private JButton ParkExButton;
    private JPanel buttonsPanel;
    private JLabel TakeCarLabel;
    private JPanel GroupTakeCarPanel;
    private JLabel LabelPlace;
    private JTextArea textAreaPlace;
    private JButton buttonDelete;
    private JComboBox comboBoxRollers;
    private JComboBox comboBoxType;
    private JTextField textBoxNewLevelName;
    private JButton buttonAddPark;
    private JList<String> listBoxParkings;
    private JButton buttonDelPark;
    private JButton buttonSet;
    private JFrame frameParking;
    private Excavator ex;
    private DefaultListModel<String> parkingList;
    private ParkingCollection parkingCollection;
    private LinkedList<TrackedVehicle> trackedVehicleList;

    private DrawParking draw;
    public FormParking(){
        frameParking = new JFrame("Parking");
        frameParking.setSize(new Dimension(1000, 700));
        frameParking.setDefaultCloseOperation(frameParking.EXIT_ON_CLOSE);
        frameParking.add(MainPanel);
        frameParking.setVisible(true);
        parkingCollection = new ParkingCollection(MainPanel.getWidth()-rightPanel.getWidth(),  MainPanel.getHeight());
        draw = new DrawParking(parkingCollection);
        MainPanel.add(draw);
        parkingList = new DefaultListModel<>();
        listBoxParkings.setModel(parkingList);
        trackedVehicleList = new LinkedList<>();
        ParkTracVehButton.addActionListener(e -> createTrackedVehicle());
        ParkExButton.addActionListener(e -> createExcavator());
        buttonAddPark.addActionListener(e -> addParking());
        buttonDelPark.addActionListener(e -> delParking());
        listBoxParkings.addListSelectionListener(e -> listListener());
        buttonDelete.addActionListener(e -> SetTransport());
        buttonSet.addActionListener(e -> GetTransport());
        frameParking.repaint();
    }
    private void createTrackedVehicle(){
        Random rnd = new Random();
        Color selectedColor = new JColorChooser().showDialog(frameParking, "Choose a color", Color.YELLOW);
        if (selectedColor != null){
            TrackedVehicle tv = new TrackedVehicle(rnd.nextInt(200)+100, rnd.nextInt(2000)+1000, selectedColor);
            if(parkingCollection.get((String) listBoxParkings.getSelectedValue()).add(tv) != -1){
                frameParking.repaint();
            }
            else {JOptionPane.showMessageDialog(frameParking, "The parking lot is full");}
        }
    }
    private void createExcavator(){
        Random rnd = new Random();
        Color selectedColor = new JColorChooser().showDialog(frameParking, "Choose a color", Color.YELLOW);
        if (selectedColor != null){
            Color selectedColorDop = new JColorChooser().showDialog(frameParking, "Choose a color", Color.GRAY);
            if (selectedColorDop != null) {
                ex = new Excavator(rnd.nextInt(200)+100, rnd.nextInt(2000)+1000, selectedColor, selectedColorDop, true, true, true, true, true, comboBoxRollers.getSelectedIndex(), comboBoxType.getSelectedItem().toString());
                if(parkingCollection.get((String) listBoxParkings.getSelectedValue()).add(ex) != -1){
                    frameParking.repaint();
                }
            } else {
                JOptionPane.showMessageDialog(frameParking, "The parking lot is full");
            }
        }
    }

    private void GetTransport() {
        if (listBoxParkings.getSelectedIndex() >= 0) {
            if (!textBoxNewLevelName.getText().equals("")) {
                try {
                    TrackedVehicle car = (parkingCollection.get((String)(listBoxParkings.getSelectedValue()))).delete(Integer.parseInt(textAreaPlace.getText()));
                    if (car != null) {
                        trackedVehicleList.add(car);
                        frameParking.repaint();
                    } else {
                        JOptionPane.showMessageDialog(frameParking, "Транспорта с таким индексом нет!");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(frameParking, "Транспорта с таким индексом нет!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(frameParking, "Парковка не выбрана");
        }
    }
    private void SetTransport() {
        if (!trackedVehicleList.isEmpty()) {
            FormExcavator formEx = new FormExcavator();
            formEx.setVehicle(trackedVehicleList.get(0));
            trackedVehicleList.remove(0);
            frameParking.repaint();
        }
    }
    private void reloadLevels() {
        int index = listBoxParkings.getSelectedIndex();
        parkingList.removeAllElements();
        int i = 0;
        for (String name : parkingCollection.keySet()) {
            parkingList.add(i, name);
            i++;
        }
        int itemsCount = parkingList.size();
        if (itemsCount > 0 && (index < 0 || index >= itemsCount)) {
            listBoxParkings.setSelectedIndex(0);
        } else if (index >= 0 && index < itemsCount) {
            listBoxParkings.setSelectedIndex(index);
        }
    }
    private void addParking() {

        if (!textBoxNewLevelName.getText().equals("")) {
            parkingCollection.AddParking(textBoxNewLevelName.getText());
            reloadLevels();
            frameParking.repaint();
        } else {
            JOptionPane.showMessageDialog(draw, "Введите название стоянки");
        }
    }
    private void delParking() {
        if (listBoxParkings.getSelectedIndex() >= 0) {
            int result = JOptionPane.showConfirmDialog(draw, "Удалить стоянку " + listBoxParkings.getSelectedValue() + "?");
            if (result == JOptionPane.YES_OPTION) {
                parkingCollection.DelParking((String) listBoxParkings.getSelectedValue());
                reloadLevels();
                frameParking.repaint();
            }
        } else {
            JOptionPane.showMessageDialog(draw, "Стоянка не выбран");
        }
    }
    private void listListener() {
        draw.setSelectedItem(listBoxParkings.getSelectedValue());
        frameParking.repaint();
    }
}
