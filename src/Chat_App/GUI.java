package Chat_App;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

public class GUI {

    private static final JFrame m_frame = new JFrame("Simple Chat");
    private static final JButton m_button = new JButton("Send");
    private static final JTextArea m_text_area = new JTextArea(20,40);
    private static final JTextField m_field = new JTextField(40);


    public static JButton getButton() { return m_button; }

    public static JTextField getField() { return m_field; }

    public static JTextArea getTextArea() { return m_text_area; }

    public static class MessageSender implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String message = m_field.getText();
            PrintWriter client_writer = ChatDriver.getClient().getWriter();

            client_writer.println(message);
            client_writer.flush();
            System.out.println("Send: " + message);
        }
    }

    public static void display()
    {
        JPanel panel = new JPanel();
        GridBagLayout layout_obj = new GridBagLayout();
        GridBagConstraints constr_obj = new GridBagConstraints();
        panel.setLayout(layout_obj);

        m_field.setText("Enter your message here");
        m_field.grabFocus();

        m_button.addActionListener(new MessageSender());

        m_text_area.setLineWrap(true);
        JScrollPane scroller = new JScrollPane(m_text_area);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        addComponentsToPanel(m_field,panel,layout_obj,constr_obj,0,0,1,1);
        addComponentsToPanel(scroller,panel,layout_obj,constr_obj,0,2,1,1);

        m_frame.add(BorderLayout.CENTER,panel);
        m_frame.add(BorderLayout.SOUTH,m_button);
        m_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m_frame.setSize(600,600);
        m_frame.setVisible(true);
    }

    private static void addComponentsToPanel(Component comp_obj, Container cont_obj, GridBagLayout manager_obj, GridBagConstraints constrains_obj, int gridx, int gridy, int gridwidth, int gridheigth)
    {
        constrains_obj.gridx = gridx;
        constrains_obj.gridy = gridy;

        constrains_obj.gridwidth = gridwidth;
        constrains_obj.gridheight = gridheigth;

        manager_obj.setConstraints(comp_obj,constrains_obj);
        cont_obj.add(comp_obj);
    }

    public static void main(String[] args)
    {
        GUI.display();
    }

}
