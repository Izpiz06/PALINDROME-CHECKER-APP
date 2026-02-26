public class UseCase13PalindromeCheckerApp {

    public static void main(String[] args) {
        String input = "A man a plan a canal Panama";
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println("Input : " + input);
        System.out.println();
        long start1 = System.nanoTime();
        boolean result1 = twoPointerCheck(normalized);
        long end1 = System.nanoTime();
        long time1 = end1 - start1;
        long start2 = System.nanoTime();
        boolean result2 = reverseCheck(normalized);
        long end2 = System.nanoTime();
        long time2 = end2 - start2;
        long start3 = System.nanoTime();
        boolean result3 = stackCheck(normalized);
        long end3 = System.nanoTime();
        long time3 = end3 - start3;
        System.out.println("Two Pointer Result : " + result1);
        System.out.println("Execution Time (ns): " + time1);
        System.out.println();
        System.out.println("Reverse String Result : " + result2);
        System.out.println("Execution Time (ns): " + time2);
        System.out.println();
        System.out.println("Stack Result : " + result3);
        System.out.println("Execution Time (ns): " + time3);
    }
    private static boolean twoPointerCheck(String input) {
        int start = 0;
        int end = input.length() - 1;
        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    private static boolean reverseCheck(String input) {
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }
        return input.equals(reversed);
    }
    private static boolean stackCheck(String input) {
        java.util.Stack<Character> stack = new java.util.Stack<>();
        for (char c : input.toCharArray()) {
            stack.push(c);
        }
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}