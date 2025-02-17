package ITHub.task;

/**
 * ## Плакал первый день
 *
 * @author Горелов Дмитрий
 * */

public class Main {
    public static void main(String[] args) {
        Hord hord = new Hord();

        double x0 = 0; // Начальное приближение 1
        double x1 = 3; // Начальное приближение 2
        double tolerance = 1e-7; // Точность
        int maxIterations = 100; // Максимальное количество итераций

        try {
            double root = hord.hordeMethod(x0, x1, tolerance, maxIterations);
            System.out.println("Найденный корень: " + root);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}