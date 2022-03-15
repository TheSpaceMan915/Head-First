package Music_Machine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Graphics_Class {
    private JFrame m_frame;
    private JLabel m_label;

    public class LabelListener implements ActionListener {

        public void actionPerformed(ActionEvent obj) {
            m_label.setText("Check out this beautiful oval");
        }
    }

    public class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent obj)      //this is an event-handling method
        {
            m_frame.repaint();
        }
    }


    //Inner class with another drawing panel
    /*public class InnerDrawingPanel extends JPanel implements ActionListener {
        private int x = 50;
        private int y = 50;

        public void paintComponent (Graphics obj)
        {
            //Image picture = new ImageIcon("Pikachu.png").getImage();
           // obj.drawImage(picture,x,y,this);

            obj.setColor(Color.WHITE);
            obj.fillRect(0,0,this.getWidth(),this.getHeight());

            obj.setColor(Color.orange);
            obj.fillOval(x,y,50,50);
        }

        public void actionPerformed(ActionEvent obj)
        {
            x += 5;
            y += 5;
            m_frame.repaint();
        }
    }

    public void PaintWithInnerPanel()
    {
        m_frame = new JFrame();
        JButton button = new JButton("Move Pikachu");
        m_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m_frame.setSize(500,500);

        InnerDrawingPanel in_panel = new InnerDrawingPanel();
        m_frame.getContentPane().add(BorderLayout.CENTER,in_panel);
        m_frame.getContentPane().add(BorderLayout.SOUTH,button);
        button.addActionListener(in_panel);
        m_frame.setVisible(true);
    }
     */

    public void PaintScreen() {
        m_frame = new JFrame();
        JButton button = new JButton("Hey there!");
        JButton button_label_control = new JButton("Change the text on the label");
        m_label = new JLabel("How's life?");
        m_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m_frame.setSize(600, 600);

        m_frame.getContentPane().add(BorderLayout.SOUTH, button);
        m_frame.getContentPane().add(BorderLayout.NORTH, button_label_control);
        m_frame.getContentPane().add(BorderLayout.EAST, m_label);
        MyDrawingPanel panel = new MyDrawingPanel();
        m_frame.getContentPane().add(BorderLayout.CENTER, panel);

        button.addActionListener(new ButtonListener());
        button_label_control.addActionListener(new LabelListener());
        m_frame.setVisible(true);
    }

    public static void main(String[] args) {
        Graphics_Class graph_obj = new Graphics_Class();
        graph_obj.PaintScreen();
        //graph_obj.PaintWithInnerPanel();
    }
}
