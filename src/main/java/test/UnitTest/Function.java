package test.UnitTest;

public class Function {
    public boolean isNumberEven(Integer number) {
        return number % 2 ==0;
    }

    public boolean isNumberPrime(Integer number) {
        if (number < 0) return false;
        if (number < 2) return true;

        for (int i = 3; i < number -1; i++) {
            if (number %i == 0) return false;
        }

        return true;
    }

    public boolean isPalindrome (String word) {
        if (word.length() < 2) return true;
        if (word.charAt(0) != word.charAt(word.length() - 1)) return false;

        return isPalindrome(word.substring(1, word.length()- 1));
    }
}
