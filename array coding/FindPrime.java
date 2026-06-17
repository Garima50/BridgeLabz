public class FindPrime {

    public static void main(String[] args) {

        int num = 29;

        boolean isPrime = true;

        // 0 and 1 are not prime numbers
        if (num <= 1) {
            isPrime = false;
        }

        // Check divisibility till square root of number
        for (int i = 2; i * i <= num; i++) {

            // If perfectly divisible, number is not prime
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime) {
            System.out.println(num + " is Prime");
        } else {
            System.out.println(num + " is Not Prime");
        }
    }
}