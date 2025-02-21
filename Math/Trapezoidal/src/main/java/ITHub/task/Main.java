package ITHub.task;

/**
 * ## Плакал четвертый день
 *
 * @author Горелов Дмитрий
 * */

public class Main {
    public static void main(String[] args) {
        Function f = x -> x * x;

        // Интервалы
        double a = 0;
        double b = 1;
        int n = 100;

        try {
            double result = integrate(f, a, b, n);
            System.out.println("Примерное значение интеграла: " + result);
        }catch (Exception err){
            System.err.println(err.getMessage());
        }
    }
    public static double integrate(Function f, double a, double b, int n) {
        double h = (b - a) / n;
        double sum = 0.5 * (f.apply(a) + f.apply(b));

        // Суммируем значения функции в промежуточных точках
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            sum += f.apply(x);
        }

        return sum * h;
    }

}