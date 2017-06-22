package snowmonkeystudios.toappver1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DocIdInput extends AppCompatActivity {

    Button mButton;
    EditText mEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_id_input);

        //MainActivity.pageID;
        mButton = (Button) findViewById(R.id.enterID);
        mEdit   = (EditText)findViewById(R.id.idInput);

        mButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String input = mEdit.getText().toString().trim();
                if(input.equals(""))
                {
                    mEdit.setError("Please enter a Google Sheets ID.");
                    return;
                }

                MainActivity.setPageID(input);
                TournamentManager.setID(input);

                //Log.i("blah", input);
                //Log.i("blah", MainActivity.pageID);


                finish();

            }
        });
    }
}
