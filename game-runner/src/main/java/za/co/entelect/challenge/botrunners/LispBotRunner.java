package za.co.entelect.challenge.botrunners;

import za.co.entelect.challenge.entities.BotMetaData;

import java.io.IOException;

public class LispBotRunner extends BotRunner {

    public LispBotRunner(BotMetaData botMetaData, int timeoutInMilliseconds) {
        super(botMetaData, timeoutInMilliseconds);
    }

    @Override
    protected String runBot() throws IOException {
        String line;

        if(System.getProperty("os.name").contains("Windows")) {
            line = "cmd /c \"" + this.getBotFileName() + "\"";
        } else {
            line = "\"./" + this.getBotFileName() + "\"";
        }

        return RunSimpleCommandLineCommand(line, 0);
    }

    @Override
    public int getDockerPort() {
        return 9012;
    }
}
