package ITHub.task;

/**
 * ## Плакал второй день
 *
 * @author Горелов Дмитрий
 * */

public class Main {
    public static void main(String[] args) {
        Newton newtonMethod = new Newton();

        double initialGuess = 3; // Начальное приближение
        double tolerance = 1e-7; // Точность
        int maxIterations = 100; // Максимальное количество итераций

        try {
            double root = newtonMethod.newtonMethod(initialGuess, tolerance, maxIterations);
            System.out.println("Найденный корень: " + root);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}