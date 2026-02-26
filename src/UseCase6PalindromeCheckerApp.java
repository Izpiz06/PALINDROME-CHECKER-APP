import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
public class UseCase6PalindromeCheckerApp {
    public static void main(String[] args) {
        // Define the input string to validate
        String input = "civic";
        // Create a Queue (FIFO)
        Queue<Character> queue = new LinkedList<>();
        // Create a Stack (LIFO)
        Stack<Character> stack = new Stack<>();
        // Insert each character into both queue and stack
        for (char c : input.toCharArray()) {
            queue.add(c);
            stack.push(c);
        }
        // Flag to track palindrome status
        boolean isPalindrome = true;
        // Compare characters until queue becomes empty
        while (!queue.isEmpty()) {
            if (!queue.remove().equals(stack.pop())) {
                isPalindrome = false;
                break;
            }
        }
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}