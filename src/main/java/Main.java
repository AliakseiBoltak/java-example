import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    static Logger logger = Logger.getLogger(Main.class);
    static String fileName = "runtime.log";

    public static void main(String args[]) throws IOException {
        logger.info("Start");
        List<LogMessage> logMessages = new ArrayList<>();
        List<String> allLines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);

        for (String line : allLines) {
            String[] record = line.split(" ");
            logMessages.add(new LogMessage(record[0], record[1], record[2], record[3]));
        }

        //Java 7 style
        List<LogMessage> filteredMessages = new ArrayList<>();
        for (LogMessage logMessage : filteredMessages){
            if (logMessage.getOperation().equals("Stop")){
                filteredMessages.add(logMessage);
            }
        }
        for (LogMessage logMessage :filteredMessages){
            System.out.println(logMessage);
        }

        //Java 8 style
        filteredMessages = logMessages.stream().filter(logMessage ->
                logMessage.getOperation().equals("Stop")).collect(Collectors.toList());

        filteredMessages.forEach(System.out::println);

        logger.info("Stop");
    }
}
