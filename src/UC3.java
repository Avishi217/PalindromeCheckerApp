import java.util.Scanner;
public class UC3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to check if it is a palindrome:");
        String input = scanner.nextLine();

        String reversed = "";

        for(int i = input.length() - 1; i >= 0; i--) {
            reversed = reversed + input.charAt(i);
        }

        if(input.equals(reversed)) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}