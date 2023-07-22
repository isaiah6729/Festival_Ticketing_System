package Competition;

import java.util.ArrayList;

/** kids object not used */
public class CompetitionKidsObject {

    public ArrayList<CompetitionKidsObject> Kids = new ArrayList<>();
    private String kidsName;
    private int number;
    private String email;
    private  String parentsName;
    private String ageGroup;

    public CompetitionKidsObject() {
        kidsName = "you";
        number = 0;
        email = "you";
        parentsName = "you";
        ageGroup = "you";
    }

    public CompetitionKidsObject(String kidsName, String parentsName, int number, String email, String ageGroup) {
        this.kidsName = kidsName;
        this.number = number;
        this.email = email;
        this.parentsName = parentsName;
        this.ageGroup = ageGroup;
    }

    public void addKids(CompetitionKidsObject kids) {
       Kids.add(kids);
    }

    public ArrayList<CompetitionKidsObject> getKids() {
        return Kids;
    }
}
