package Cracking_The_Coding_Interview;

import java.util.*;

public class ArraysAndStrings
{
    
    //task 1.1 Version №1
    //Time complexity: O(n * n) because table.contains(Value) takes O(n)
    public static boolean isUnique(String str)
{
        Hashtable<Integer,Character> table = new Hashtable<>();
    
        for (int i=0; i < str.length(); i++)
        {
            if (table.contains(str.charAt(i)))
            { return false; }
            else
            { table.put(i,str.charAt(i)); }
        }
        
        return true;
}

    //task 1.1 Version №2
    //Time complexity: O(n)
    public static boolean isUniqueV2(String str)
    {
        final int size = 127;
        boolean[] letters_arr = new boolean[size];
        int alphabet_position = 0;
        boolean res = false;

        for (int i = 0; i < str.length(); i++)
        {
            alphabet_position = str.charAt(i);

            if (letters_arr[alphabet_position])
            { return res; }
            else
            { letters_arr[alphabet_position] = true; }
        }

        res = true;
        return res;
    }

    //task 1.2  Version №1
    //Time complexity: O(n)
    public static boolean isPermutation(String str1, String str2)
    {
        if (str1.length() != str2.length())
        { return false; }

        Map<Character,Integer> table = new Hashtable<>();

        for (int i = 0; i < str1.length(); i++)
        {
            Character c = str1.charAt(i);

            if (table.containsKey(c))
            {
                Integer amount = table.get(c);
                amount++;
                table.put(c,amount);
            }
            else
            { table.put(c,1); }
        }

        for (int j = 0; j < str2.length(); j++)
        {
            Character c = str2.charAt(j);

            if (table.containsKey(c))
            {
                Integer amount = table.get(c);
                if (amount > 0)
                {
                    amount--;
                    table.put(c,amount);
                }
                else
                { return false; }
            }
            else
            { return false; }
        }

        return true;
    }

    //task 1.2  Version №2
    //Time complexity: O(n * logn)
    //Should've sorted the chars arrays, create two strings out of those arrays and
    //compare the strings
    public static boolean isPermutationV2(String str1, String str2)
    {
        if (str1.length() != str2.length())
        { return false; }

        int[] arr1 = new int[str1.length()];
        int[] arr2 = new int[str2.length()];

        for (int i = 0; i < str1.length(); i++)
        { arr1[i] = str1.charAt(i); }

        for (int j = 0; j < str2.length(); j++)
        { arr2[j] = str2.charAt(j); }

        Arrays.sort(arr2);

        for (int i = 0; i < str1.length(); i++)
        {
            int ind = Arrays.binarySearch(arr2,arr1[i]);

            if (ind >= 0)
            { arr2[ind] = -1; }
            else
            { return false; }
        }

        return true;
    }

    //task 1.3 Version №1
    public static String replaceSpaces(String s)
    {
        int space_counter = 0;

        for (int i=0; i < s.length(); i++)
        {
            if (s.charAt(i) == ' ')
            { space_counter++; }
        }

        final int size = (s.length() - space_counter) + (3 * space_counter);
        char[] chars_arr = new char[size];

        int j = 0;
        for (int k = 0; k < s.length(); k++)
        {
            if (s.charAt(k) == ' ')
            {
                chars_arr[j++] = '%';
                chars_arr[j++] = '2';
                chars_arr[j++] = '0';
            }
            else
            { chars_arr[j++] = s.charAt(k); }
        }

        return new String(chars_arr);
    }

    public static void main(String args[])
    {
        String test_str1 = "abc";
        String test_str2 = "cab";

        boolean test1 = isPermutationV2(test_str1,test_str2);

        System.out.println(test1);

        String test_str3 = "England is a nice country";
        String res_str = replaceSpaces(test_str3);
        System.out.println(res_str);
    }
}