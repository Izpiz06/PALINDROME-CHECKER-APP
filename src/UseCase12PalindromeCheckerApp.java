public class UseCase12PalindromeCheckerApp {
    public static void main(String[] args) {
        String input = "madam";
        // Inject strategy at runtime
        PalindromeStrategy strategy = new StackStrategy();
        // To switch algorithm dynamically, replace above line with:
        // PalindromeStrategy strategy = new DequeStrategy();
        boolean result = strategy.check(input);
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + result);
    }
    // INTERFACE
    interface PalindromeStrategy {
        boolean check(String input);
    }
    // STACK BASED STRATEGY (LIFO)
    static class StackStrategy implements PalindromeStrategy {
        @Override
        public boolean check(String input) {
            java.util.Stack<Character> stack = new java.util.Stack<>();
            // Push characters onto stack
            for (char c : input.toCharArray()) {
                stack.push(c);
            }
            // Compare by popping
            for (char c : input.toCharArray()) {
                if (c != stack.pop()) {
                    return false;
                }
            }
            return true;
        }
    }
    // DEQUE BASED STRATEGY (Bidirectional)
    static class DequeStrategy implements PalindromeStrategy {
        @Override
        public boolean check(String input) {
            java.util.Deque<Character> deque =
                    new java.util.ArrayDeque<>();
            for (char c : input.toCharArray()) {
                deque.addLast(c);
            }
            while (deque.size() > 1) {
                if (!deque.removeFirst()
                        .equals(deque.removeLast())) {
                    return false;
                }
            }
            return true;
        }
    }
}