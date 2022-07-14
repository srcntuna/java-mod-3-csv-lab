import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteToFileService {


    public void writeToFile(String fileName, List<Person> people) throws IOException {

        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append("firstName, lastName, birthYear, birthMonth, birthDay\n");

        for (int i=0;i<people.size();i++) {
            Person person = people.get(i);
            if(i == people.size() -1){
                stringBuffer.append(person.formatAsCSV());
            }else{
                stringBuffer.append(person.formatAsCSV() + "\n");
            }

        }

        try (FileWriter fileWriter = new FileWriter(fileName);) {

            fileWriter.write(stringBuffer.toString());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
}