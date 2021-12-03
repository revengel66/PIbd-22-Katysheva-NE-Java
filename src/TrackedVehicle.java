import java.awt.*;
public class TrackedVehicle extends Vehical{
    protected  int trackedVehicleWidth = 210; /// Ширина отрисовки гусеничной машины
    protected  int trackedVehicleHeight = 250;/// Высота отрисовки гусеничной машины

    private RollersUsual rollers;
    public TrackedVehicle(int maxSpeed, float weight, Color mainColor)//Конструктор
    {
        MaxSpeed = maxSpeed;
        Weight = weight;
        MainColor = mainColor;
    }
    /// Конструкторс изменением размеров машины
    protected TrackedVehicle(int maxSpeed, float weight, Color mainColor, int trackedVehicleWidth, int trackedVehicleHeight)
    {
        MaxSpeed = maxSpeed;
        Weight = weight;
        MainColor = mainColor;
        this.trackedVehicleWidth = trackedVehicleWidth;
        this.trackedVehicleHeight = trackedVehicleHeight;
    }
    @Override
    public void MoveTransport(Direction direction) /// Изменение направления пермещения
    {
        float step = MaxSpeed * 100 / Weight;
        switch (direction)
        {
            // вправо
            case Right:
                if (_startPosX + step < _pictureWidth - trackedVehicleWidth)
                {
                    _startPosX += step;
                }
                break;
            //влево
            case Left:
                if (_startPosX - step > 0)
                {
                    _startPosX -= step;
                }
                break;
            //вверх
            case Up:
                if (_startPosY - step > 0)
                {
                    _startPosY -= step;
                }
                break;
            //вниз
            case Down:
                if (_startPosY + step < _pictureHeight - trackedVehicleHeight)
                {
                    _startPosY += step;
                }
                break;
        }
    }
    @Override
    public void DrawTransport(Graphics g)
    {
        g.setColor(MainColor);
        g.fillRect(_startPosX, _startPosY + 150, 150, 50); //Нижняя часть кузова
        g.setColor(Color.BLACK);
        g.drawRect(_startPosX, _startPosY + 150, 150, 50); //Нижняя часть кузова
        g.setColor(MainColor);

        g.fillRect(_startPosX + 70, _startPosY + 100, 80, 90);//Верхняя часть кузова
        g.setColor(Color.BLACK);
        g.drawRect(_startPosX + 70, _startPosY + 100, 80, 90);//Верхняя часть кузова

        g.drawRect(_startPosX + 85, _startPosY + 110, 60, 60);//Окно
        g.setColor(Color.BLUE);
        g.fillRect(_startPosX + 85, _startPosY + 110, 60, 60);//Окно

        g.setColor(Color.BLACK);
        g.fillOval(_startPosX, _startPosY + 200, 50, 50); //Гусеничная тележка
        g.fillOval(_startPosX + 160, _startPosY + 200, 50, 50);
        g.fillRect(_startPosX + 25, _startPosY + 200, 160, 50);
        g.setColor(Color.GRAY);
        g.fillOval(_startPosX + 5, _startPosY + 205, 40, 40);
        g.fillRect(_startPosX + 50, _startPosY + 215, 110, 20);
        g.fillOval(_startPosX + 165, _startPosY + 205, 40, 40);

    }
}

