package dataaccess;

import domain.domain.Person;
import domain.domain.Tenant;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class PeopleJSONParser {
    private static String json = "{}";

    public static String readFile(String path) {
        try (BufferedReader in = new BufferedReader(
                new FileReader(path)))
        {
            String line = "";
            StringBuilder sbJson = new StringBuilder( 400);
            while((line = reader.readLine())!=null {
            sb.append(line + "\n");
        }
        json = sbJson.toString();
        }
        catch (FileNotFoundException e) {
            System.out.println("File Not Found.");
        }
        catch (IOException e) {
            System.out.println("I/O error occurred");
            return null;
        }
        public static Person getPerson() {
            int personId = obj.getJSONObject("person").getString("personId");
            String lastName = obj.getJSONObject("person").getString("personId");
            String firstName = obj.getJSONObject("person").getString("firstName");
            String userName = obj.getJSONObject("person").getString("userName");
            String birthDate = obj.getJSONObject("birthDate").getString("birthDate");


            Person person = null;
            Person person = new Person(personId, firstName, lastName, userName);
            return person;
        }
        public static Tenant getTenant() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            int personId = obj.getJSONObject("tenant").getString("personId");
            String lastName = obj.getJSONObject("tenant").getString("personId");
            String firstName = obj.getJSONObject("tenant").getString("firstName");
            String userName = obj.getJSONObject("tenant").getString("userName");
            String birthDate = obj.getJSONObject("birthDate").getString("birthDate");
            LocalDateTime birthDate = LocalDateTime.parse(strBirthDate, Formatter);
            LocalDateTime birthDateTime = LocalDateTime.of(birthDate, LocalTime.of(0, 0));


            Tentant tenant = null;
            return tenant;
        }
    }
}




