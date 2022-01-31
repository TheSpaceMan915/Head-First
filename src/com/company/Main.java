package com.company;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Animal cat2 = new Cat("Barsik",3,"Naughty","White");

        Animal cat3 = new Cat("Rijik","Bad","Orange");

        //polymorphism:
        //create an Animal reference and assign to it a Cat object
        Animal mycat = new Cat("Frousa",4,"Awesome","Grey");

        ArrayList <Animal> arr_animal = new ArrayList<Animal>();

        arr_animal.add(mycat);       //polymorphism:
                                    //add a Cat object in an Animal ArrayList
        arr_animal.add(cat2);

        for (int i = 0; i < arr_animal.size();i++)
        {
            arr_animal.get(i).Print();           //get(index) returns the element
            arr_animal.get(i).WalkAround();      //at the specified position in the list

        }

    }
}
