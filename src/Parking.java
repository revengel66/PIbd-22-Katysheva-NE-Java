import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Parking<T extends ITransport, U extends IRollers> {
    private List<T> _places; /// Массив объектов, которые храни
    private  int _maxCount;
    private int pictureWidth;/// Ширина окна отрисовки
    private int pictureHeight;/// Высота окна отрисовки
    private int _placeSizeWidth = 370;/// Размер парковочного места (ширина)
    private int _placeSizeHeight = 260; /// Размер парковочного места (высота)
    public Parking(int picWidth, int picHeight) /// Конструктор
    {
        int width = picWidth / _placeSizeWidth;
        int height = picHeight / _placeSizeHeight;
        _maxCount = width*height;
        _places = new ArrayList<>();
        pictureWidth = picWidth;
        pictureHeight = picHeight;
    }
    /// Перегрузка оператора сложения
    /// Логика действия: на парковку добавляется машина
    public  int add(T car)
    {
        if (_places.size() < _maxCount)
        {
            _places.add(car);
            return _places.size();
        }
        return -1;
    }
    public boolean equal(Parking<T,U> parking, Excavator ex)
    {
       return  parking._places.size() == ex.MaxSpeed;
    }
    public boolean unequal(Parking<T,U> parking, Excavator ex)
    {
        return  parking._places.size() != ex.MaxSpeed;
    }
    /// Перегрузка оператора вычитания
    /// Логика действия: с парковки забираем машину
    public  T delete(int index)
    {
        if (index >= 0 && index < _maxCount && _places.get(index) != null)
        {
            T car = _places.get(index);
            _places.remove(index);
            return car;
        }
        return null;
    }
    public T getVehicle(int index) {
        if (index >= 0 && index < _places.size()) {
            return _places.get(index);
        }
        return null;
    }
    public void Draw(Graphics g) /// Метод отрисовки парковки
    {
        DrawMarking(g);
        int x = 5, y = 5;
        for (int i = 0; i < _places.size(); ++i)
        {
            if (i % (pictureWidth / _placeSizeWidth) == 0 && i != 0) {
                y += 260;
                x = 5;
            }
            if (_places.get(i) != null) {
                _places.get(i).SetPosition(x, y, 1, 1);
                _places.get(i).DrawTransport(g);
            }
            x += 370;
        }
    }
    private void DrawMarking(Graphics g) /// Метод отрисовки разметки парковочных мест
    {
        g.setColor(Color.BLACK);
        for (int i = 0; i < pictureWidth / _placeSizeWidth; i++)
        {
            for (int j = 0; j < pictureHeight / _placeSizeHeight + 1; ++j)
            {//линия разметки места
                g.drawLine(i * _placeSizeWidth, j * _placeSizeHeight, i *_placeSizeWidth + _placeSizeWidth / 2, j * _placeSizeHeight);
            }
            g.drawLine(i * _placeSizeWidth, 0, i * _placeSizeWidth,(pictureHeight / _placeSizeHeight) * _placeSizeHeight);
        }
    }
}
