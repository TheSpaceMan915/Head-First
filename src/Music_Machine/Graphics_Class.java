package Music_Machine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Graphics_Class implements ActionListener {
    private JFrame m_frame;


    public void actionPerformed(ActionEvent obj)      //this is an event-handling method
    {
        m_frame.repaint();
    }

    public void PaintScreen()
    {
        m_frame = new JFrame();
        JButton button = new JButton("Hey there!");
        m_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m_frame.setSize(500,500);
        m_frame.getContentPane().add(BorderLayout.SOUTH,button);

        MyDrawingPanel panel = new MyDrawingPanel();
        m_frame.getContentPane().add(BorderLayout.CENTER,panel);

        button.addActionListener(this);
        m_frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        Graphics_Class graph_obj = new Graphics_Class();
        graph_obj.PaintScreen();
    }
}