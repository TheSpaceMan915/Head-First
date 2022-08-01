package Swing_Test;
import javax.swing.*;
import java.awt.*;

public class MyDrawingPanel extends JPanel
{
    public void paintComponent(Graphics obj)
    {
        obj.setColor(Color.PINK);
        obj.fillRect(0,0,this.getWidth(),this.getHeight());

    }

}
