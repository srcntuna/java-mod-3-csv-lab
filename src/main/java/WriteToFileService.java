import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteToFileService {


    public void writeToFile(String fileName, List<Person> people) throws IOException {

        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append("firstName, lastName, birthYear, birthMonth, birthDay\n");

        for (Person person : people) {
            stringBuffer.append(person.formatAsCSV() + "\n");
        }

        try (FileWriter fileWriter = new FileWriter(fileName);) {

            fileWriter.write(stringBuffer.toString());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
}