package com.inheritance_example;

public abstract class Animal {
    protected String m_name;
    protected int m_size;
    protected String m_behavior;
    protected static int m_count;

    static {                //static initializer
        m_count = 0;
    }

    public Animal()
    {
        this("noname",0,"");
    }

    public Animal(String name,int size,String behavior)     //the main constructor
    {
        m_count++;      //count how many animals there are
        m_name = name;
        m_size = size;
        m_behavior = behavior;
    }

    public Animal(String name, String behavior)
    {
        this(name,0,behavior);              //reusing the main constructor
    }

    public Animal(String behavior,String name,int size)    //the arguments are in a different order
    {                                                       //so it's a different constructor
        this(name,size,behavior);
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

    public static int GetCount()
    {
        return m_count;
    }

}
