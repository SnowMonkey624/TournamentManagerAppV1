package snowmonkeystudios.toappver1.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Participant implements Parcelable {

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

    protected Participant(Parcel in) {
        name = in.readString();
        tag = in.readString();
        if (in.readByte() == 0x01) {
            gamesEntered = new ArrayList<Game>();
            in.readList(gamesEntered, Game.class.getClassLoader());
        } else {
            gamesEntered = null;
        }
        costOfEntry = in.readFloat();
        totalPaid = in.readFloat();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(tag);
        if (gamesEntered == null) {
            parcel.writeByte((byte) (0x00));
        } else {
            parcel.writeByte((byte) (0x01));
            parcel.writeList(gamesEntered);
        }
        parcel.writeFloat(costOfEntry);
        parcel.writeFloat(totalPaid);
    }

    public static final Parcelable.Creator<Participant> CREATOR = new Parcelable.Creator<Participant>() {
        @Override
        public Participant createFromParcel(Parcel in) {
            return new Participant(in);
        }

        @Override
        public Participant[] newArray(int size) {
            return new Participant[size];
        }
    };
}
