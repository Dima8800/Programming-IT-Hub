package ITHub.task;

public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine();

        Command On = new EngineOnCommand(engine);
        Command Off = new EngineOffCommand(engine);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(On);
        remote.pressButton();

        remote.setCommand(Off);
        remote.pressButton();
    }
}