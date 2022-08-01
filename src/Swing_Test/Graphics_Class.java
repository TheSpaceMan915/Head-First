package Swing_Test;
import javax.swing.*;
import java.awt.*;

public class Graphics_Class {
    private JFrame m_frame = new JFrame();
    private JPanel m_panel = new JPanel();
    private JTextArea m_area = new JTextArea();
    private JList m_list;

    //an explicit implementation of the ActionListener interface
  /*  public class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent obj)      //this is an event-handling method
        {
            m_label.setText("Check out this");
            m_frame.repaint();
        }
    }*/

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

    //A method to make text areas
    public JScrollPane MakeTextArea(int area_rows,int area_columns)
    {
        m_area.setRows(area_rows);
        m_area.setColumns(area_columns);
        JScrollPane scroller_obj = new JScrollPane(m_area);
        m_area.setLineWrap(true);
        scroller_obj.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller_obj.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        m_area.setText("Check out what you've written: ");
        return scroller_obj;
    }

    //A method to make Jlists
    public JScrollPane MakeList(Object[] arr, int max_number_of_lines)
    {
        m_list = new JList(arr);

        JScrollPane scroller = new JScrollPane(m_list);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        m_list.setVisibleRowCount(max_number_of_lines);
        m_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        return scroller;
    }

    public void PaintScreen() {
        JTextField field = new JTextField(40);
        JButton button = new JButton("Print");
        Font font_obj = new Font("SANS_SERIF",Font.PLAIN,14);
        JLabel label = new JLabel("Enter your text here:  ");
        JLabel label_title = new JLabel("Testing frame");
        JCheckBox box = new JCheckBox("Check it");

        m_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m_frame.setSize(600, 600);
        button.setFont(font_obj);

        m_frame.getContentPane().add(BorderLayout.NORTH,label_title);
        m_frame.getContentPane().add(BorderLayout.SOUTH,button);
        m_panel.add(label);
        m_panel.add(field);
        m_panel.add(box);

        //make a text area with a scroll bar
        JScrollPane text_area = MakeTextArea(4,45);
        m_panel.add(text_area);

        //make a JList
        String[] arr = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        JScrollPane list = MakeList(arr,5);
        m_panel.add(list);
        m_frame.getContentPane().add(BorderLayout.CENTER,m_panel);
        m_frame.setVisible(true);

        //MyDrawingPanel
       /* MyDrawingPanel panel = new MyDrawingPanel();
        panel.add(button);
        panel.add(field);
        m_frame.getContentPane().add(BorderLayout.CENTER, panel);*/

        //use a wrapper in order to be able to modify local variables within a lambda expression
        var wrapper = new Object(){String str = ""; };

        //an event-listener using a lambda expression
        button.addActionListener(obj -> m_area.append('\n' + wrapper.str));
        //button.addActionListener(new ButtonListener());

        field.addActionListener(obj ->
        {
            wrapper.str = field.getText();
        });

        box.addActionListener(obj ->
        {
            if (box.isSelected())
            {wrapper.str = "The box's been checked";}
            else
            {wrapper.str = "You've unchecked it";}
        });

        m_list.addListSelectionListener(obj ->
        {
            if (!m_list.getValueIsAdjusting())
            {
                String selected_line = (String) m_list.getSelectedValue();
                m_area.append('\n' + selected_line);
            }
        });
    }

    public static void main(String[] args) {
        Graphics_Class graph_obj = new Graphics_Class();
        graph_obj.PaintScreen();
        //graph_obj.PaintWithInnerPanel();
    }
}
