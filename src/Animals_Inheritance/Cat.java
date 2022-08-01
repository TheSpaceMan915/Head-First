package Animals_Inheritance;

public class Cat extends Feline implements Pet
{
    private String m_colour;

    public Cat()
    {
        this("noname",0,"Fine","");
    }

    public Cat(String name,int size,String behavior,String colour)
    {
        super(name,size,behavior);
        m_colour = colour;
    }

    public Cat(String name,String behavior,String colour)
    {
        this(name,0,behavior,colour);
    }

    public Cat(String name,String behavior, int size, String colour)
    {
        this(name,size,behavior,colour);
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
