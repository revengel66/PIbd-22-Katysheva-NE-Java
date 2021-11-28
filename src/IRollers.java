import java.awt.*;

public interface IRollers {
     void SetEnumRollers(int countRollers); //Установка кол-ва катков
     void DrawRollers(Graphics g, Color DolColor, int StartPosX, int StartPosY); //Отрисовка катков
}
