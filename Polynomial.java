public class Polynomial {
    double[] coefficient;

    // Default constructor
    public Polynomial() {
        coefficient = new double[10];  // Initialize the array
        for (int i = 0; i < coefficient.length; i++) {
            coefficient[i] = 0;
        }
    }

    // Constructor with input array
    public Polynomial(double[] input) {
        coefficient = new double[input.length];
        for (int i = 0; i < coefficient.length; i++) {
            coefficient[i] = input[i];
        }
    }

    // Add method: adds two polynomials
    public Polynomial add(Polynomial other) {
        int maxLength = Math.max(this.coefficient.length, other.coefficient.length);
        double[] result = new double[maxLength];

        for (int i = 0; i < maxLength; i++) {
            double thisCoeff = i < this.coefficient.length ? this.coefficient[i] : 0;
            double otherCoeff = i < other.coefficient.length ? other.coefficient[i] : 0;
            result[i] = thisCoeff + otherCoeff;
        }

        return new Polynomial(result);
    }

    // Evaluate method: calculates the polynomial value for a given x
    public double evaluate(double x) {
        double sum = 0;
        for (int i = 0; i < coefficient.length; i++) {
            sum += coefficient[i] * Math.pow(x, i);
        }
        return sum;
    }

    // Check if x is a root of the polynomial
    public boolean hasRoot(double x) {
        return evaluate(x) == 0;
    }
}
