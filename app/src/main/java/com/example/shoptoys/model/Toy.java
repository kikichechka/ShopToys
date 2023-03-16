package com.example.shoptoys.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Toy implements Parcelable {
    private int id;
    private final String name;
    private int quantity;
    private final int winningFrequency;

    public Toy(String name, int quantity, int winningFrequency) {
        this.name = name;
        this.quantity = quantity;
        this.winningFrequency = winningFrequency;
    }

    public Toy(int id, String name, int quantity, int winningFrequency) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.winningFrequency = winningFrequency;
    }

    public static final Creator<Toy> CREATOR = new Creator<Toy>() {
        @Override
        public Toy createFromParcel(Parcel in) {
            return new Toy(in);
        }

        @Override
        public Toy[] newArray(int size) {
            return new Toy[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getWinningFrequency() {
        return winningFrequency;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeInt(quantity);
        parcel.writeInt(winningFrequency);
    }

    protected Toy(Parcel in) {
        id = in.readInt();
        name = in.readString();
        quantity = in.readInt();
        winningFrequency = in.readInt();
    }
}
