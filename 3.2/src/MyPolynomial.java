public class MyPolynomial {
    private double[] coeffs;

    public MyPolynomial(double... coeffs) {
        this.coeffs = coeffs;
    }

    public int getDegree() {
        return coeffs.length - 1;
    }

    public double evaluate(double x) {
        double result = 0;
        for (int i = 0; i < coeffs.length; i++) {
            result += coeffs[i] * Math.pow(x, i);
        }
        return result;
    }

    public MyPolynomial add(MyPolynomial another) {
        int maxDegree = Math.max(this.getDegree(), another.getDegree());
        double[] sumCoeffs = new double[maxDegree + 1];

        for (int i = 0; i <= this.getDegree(); i++) {
            sumCoeffs[i] = this.coeffs[i];
        }

        for (int i = 0; i <= another.getDegree(); i++) {
            sumCoeffs[i] += another.coeffs[i];
        }

        return new MyPolynomial(sumCoeffs);
    }

    public MyPolynomial multiply(MyPolynomial another) {
        int newDegree = this.getDegree() + another.getDegree();
        double[] productCoeffs = new double[newDegree + 1];

        for (int i = 0; i <= this.getDegree(); i++) {
            for (int j = 0; j <= another.getDegree(); j++) {
                productCoeffs[i + j] += this.coeffs[i] * another.coeffs[j];
            }
        }

        return new MyPolynomial(productCoeffs);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = getDegree(); i >= 0; i--) {
            if (coeffs[i] != 0) {
                if (sb.length() > 0) {
                    sb.append(" + ");
                }
                sb.append(coeffs[i]);
                if (i > 0) {
                    sb.append("x");
                    if (i > 1) {
                        sb.append("^").append(i);
                    }
                }
            }
        }
        return sb.toString();
    }
}
