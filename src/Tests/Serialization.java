package Tests;
import Animals_Inheritance.Animal;
import Animals_Inheritance.Cat;

import java.io.*;

public class Serialization {


    private static final File m_file = new File("justfile.txt");

    public static void serializeObjects()
    {
        try
        {
            FileOutputStream file_stream = new FileOutputStream(m_file);
            ObjectOutputStream writer_obj = new ObjectOutputStream(file_stream);

            Cat cat1 = new Cat("Link","Good",12,"Black");
            Cat cat2 = new Cat("Bob","Nice",10,"White");
            Cat cat3 = new Cat("Dave","Nasty",5,"Ginger");

            writer_obj.writeObject(cat1);
            writer_obj.writeObject(cat2);
            writer_obj.writeObject(cat3);

            writer_obj.close();
        }
        catch (Exception exep)
        { exep.printStackTrace(); }
    }

    public static void deserializeObjects()
    {
        try
        {
            FileInputStream input_stream = new FileInputStream(m_file);
            ObjectInputStream reader_obj = new ObjectInputStream(input_stream);

            Animal animal1 = (Cat) reader_obj.readObject();
            System.out.println(animal1.GetSize());

            Animal animal2 = (Cat) reader_obj.readObject();
            Animal animal3 = (Cat) reader_obj.readObject();

            reader_obj.close();
        }
        catch (Exception exep)
        { exep.printStackTrace(); }

    }


    public static void main(String[] args)
    {

    }
}
