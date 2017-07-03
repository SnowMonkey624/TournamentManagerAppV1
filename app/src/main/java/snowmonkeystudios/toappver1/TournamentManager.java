package snowmonkeystudios.toappver1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import snowmonkeystudios.toappver1.Model.Game;
import snowmonkeystudios.toappver1.Model.Participant;
import snowmonkeystudios.toappver1.Model.Tournament;

public class TournamentManager extends AppCompatActivity {

    private static String ID;
    //TODO: Add values to Tournament object for cleaner code?
    private static List<List<Object>> values = null;
    private static Tournament currentTournament = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament_manager);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        currentTournament = new Tournament();//Create/refresh tournament

        if(values != null)
        {
            //currentTournament = new Tournament();
            List initialRow = values.get(1);
            Iterator lineIterator = initialRow.listIterator(2);

            while(lineIterator.hasNext())
            {
                currentTournament.addGame(lineIterator.next().toString());
            }

            Iterator sheetIterator = values.listIterator(2);
            List currentList;
            int numOfGames =  currentTournament.getNumberOfGames();

            for(int i = 2; i < values.size(); i++)
            {
                currentList = values.get(i);
                Participant p = new Participant(currentList.get(0).toString(), currentList.get(1).toString());

                for(int j = 2; j < numOfGames + 2; j++)
                {
                    try
                    {
                        if(currentList.get(j) != "")
                        {
                            p.enterGame(currentTournament.getGamesRun().get(j-2));
                        }
                    }
                    catch(NullPointerException n)
                    {

                    }
                    catch(IndexOutOfBoundsException e)
                    {
                        break;
                    }

                }

                currentTournament.addPlayer(p);
            }
        }
        else
        {
            values = new ArrayList<List<Object>>();
        }

        ListView players = (ListView)findViewById(R.id.PlayerList);

        ArrayAdapter<Participant> playerAdapter =
                new ArrayAdapter<Participant>(this,android.R.layout.simple_list_item_1, currentTournament.getPlayers());

        players.setAdapter(playerAdapter);

        players.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            // argument position gives the index of item which is clicked
            public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3)
            {
                //String selectedPlayer = currentTournament.getPlayers().get(position).toString();
                //Toast.makeText(getApplicationContext(), "Player Selected : "+ selectedPlayer,   Toast.LENGTH_LONG).show();

                Intent myIntent = new Intent(getApplicationContext(), PlayerDetails.class);
                myIntent.putExtra("Playerindex", position);
                //finish();
                startActivity(myIntent);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.addNewPlayer);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        //.setAction("Action", null).show();
                Intent myIntent = new Intent(getApplicationContext(), AddParticipant.class);
                startActivity(myIntent);
            }
        });
    }

    public static void updateValues(List<List<Object>> newVals)
    {
        values = newVals;
    }

    public static void setID(String newID)
    {
        ID = newID;
    }

    public static void setCurrentTournament(Tournament newTournament) { currentTournament = newTournament; }

    public static int getNumberOfEntrants(){ return currentTournament.getPlayers().size(); }

    public static List<Participant> getPlayerList() { return currentTournament.getPlayers(); }

    public static List<Game> getGamesList() { return currentTournament.getGamesRun(); }

    public static Participant getSpecifiedPlayerData(int index)
    {
        return currentTournament.getPlayers().get(index);
    }
}
