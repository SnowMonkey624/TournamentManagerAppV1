package snowmonkeystudios.toappver1.Model;

public class Game
{
    String name;
    String abbreviation;
    long payout;
    boolean selected;//Only used when adding new entrant.

    //Different equations for payout depending on game?

    public Game()
    {
        name = " ";
        abbreviation = name;
        selected = false;
    }

    public Game(String nameIn)
    {
        name = nameIn;
        abbreviation = name;
        selected = false;
    }

    public Game(String nameIn, String gameAbbr)
    {
        name = nameIn;
        abbreviation = gameAbbr;
        selected = false;
    }

    public String toString()
    {
        if(name == abbreviation)
            return name;

        else
            return abbreviation + ": " + name;
    }

    public void setSelected(boolean selectedIn)
    {
        selected = selectedIn;
    }

    public boolean isSelected()
    {
        return selected;
    }
}
