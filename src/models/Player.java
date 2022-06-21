package models;

import java.util.UUID;

public class Player {
    private String name;
    private String choice;
    private String id;

    public Player(){
        id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", choice='" + choice + '\'' +
                ", ID='" + id + '\'' +
                '}';
    }
}
