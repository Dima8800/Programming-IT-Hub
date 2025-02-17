package ITHub.task;

public class EngineOnCommand implements Command{
    private Engine engine;

    public EngineOnCommand(Engine engine){
        this.engine = engine;
    }

    @Override
    public void execute() {
        engine.turnOn();
    }
}
