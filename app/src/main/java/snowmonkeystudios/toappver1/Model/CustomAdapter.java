package snowmonkeystudios.toappver1.Model;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import snowmonkeystudios.toappver1.R;

public class CustomAdapter extends ArrayAdapter<Game>
{
    List<Game> gamesRun = null;
    Context context;

    public CustomAdapter(Context context, List<Game> resource)
    {
        super(context, R.layout.row_layout,resource);
        // TODO Auto-generated constructor stub
        this.context = context;
        this.gamesRun = resource;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.row_layout, parent, false);

        listItem item = new listItem();

        item.name = (TextView) convertView.findViewById(R.id.gameName);
        item.cb = (CheckBox) convertView.findViewById(R.id.checkBox);
        item.name.setText(gamesRun.get(position).toString());

        if(gamesRun.get(position).isSelected())
            item.cb.setChecked(true);
        else
            item.cb.setChecked(false);

        item.cb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CheckBox cb = (CheckBox) v ;
                //Game g = gamesRun.get(position);
                /*Toast.makeText(getContext(),
                        "Clicked on Checkbox: " + cb.getText() +
                                " is " + cb.isChecked(),
                        Toast.LENGTH_LONG).show();*/
                gamesRun.get(position).setSelected(cb.isChecked());
                //gamesRun.get(position).payout = 0;
            }
        });

        return convertView;
    }

    private class listItem
    {
        TextView name;
        CheckBox cb;
    }
}
