public class Polynomial {
    double[] coefficient;
    int[] expo;

    public Polynomial() {
        this coefficient = new double[0];
        this expo = new int[0];
    }
    public Polynomial(File file) {
       
    }

    public Polynomial(double[] coef, int[] exponent) {
        coefficient = new double[coef.length];
        expo = new int[exponent.length]
        for (int i = 0; i < coefficient.length; i++) {
            coefficient[i] = coef[i];
            expo[i] = exponent[i];
        }
    }

    public int in_list(double[] a, double b) {
    	for (int i = 0; i <  a.length; i++) {
        	if (a[i]==b) return 1;
        }
    	return 0;
    }
    public Polynomial add(Polynomial given) {
        int maxExp = Math.max(this.expo[this.expo.length - 1], given.expo[given.expo.length - 1]);

        double[] resultCoefficients = new double[maxExp + 1];
        int[] resultExponents = new int[maxExp + 1];

        for (int i = 0; i <= maxExp; i++) {
            resultExponents[i] = i;
        }

        for (int i = 0; i < this.coefficient.length; i++) {
            int exp = this.expo[i];
            resultCoefficients[exp] += this.coefficient[i]; // Add the coefficient to the correct exponent
        }

        for (int i = 0; i < given.coefficient.length; i++) {
            int exp = given.expo[i];
            resultCoefficients[exp] += given.coefficient[i]; // Add the coefficient to the correct exponent
        }

        int nonZeroTerms = 0;
        for (int i = 0; i <= maxExp; i++) {
            if (resultCoefficients[i] != 0) {
                nonZeroTerms++;
            }
        }

        double[] finalCoefficients = new double[nonZeroTerms];
        int[] finalExponents = new int[nonZeroTerms];
        int index = 0;
        for (int i = 0; i <= maxExp; i++) {
            if (resultCoefficients[i] != 0) {
                finalCoefficients[index] = resultCoefficients[i];
                finalExponents[index] = resultExponents[i];
                index++;
            }
        }

        return new Polynomial(finalCoefficients, finalExponents);
    }


    public double evaluate(double x) {
        double sum = 0;
        for (int i = 0; i < coefficient.length; i++) {
            sum += coefficient[i] * Math.pow(x, expo[i]);
        }
        return sum;
    }

    public boolean hasRoot(double x) {
        return evaluate(x) == 0;
    }
    
    public Polynomial multiply(Polynomial given) {
        int resultLength = this.coefficient.length + given.coefficient.length - 1;
        
        double[] resultCoefficients = new double[resultLength];
        int[] resultExponents = new int[resultLength];

        for (int i = 0; i < resultLength; i++) {
            resultExponents[i] = i;
        }

        for (int i = 0; i < this.coefficient.length; i++) {
            for (int j = 0; j < given.coefficient.length; j++) {
                resultCoefficients[i + j] += this.coefficient[i] * given.coefficient[j];
                resultExponents[i + j] = this.expo[i] + given.expo[j];
            }
        }

        return new Polynomial(resultCoefficients, resultExponents);
    }
    
    

}
