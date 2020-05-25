package com.example.diplomepy.databse.entities;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "dict")
public class DictModel implements Parcelable  {

    @PrimaryKey(autoGenerate = true)
    private int id_dict;
    private String title;
    private String information;

    public DictModel(String title, String information){
        this.title = title;
        this.information = information;
    }

    protected DictModel(Parcel in) {
        id_dict = in.readInt();
        title = in.readString();
        information = in.readString();
    }

    public static final Creator<DictModel> CREATOR = new Creator<DictModel>() {
        @Override
        public DictModel createFromParcel(Parcel in) {
            return new DictModel(in);
        }

        @Override
        public DictModel[] newArray(int size) {
            return new DictModel[size];
        }
    };

    public void setId_dict(int id_dict) {
        this.id_dict = id_dict;
    }
    public int getId_dict() {
        return id_dict;
    }
    public String getTitle() {
        return title;
    }
    public String getInformation() {
        return information;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id_dict);
        dest.writeString(title);
        dest.writeString(information);
    }
}
