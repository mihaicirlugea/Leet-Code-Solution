class Solution {
    // Helper method to get the value of a single Roman numeral
    int setValue(char c) {
        if (c == 'I') return 1;
        if (c == 'V') return 5;
        if (c == 'X') return 10;
        if (c == 'L') return 50;
        if (c == 'C') return 100;
        if (c == 'D') return 500;
        if (c == 'M') return 1000;
        return 0;
    }

    public int romanToInt(String s) {
        int n = s.length();
        int total = 0;

        // Loop through the string, stopping before the very last character
        for (int i = 0; i < n - 1; i++) {
            int current = setValue(s.charAt(i));
            int next = setValue(s.charAt(i + 1));

            // CRITICAL POINT: If current value is larger or equal, we add it
            if (current >= next) {
                total += current;
            } 
            // CRITICAL POINT: If current value is smaller, it's a subtraction case (like IV)
            else {
                total -= current;
            }
        }

        // CRITICAL POINT: Don't forget to add the last character after the loop ends
        total += setValue(s.charAt(n - 1));

        return total;
    }
}
