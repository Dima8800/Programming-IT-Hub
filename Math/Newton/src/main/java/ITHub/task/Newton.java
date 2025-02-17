package ITHub.task;

/**
 * ## Реализация метода Ньютона
 *
 * @author Горелов Дмитрий
 * */
public class Newton {

    // Пример: f(x) = x^3 - 6x^2 + 11x - 6
    public double function(double x) {
        return Math.pow(x, 3) - 6 * Math.pow(x, 2) + 11 * x - 6;
    }

    // Производная функции f'(x)
    // Пример: f'(x) = 3x^2 - 12x + 11
    public double derivative(double x) {
        return 3 * Math.pow(x, 2) - 12 * x + 11;
    }

    // Метод Ньютона
    public double newtonMethod(double initialGuess, double tolerance, int maxIterations) {
        double x0 = initialGuess;
        for (int i = 0; i < maxIterations; i++) {
            double fx0 = function(x0);
            double dfx0 = derivative(x0);

            if (Math.abs(dfx0) < tolerance) {
                throw new RuntimeException("Производная мала");
            }

            double x1 = x0 - fx0 / dfx0; // Следующее приближение

            if (Math.abs(x1 - x0) < tolerance) {
                return x1; // Найден корень с заданной точностью
            }

            x0 = x1; // Обновляем текущее приближение
        }

        throw new RuntimeException("Корень не найден за максимальное количество итераций");
    }
}
