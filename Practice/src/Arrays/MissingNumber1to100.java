package Arrays;

public class MissingNumber1to100 {

    public static void findMissingInteger(int[] listOfNumbers) {
        long startTime = System.currentTimeMillis();
        Long sum = 0L; // uses Long, not long
        for(long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("The missing number is: " + sum + " And it took " +  elapsedTime + " milliseconds");
    }
}
