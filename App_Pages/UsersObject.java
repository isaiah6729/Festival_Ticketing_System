package com.zybooks.testworldsalsa;

import java.util.ArrayList;

/** not used object for the custom spinner / but used for  */
public class UsersObject {

    public ArrayList<UsersObject> states = new ArrayList<>();
    public ArrayList<UsersObject> continents = new ArrayList<>();
    public ArrayList<UsersObject> informed = new ArrayList<>();

    private int id;
    private  String name;
    private  String username;
    private String password;
    String email ;
    private String state;
    private String continent;
    private String inform;

    public UsersObject(int id, String name, String email, String username, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public UsersObject(int id, String continent, int id2) {
        this.id = id;
        this.continent = continent;
    }

    public UsersObject(int id, String inform, int t, int a) {
        this.id = id;
        this.inform = inform;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    /*  public void addStates () {

        states.add(new UsersObject(1, "AL")); states.add(new UsersObject(2, "AK")); states.add(new UsersObject(3, "AZ"));
        states.add(new UsersObject(4, "AR")); states.add(new UsersObject(5, "CA")); states.add(new UsersObject(6, "CO"));
        states.add(new UsersObject(7, "CT")); states.add(new UsersObject(8, "DE")); states.add(new UsersObject(9, "FL"));
        states.add(new UsersObject(10, "GA")); states.add(new UsersObject(11, "HI")); states.add(new UsersObject(12, "ID"));
        states.add(new UsersObject(13, "IL")); states.add(new UsersObject(14, "IN")); states.add(new UsersObject(15, "IA"));
        states.add(new UsersObject(16, "KS")); states.add(new UsersObject(17, "KY")); states.add(new UsersObject(18, "LA"));
        states.add(new UsersObject(19, "ME")); states.add(new UsersObject(20, "MD")); states.add(new UsersObject(21, "MA"));
        states.add(new UsersObject(22, "MI")); states.add(new UsersObject(23, "MN"));states.add(new UsersObject(24, "MS"));
        states.add(new UsersObject(25, "MO")); states.add(new UsersObject(26, "MT")); states.add(new UsersObject(27, "NE"));
        states.add(new UsersObject(28, "NV")); states.add(new UsersObject(29, "NH")); states.add(new UsersObject(30, "NJ"));
        states.add(new UsersObject(31, "NM")); states.add(new UsersObject(32, "NY")); states.add(new UsersObject(33, "NC"));
        states.add(new UsersObject(34, "ND")); states.add(new UsersObject(35, "OH")); states.add(new UsersObject(36, "OK"));
        states.add(new UsersObject(37, "OR")); states.add(new UsersObject(38, "PA")); states.add(new UsersObject(39, "RI"));
        states.add(new UsersObject(40, "SC")); states.add(new UsersObject(41, "SD")); states.add(new UsersObject(42, "TN"));
        states.add(new UsersObject(43, "TX")); states.add(new UsersObject(44, "UT")); states.add(new UsersObject(45, "VT"));
        states.add(new UsersObject(46, "VA")); states.add(new UsersObject(47, "WA")); states.add(new UsersObject(48, "WV"));
        states.add(new UsersObject(49, "WI")); states.add(new UsersObject(50, "WY"));states.add(new UsersObject(51, "Not Applicable"));

    }*/

    public void addContinent () {

        continents.add(new UsersObject(1, "USA/CANADA", 0));
        continents.add(new UsersObject(2, "EUROPE", 0));
        continents.add(new UsersObject(3, "CENTRAL AMERICA", 0));
        continents.add(new UsersObject(4, "ASIA/RUSSIA", 0));
        continents.add(new UsersObject(5, "SOUTH AMERICA", 0));
        continents.add(new UsersObject(6, "AUSTRALIA/NEW ZEALAND", 0));
        continents.add(new UsersObject(7, "AFRICA", 0));
    }

    public void addInform() {

        informed.add(new UsersObject(1, "FaceBook", 0, 0));
        informed.add(new UsersObject(2, "Twitter", 0, 0));
        informed.add(new UsersObject(3, "Instagram", 0, 0));
        informed.add(new UsersObject(4, "Online/TV/Radio Ad", 0, 0));
        informed.add(new UsersObject(5, "Word of Mouth", 0, 0));
        informed.add(new UsersObject(6, "Repeat Customer", 0, 0));
        informed.add(new UsersObject(7, "Salsa Event/Class", 0, 0));
        informed.add(new UsersObject(8, "Other", 0, 0));
    }

    public ArrayList<UsersObject> getContinents() {
        addContinent();
        return continents;
    }

    public ArrayList<UsersObject> getInformed() {
        addInform();
        return informed;
    }

    public ArrayList<UsersObject> getStates() {
     //   addStates();
        return states;
    }

    public String toString() {
        return this.state + this.continent + this.inform;
    }
}
