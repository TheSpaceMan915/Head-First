package Music_Machine;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MyDrawingPanel extends JPanel
{
    public void paintComponent(Graphics obj)
    {
        obj.fillRect(0,0,this.getWidth(),this.getHeight());
    }

}
