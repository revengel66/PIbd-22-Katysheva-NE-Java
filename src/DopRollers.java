import java.awt.*;
public class DopRollers {//для отрисовки катка
    private DopEnum dopEnum;
    public int count;

    public DopRollers(int countRollers){
        this.count = countRollers;
        SetEnumRollers(count);
    }
    public void SetEnumRollers(int countRollers){
        this.dopEnum = DopEnum.setEnumNumber(countRollers);
    }

    public void DrawRoll(Graphics g, Color DolColor, int StartPosX, int StartPosY){
        g.setColor(DolColor);
        g.fillOval(StartPosX + 50, StartPosY + 203, 10, 10);
        g.setColor(Color.BLACK);
        g.drawOval(StartPosX + 50, StartPosY + 203, 10, 10);
    }
    public void DrawRolls(Graphics g, Color DolColor, int StartPosX, int StartPosY){
        if (dopEnum == DopEnum.FOUR || dopEnum == DopEnum.FIVE || dopEnum == DopEnum.SIX){
            DrawRoll(g, DolColor, StartPosX, StartPosY);
            DrawRoll(g, DolColor, StartPosX + 50, StartPosY);
            DrawRoll(g, DolColor, StartPosX + 100, StartPosY);
            DrawRoll(g, DolColor, StartPosX + 50, StartPosY + 34);
        }
        if (dopEnum == DopEnum.FIVE || dopEnum == DopEnum.SIX) {
            DrawRoll(g, DolColor, StartPosX, StartPosY + 34);
        }
        if (dopEnum == DopEnum.SIX) {
            DrawRoll(g, DolColor, StartPosX + 100, StartPosY + 34);
        }
    }




}
