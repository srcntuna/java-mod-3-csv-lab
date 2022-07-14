import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFileService {


    public List<Person> parseCsv(String fileName) {

        List<Person> people = new ArrayList<>();

        File csvFile = new File(fileName);
        Scanner scanner;
        try {
            scanner = new Scanner(csvFile);
        } catch (Exception e) {
            System.out.println("File does not exist");
            return null;
        }
        System.out.println("File does exist!");

        String header = scanner.nextLine();

        while (scanner.hasNextLine()) {
            String thisLine = scanner.nextLine();

            String[] personStrings = thisLine.split(",");

            String firstName = personStrings[0];
            String lastName = personStrings[1];
            int birthYear = Integer.parseInt(personStrings[2]);
            int birthMonth= Integer.parseInt(personStrings[3]);
            int birthDay = Integer.parseInt(personStrings[4]);

            Person student = new Person(firstName, lastName, birthYear,birthMonth,birthDay);

            people.add(student);
        }

        return  people;
    }


}
