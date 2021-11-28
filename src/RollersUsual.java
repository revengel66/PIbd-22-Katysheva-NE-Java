import java.awt.*;
public class RollersUsual implements IRollers {//для отрисовки катка
    private DopEnum dopEnum;
    public int count;

    public RollersUsual(int countRollers){
        this.count = countRollers;
        SetEnumRollers(count);
        System.out.println("Обычные");
    }
    @Override
    public void SetEnumRollers(int countRollers){
        this.dopEnum = DopEnum.setEnumNumber(countRollers);
    }

    public void DrawRollUsual(Graphics g, Color DolColor, int StartPosX, int StartPosY){
        g.setColor(DolColor);
        g.fillOval(StartPosX + 50, StartPosY + 203, 10, 10);
        g.setColor(Color.BLACK);
        g.drawOval(StartPosX + 50, StartPosY + 203, 10, 10);
    }
    @Override
    public void DrawRollers(Graphics g, Color DolColor, int StartPosX, int StartPosY){
        if (dopEnum == DopEnum.FOUR || dopEnum == DopEnum.FIVE || dopEnum == DopEnum.SIX){
            DrawRollUsual(g, DolColor, StartPosX, StartPosY);
            DrawRollUsual(g, DolColor, StartPosX + 50, StartPosY);
            DrawRollUsual(g, DolColor, StartPosX + 100, StartPosY);
            DrawRollUsual(g, DolColor, StartPosX + 50, StartPosY + 34);
        }
        if (dopEnum == DopEnum.FIVE || dopEnum == DopEnum.SIX) {
            DrawRollUsual(g, DolColor, StartPosX, StartPosY + 34);
        }
        if (dopEnum == DopEnum.SIX) {
            DrawRollUsual(g, DolColor, StartPosX + 100, StartPosY + 34);
        }
    }
}
