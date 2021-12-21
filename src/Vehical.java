import java.awt.*;

public abstract class Vehical implements ITransport {
    protected int _startPosX; /// Левая координата отрисовки
    protected int _startPosY; /// Верхняя кооридната отрисовки
    protected int _pictureWidth; /// Ширина окна отрисовки
    protected int _pictureHeight; /// Высота окна отрисовки

    public int MaxSpeed; /// Максимальная скорость
    public int getMaxSpeed() { return MaxSpeed; }
    public void setMaxSpeed(int maxSpeed) { MaxSpeed = maxSpeed; }

    public float Weight; /// Вес экскаватора
    public float getWeight() { return Weight; }
    public void setWeight(int Weight) { Weight = Weight; }

    public Color MainColor; /// Основной цвет
    public Color getMainColor() { return MainColor; }
    public void setMainColor(Color MainColor) { MainColor = MainColor; }

    public void SetPosition(int x, int y, int width, int height) /// Установка позиции автомобиля
    {
        _startPosX = x;
        _startPosY = y;
        _pictureWidth = width;
        _pictureHeight = height;
    }
    public abstract void DrawTransport(Graphics g);
    public abstract void MoveTransport(Direction direction);

    public abstract void setNewMainColor(Color MainColor);
}
