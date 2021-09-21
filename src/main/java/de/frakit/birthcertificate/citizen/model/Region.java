package de.frakit.birthcertificate.citizen.model;

public enum Region {
    NORTHWEST("North West", "NW"),
    SOUTHWEST("South West", "SW"),
    OUEST("Ouest", "OU"),
    LITTORAL("Littoral", "LT"),
    CENTRE("Centre", "CE"),
    EST("Est", "ES"),
    SUD("Sud", "SU"),
    ADAMAOUA("Adamaoua", "AD"),
    NORD("Nord", "NO"),
    EXTREMENORD("Extrême Nord", "EN");

    private final Object[] values;

    Region(Object... vals) {
        values = vals;
    }

    public String region() {
        return (String) values[0];
    }

    public String code() {
        return (String) values[1];
    }
    }
