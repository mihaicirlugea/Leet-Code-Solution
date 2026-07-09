//Basic Version (Full Reversal)

class SolutionBasic {
    public boolean isPalindrome(int x) {
        // Negative numbers cannot be palindromes
        if (x < 0) {
            return false;
        }
        
        int copy = x; 
        int y = 0;
        
        // Reverse the entire integer digit by digit
        while (copy != 0) {
            y = (y * 10) + (copy % 10);
            copy = copy / 10;
        }
        
        // Compare the original number with the fully reversed number
        return x == y;
    }
}

//Efficient Version (Half Reversal)

class SolutionEfficient {
    public boolean isPalindrome(int x) {
        // 1. Negative numbers are not palindromes.
        // 2. Any number ending in 0 (except 0 itself) cannot be a palindrome 
        //    because a valid number cannot start with 0.
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        // Reverse the digits only up to the middle of the number
        while (x > revertedNumber) {
            revertedNumber = (revertedNumber * 10) + (x % 10);
            x /= 10;
        }

        // For even-length numbers: x must equal revertedNumber (e.g., 12 == 12)
        // For odd-length numbers: we discard the middle digit via division by 10 (e.g., 12 == 123 / 10)
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
