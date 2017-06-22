package snowmonkeystudios.toappver1.Model;

import java.util.ArrayList;
import java.util.List;

public class Participant {

    String name;
    String tag;
    List<Game> gamesEntered;
    float costOfEntry;
    float totalPaid;

    public Participant()
    {
        name = " ";
        tag = " ";
        gamesEntered = new ArrayList<Game>();
    }

    public Participant(String realName)
    {
        name = realName;
        tag = name;
        gamesEntered = new ArrayList<Game>();
    }

    public Participant(String realName, String tagIn)
    {
        name = realName;
        tag = tagIn;
        gamesEntered = new ArrayList<Game>();
    }

    public void changePlayerName(String newName)
    {
        name = newName;
    }

    public void changePlayerTag(String newTag)
    {
        tag = newTag;
    }

    public void makePayment(float payment)
    {
        totalPaid += payment;
    }

    public void setCost(float cost)
    {
        costOfEntry = cost;
    }

    public void enterGame(Game g) { gamesEntered.add(g); }

    public String toString()
    {
        return name + ": " + tag;
    }

    public List<Game> getGamesEntered() { return gamesEntered; }

    public String getName() { return name; }

    public String getTag() { return tag; }

}
