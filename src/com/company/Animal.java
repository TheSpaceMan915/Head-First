package com.company;

abstract class Animal {
    protected String m_name;
    protected int m_size;
    protected String m_behavior;

    Animal(){}

    Animal(String name,int size,String behavior)
    {
        m_name = name;
        m_size = size;
        m_behavior = behavior;
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
