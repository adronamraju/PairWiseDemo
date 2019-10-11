package com.swacorp;

public enum State {

    TX(5),
    NM(5),
    MA(0),
    NY(0);

    public final int weight;

    State(int i) {
        this.weight = i;
    }

    public static State getStateFromString(String string){
        string = string.toUpperCase();
        switch (string){
            case "TX":
                return TX;
            case "NM":
                return NM;
            case "MA":
                return MA;
            case "NY":
                return NY;
            default:
                return null;
        }

    }
}
