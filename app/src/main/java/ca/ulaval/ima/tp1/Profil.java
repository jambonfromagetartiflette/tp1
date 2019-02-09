package ca.ulaval.ima.tp1;

import android.os.Parcelable;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import android.os.Parcel;

public class Profil implements Parcelable {
    private String last_name;
    private String first_name;
    private Date birthdate;
    private String idul;

    public Profil(Parcel in) {
        last_name = in.readString();
        first_name = in.readString();
        birthdate = (java.util.Date) in.readSerializable();
        idul = in.readString();
    }

    public Profil(String name, String prenom, Date naissance, String IDUL) {
        this.last_name = name;
        this.first_name = prenom;
        this.birthdate = naissance;
        this.idul = IDUL;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getBirthdate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(birthdate);
        return date;
    }

    public String getIdul() {
        return idul;
    }

    public static final Creator<Profil> CREATOR = new Creator<Profil>() {
        @Override
        public Profil createFromParcel(Parcel in) {
            return new Profil(in);
        }

        @Override
        public Profil[] newArray(int size) {
            return new Profil[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(last_name);
        parcel.writeString(first_name);
        parcel.writeSerializable(birthdate);
        parcel.writeString(idul);
    }
}
