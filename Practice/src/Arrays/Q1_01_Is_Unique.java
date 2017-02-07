package Arrays;

import java.util.HashSet;

public class Q1_01_Is_Unique {
    public static boolean is_Unique1(String mystring) {
        long startTime = System.nanoTime();
        boolean result = false;
        HashSet<Character> currentChar = new HashSet();
        // Read each character of string in for loop
        // Add each character to hashset
        // if add returns False, break
        // else if it doesnt for the end of string return true

        for (int i = 0; i < mystring.length(); i++) {
            result = currentChar.add(mystring.charAt(i));

            if (!result) {
                return false;
            }
        }
        long endTime = System.nanoTime();

        long elapsedTime = endTime - startTime;
        System.out.println("Time took to run the code HASHSET: " + elapsedTime);
        return result;
    }

    public static boolean is_Unique2(String mystring) {

        // use bit vector to do comparison
        // return false if string is more than 26 characters in length
        // assuming a-z
        // use int vector for bitwise comparison
        // loop through the string and return false if bitwise & returns true
        // do bitwise | when & is == 0
        // return true at the end
        long startTime = System.nanoTime();

        if (mystring.length() > 26) {
            return false;
        }

        int checker = 0;
        for (int i = 0; i < mystring.length(); i++) {
            int val = mystring.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) return false;
            checker |= (1 << val);
        }
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println("Time took to run the code BITWISE : " + elapsedTime);

        return true;
    }

    public static boolean is_Unique3(String mystring) {
        long startTime = System.nanoTime();

        if (mystring.length() > 128) {
            return false;
        }
        boolean[] char_set = new boolean[128];
        for (int i = 0; i < mystring.length(); i++) {
            int val = mystring.charAt(i);
            if (char_set[val]) return false;
            char_set[val] = true;
        }
        long endTime = System.nanoTime();

        long elapsedTime = endTime - startTime;
        System.out.println("Time took to run the code ARRAY: " + elapsedTime);
        return true;
    }
}

// performance O(n)
// performance O(1)

// testCases:
/*
        boolean isUnique = Q1_01_Is_Unique.is_Unique("My Name@");
        System.out.println(isUnique);
 */
