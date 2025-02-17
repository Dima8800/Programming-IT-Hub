package ITHub.task;

/**
 * ## Реализация метода Хорд
 *
 * @author Горелов Дмитрий
 * */

public class Hord {

    // Пример: x^3 - 6x^2 + 11x - 6 = 0 (корни: 1, 2, 3)
    private double function(double x) {
        return Math.pow(x, 3) - 6 * Math.pow(x, 2) + 11 * x - 6;
    }

    // Метод Хорда
    public double hordeMethod(double x0, double x1, double tolerance, int maxIterations) {
        double f0 = function(x0);
        double f1 = function(x1);

        for (int i = 0; i < maxIterations; i++) {
            // Вычисляем новый x по формуле Хорда
            double x2 = x1 - f1 * (x1 - x0) / (f1 - f0);
            double f2 = function(x2);

            // Проверяем, достигли ли мы необходимой точности
            if (Math.abs(f2) < tolerance) {
                return x2; // Найден корень
            }

            // Обновляем значения для следующей итерации
            x0 = x1;
            f0 = f1;
            x1 = x2;
            f1 = f2;
        }

        throw new RuntimeException("Не удалось найти корень за заданное количество итераций");
    }
}
