package Swing_Test;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dialog_Test {

    final static private JFrame m_frame = new JFrame();
    final static private JTextField m_field = new JTextField(20);
    final static private JPopupMenu m_popup_menu = new JPopupMenu();


    private class PopUpListener extends MouseAdapter
    {
        @Override
        public void mousePressed(MouseEvent e)
        { showPopup(e); }

        @Override
        public void mouseReleased(MouseEvent e)
        { showPopup(e); }


        public void showPopup(MouseEvent obj)
        {
            if (obj.isPopupTrigger())
            { m_popup_menu.show(obj.getComponent(),obj.getX(),obj.getY()); }
        }
    }

    public void go()
    {
        m_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m_frame.setSize(600,600);

        JButton button = new JButton("Hello!");
        JPanel panel = new JPanel();
        panel.add(m_field);

        m_frame.add(BorderLayout.CENTER,panel);
        m_frame.add(BorderLayout.SOUTH,button);


        //create a menu bar with one menu
        JMenuBar menu_bar = new JMenuBar();
        JMenu menu_obj = new JMenu("File");
        menu_obj.getAccessibleContext().setAccessibleDescription("This is just a description");


        JMenuItem item1 = new JMenuItem("Save");
        JMenuItem item2 = new JMenuItem("Save as");
        JMenuItem pop_item = new JMenuItem("Check me out");
        item1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.SHIFT_MASK));


        //set the listener for popup menu
        MouseListener listener_obj = new PopUpListener();
        m_frame.addMouseListener(listener_obj);

        item1.addActionListener(x -> button.setText("Hey"));
        button.addActionListener(x -> button.setText("Hello"));

        menu_obj.add(item1);
        menu_obj.add(item2);
        menu_bar.add(menu_obj);
        m_popup_menu.add(pop_item);

        m_frame.setJMenuBar(menu_bar);
        m_frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        Dialog_Test test_obj = new Dialog_Test();
        test_obj.go();
    }
}
