package snowmonkeystudios.toappver1.Model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tournament
{
    String tournamentName;

    List<Game> gamesRun;
    int numberOfGames = 0;

    List<Participant> players;

    String date;
    String link; //getEmbedLink()

    float venueFee;

    private float costToRun;

    //Different equations for payout depending on game?

    public Tournament()
    {
        tournamentName = "";
        date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        venueFee = 0;
        costToRun = 0;
        gamesRun = new ArrayList<Game>();
        players  = new ArrayList<Participant>();
    }

    public Tournament(String tName)
    {
        tournamentName = tName;
        date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        venueFee = 0;
        costToRun = 0;
        gamesRun = new ArrayList<Game>();
        players  = new ArrayList<Participant>();
    }

    public Tournament(String tName, float totalCost)
    {
        tournamentName = tName;
        date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        venueFee = 0;
        costToRun = totalCost;
        gamesRun = new ArrayList<Game>();
        players  = new ArrayList<Participant>();
    }

    public Tournament(String tName, float cost, float totalCost)
    {
        tournamentName = tName;
        date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        venueFee = cost;
        costToRun = totalCost;
        gamesRun = new ArrayList<Game>();
        players  = new ArrayList<Participant>();
    }

    public void addGame(String gameName)
    {
        gamesRun.add(new Game(gameName));
        numberOfGames++;
    }

    public void removeGame(Game g)
    {
        gamesRun.remove(g);
        numberOfGames--;
    }

    public void addPlayer(Participant p)
    {
        players.add(p);
    }

    public void removePlayer(Participant p)
    {
        players.remove(p);
    }

    public int getNumberOfGames()
    {
        return numberOfGames;
    }

    public List<Game> getGamesRun()
    {
        return gamesRun;
    }

    public List<Participant> getPlayers()
    {
        return players;
    }
}
