import java.awt.*;
public class RollersVertical implements IRollers {//для отрисовки катка
    private DopEnum dopEnum;
    private int count;

    public RollersVertical(int countRollers){
        this.count = countRollers;
        SetEnumRollers(count);
    }
    @Override
    public void SetEnumRollers(int countRollers){
        this.dopEnum = DopEnum.setEnumNumber(countRollers);
    }

    private void DrawRollVertical(Graphics g, Color DolColor, int StartPosX, int StartPosY){
        g.setColor(DolColor);
        g.fillOval(StartPosX + 50, StartPosY + 203, 10, 10);
        g.setColor(Color.BLACK);
        g.drawOval(StartPosX + 50, StartPosY + 203, 10, 10);
        g.drawLine(StartPosX + 52, StartPosY + 203, StartPosX+52, StartPosY + 213);
        g.drawLine(StartPosX + 54, StartPosY + 203, StartPosX+54, StartPosY + 213);
        g.drawLine(StartPosX + 56, StartPosY + 203, StartPosX+55, StartPosY + 213);
        g.drawLine(StartPosX + 58, StartPosY + 203, StartPosX+58, StartPosY + 213);
    }
    @Override
    public void DrawRollers(Graphics g, Color DolColor, int StartPosX, int StartPosY){
        if (dopEnum == DopEnum.FOUR || dopEnum == DopEnum.FIVE || dopEnum == DopEnum.SIX){
            DrawRollVertical(g, DolColor, StartPosX, StartPosY);
            DrawRollVertical(g, DolColor, StartPosX + 50, StartPosY);
            DrawRollVertical(g, DolColor, StartPosX + 100, StartPosY);
            DrawRollVertical(g, DolColor, StartPosX + 50, StartPosY + 34);
        }
        if (dopEnum == DopEnum.FIVE || dopEnum == DopEnum.SIX) {
            DrawRollVertical(g, DolColor, StartPosX, StartPosY + 34);
        }
        if (dopEnum == DopEnum.SIX) {
            DrawRollVertical(g, DolColor, StartPosX + 100, StartPosY + 34);
        }
    }
}
