package Music_Machine;

import java.util.ArrayList;

public class MathTesting
{
public int m_value;
public Integer m_valueobj;

    public static void main(String[] args) {

        ArrayList <Integer> list1 = new ArrayList <Integer>();
        list1.add(3);

        Integer iwrap = 3;
        Float fwrap = 4f;
        MathTesting obj = new MathTesting();

        for (int i = 0;i < list1.size();i++)
        {
            System.out.println(list1.get(i));
        }

        obj.PrintValues();

        try {
            int gf = 5/0;
        }
        catch (Exception exep) {
            exep.printStackTrace();
            System.out.println("Boom");
        }

    }

    public void PrintValues()
    {
        System.out.println(m_value);
        System.out.println(m_valueobj);
    }
}
