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
    static List<LogMessage> logMessages = new ArrayList<>();
    static List<LogMessage> filteredlLogMessages = new ArrayList<>();

    public static void main(String args[]) throws IOException {
        logger.info("Start");
        List<String> allLines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);

        for (String line : allLines) {
            String[] record = line.split(" ");
            logMessages.add(new LogMessage(record[0], record[1], record[2], record[3]));
        }

        //Java 7 style
        for (LogMessage logMessage : logMessages) {
            if (logMessage.getOperation().equals("Stop")) {
                filteredlLogMessages.add(logMessage);
            }
        }
        for (LogMessage filteredLogMessage :filteredlLogMessages){
            System.out.println(filteredLogMessage);
        }

        //Java 8 style
        filteredlLogMessages = logMessages.stream().filter(logMessage ->
                logMessage.getOperation().equals("Stop")).collect(Collectors.toList());
        filteredlLogMessages.forEach(System.out::println);

        logger.info("Stop");
    }
}
