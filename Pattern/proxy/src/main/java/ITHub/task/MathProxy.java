package ITHub.task;

public class MathProxy implements IMath {
    private Math math;

    public MathProxy() {
        math = new Math();
    }

    @Override
    public double add(double x, double y) {
        return math.add(x, y);
    }

    @Override
    public double sub(double x, double y) {
        return math.sub(x, y);
    }

    @Override
    public double mul(double x, double y) {
        return math.mul(x, y);
    }

    @Override
    public double div(double x, double y) {
        return math.div(x, y);
    }
}
