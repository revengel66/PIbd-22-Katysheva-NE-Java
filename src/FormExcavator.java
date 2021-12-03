import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class FormExcavator {
    private JPanel MainPanel;
    private JPanel ButtonPanel;
    private JPanel ArrowPanel;
    private JButton buttonCreate;
    private JButton buttonRight;
    private JButton buttonLeft;
    private JButton buttonDown;
    private JButton buttonUp;
    private JPanel ArrowWrapperPanel;

    private JComboBox<String> comboBoxRollers;
    private DrawPic draw;
    private JFrame frameExcavator;

    public FormExcavator(){
        frameExcavator = new JFrame("Excavator");
        frameExcavator.setSize(new Dimension(1000, 700));
        frameExcavator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        draw = new DrawPic();

        buttonCreate.addActionListener(e -> setExcavator());
        buttonUp.addActionListener(e -> clickArrow(buttonUp));
        buttonDown.addActionListener(e -> clickArrow(buttonDown));
        buttonLeft.addActionListener(e -> clickArrow(buttonLeft));
        buttonRight.addActionListener(e -> clickArrow(buttonRight));
        frameExcavator.add(MainPanel);
        frameExcavator.setVisible(true);
    }

    private void setExcavator(){
        Random rnd = new Random();
        draw.setTransport(new Excavator(rnd.nextInt(200)+100, rnd.nextInt(2000)+1000, Color.YELLOW, Color.GRAY, true, true, true, true, true, comboBoxRollers.getSelectedIndex()));
        draw.getTransport().SetPosition(rnd.nextInt(100), rnd.nextInt(100), MainPanel.getWidth(), MainPanel.getHeight()-ArrowWrapperPanel.getHeight()-ButtonPanel.getHeight() );
        MainPanel.add(draw);
        frameExcavator.repaint();
        frameExcavator.setVisible(true);
    }

    private void clickArrow(JButton button){
        String name = button.getName();
        switch (name){
            case "buttonRight":
                draw.getTransport().MoveTransport(Direction.Right);
                break;
            case "buttonLeft":
                draw.getTransport().MoveTransport(Direction.Left);
                break;
            case "buttonUp":
                draw.getTransport().MoveTransport(Direction.Up);
                break;
            case "buttonDown":
                draw.getTransport().MoveTransport(Direction.Down);
                break;
        }
        frameExcavator.repaint();
    }
}
