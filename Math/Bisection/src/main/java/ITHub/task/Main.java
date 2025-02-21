package ITHub.task;

/**
 * ## Плакал третий день
 *
 * @author Горелов Дмитрий
 * */

public class Main {
    public static void main(String[] args) {
        Function f = x -> x * x - 2;

        // Интервалы
        double a = 0;
        double b = 2;
        double e = 1e-8;

        try {
            double root = bisect(f, a, b, e);
            System.out.println("Примрное значение корня: " + root);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static double bisect(Function f, double a, double b, double e) {
        double an = a;
        double bn = b;
        int k = 0;

        if (f.apply(an) * f.apply(bn) >= 0) {
            throw new IllegalArgumentException("Функция должна иметь разные знаки на концах отрезка [a, b]");
        }

        double xn = 0;

        while ((bn - an) > e) {
            xn = (an + bn) / 2;
            double fa = f.apply(an);
            double fb = f.apply(bn);
            double fxn = f.apply(xn);

            // Определяем, в каком подотрезке искать корень
            if (fa * fxn <= 0) {
                bn = xn; // Корень находится в [an, xn]
            } else {
                an = xn; // Корень находится в [xn, bn]
            }
            k++;
        }

        return xn;
    }
}