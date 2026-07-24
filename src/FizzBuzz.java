
class FizzBuzz {
    void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        System.out.println(fizzBuzz(n));
    }

    static String fizzBuzz(int n) {
        if (n % 15 == 0) return "FizzBuzz";
        if (n % 3 == 0) return "Fizz";
        if (n % 5 == 0) return "Buzz";

        return String.valueOf(n);
    }
}
