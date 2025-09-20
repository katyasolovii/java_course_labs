package hw03;

public class t03_03 {
    public static void main(String[] args) {
        Polynomial p1 = new Polynomial(new double[]{1, 2, 3}); 
        Polynomial p2 = new Polynomial(new double[]{0, 5, 1});
        Polynomial p3 = new Polynomial(new double[]{0, 0, 0});
        Polynomial[] arr = new Polynomial[]{p1, p2};

        System.out.println("Polynomial 1: " + p1);
        System.out.println("Polynomial 2: " + p2);
        System.out.println("Polynomial 3: " + p3);
        System.out.println("\nSum of polynomials (p1+p2): " + p1.add(p2));
        System.out.println("Subtract of polynomials (p1-p2): " + p1.subtract(p2));
        System.out.println("Multiply of polynomials (p1*p2): " + p1.multiply(p2));
        System.out.println("Sum of array: " + Polynomial.sumArray(arr));
    }
}

class Polynomial {
    protected double[] coefficient;

    public Polynomial(double[] coeffs) {
        coefficient = new double[coeffs.length];
        for (int i = 0; i < coeffs.length; i++) {
            coefficient[i] = coeffs[i];
        }
    }

    public Polynomial(int degree) {
        coefficient = new double[degree + 1];
    }

    
    public int degree() {
        return coefficient.length - 1;
    }


    public Polynomial add(Polynomial other) {
        int max_deg = Math.max(this.degree(), other.degree());
        double[] res = new double[max_deg + 1];

        for (int i = 0; i <= max_deg; i++) {
            double a = 0;
            double b = 0;
            if (i <= this.degree()) {
                a = this.coefficient[i];
            }
            if (i <= other.degree()) {
                b = other.coefficient[i];
            }
            res[i] = a + b;
        }
        return new Polynomial(res);
    }


    public Polynomial subtract(Polynomial other) {
        int max_deg = Math.max(this.degree(), other.degree());
        double[] res = new double[max_deg + 1];

        for (int i = 0; i <= max_deg; i++) {
            double a = 0;
            double b = 0;
            if (i <= this.degree()) {
                a = this.coefficient[i];
            }
            if (i <= other.degree()) {
                b = other.coefficient[i];
            }
            res[i] = a - b;
        }
        return new Polynomial(res);
    }


    public Polynomial multiply(Polynomial other) {
        int new_deg = this.degree() + other.degree();
        double[] res = new double[new_deg + 1];

        for (int i = 0; i <= this.degree(); i++) {
            for (int j = 0; j <= other.degree(); j++) {
                res[i + j] += this.coefficient[i] * other.coefficient[j];
            }
        }
        return new Polynomial(res);
    }


    public static Polynomial sumArray(Polynomial[] arr) {
        double[] coeffs = new double[arr[0].coefficient.length];

        for (int i = 0; i < arr[0].coefficient.length; i++) {
            coeffs[i] = arr[0].coefficient[i];
        }

        Polynomial sum = new Polynomial(coeffs);
        for (int i = 1; i < arr.length; i++) {
            sum = sum.add(arr[i]);
        }
        return sum;
    }
    

    @Override
    public String toString() {
        String s = "";
        boolean t = true;

        for (int i = coefficient.length - 1; i >= 0; i--) {
            double c = coefficient[i];
            if (c != 0) {
                if (!t) {
                    if (c > 0) {
                        s += " + ";
                    }
                    else {
                        s += " - ";
                    }
                } else {
                    if (c < 0) {
                        s += "-";
                    }
                }

                double num = Math.abs(c);
                if (num != 1 || i == 0) {
                    s += num;
                }
                if (i > 0) {
                    s += "x";
                }
                if (i > 1) {
                    s += "^" + i;
                }
                t = false;
            }
        }
        if (t) {
            return "0"; 
        }

        return s;
    }

}
