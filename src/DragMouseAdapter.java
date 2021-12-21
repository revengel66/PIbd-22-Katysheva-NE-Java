import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DragMouseAdapter implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent event) {
        var c = (JComponent) event.getSource();
        var handler = c.getTransferHandler();
        handler.exportAsDrag(c, event, TransferHandler.COPY);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
