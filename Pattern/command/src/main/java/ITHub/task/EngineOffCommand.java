package ITHub.task;

public class EngineOffCommand implements Command{
    private Engine engine;

    public EngineOffCommand(Engine engine){
        this.engine = engine;
    }

    @Override
    public void execute() {
        engine.turnOff();
    }
}
