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

}
