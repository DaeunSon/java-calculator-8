package calculator.io;

public class ConsoleOutput implements OutputPort {
    @Override
    public void printLine(String message){
        System.out.println(message);
    }
}
