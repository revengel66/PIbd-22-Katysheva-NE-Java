import java.awt.*;
public class RollersHorisontal implements IRollers {//для отрисовки катка
    private DopEnum dopEnum;
    public int count;

    public RollersHorisontal(int countRollers){
        this.count = countRollers;
        SetEnumRollers(count);
    }
    @Override
    public void SetEnumRollers(int countRollers){
        this.dopEnum = DopEnum.setEnumNumber(countRollers);
    }

    private void DrawRollHorisontal(Graphics g, Color DolColor, int StartPosX, int StartPosY){
        g.setColor(DolColor);
        g.fillOval(StartPosX + 50, StartPosY + 203, 10, 10);
        g.setColor(Color.BLACK);
        g.drawOval(StartPosX + 50, StartPosY + 203, 10, 10);
        g.drawLine(StartPosX + 50, StartPosY + 205, StartPosX+60, StartPosY + 205);
        g.drawLine(StartPosX + 50, StartPosY + 207, StartPosX+60, StartPosY + 207);
        g.drawLine(StartPosX + 50, StartPosY + 209, StartPosX+60, StartPosY + 209);
        g.drawLine(StartPosX + 50, StartPosY + 211, StartPosX+60, StartPosY + 211);

    }
    @Override
    public void DrawRollers(Graphics g, Color DolColor, int StartPosX, int StartPosY){
        if (dopEnum == DopEnum.FOUR || dopEnum == DopEnum.FIVE || dopEnum == DopEnum.SIX){
            DrawRollHorisontal(g, DolColor, StartPosX, StartPosY);
            DrawRollHorisontal(g, DolColor, StartPosX + 50, StartPosY);
            DrawRollHorisontal(g, DolColor, StartPosX + 100, StartPosY);
            DrawRollHorisontal(g, DolColor, StartPosX + 50, StartPosY + 34);
        }
        if (dopEnum == DopEnum.FIVE || dopEnum == DopEnum.SIX) {
            DrawRollHorisontal(g, DolColor, StartPosX, StartPosY + 34);
        }
        if (dopEnum == DopEnum.SIX) {
            DrawRollHorisontal(g, DolColor, StartPosX + 100, StartPosY + 34);
        }
    }
}

