import javax.swing.*;
import java.awt.*;
public class DrawParking extends JComponent {
    private Parking<TrackedVehicle, IRollers> parking;

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if (parking != null){
            parking.Draw(g);
        }
        super.repaint();
    }

    public void setParking(Parking<TrackedVehicle, IRollers> parking){
        this.parking = parking;
    }

    public Parking<TrackedVehicle, IRollers> getParking(){
        return parking;
    }
}
