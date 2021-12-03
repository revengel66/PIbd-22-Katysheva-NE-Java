import javax.swing.*;
import java.awt.*;
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
    private JFrame frameParking;
    private JComponent drawParking;
    private Excavator ex;

    private Parking<TrackedVehicle, IRollers> parking;

    private DrawParking draw;
    public FormParking(){
        frameParking = new JFrame("Parking");
        frameParking.setSize(new Dimension(1000, 700));
        frameParking.setDefaultCloseOperation(frameParking.EXIT_ON_CLOSE);
        ParkTracVehButton.addActionListener(e -> createTrackedVehicle());
        ParkExButton.addActionListener(e -> createExcavator());
        buttonDelete.addActionListener(e -> deleteTransport());
        frameParking.add(MainPanel);
        frameParking.setVisible(true);
        draw = new DrawParking();
        parking = new Parking<TrackedVehicle, IRollers>(MainPanel.getWidth(), MainPanel.getHeight());
        draw.setParking(parking);
        MainPanel.add(draw);
        draw.repaint();
    }
    private void createTrackedVehicle(){
        Random rnd = new Random();
        Color selectedColor = new JColorChooser().showDialog(frameParking, "Choose a color", Color.YELLOW);
        if (selectedColor != null){
            TrackedVehicle tv = new TrackedVehicle(rnd.nextInt(200)+100, rnd.nextInt(2000)+1000, selectedColor);
            if(draw.getParking().add(tv) != -1){
                draw.repaint();
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
                if (draw.getParking().add(ex) != -1) {
                    draw.repaint();
                } else {
                    JOptionPane.showMessageDialog(frameParking, "The parking lot is full");
                }
            }
        }
    }
    private void deleteTransport(){
        if (textAreaPlace.getText() != ""){
            ITransport transport = draw.getParking().delete(Integer.parseInt((textAreaPlace.getText())));
            if (transport != null){
                FormExcavator form = new FormExcavator();
                form.setVehicle(transport);
            }
        }
        draw.repaint();
    }
}
