package ui;

import dataaccess.PeopleJSONParser;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    private static String json = "{\n" +
            = "{\n" +
            "\"person\": {\n" +
            "\"personId\": 101, \n" +
            "\"lastName\": \"Swanson\",\n" +
            " \"firstName\": \"Mark\",\n" +
            "\"userName\": \"mark.swanson\"\n" +
            "}\n" +
            "}";

    public static void main(String[] args) {
        JSONObject obj = new JSONObject(json);
        int personId = obj.getJSONObject("person").getString("personId");
        String lastName = obj.getJSONObject("person").getString("personId");
        String firstName = obj.getJSONObject("person").getString("firstName");
        String userName = obj.getJSONObject("person").getString("userName");

        Person person = new Person(personId, firstName, lastName, userName);
try {
    PeopleJSONParser.readFile("mswanson2742ex2c1/resources/people.json");
    person = PeopleJSONParser.getPerson();
    tenant = PeopleJSONParser.getTenant();
}
catch (FileNotFoundException e) {
    System.out.println("File Not Found");
}
catch (IOException e) {
    System.out.println ("I/O error occurred");
}


        System.out.println("person: " + personId + ", " + lastName + ", " + firstName + ", " + userName);
        System.out.println("person: " + person.toString());
    }
}


