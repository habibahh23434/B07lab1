public class Driver {
    public static void main(String[] args) {
        Polynomial p = new Polynomial();
        System.out.println(p.evaluate(3));
        double[] c1 = {6, 0, 0, 5};
        double[] e1 = {3, 0, 0, 2};
        Polynomial p1 = new Polynomial(c1,e1);
        double[] c2 = {0, -2, 0, 0, -9};
        double[] e2 = {0, 2, 0,0, 2};
        Polynomial p2 = new Polynomial(c2,e2);
        Polynomial s = p1.add(p2);
        System.out.println("s(1) = " + s.evaluate(1));

    }
}
