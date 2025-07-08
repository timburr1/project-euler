import java.util.*;

public class Driver {

    // https://projecteuler.net/problem=1
    private static void problemOne() {
        int sum = 0;

        for(int i=2; i < 1000; i++) {
            if(i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }

        System.out.println(sum);
    }

    // https://projecteuler.net/problem=2
    private static void problemTwo() {
        int sum = 2;

        int i = 1;
        int j = 2;
        int k = i + j;
        while(k <= 4000000) {
            if(k % 2 == 0) {
                sum += k;
            }

            i = j;
            j = k;
            k = i + j;
        }

        System.out.println(sum);
    }

    // https://projecteuler.net/problem=3
    private static void problemThree() {
        List<Long> primeFactors = new ArrayList<>();
        long num = 600851475143L;
        int d = 2;

        while(num > 1) {
            while(num % d == 0) {
                primeFactors.add(Long.valueOf(d));
                num /= d;
            }
            d++;
            if(d*d > num) {
                if(num > 1) {
                    primeFactors.add(num);
                }
                break;
            }
        }    
        
        long max = 1L;
        for(int i =0; i < primeFactors.size(); i++) {
            if(primeFactors.get(i) > max) {
                max = primeFactors.get(i);
            }
        }

        System.out.println(max);
    }

    // https://projecteuler.net/problem=4
    private static void problemFour() {
        int maxPalindrome = 0;

        for(int i=999; i > 500; i--) {
            for(int j=999; j > 500; j--) {
                int p = i * j;
                
                if(p > maxPalindrome && isPalindrome(p)) {
                    maxPalindrome = p;
                }
            }
        }

        System.out.println(maxPalindrome);
    }

    private static boolean isPalindrome(Integer i) {
        String s = i.toString();

        for(int n=0; n < s.length() / 2; n++) {
            if(s.charAt(n) != s.charAt(s.length() - 1 - n)) {
                return false;
            }
        }

        return true;
    }

    // https://projecteuler.net/problem=5
    private static void problemFive() {

        int i = 11;
        while(!fullyDivisible(i)) {
            i++;
        }

        System.out.println(i);
    }

    private static boolean fullyDivisible(int i) {

        for(int j=20; j > 5; j--) {
            if(i % j != 0) {
                return false;
            }
        }
        
        return true;
    }

    // https://projecteuler.net/problem=6
    private static void problemSix() {
        int sumOfSquares = 0;
        for(int i=1; i <= 100; i++) {
            sumOfSquares += i*i;
        }

        int sum = 0;
        for(int i=1; i <= 100; i++) {
            sum += i;
        }
        int squareOfSums = sum * sum;

        System.out.println(squareOfSums - sumOfSquares);
    }

    // https://projecteuler.net/problem=7
    private static void problemSeven() {
        final int TARGET = 10001;
        int count = 0;

        for(int i=2; count < TARGET; i++) {
            if(isPrime(i)) {
                count++;

                if(count == TARGET) {
                    System.out.println(i);
                    return;
                }
            }            
        }
    }

    private static boolean isPrime(int i) {

        for(int j=2; j <= i/2; j++) {
            if(i % j == 0) {
                return false;
            }
        }

        // System.out.println(i);
        return true;
    }

    // https://projecteuler.net/problem=8
    private static void problemEight() {
        String numString = "73167176531330624919225119674426574742355349194934"
                + "96983520312774506326239578318016984801869478851843"
                + "85861560789112949495459501737958331952853208805511"
                + "12540698747158523863050715693290963295227443043557"
                + "66896648950445244523161731856403098711121722383113"
                + "62229893423380308135336276614282806444486645238749"
                + "30358907296290491560440772390713810515859307960866"
                + "70172427121883998797908792274921901699720888093776"
                + "65727333001053367881220235421809751254540594752243"
                + "52584907711670556013604839586446706324415722155397"
                + "53697817977846174064955149290862569321978468622482"
                + "83972241375657056057490261407972968652414535100474"
                + "82166370484403199890008895243450658541227588666881"
                + "16427171479924442928230863465674813919123162824586"
                + "17866458359124566529476545682848912883142607690042"
                + "24219022671055626321111109370544217506941658960408"
                + "07198403850962455444362981230987879927244284909188"
                + "84580156166097919133875499200524063689912560717606"
                + "05886116467109405077541002256983155200055935729725"
                + "71636269561882670428252483600823257530420752963450";
        long maxProduct = 0;
        final int LEN = 13;

        for(int i = 0; i < numString.length() - LEN; i++) {   
            long p = 1;
            for(int j = i; j <= i + LEN - 1; j++) {  
                p *= Integer.parseInt(String.valueOf(numString.charAt(j)));
                if(p == 0) {
                    break;
                }
            }

            if(p > maxProduct) {
                maxProduct = p;
            }
        }

        System.out.println(maxProduct);
    }

    // https://projecteuler.net/problem=9
    private static void problemNine() {

        for(int a=1; a < 500; a++) {
            for(int b = a+1; b < 500; b++) {
                int c = 1000 - a - b;
                
                if(a*a + b*b == c*c) {
                    System.out.println(a * b * c);
                    return;
                }
            }         
        }
        
        System.out.println("Failed to find.");
    }

    // https://projecteuler.net/problem=10
    private static void problemTen() {
        Long sum = 17L;

        for(int i=11; i < 2000000; i++) {
            if(isPrime(i)) {
                sum += i;
            }
        }

        System.out.println(sum);
    }

    public static void main(String[] args) {
        problemTen();
        return;
    }
}