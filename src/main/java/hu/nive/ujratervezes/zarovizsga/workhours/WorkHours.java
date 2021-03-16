package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class WorkHours {

    public static final int POS_NAME = 0;
    public static final int POS_HOURS = 1;
    public static final int POS_DATE = 2;
    public static final DateTimeFormatter DT_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public String minWork(String file) {
        Path path = Path.of(file);
        StringBuilder result = new StringBuilder();
        int minHours = Integer.MAX_VALUE;

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            result = processLine(result, minHours, reader);
            return result.toString();
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Unable to read from file", ioe);
        }
    }


    private StringBuilder processLine(StringBuilder result, int minHours, BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            int hours = Integer.parseInt(data[POS_HOURS]);
            if (hours < minHours) {
                minHours = hours;
                result = new StringBuilder();
                result.append(data[POS_NAME]).append(": ");
                result.append(LocalDate.parse(data[POS_DATE], DT_FORMAT));
            }
        }
        return result;
    }
}
