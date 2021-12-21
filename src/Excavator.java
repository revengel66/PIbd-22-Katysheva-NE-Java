import java.awt.*;
public class Excavator extends TrackedVehicle{

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

    public IRollers TypeRollers;
    /// Иницифализация свойств
    public Excavator(int maxSpeed, float weight, Color mainColor, Color dopColor, boolean bucket, boolean handle, boolean arrow, boolean counterweight, boolean rollersIs, int countRollers, String typeRollers)
    {
        super(maxSpeed, weight, mainColor, 355, 250);
        DopColor = dopColor;
        Bucket = bucket;
        Handle = handle;
        Arrow = arrow;
        СounterWeight = counterweight;
        RollersIs = rollersIs;
        switch (typeRollers){
            case "Обычные":
                TypeRollers = new RollersUsual(countRollers);
                break;
            case "Горизонтальные":
                TypeRollers = new RollersHorisontal(countRollers);
                break;
            case "Вертикальные":
                TypeRollers = new RollersVertical(countRollers);
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
        if (СounterWeight)
        {
            g2d.setColor(DopColor);
            g.fillRect(_startPosX+10, _startPosY + 130, 30, 20);
            g2d.setPaint(Color.BLACK);
            g.drawRect(_startPosX+10, _startPosY + 130, 30, 20); //Противовес
        }
        super.DrawTransport(g);
        if (RollersIs){
            TypeRollers.DrawRollers(g, DopColor, _startPosX, _startPosY);
        }
    }

    public void setNewDopColor(Color DopColor) {
        this.DopColor = DopColor;
    }

    public void setRollers(IRollers rollers){
        this.TypeRollers = rollers;
    }

}
