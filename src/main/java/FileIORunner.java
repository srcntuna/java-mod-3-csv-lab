import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIORunner {

    public static void main(String[] args) throws IOException {

       UserOutputService userOutputService = new SysoutUserOutputService();

       try (UserInputService userInputService = new ScannerUserInputService(userOutputService);) {

          OptionsService optionsService = new OptionsService(userInputService);
          int initialOption = optionsService.getInitialOption();
          List<Person> peopleList;
          if(initialOption == 1){
             peopleList = new ReadFileService().parseCsv("person.csv");
          }else {
             peopleList = new ArrayList<>();
          }

          while(true){
             int toDoOption = optionsService.getToDoOption();

             if(toDoOption == 1){
                AddPersonService addPersonService = new AddPersonService(userInputService);
                addPersonService.createPerson(peopleList);
             } else if (toDoOption == 2) {
                PrintPeopleService printPeopleService = new PrintPeopleService();
                printPeopleService.printPeople(peopleList);
             }else{
                WriteToFileService writeToFileService = new WriteToFileService();
                writeToFileService.writeToFile("person.csv",peopleList);
                userOutputService.printMessage("GOODBYE!");
                break;
             }
          }


       } catch (Exception e) {
          e.printStackTrace();
       }




       }









    }





