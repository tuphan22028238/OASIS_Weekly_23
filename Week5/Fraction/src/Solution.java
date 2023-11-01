public class Solution {
    private int denominator = 1;
    private int numerator;

    public int getDenominator() {
        return denominator;
    }

    /**
     * set the denominator.
     * @param denominator given denominator
     */
    public void setDenominator(int denominator) {
        if (denominator == 0) {
            this.denominator = 1;
        }
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    /**
     * Constructor initializes a fraction.
     * @param numerator numerator of the fraction
     * @param denominator denominator of the fraction
     */
    Solution(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator != 0) {
            this.denominator = denominator;
        }
    }

    /**
     * Calculate the gcd.
     * @param a the first number
     * @param b the second number
     * @return gcd of two number
     */
    int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        int tmp;
        while (b != 0) {
            tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    /**
     * Reduce the fraction.
     * @return the reduced fraction
     */
    Solution reduce() {
        int i = gcd(numerator, denominator);
        numerator /= i;
        denominator /= i;
        if (denominator < 0) {
            numerator = - numerator;
            denominator = - denominator;
        }
        return this;
    }

    /**
     * Adding two fraction.
     * @param other other fraction
     * @returnthe sum of two fraction
     */
    Solution add(Solution other) {
        int i = denominator * other.denominator;
        numerator = numerator * other.denominator + denominator * other.numerator;
        denominator = i;
        return this.reduce();
    }

    /**
     * subtract two fraction.
     * @param other other fraction
     * @return subtraction of two fraction
     */
    Solution subtract(Solution other) {
        int i = denominator * other.denominator;
        numerator = numerator * other.denominator - denominator * other.numerator;
        denominator = i;
        return this.reduce();
    }

    /**
     * multiply two fraction.
     * @param other other fraction
     * @return multiplication of two fraction
     */
    Solution multiply(Solution other) {
        numerator *= other.numerator;
        denominator *= other.denominator;
        return this.reduce();
    }

    /**
     * divide two fraction.
     * @param other other fraction
     * @return division of two fraction
     */
    Solution divide(Solution other) {
        if (other.numerator != 0) {
            numerator *= other.denominator;
            denominator *= other.numerator;
        }
        return this.reduce();
    }

    /**
     * compare two fraction.
     * @param obj the other fraction
     * @return true if two fractions are equal
     */
    public boolean equals(Object obj) {
        if (obj instanceof Solution) {
            Solution other = (Solution) obj;
            return (other.subtract(this)).numerator == 0;
        }
        return false;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

}
