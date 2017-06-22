package snowmonkeystudios.toappver1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import snowmonkeystudios.toappver1.Model.CustomAdapter;
import snowmonkeystudios.toappver1.Model.Game;
import snowmonkeystudios.toappver1.Model.Participant;

public class AddParticipant extends AppCompatActivity {

    ListView games;
    List<Game> gamesList;
    EditText nameIn;
    EditText tagIn;
    Button add;
    static List<Object> docEntry = null;
    static int index = -1;
    //static Participant newPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_participant);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        docEntry = new ArrayList<Object>();

        nameIn = (EditText)findViewById(R.id.NameInput);
        tagIn = (EditText)findViewById(R.id.TagInput);
        add = (Button)findViewById(R.id.AddButton);


        games = (ListView)findViewById(R.id.GamesEntered);
        gamesList =  TournamentManager.getGamesList();

        CustomAdapter adapter = new CustomAdapter(this, gamesList);

        games.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(nameIn.getText().toString().isEmpty() || tagIn.getText().toString().isEmpty())
                {
                    //Error msg that there must be a name and a tag.
                }
                else
                {
                    docEntry.add(nameIn.getText().toString());
                    docEntry.add(tagIn.getText().toString());

                    for(int i = 0; i < gamesList.size(); i++)
                    {
                        Game g = gamesList.get(i);
                        if(g.isSelected())
                        {
                            docEntry.add("x");
                        }
                        else
                        {
                            docEntry.add("");
                        }
                    }
                    Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                    finish();
                    //TODO: alt to test
                    //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(myIntent);
                }
            }
        });

        /*games.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View v, int position, long arg3)
            {

                Game gameTest = (Game) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),
                        "Clicked on Row: " + gameTest.toString(),
                        Toast.LENGTH_LONG).show();
                gamesList.get(position).flipSelected();
                games.invalidate();
                games.requestLayout();
            }
        });*/
    }
}
