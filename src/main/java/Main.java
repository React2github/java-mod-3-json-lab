import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        // Ask user if they want to restore list of ppl from file.

        Scanner scanner = new Scanner(System.in);
        // We are asking user if they want to restore data file
        System.out.println("Do you want to restore your previous session?");
        String response = scanner.nextLine();
            if(response.equalsIgnoreCase("yes")) {
                // This is for reading from file

                List<Person> previousPeople = Arrays.asList(new ObjectMapper().readValue(new File("simple.json"), Person[].class));

                for (Person person : previousPeople) {
                    Logger.getInstance().log(person.getFirstName() + " " + person.getLastName());
                }
            } else {
                // This is for writing to file

                Person jill = new Person("Jill", "Johnson", 1986, 2, 15);
                Person will = new Person("Will", "Williams", 1985, 1, 5);
                Person phil = new Person("Phil", "Pop", 1982, 1, 25);
                Person dill = new Person("Dill", "Dolo", 1983, 1, 14);


                List<Person> peopleList = new ArrayList<Person>();

                peopleList.add(jill);
                peopleList.add(will);
                peopleList.add(phil);
                peopleList.add(dill);

                writeToFile("simple.json", peopleList);
            }
            }



    private static void writeToFile(String fileName, List<Person> peopleList)  throws IOException {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
            String json = new ObjectMapper().writeValueAsString(peopleList);
            fileWriter.write(json);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            if (fileWriter != null)
                fileWriter.close();
        }
    }
}







