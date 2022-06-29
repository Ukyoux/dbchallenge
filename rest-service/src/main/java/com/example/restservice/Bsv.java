package com.example.restservice;

/**
 * Aufbau des BSV Objektes sowie der Getter-Methoden
 */
public class Bsv {

    private final String plc;
    private final String rl100LangName;
    private final String rl100KurzName;
    private final String typKurz;
    private final String typLang;
    private final String betriebszustand;
    private final Long datumAb;
    private final Long datumBis;
    private final Long niederlassung;
    private final String regionalbereich;
    private final Long letzteAenderung;

    /**
     * Konstruktor der Bsv Klasse
     * @param nextline Array, dass die Header der CSV Datei abbildet
     */
    public Bsv(String[] nextline) {
        this.plc = nextline[0];
        this.rl100LangName = nextline[2];
        this.rl100KurzName = nextline[3];
        this.typKurz = nextline[4];
        this.typLang = nextline[5];
        this.betriebszustand = nextline[6];
        this.datumAb = !nextline[7].isEmpty() ? Long.parseLong(nextline[7]) : null;
        this.datumBis = !nextline[8].isEmpty() ? Long.parseLong(nextline[8]) : null;
        this.niederlassung = !nextline[9].isEmpty() ? Long.parseLong(nextline[9]) : null;
        this.regionalbereich = nextline[10];
        this.letzteAenderung = !nextline[1].isEmpty() ? Long.parseLong(nextline[11]) : null;
    }

    public String getPlc() {
        return plc;
    }

    public String getRl100LangName() {
        return rl100LangName;
    }

    public String getRl100KurzName() {
        return rl100KurzName;
    }

    public String getTypKurz() {
        return typKurz;
    }

    public String getTypLang() {
        return typLang;
    }

    public String getBetriebszustand() {
        return betriebszustand;
    }

    public Long getDatumAb() {
        return datumAb;
    }

    public Long getDatumBis() {
        return datumBis;
    }

    public Long getNiederlassung() {
        return niederlassung;
    }

    public String getRegionalbereich() {
        return regionalbereich;
    }

    public Long getLetzteAenderung() {
        return letzteAenderung;
    }
}
