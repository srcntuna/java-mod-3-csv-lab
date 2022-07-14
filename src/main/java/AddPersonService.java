import java.util.List;

public class AddPersonService {

    private UserInputService userInputService;

    public AddPersonService(UserInputService userInputService) {
        this.userInputService = userInputService;
    }

    public void createPerson(List<Person> peopleList){
        String firstName = userInputService.getUserInputToPrompt("What is firstName?");
        String lastName = userInputService.getUserInputToPrompt("What is lastName?");
        String birthYearStr = userInputService.getUserInputToPrompt("What is birthYear?");
        int birthYear = Integer.parseInt(birthYearStr);
        String birthMonthStr = userInputService.getUserInputToPrompt("What is birthMonth?");
        int birthMonth = Integer.parseInt(birthMonthStr);
        String birthDayStr = userInputService.getUserInputToPrompt("What is birthDay?");
        int birthDay = Integer.parseInt(birthDayStr);
        Person newPerson  = new Person(firstName,lastName,birthYear,birthMonth,birthDay);
        peopleList.add(newPerson);
        System.out.println(firstName+" "+lastName+" successfully added to the list!");
    }

}
