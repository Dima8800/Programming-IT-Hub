package ITHub.task;

/**
 * ## Плакал Пятый день
 *
 * @author Горелов Дмитрий
 * */

public class Main {
    public static void main(String[] args) {
        Function f = x -> Math.sin(x) + Math.log(x + 1);

        // Интервалы
        double a = 0;
        double b = 20;
        int n = 100;

        try {
            double result = integrate(f, a, b, n);
            System.out.println("Примерное значение интеграла: " + result);
        }catch (Exception err){
            System.err.println(err.getMessage());
        }
    }

    public static double integrate(Function f, double a, double b, int n) {
        // Проверяем, чтобы n было четным
        if (n % 2 != 0) {
            throw new IllegalArgumentException("Количество подинтервалов n должно быть четным.");
        }

        double h = (b - a) / n;
        double sum = f.apply(a) + f.apply(b);

        // Суммируем значения функции в промежуточных точках
        for (int i = 1; i < n; i++) {
            double x = a + i * h;

            // Ченые \ не четный
            if (i % 2 == 0) {
                sum += 2 * f.apply(x);
            } else {
                sum += 4 * f.apply(x);
            }
        }

        return sum * (h / 3);
    }
}