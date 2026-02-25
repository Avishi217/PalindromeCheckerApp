import java.util.*;

public class UseCase13PalindromeCheckerApp {

    // 1️⃣ Iterative Two-Pointer Method
    public static boolean iterativeCheck(String input) {
        String processed = input.replaceAll("\\s+", "").toLowerCase();
        int start = 0;
        int end = processed.length() - 1;

        while (start < end) {
            if (processed.charAt(start) != processed.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // 2️⃣ Stack-Based Method
    public static boolean stackCheck(String input) {
        String processed = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char ch : processed.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : processed.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    // 3️⃣ Recursive Method
    public static boolean recursiveCheck(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return recursiveCheck(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Palindrome Performance Comparison =====");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String processed = input.replaceAll("\\s+", "").toLowerCase();

        // Measure Iterative
        long startTime = System.nanoTime();
        boolean iterativeResult = iterativeCheck(input);
        long endTime = System.nanoTime();
        long iterativeTime = endTime - startTime;

        // Measure Stack
        startTime = System.nanoTime();
        boolean stackResult = stackCheck(input);
        endTime = System.nanoTime();
        long stackTime = endTime - startTime;

        // Measure Recursive
        startTime = System.nanoTime();
        boolean recursiveResult = recursiveCheck(processed, 0, processed.length() - 1);
        endTime = System.nanoTime();
        long recursiveTime = endTime - startTime;

        System.out.println("\n===== Results =====");
        System.out.println("Iterative Result : " + iterativeResult + " | Time: " + iterativeTime + " ns");
        System.out.println("Stack Result     : " + stackResult + " | Time: " + stackTime + " ns");
        System.out.println("Recursive Result : " + recursiveResult + " | Time: " + recursiveTime + " ns");

        scanner.close();
    }
}