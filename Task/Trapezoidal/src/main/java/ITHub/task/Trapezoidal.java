package ITHub.task;

/**
 * ## Класс для решение функции методом трапеции
 * */

public class Trapezoidal {
    /**
     * ## Метод, который позволяет приближенно вычислить определенный интеграл функции
     *
     * Метод разбивает интервал на n равных частей и суммирует площади трапеций, образованных осью x.
     * @param function - Функция, которую мы хотим интегрировать.
     * @param a - Начальная граница интервала
     * @param b - Конечная граница интервала
     * @param n - Количество разбиений интервала. Чем больше значение n, тем точнее будет резултат
     */
    public static double integrate(Function function, double a, double b, int n) {
        double h = (b - a) / n; // Получаем шрину
        double sum = 0.5 * (function.apply(a) + function.apply(b)); // Начальная сумма

        for (int i = 1; i < n; i++) {
            double x = a + i * h; // Промежуточная точка на графике
            sum += function.apply(x);
        }

        return sum * h; // Умножаем на ширину что бы получить плозадь
    }
}
