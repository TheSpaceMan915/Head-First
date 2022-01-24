package com.company;

public class Cat extends Feline
{
    String m_colour;

    Cat(){}

    Cat(String name,int size,String behavior,String colour)
    {
        super(name,size,behavior);
        m_colour = colour;
    }

    void Print()
    {
        System.out.println("Cat " + m_name + " says meayyy");
    }
}
