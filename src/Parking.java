import java.awt.*;
import java.lang.reflect.Array;

public class Parking<T extends ITransport, U extends IRollers> {
    private T[] _places; /// Массив объектов, которые храним
    private int pictureWidth;/// Ширина окна отрисовки
    private int pictureHeight;/// Высота окна отрисовки
    private int _placeSizeWidth = 370;/// Размер парковочного места (ширина)
    private int _placeSizeHeight = 260; /// Размер парковочного места (высота)
    public Parking(int picWidth, int picHeight) /// Конструктор
    {
        int width = picWidth / _placeSizeWidth;
        int height = picHeight / _placeSizeHeight;
        _places = (T[]) Array.newInstance(ITransport.class, width*height);
        pictureWidth = picWidth;
        pictureHeight = picHeight;
    }
    /// Перегрузка оператора сложения
    /// Логика действия: на парковку добавляется машина
    public int add(T car)
    {
        for (int i = 0; i < _places.length; i++)
        {
            if (_places[i] == null)
            {
                _places[i] = car;
                return i;
            }
        }
        return -1;
    }
    public boolean equal(Parking<T,U> parking, Excavator ex)
    {
       return  parking._places.length == ex.MaxSpeed;
    }
    public boolean unequal(Parking<T,U> parking, Excavator ex)
    {
        return  parking._places.length != ex.MaxSpeed;
    }
    /// Перегрузка оператора вычитания
    /// Логика действия: с парковки забираем машину
    public  T delete(int index)
    {
        if (index < _places.length)
        {
            T car = (T) _places[index];
            _places[index] = null;
            return car;
        }
        return null;
    }
    public void Draw(Graphics g) /// Метод отрисовки парковки
    {
        DrawMarking(g);
        int x = 5, y = 5;
        for (int i = 0; i < _places.length; ++i)
        {
            if (i % (pictureWidth / _placeSizeWidth) == 0 && i != 0) {
                y += 260;
                x = 5;
            }
            if (_places[i] != null) {
                _places[i].SetPosition(x, y, 1, 1);
                _places[i].DrawTransport(g);
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
