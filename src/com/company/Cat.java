package com.company;

public class Cat extends Feline implements Pet
{
    private String m_colour;

    public Cat(){}

    public Cat(String name,int size,String behavior,String colour)
    {
        super(name,size,behavior);
        m_colour = colour;
    }

    public Cat(String name,String behavior,String colour)
    {
        super(name,behavior);
        m_colour = colour;
    }

    public Cat(String name,String behavior, int size, String colour)
    {
        super(behavior,name,size);
        m_colour = colour;
    }

    public void WalkAround()
    {
        System.out.println("I'm walking by myself\n");
    }

    /*\\public void Print()
    {
        System.out.println("Cat " + m_name + " says meayyy");
    }
*/

    public void BeFriendly()
    {
        //being friendly
    }

    public void LickHand()
    {
        //licking your hand
    }
}
