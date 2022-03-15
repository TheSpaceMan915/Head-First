package Music_Machine;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MyDrawingPanel extends JPanel
{
    public void paintComponent(Graphics obj)
    {

     obj.fillRect(0,0,this.getWidth(),this.getHeight());    //make the background of the window black
     Graphics2D obj2D = (Graphics2D) obj;    //x1,y1 - this is where the 1st color starts
                                                //x2,y2 - this is where the 2nd color starts

        Random rand = new Random();
        float red = rand.nextFloat();
        float green = rand.nextFloat();
        float blue = rand.nextFloat();
        Color start_colour = new Color(red,green,blue);
        red = rand.nextFloat();
        green = rand.nextFloat();
        blue = rand.nextFloat();
        Color end_colour = new Color(red,green,blue);

        int x_k = ThreadLocalRandom.current().nextInt(0,290 + 1);
        int y_k = ThreadLocalRandom.current().nextInt(0,290 + 1);
        int width = ThreadLocalRandom.current().nextInt(50,150 + 1);
        int height = ThreadLocalRandom.current().nextInt(50,150 + 1);

        GradientPaint grad = new GradientPaint(x_k,y_k,start_colour,x_k + width,y_k + height,end_colour);
        obj2D.setPaint(grad);
        obj2D.fillOval(x_k,y_k,width,height);

    }

}
