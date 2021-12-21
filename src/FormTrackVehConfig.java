import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeListener;

public class FormTrackVehConfig {
    Vehical vehicle;
    FormParking formParking;

    private  JFrame frame;
    private  DrawTransport drawTransport;

    private JSpinner spinnerWeight;
    private JSpinner spinnerMaxSpeed;
    private JCheckBox checkBoxBucket;
    private JCheckBox checkBoxHandle;
    private JCheckBox checkBoxArrow;
    private JCheckBox checkBoxСounterWeight;
    private JCheckBox checkBoxRollers;
    private JSpinner spinnerRollersCount;

    private JLabel labelPictureBox;

    public FormTrackVehConfig(FormParking formParking) {

        this.formParking = formParking;

        frame = new JFrame("Конфигурация транспорта");
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(null);

        JButton buttonAddTransport = new JButton("Добавить");
        buttonAddTransport.setBounds(220, 420, 200, 80);
        buttonAddTransport.addActionListener(e -> addVehicle());
        frame.getContentPane().add(buttonAddTransport);

        JButton buttonCancel = new JButton("Отменить");
        buttonCancel.setBounds(440, 420, 200, 80);
        buttonAddTransport.addActionListener(e -> cancel());
        frame.getContentPane().add(buttonCancel);

        JPanel groupRollers = new JPanel();
        groupRollers.setBorder(BorderFactory.createTitledBorder("Виды катков"));
        groupRollers.setBounds(650, 180, 210, 230);
        groupRollers.setLayout(null);
        frame.getContentPane().add(groupRollers);

        JLabel labelRollersUsual = new JLabel("Обычные");
        labelRollersUsual.setHorizontalAlignment(SwingConstants.CENTER);
        labelRollersUsual.setBorder(BorderFactory.createLineBorder(Color.black));
        labelRollersUsual.setBounds(10, 20, 190, 40);
        groupRollers.add(labelRollersUsual);

        JLabel labelRollersHorisontal = new JLabel("Горизонтальные полосы");
        labelRollersHorisontal.setHorizontalAlignment(SwingConstants.CENTER);
        labelRollersHorisontal.setBorder(BorderFactory.createLineBorder(Color.black));
        labelRollersHorisontal.setBounds(10, 70, 190, 40);
        groupRollers.add(labelRollersHorisontal);

        JLabel labelRollerVertical = new JLabel("Вертикальные полосы");
        labelRollerVertical.setHorizontalAlignment(SwingConstants.CENTER);
        labelRollerVertical.setBorder(BorderFactory.createLineBorder(Color.black));
        labelRollerVertical.setBounds(10, 120, 190, 40);
        groupRollers.add(labelRollerVertical);

        JLabel labelRollersCount = new JLabel("Количество катков:");
        labelRollersCount.setBounds(10, 170, 190, 20);
        groupRollers.add(labelRollersCount);
        spinnerRollersCount = new JSpinner(new SpinnerNumberModel(4, 4, 6, 1));
        spinnerRollersCount.setBounds(10, 190, 190, 20);
        groupRollers.add(spinnerRollersCount);

        var listenerForRollers= new DragMouseAdapter();

        labelRollersUsual.addMouseListener(listenerForRollers);
        labelRollersHorisontal.addMouseListener(listenerForRollers);
        labelRollerVertical.addMouseListener(listenerForRollers);

        labelRollersUsual.setTransferHandler(new TransferHandler("text"));
        labelRollersHorisontal.setTransferHandler(new TransferHandler("text"));
        labelRollerVertical.setTransferHandler(new TransferHandler("text"));

        JPanel groupColor = new JPanel();
        groupColor.setBorder(BorderFactory.createTitledBorder("Цвет машины"));
        groupColor.setBounds(650, 10, 210, 160);
        groupColor.setLayout(null);
        frame.getContentPane().add(groupColor);

        JLabel labelMainColor = new JLabel("Основной цвет");
        PropertyChangeListener propertyChangeListenerMainColor = propertyChangeEvent -> {
            if (vehicle != null) {
                vehicle.setNewMainColor(labelMainColor.getBackground());
                frame.repaint();
            }
        };
        labelMainColor.setBorder(BorderFactory.createLineBorder(Color.black));
        labelMainColor.setHorizontalAlignment(SwingConstants.CENTER);
        labelMainColor.addPropertyChangeListener("background", propertyChangeListenerMainColor);
        labelMainColor.setBounds(10, 20, 90, 30);
        groupColor.add(labelMainColor);

        JLabel labelDopColor = new JLabel("Доп. цвет");
        PropertyChangeListener propertyChangeListenerDopColor = propertyChangeEvent -> {
            if (vehicle instanceof Excavator) {
                Excavator ex = (Excavator) vehicle;
                ex.setNewDopColor(labelDopColor.getBackground());
                vehicle = ex;
                frame.repaint();
            }
        };
        labelDopColor.setBorder(BorderFactory.createLineBorder(Color.black));
        labelDopColor.setHorizontalAlignment(SwingConstants.CENTER);
        labelDopColor.addPropertyChangeListener("background", propertyChangeListenerDopColor);
        labelDopColor.setBounds(110, 20, 90, 30);
        groupColor.add(labelDopColor);

        JLabel labelRed = new JLabel();
        labelRed.setBackground(Color.RED);
        labelRed.setOpaque(true);
        labelRed.setBorder(BorderFactory.createLineBorder(Color.black));
        labelRed.setBounds(10, 60, 40, 40);
        groupColor.add(labelRed);

        JLabel labelOrange = new JLabel();
        labelOrange.setBackground(Color.ORANGE);
        labelOrange.setOpaque(true);
        labelOrange.setBorder(BorderFactory.createLineBorder(Color.black));
        labelOrange.setBounds(60, 60, 40, 40);
        groupColor.add(labelOrange);

        JLabel labelYellow = new JLabel();
        labelYellow.setBackground(Color.YELLOW);
        labelYellow.setOpaque(true);
        labelYellow.setBorder(BorderFactory.createLineBorder(Color.black));
        labelYellow.setBounds(110, 60, 40, 40);
        groupColor.add(labelYellow);

        JLabel labelGreen = new JLabel();
        labelGreen.setBackground(Color.GREEN);
        labelGreen.setOpaque(true);
        labelGreen.setBorder(BorderFactory.createLineBorder(Color.black));
        labelGreen.setBounds(160, 60, 40, 40);
        groupColor.add(labelGreen);

        JLabel labelBlue = new JLabel();
        labelBlue.setBackground(Color.BLUE);
        labelBlue.setOpaque(true);
        labelBlue.setBorder(BorderFactory.createLineBorder(Color.black));
        labelBlue.setBounds(10, 110, 40, 40);
        groupColor.add(labelBlue);

        JLabel labelPink = new JLabel();
        labelPink.setBackground(Color.PINK);
        labelPink.setOpaque(true);
        labelPink.setBorder(BorderFactory.createLineBorder(Color.black));
        labelPink.setBounds(60, 110, 40, 40);
        groupColor.add(labelPink);

        JLabel labelGray = new JLabel();
        labelGray.setBackground(Color.GRAY);
        labelGray.setOpaque(true);
        labelGray.setBorder(BorderFactory.createLineBorder(Color.black));
        labelGray.setBounds(110, 110, 40, 40);
        groupColor.add(labelGray);

        JLabel labelCyan = new JLabel();
        labelCyan.setBackground(Color.cyan);
        labelCyan.setOpaque(true);
        labelCyan.setBorder(BorderFactory.createLineBorder(Color.black));
        labelCyan.setBounds(160, 110, 40, 40);
        groupColor.add(labelCyan);

        var listenerForColor = new DragMouseAdapter();

        labelGray.addMouseListener(listenerForColor);
        labelPink.addMouseListener(listenerForColor);
        labelOrange.addMouseListener(listenerForColor);
        labelBlue.addMouseListener(listenerForColor);
        labelGreen.addMouseListener(listenerForColor);
        labelRed.addMouseListener(listenerForColor);
        labelCyan.addMouseListener(listenerForColor);
        labelYellow.addMouseListener(listenerForColor);
        labelDopColor.addMouseListener(listenerForColor);
        labelMainColor.addMouseListener(listenerForColor);

        labelGray.setTransferHandler(new TransferHandler("background"));
        labelPink.setTransferHandler(new TransferHandler("background"));
        labelOrange.setTransferHandler(new TransferHandler("background"));
        labelBlue.setTransferHandler(new TransferHandler("background"));
        labelGreen.setTransferHandler(new TransferHandler("background"));
        labelRed.setTransferHandler(new TransferHandler("background"));
        labelCyan.setTransferHandler(new TransferHandler("background"));
        labelYellow.setTransferHandler(new TransferHandler("background"));
        labelDopColor.setTransferHandler(new TransferHandler("background"));
        labelMainColor.setTransferHandler(new TransferHandler("background"));

        JPanel groupSettingsPanel = new JPanel();
        groupSettingsPanel.setBorder(BorderFactory.createTitledBorder("Параметры машины"));
        groupSettingsPanel.setBounds(10, 10, 200, 400);
        groupSettingsPanel.setLayout(null);
        frame.getContentPane().add(groupSettingsPanel);

        JLabel labelTrackedVehicle = new JLabel("Гусеничная машина");
        labelTrackedVehicle.setBorder(BorderFactory.createLineBorder(Color.black));
        labelTrackedVehicle.setHorizontalAlignment(SwingConstants.CENTER);
        labelTrackedVehicle.setBounds(10, 30, 180, 60);
        groupSettingsPanel.add(labelTrackedVehicle);

        JLabel labelExcavator = new JLabel("Экскаватор");
        labelExcavator.setBorder(BorderFactory.createLineBorder(Color.black));
        labelExcavator.setHorizontalAlignment(SwingConstants.CENTER);
        labelExcavator.setBounds(10, 110, 180, 60);
        groupSettingsPanel.add(labelExcavator);

        JLabel labelWeight = new JLabel("Вес:");
        labelWeight.setBounds(10, 180, 180, 20);
        groupSettingsPanel.add(labelWeight);
        spinnerWeight = new JSpinner(new SpinnerNumberModel(100, 100, 1000, 10));
        spinnerWeight.setBounds(10, 200, 180, 20);
        groupSettingsPanel.add(spinnerWeight);

        JLabel labelMaxSpeed = new JLabel("Максимальная скорость:");
        labelMaxSpeed.setBounds(10, 230, 180, 20);
        groupSettingsPanel.add(labelMaxSpeed);
        spinnerMaxSpeed = new JSpinner(new SpinnerNumberModel(10, 10, 100, 10));
        spinnerMaxSpeed.setBounds(10, 250, 180, 20);
        groupSettingsPanel.add(spinnerMaxSpeed);

        checkBoxBucket = new JCheckBox("Ковш");
        checkBoxBucket.setBounds(10, 280, 180, 20);
        groupSettingsPanel.add(checkBoxBucket);

        checkBoxHandle = new JCheckBox("Рукоять");
        checkBoxHandle.setBounds(10, 300, 180, 20);
        groupSettingsPanel.add(checkBoxHandle);

        checkBoxArrow = new JCheckBox("Стрела");
        checkBoxArrow.setBounds(10, 320, 180, 20);
        groupSettingsPanel.add(checkBoxArrow);

        checkBoxСounterWeight = new JCheckBox("Противовес");
        checkBoxСounterWeight.setBounds(10, 340, 180, 20);
        groupSettingsPanel.add(checkBoxСounterWeight);

        checkBoxRollers = new JCheckBox("Катки");
        checkBoxRollers.setBounds(10, 360, 180, 20);
        groupSettingsPanel.add(checkBoxRollers);

        drawTransport = new DrawTransport();
        drawTransport.setBorder(BorderFactory.createLineBorder(Color.black));
        drawTransport.setBounds(230, 20, 400, 400);
        frame.getContentPane().add(drawTransport);

        labelPictureBox = new JLabel("");
        PropertyChangeListener propertyChangeListenerTransport = propertyChangeEvent -> {
            if (labelPictureBox.getText().equals("Гусеничная машина")) {
                setTrackedVehicle();
            }
            if (labelPictureBox.getText().equals("Экскаватор")) {
                setExcavator();
            }
            if (labelPictureBox.getText().equals("Обычные")) {
                if (vehicle instanceof Excavator) {
                    Excavator ex = (Excavator) vehicle;
                    ex.setRollers(new RollersUsual((int) spinnerRollersCount.getValue()));
                    vehicle = ex;
                    frame.repaint();
                }
            }
            if (labelPictureBox.getText().equals("Горизонтальные полосы")) {
                if (vehicle instanceof Excavator) {
                    Excavator ex = (Excavator) vehicle;
                    ex.setRollers(new RollersHorisontal((int) spinnerRollersCount.getValue()));
                    vehicle = ex;
                    frame.repaint();
                }
            }
            if (labelPictureBox.getText().equals("Вертикальные полосы")) {
                if (vehicle instanceof Excavator) {
                    Excavator ex = (Excavator) vehicle;
                    ex.setRollers(new RollersVertical((int) spinnerRollersCount.getValue()));
                    vehicle = ex;
                    frame.repaint();
                }
            }
            labelPictureBox.setText("");
        };
        labelPictureBox.addPropertyChangeListener("text", propertyChangeListenerTransport);
        labelPictureBox.setBounds(230, 20, 400, 400);
        frame.getContentPane().add(labelPictureBox);

        var listenerForConfig = new DragMouseAdapter();

        labelTrackedVehicle.addMouseListener(listenerForConfig);
        labelExcavator.addMouseListener(listenerForConfig);
        labelPictureBox.addMouseListener(listenerForConfig);

        labelTrackedVehicle.setTransferHandler(new TransferHandler("text"));
        labelExcavator.setTransferHandler(new TransferHandler("text"));
        labelPictureBox.setTransferHandler(new TransferHandler("text"));

        frame.repaint();
    }

    private void setTrackedVehicle() {
        vehicle = new TrackedVehicle((int) spinnerMaxSpeed.getValue(), (int) spinnerWeight.getValue(), Color.WHITE);
        drawTransport.setTransport(vehicle);
        drawTransport.getTransport().SetPosition(40, 70, 200, 200);
        frame.repaint();
    }

    private void setExcavator() {
        vehicle =new Excavator((int) spinnerMaxSpeed.getValue(), (int) spinnerWeight.getValue(), Color.WHITE, Color.WHITE, checkBoxBucket.isSelected(), checkBoxHandle.isSelected(), checkBoxArrow.isSelected(), checkBoxСounterWeight.isSelected(), checkBoxRollers.isSelected(), (int)spinnerRollersCount.getValue(), "Обычные");
        drawTransport.setTransport(vehicle);
        drawTransport.getTransport().SetPosition(40, 70, 200, 200);
        frame.repaint();
    }

    private void cancel() {
        frame.dispose();
    }

    private void addVehicle() {
        if (vehicle == null) {
            formParking.addTransport(null);
        } else if (vehicle instanceof Excavator) {
            Excavator ex = (Excavator) vehicle;
            formParking.addTransport(ex);
        } else {
            TrackedVehicle tv = (TrackedVehicle) vehicle;
            formParking.addTransport(tv);
        }
        frame.dispose();
    }
}
