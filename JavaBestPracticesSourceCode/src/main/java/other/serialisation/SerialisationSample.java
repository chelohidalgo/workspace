package other.serialisation;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.List;

public class SerialisationSample {

    public static void main(String[] args) {
        System.out.println("-- BAD PRACTICE --");
        showBadPractice();

        System.out.println("\n-- GOOD PRACTICE --");
        showGoodPractice();
    }

    private static void showBadPractice() {
        // Serialise
        try {
            Person person = new Person("John", 30, List.of("johny", "jack", "j.j."));
            FileOutputStream fileOut = new FileOutputStream("person.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(person);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in person.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialise
        try {
            FileInputStream fileIn = new FileInputStream("person.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            // potentially unsafe!
            Person deserializedPerson = (Person) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Deserialised Person: " + deserializedPerson);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void showGoodPractice() {
        // Serialise
        try {
            ObjectMapper mapper = new ObjectMapper();
            Person person = new Person("John", 30, List.of("johny", "jack", "j.j."));
            File file = new File("person.json");
            mapper.writeValue(file, person);
            System.out.println("Serialised JSON and saved to person.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialise
        try {
            File file = new File("person.json");
            ObjectMapper mapper = new ObjectMapper();
            Person deserializedPerson = mapper.readValue(file, Person.class);
            System.out.println("Deserialised Person: " + deserializedPerson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
