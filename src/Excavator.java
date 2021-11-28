import java.awt.*;
public class Excavator {
    private int _startPosX; /// Левая координата отрисовки
    private int _startPosY; /// Верхняя кооридната отрисовки
    private int _pictureWidth; /// Ширина окна отрисовки
    private int _pictureHeight; /// Высота окна отрисовки
    private  int exWidth = 355; /// Ширина отрисовки екскаватора
    private  int exHeight = 250;/// Высота отрисовки екскаватора

    public int MaxSpeed; /// Максимальная скорость
    public int getMaxSpeed() { return MaxSpeed; }
    public void setMaxSpeed(int maxSpeed) { MaxSpeed = maxSpeed; }

    public float Weight; /// Вес экскаватора
    public float getWeight() { return Weight; }
    public void setWeight(int Weight) { Weight = Weight; }

    public Color MainColor; /// Основной цвет
    public Color getMainColor() { return MainColor; }
    public void setMainColor(Color MainColor) { MainColor = MainColor; }

    public Color DopColor; /// Дополнительный цвет
    public Color getDopColor() { return DopColor; }
    public void setDopColor(Color DopColor) { DopColor = DopColor; }

    public boolean Bucket; /// Признак наличия ковша
    public boolean getBucket() { return Bucket; }
    public void setBucket(boolean DopColor) { Bucket = Bucket; }

    public boolean Handle; /// Признак наличия рукояти
    public boolean getHandle() { return Handle; }
    public void setHandle(boolean Handle) { Handle = Handle; }

    public boolean Arrow; /// Признак наличия стрелы
    public boolean getArrow() { return Arrow; }
    public void setArrow(boolean Arrow) { Arrow = Arrow; }

    public boolean СounterWeight; /// Признак наличия противовеса
    public boolean getСounterWeight() { return СounterWeight; }
    public void setСounterWeight(boolean СounterWeight) { СounterWeight = СounterWeight; }

    public boolean RollersIs;
    public boolean getRollers() { return RollersIs; }
    public void setRollers(boolean RollersIs) { RollersIs = RollersIs; }

    private DopRollers rollers;

    /// Иницифализация свойств
    public Excavator(int maxSpeed, float weight, Color mainColor, Color dopColor, boolean bucket, boolean handle, boolean arrow, boolean counterweight, boolean rollersIs, int countRollers)
    {
        MaxSpeed = maxSpeed;
        Weight = weight;
        MainColor = mainColor;
        DopColor = dopColor;
        Bucket = bucket;
        Handle = handle;
        Arrow = arrow;
        СounterWeight = counterweight;
        RollersIs = rollersIs;
        this.rollers = new DopRollers(countRollers);
    }
    public void SetPosition(int x, int y, int width, int height) /// Установка позиции автомобиля
    {
        _startPosX = x;
        _startPosY = y;
        _pictureWidth = width;
        _pictureHeight = height;

    }
    public void MoveTransport(Direction direction) /// Изменение направления пермещения
    {
        float step = MaxSpeed * 100 / Weight;
        switch (direction)
        {
            // вправо
            case Right:
                if (_startPosX + step < _pictureWidth - exWidth)
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
                if (_startPosY + step < _pictureHeight - exHeight)
                {
                    _startPosY += step;
                }
                break;
        }
    }
    public void DrawTransport(Graphics g)
    {
        Graphics2D g2d = (Graphics2D)g;
        if (Handle) { //Рукоять
            g2d.setColor(MainColor);
            int Handle_points_x[] = {_startPosX + 130, _startPosX + 240, _startPosX + 340, _startPosX + 320, _startPosX +250, _startPosX +140,_startPosX +130};
            int Handle_points_y[] = {_startPosY + 120, _startPosY,_startPosY + 20, _startPosY + 50,  _startPosY + 60,  _startPosY + 150,  _startPosY + 120};
            g2d.fillPolygon(Handle_points_x, Handle_points_y, Handle_points_x.length);
            g2d.setColor(Color.BLACK);
            g2d.drawPolygon(Handle_points_x, Handle_points_y, Handle_points_x.length);
            if (Arrow) //Стрела
            {
                g2d.setColor(MainColor);
                int Arrow_points_x[] = {_startPosX + 340, _startPosX + 350, _startPosX + 340, _startPosX + 320, _startPosX + 340};
                int Arrow_points_y[] = {_startPosY + 20, _startPosY + 170,_startPosY + 170, _startPosY + 50,  _startPosY + 20};
                g2d.fillPolygon(Arrow_points_x, Arrow_points_y, Arrow_points_x.length);
                g2d.setColor(Color.BLACK);
                g2d.drawPolygon(Arrow_points_x, Arrow_points_y, Arrow_points_x.length);
                if (Bucket) //Ковш
                {
                    g2d.setColor(DopColor);
                    int Bucket_points_x[] = {_startPosX + 350, _startPosX + 330, _startPosX + 250, _startPosX + 350};
                    int Bucket_points_y[] = {_startPosY + 170, _startPosY + 250,_startPosY + 230, _startPosY + 170};
                    g2d.fillPolygon(Bucket_points_x, Bucket_points_y, Bucket_points_x.length);
                    g2d.setColor(Color.BLACK);
                    g2d.drawPolygon(Bucket_points_x, Bucket_points_y, Bucket_points_x.length);
                }
                g2d.setColor(DopColor);
                g2d.fillOval(_startPosX + 335, _startPosY + 160, 20, 20);
                g2d.setColor(Color.BLACK);
                g2d.drawOval(_startPosX + 335, _startPosY + 160, 20, 20);
            }
        }
        g2d.setColor(MainColor);
        g2d.fillRect(_startPosX, _startPosY + 150, 150, 50); //Нижняя часть кузова
        g2d.setPaint(DopColor);
        g2d.drawRect(_startPosX, _startPosY + 150, 150, 50); //Нижняя часть кузова
        g2d.setColor(MainColor);
        g2d.fillRect(_startPosX + 70, _startPosY + 100, 80, 90);//Верхняя часть кузова

        g2d.setPaint(DopColor);
        g2d.drawRect(_startPosX + 70, _startPosY + 100, 80, 90);//Верхняя часть кузова
        g2d.drawRect(_startPosX + 85, _startPosY + 110, 60, 60);//Окно

        g2d.setColor(Color.BLUE);
        g2d.fillRect(_startPosX + 85, _startPosY + 110, 60, 60);//Окно

        if (СounterWeight)
        {
            g2d.setColor(DopColor);
            g.fillRect(_startPosX+10, _startPosY + 130, 30, 20);
            g2d.setPaint(Color.BLACK);
            g.drawRect(_startPosX+10, _startPosY + 130, 30, 20); //Противовес
        }
        g2d.setColor(Color.BLACK);
        g.fillOval(_startPosX, _startPosY + 200, 50, 50); //Гусеничная тележка
        g.fillOval(_startPosX + 160, _startPosY + 200, 50, 50);
        g.fillRect(_startPosX + 25, _startPosY + 200, 160, 50);

        g2d.setColor(Color.GRAY);
        g.fillOval(_startPosX + 5, _startPosY + 205, 40, 40);
        g.fillRect(_startPosX + 50, _startPosY + 215, 110, 20);
        g.fillOval(_startPosX + 165, _startPosY + 205, 40, 40);

        if (RollersIs){
            rollers.DrawRolls(g, DopColor, _startPosX, _startPosY);
        }
    }

}
