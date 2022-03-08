package com.inheritance_example;

public abstract class Feline extends Animal {

    public Feline()
    {
        this("noname",0,"");
    }

    public Feline(String name,int size,String behavior)
    {
        super(name,size,behavior);           //use "super" keyword
                                            //to access parent's constructor
    }

    public Feline(String name,String behavior)
    {
        this(name,0,behavior);
    }

    public Feline(String behavior,String name,int size)
    {
        this(name,size,behavior);
    }

    public void Print()     //Feline implements Print() so Cat doesn't have to do that
    {
        super.Print();
        System.out.println( super.m_name + " is a Feline");
    }
}
