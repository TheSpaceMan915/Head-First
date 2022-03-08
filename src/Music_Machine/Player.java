package Music_Machine;
import javax.sound.midi.*;
import java.util.concurrent.TimeUnit;

public class Player
{
    public void play()
    {
        try {
            Sequencer CD_player = CD_player = MidiSystem.getSequencer();
            CD_player.open();
            Sequence seq1 = new Sequence(Sequence.PPQ,4);
            Track song1 = seq1.createTrack();

            ShortMessage a = new ShortMessage();
            a.setMessage(144,1,44,10);
            MidiEvent noteOn = new MidiEvent(a,1);
            song1.add(noteOn);

            ShortMessage b = new ShortMessage();
            b.setMessage(144,1,44,100);
            MidiEvent noteOff = new MidiEvent(b,16);
            song1.add(noteOff);

            CD_player.setSequence(seq1);
            CD_player.start();

        }
        catch (Throwable exep)
        {
            System.out.println("Boom");
            exep.printStackTrace();
        }
    }

public static void main (String[] args)
{
    Player t_obj = new Player();
    System.out.println("Halowa");
    while(true){
        t_obj.play();
        try {
            TimeUnit.MILLISECONDS.sleep(120);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

}
