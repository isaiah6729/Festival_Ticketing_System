package Competition;

import java.util.ArrayList;

/** pro/am competition object not used */
public class CompetitionProAmObject {

    public ArrayList<CompetitionProAmObject> Professionals = new ArrayList<>();
    private final String name;
    private final int number;
    private final String email;
    private final String partnersName;
    private final String professionalAmateur;
    private final String type;

    public CompetitionProAmObject() {
        name = "you";
        number = 0;
        email = "you";
        partnersName = "you";
        professionalAmateur = "you";
        type = "dance";
    }

    public CompetitionProAmObject(String name, String partnersName, int number, String email, String professionalAmateur, String type) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.partnersName = partnersName;
        this.professionalAmateur = professionalAmateur;
        this.type = type;
    }

    public void addProfessionals(CompetitionProAmObject professionals) {
        Professionals.add(professionals);
    }

    public ArrayList<CompetitionProAmObject> getProfessionals() {
        return Professionals;
    }
}
