import javax.swing.*;
import java.awt.*;
public class DrawParking extends JPanel {
    private  ParkingCollection parkingCollection;
    private String selectedItem = null;

    @Override
    public void paint(Graphics g) {
        if (selectedItem != null) {
            if (parkingCollection != null) {
                parkingCollection.get(selectedItem).Draw(g);
            }
        }
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }

    public DrawParking(ParkingCollection parkingCollection) {
        this.parkingCollection = parkingCollection;
    }
}