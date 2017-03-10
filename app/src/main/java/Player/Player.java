package Player;

/**
 * Created by garethlye on 28/02/2017.
 */

public class Player {

    String playerName;
    String playerClass;
    String playerSex;

    int strength, agility, dexterity, wisdom, charisma, constitution;


    public Player(String name, String classType, String sex){
        playerName = name;
        playerClass = classType;
        playerSex = sex;
    }

    public void addAttributes(int str, int ag, int dex, int wis, int cha, int consti){
        strength = str;
        agility = ag;
        dexterity = dex;
        wisdom = wis;
        charisma = cha;
        constitution = consti;
    }

}
