package fr.epf.gestionclient.model;

import java.util.ArrayList;

/**
 * Created by stephaneguichard on 01/03/2018.
 */

public class Client {
    private String lastname;
    private String firstname;
    private String email;
    private int age;
    private Gender gender;
    private String level;
    private boolean active;

    public enum Gender {
        MAN,WOMAN
    }

    public Client(String lastname, String firstname, String email, int age, Gender gender, String level, boolean active) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.level = level;
        this.active = active;
    }


    private static ArrayList<Client> clients;

    public static ArrayList<Client> getClients(){
        return clients;
    }


    static {
        clients = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Client client = new Client ("lastname"+i,
                    "firstname"+i,
                    "email@"+i,
                    20+i,
                     i % 3 == 0 ? Gender.MAN : Gender.WOMAN,
                    "Débutant",
                    i%2 ==0);
            clients.add(client);

        }
    }
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }




}
