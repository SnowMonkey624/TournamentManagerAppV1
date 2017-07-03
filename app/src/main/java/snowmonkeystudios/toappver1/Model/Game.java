package snowmonkeystudios.toappver1.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Game implements Parcelable
{
    String name;
    String abbreviation;
    boolean selected;//Only used when adding new entrant.
    long payout;

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

    protected Game(Parcel in) {
        name = in.readString();
        abbreviation = in.readString();
        selected = in.readByte() != 0x00;
        payout = in.readLong();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(abbreviation);
        parcel.writeByte((byte) (selected ? 0x01 : 0x00));
        parcel.writeLong(payout);
    }

    public static final Parcelable.Creator<Game> CREATOR = new Parcelable.Creator<Game>() {
        @Override
        public Game createFromParcel(Parcel in) {
            return new Game(in);
        }

        @Override
        public Game[] newArray(int size) {
            return new Game[size];
        }
    };

}
