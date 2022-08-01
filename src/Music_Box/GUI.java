package Music_Box;
import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class GUI {
    ArrayList<JCheckBox> check_boxes_arr = new ArrayList<JCheckBox>();
    static final int n_check_boxes = 256;
    ArrayList<JLabel> labels_arr = new ArrayList<JLabel>();
    JButton start_button = new JButton("Start");
    JButton stop_button = new JButton("Stop");
    JButton tempo_up_button = new JButton("Tempo up");
    JButton tempo_down_button = new JButton("Tempo down");
    JFrame m_frame = new JFrame();
    Box m_labels_box = new Box(BoxLayout.Y_AXIS);           //use Box class so I can set the distance
    Box m_checkboxes_box = new Box(BoxLayout.Y_AXIS);      //between labels
    Box m_buttons_box = new Box(BoxLayout.Y_AXIS);
    String[] instruments_arr = {"Bass Drum","Closed Hi-Hat","Open Hi-Hat","Acoustic Snare","Crash Cymbal",
            "Hand Clap","High Tom","Hi Bongo","Maracas","Whistle","Low Conga","Cowbell","Vibraslap",
            "Low-mid Tom","High Agogo","Open Hi Conga"};
    Sequencer m_sequencer;
    Sequence m_sequence;
    Track m_track;


    //Func buildGUI
    public void BuildGUI()
    {
        m_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m_frame.setSize(685,600);
        Font bigger_font = new Font("Sans_Serif", Font.PLAIN,20);

        //create labels and add them to the panel
        JLabel temp_label;
        for (String label : instruments_arr)
        {
            temp_label = new JLabel(label);
            temp_label.setFont(bigger_font);
            labels_arr.add(temp_label);
        }

        for (JLabel label : labels_arr)
        {
            m_labels_box.add(label);
        }
        //m_labels_box.setBorder(BorderFactory.createEmptyBorder(10,10,0,0));

        //create checkboxes and add them to the panel
        for (int i = 0; i < n_check_boxes; i++)
        {
            JCheckBox temp_box = new JCheckBox();
            check_boxes_arr.add(temp_box);
        }
        for (JCheckBox box : check_boxes_arr)
        {
            m_checkboxes_box.add(box);
        }
        //m_check_boxes_panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        m_frame.getContentPane().add(BorderLayout.CENTER, m_checkboxes_box);

        //add buttons to the panel
        m_buttons_box.add(start_button);
        m_buttons_box.add(stop_button);
        m_buttons_box.add(tempo_up_button);
        m_buttons_box.add(tempo_down_button);
        //m_buttons_panel.setBorder(BorderFactory.createEmptyBorder(10,0,10,10));
        m_frame.getContentPane().add(BorderLayout.EAST, m_buttons_box);

        m_frame.setVisible(true);

    }

    public static void BuildTracksAndStart()
    {

    }

    public void SetUpActionListeners(GUI obj)
    {
        obj.start_button.addActionListener(act_obj -> BuildTracksAndStart());
        obj.stop_button.addActionListener(act_obj -> m_sequencer.stop());
        obj.tempo_up_button.addActionListener(act_obj ->
        {
            float tempo_factor = m_sequencer.getTempoFactor();
            float adjusting_tempo = tempo_factor * 1.03f;           //increase the tempo by 3%
            m_sequencer.setTempoFactor(adjusting_tempo);
        });

        obj.tempo_down_button.addActionListener(act_obj ->
        {
            float tempo_factor = m_sequencer.getTempoFactor();
            float adjusting_tempo = tempo_factor * .97f;            //decrease the tempo by 3%
            m_sequencer.setTempoFactor(adjusting_tempo);
        });

    }

    public static void main(String[] args)
    {
        GUI gui_obj = new GUI();
        gui_obj.BuildGUI();


    }

    }
