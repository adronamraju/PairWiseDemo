package com.swacorp;

public class StateFromString {
    public static State getStateFromString(String string){
        string = string.toUpperCase();
        switch (string){
            case "TX":
                return State.TX;
            case "NM":
                return State.NM;
            case "MA":
                return State.MA;
            case "NY":
                return State.NY;
            default:
                return null;
        }

    }
}
