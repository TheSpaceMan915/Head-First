package Tests;

import java.util.Scanner;

public class DriveThread {

    private class Person
    {
        public int m_age;
        public String m_profession;

        public Person(int age, String profession)
        {
            m_age = age;
            m_profession = profession;
        }
    }

    private class ThreadJob implements Runnable
    {
        private final Person dave = new Person(32,"Software engineer");

        @Override
        public void run()
        {
            changeAge();
        }

        public void changeAge()
        {

            Scanner keyboard = new Scanner(System.in);

            synchronized (dave)
            {
                System.out.println("Enter age: ");
                int age = keyboard.nextInt();
                dave.m_age = age;
                System.out.println("Dave's age is " + dave.m_age);
            }
        }
    }

    public void go()
    {
        final Runnable thread_job = new ThreadJob();

        Thread thread_age1 = new Thread(thread_job);
        Thread thread_age2 = new Thread(thread_job);

        thread_age1.start();
        thread_age2.start();

    }

    public static void main(String[] args)
    {
        //creating a thread using Lambda expression
        Thread thread_obj = new Thread( () ->
        {
            System.out.println("The lambda thread has worked");
        });

        DriveThread driver = new DriveThread();
        driver.go();

        System.out.println("The main has finished");
    }
}
