package Animals_Inheritance;
import java.util.*;

public class Main {

    public static void func(List<? extends Animal> list_animals)
    {
        list_animals.forEach(animal -> animal.Print() );
    }
    public static void main(String[] args) {

        Animal cat2 = new Cat("Barsik",3,"Naughty","White");

        Animal cat3 = new Cat("Rijik","Bad","Orange");

        //polymorphism:
        //create an Animal reference and assign to it a Cat object
        Animal mycat = new Cat("Frousa",4,"Awesome","Grey");

        ArrayList <Animal> arr_animals = new ArrayList<Animal>();

        arr_animals.add(mycat);       //polymorphism:
                                    //add a Cat object in an Animal ArrayList
        arr_animals.add(cat2);
        /*
        for (int i = 0; i < arr_animal.size();i++)
        {
            arr_animal.get(i).Print();           //get(index) returns the element
            arr_animal.get(i).WalkAround();      //at the specified position in the list

        }
*/

        ArrayList<Animal> arr_cats = new ArrayList<>();
        Cat cat4 = new Cat();
        arr_cats.add(cat4);

        func(arr_cats);
    }
}
