package com.company;

public abstract class Animal {
    protected String m_name;
    protected int m_size;
    protected String m_behavior;

    public Animal()
    {
        this("noname",0,"");
    }

    public Animal(String name,int size,String behavior)
    {
        m_name = name;
        m_size = size;
        m_behavior = behavior;
    }

    public Animal(String name, String behavior)   //constructor with default size
    {
        m_name = name;
        m_behavior = behavior;
        m_size = 0;
    }

    public Animal(String behavior,String name,int size)    //the arguments are in a different order
    {                                                       //so it's a different constructor
        m_name = name;
        m_behavior = behavior;
        m_size = size;
    }

    final public int GetSize()
    {
        return m_size;
    }

    abstract void WalkAround();

    void Print()
    {
        System.out.println("Animal " + m_name + " says Rrrr");
    }



}
