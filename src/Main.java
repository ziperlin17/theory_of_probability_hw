import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static BigInteger factorialOf(BigInteger n) {
        if (n.equals(BigInteger.ZERO))
            return BigInteger.ONE;
        else
            return n.multiply(factorialOf(n.subtract(BigInteger.ONE)));
    }

    public static void permutationsWithRepetition(String numbers) {
        String[] nums = numbers.split(" ");
        BigInteger numerator = BigInteger.valueOf(0);
        BigInteger denominator = BigInteger.valueOf(1);
        for (int i = 0; i < nums.length; i++) {
            int numi=Integer.parseInt(nums[i]);
            numerator = numerator.add(BigInteger.valueOf(numi));
            denominator = denominator.multiply(factorialOf(BigInteger.valueOf(numi)));
        }
        System.out.println(factorialOf(numerator).divide(denominator));
    }

    public static void permutationsWithoutRepetition(int number) {
        System.out.println(factorialOf(BigInteger.valueOf(number)));
    }

    public static void combinationWithoutRepetitions(int n, int k){
        BigInteger numerator = factorialOf(BigInteger.valueOf(n));
        BigInteger denominator = factorialOf(BigInteger.valueOf(k)).multiply(BigInteger.valueOf(n-k));
        System.out.println(numerator.divide(denominator));
    }

    public static void combinationWithRepetitions(int n, int k){
        BigInteger numerator = factorialOf(BigInteger.valueOf(n+k-1));
        BigInteger denominator = factorialOf(BigInteger.valueOf(k)).multiply(BigInteger.valueOf(n-1));
        System.out.println(numerator.divide(denominator));
    }

    public static void placementWithoutRepetitions(int n, int k) {
        BigInteger numerator = factorialOf(BigInteger.valueOf(n));
        BigInteger denominator = factorialOf(BigInteger.valueOf(n-k));
        System.out.println(numerator.divide(denominator));
    }

    public static void placementWithRepetitions(int n, int k) {
        BigInteger base = BigInteger.valueOf(n);
        System.out.println(base.pow(k));
    }


    public static void main(String[] args) {
        System.out.println("""
                       1. permutations Without Repetition
                       2. permutations With Repetition
                       3. combination Without repetitions
                       4. combination With Repetitions
                       5. placement Without Repetitions
                       6. placement With Repetitions"""
        );
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String sc;
            sc = scanner.next();
            if (sc.equals("6")) {
                System.out.print("n = ");
                int n = scanner.nextInt();
                System.out.print("k = ");
                int k = scanner.nextInt();
                System.out.print("result = ");
                placementWithRepetitions(n, k);
            }
            else if (sc.equals("5")) {
                System.out.print("n = ");
                int n = scanner.nextInt();
                System.out.print("k = ");
                int k = scanner.nextInt();
                if (n<k){
                    System.out.println("invalid data");
                } else {
                    System.out.print("result = ");
                    placementWithoutRepetitions(n, k);
                }
            }
            else if (sc.equals("4")) {
                System.out.print("n = ");
                int n = scanner.nextInt();
                System.out.print("k = ");
                int k = scanner.nextInt();
                System.out.print("result = ");
                combinationWithRepetitions(n, k);
            }
            else if (sc.equals("3")) {
                System.out.print("n = ");
                int n = scanner.nextInt();
                System.out.print("k = ");
                int k = scanner.nextInt();
                if (n<k){
                    System.out.println("invalid data");
                } else {
                    System.out.print("result = ");
                    combinationWithoutRepetitions(n, k);
                }
            }
            else if (sc.equals("2")) {
                System.out.print("n = ");
                int n = scanner.nextInt();
                System.out.print("result = ");
                permutationsWithoutRepetition(n);
            }
            else if (sc.equals("1")) {
                Scanner sc2 = new Scanner(System.in);
                System.out.print("enter the numbers separated by a space: ");
                String nums = sc2.nextLine();
                System.out.print("result = ");
                permutationsWithRepetition(nums);
            }
            System.out.println("""
                       
                       1. permutations Without Repetition
                       2. permutations With Repetition
                       3. combination Without repetitions
                       4. combination With Repetitions
                       5. placement Without Repetitions
                       6. placement With Repetitions"""
            );
        }
    }
}