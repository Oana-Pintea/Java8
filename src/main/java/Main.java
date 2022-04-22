import lombok.SneakyThrows;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        String input = args[0];
        int month = Integer.parseInt(args[1]);
        String output = args[2];

        OutputStream outputStream = new FileOutputStream(output);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);

        List<User> users = readUsers(input);

        List<User> outputList = processUsers(month, users);

        writeUsers(outputStreamWriter, outputList);

    }

    public static List<User> processUsers(int month, List<User> users) {
        List<User> outputList = users.stream()
                .filter(user -> user.getDateOfBirth().getMonthValue() == month)
                .sorted((o1, o2) -> o1.getLastName().compareTo(o2.getLastName()))
                .toList();
        return outputList;
    }

    public static void writeUsers(OutputStreamWriter outputStreamWriter, List<User> outputList) throws IOException {
        for (User user : outputList) {
            outputStreamWriter.write(user.toString());
        }
        outputStreamWriter.close();
    }

    public static List<User> readUsers(String input) throws FileNotFoundException {
        List<User> userList;

        Scanner scanner = new Scanner(new File(input));
        scanner.useDelimiter("," + "|" + System.getProperty("line.separator"));
        userList = new ArrayList<>();
        while (scanner.hasNext()) {
            String first = scanner.next();
            String last = scanner.next();
            String birth = scanner.next();
            userList.add(new User(first, last, LocalDate.parse(birth, DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
        }
        return userList;
    }
}
