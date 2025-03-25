package ITHub.task;

/**
 * ## Плакал уже какой день с этой математикой (хотя это уже делал, можно сказать просто добавил комментарии)
 *
 * @author Горелов Дмитрий
 * */
public class Main {
    public static void main(String[] args) {
        Function function = x -> Math.exp(-x * x); // Пример: функция e^(-x^2)

        // Границы
        double a = 10;
        double b = 200;

        // Количество итерации
        int n = 1000;

        double result = Trapezoidal.integrate(function, a, b, n);

        System.out.println("Значение интеграла от " + a + " до " + b + " : " + result);
    }
}