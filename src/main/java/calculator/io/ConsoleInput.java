package calculator.io;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput implements InputPort {
    @Override
    public String readLine(){
        return Console.readLine();
    }
}
