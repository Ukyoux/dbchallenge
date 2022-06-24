package com.example.restservice;

public class Bsv {
    /*
     * private final String plc;
     * private final String rl100code;
     * private final String rl100langname;
     * private final String rl100kurzname;
     * private final String typkurz;
     * private final String typlang;
     * private final String betriebszustand;
     * private final long datumab;
     * private final long niederlassung;
     * private final String regionalbereich;
     * private final long letzteaenderung;
     */
    private final String name;
    private final String courseName;
    private final String type;

    public Bsv(String name, String courseName, String type) {

        this.courseName = courseName;
        this.type = type;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return courseName;
    }

    public String getType() {
        return type;
    }

}
