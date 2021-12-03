import javax.swing.*;
import java.awt.*;

public class DrawPic extends JComponent {
    private ITransport transport;
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if (transport != null){
            transport.DrawTransport(g);
        }
        super.repaint();
    }
    public void setTransport(ITransport transport){
        this.transport = transport;
    }
    public ITransport getTransport(){
        return transport;
    }

}
