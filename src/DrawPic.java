import javax.swing.*;
import java.awt.*;

public class DrawPic extends JComponent {
    private Excavator ex;
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if (ex != null){
            ex.DrawTransport(g);
        }
        super.repaint();
    }
    public void setTransport(Excavator ex){
        this.ex = ex;
    }
    public Excavator getTransport(){
        return ex;
    }
}
