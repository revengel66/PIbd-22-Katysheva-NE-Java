import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class ParkingCollection {
    private  Map<String, Parking<TrackedVehicle, IRollers>> parkingStages;
    private  int pictureWidth;
    private  int pictureHeight;

    public ParkingCollection(int pictureWidth, int pictureHeight)///Конструктор
    {
        parkingStages = new HashMap<>();
        this.pictureWidth = pictureWidth;
        this.pictureHeight = pictureHeight;
    }
    public void AddParking(String name)/// Добавление парковки
    {
        if (!parkingStages.containsKey(name)){
            parkingStages.put(name, new Parking<>(pictureWidth, pictureHeight));
        }
    }
    public void DelParking(String name) /// Удаление парковки
    {
        if (parkingStages.containsKey(name))
        {
            parkingStages.remove(name);
        }
    }
    public Parking<TrackedVehicle, IRollers> get(String ind) /// Доступ к парковке
    {
        if (parkingStages.containsKey(ind))
        {
            return parkingStages.get(ind);
        }
        return null;
    }
    public Vehical getVehicle(String name, int index) {
        if (parkingStages.containsKey(name)) {
            return parkingStages.get(name).getVehicle(index);
        }
        return null;
    }
    public Set<String> keySet() {
        return parkingStages.keySet();
    }
}
