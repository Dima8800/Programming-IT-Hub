package ITHub.task;

public class Main {
    static int first = 2;

    static int two = 6;

    static int three = 4;

    public static void main(String[] args) {
        IMath proxy = new MathProxy();

        // +
        System.out.println(new StringBuilder()
                .append(three)
                .append(" + ")
                .append(two)
                .append(" = ")
                .append(proxy.add(three, two)));

        // -
        System.out.println(new StringBuilder()
                .append(three)
                .append(" - ")
                .append(first)
                .append(" = ")
                .append(proxy.sub(three, first)));

        // *
        System.out.println(new StringBuilder()
                .append(three)
                .append(" * ")
                .append(first)
                .append(" = ")
                .append(proxy.mul(three, first)));

        // - /
        System.out.println(new StringBuilder()
                .append(three)
                .append(" / ")
                .append(first)
                .append(" = ")
                .append(proxy.div(three, first)));
    }
}
