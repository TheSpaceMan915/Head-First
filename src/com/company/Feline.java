package com.company;

abstract class Feline extends Animal {

    Feline(){}

    Feline(String name,int size,String behavior)
    {
        super(name,size,behavior);           //use "super" keyword
                                            //to access parent's constructor
    }

    void WalkAround()
    {
        System.out.println("I'm walking by myself");
    }

}
