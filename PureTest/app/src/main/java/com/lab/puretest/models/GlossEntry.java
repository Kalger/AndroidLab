package com.lab.puretest.models;

class GlossEntry {
    /**
     * ID : SGML
     * SortAs : SGML
     * GlossTerm : Standard Generalized Markup Language
     * Acronym : SGML
     * Abbrev : ISO 8879:1986
     * GlossDef : {"para":"A meta-markup language, used to create markup languages such as DocBook.","GlossSeeAlso":["GML","XML"]}
     * GlossSee : markup
     */

    private String ID;
    private String SortAs;
    private String GlossTerm;
    private String Acronym;
    private String Abbrev;
    private com.lab.puretest.models.GlossDef GlossDef;
    private String GlossSee;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getSortAs() {
        return SortAs;
    }

    public void setSortAs(String SortAs) {
        this.SortAs = SortAs;
    }

    public String getGlossTerm() {
        return GlossTerm;
    }

    public void setGlossTerm(String GlossTerm) {
        this.GlossTerm = GlossTerm;
    }

    public String getAcronym() {
        return Acronym;
    }

    public void setAcronym(String Acronym) {
        this.Acronym = Acronym;
    }

    public String getAbbrev() {
        return Abbrev;
    }

    public void setAbbrev(String Abbrev) {
        this.Abbrev = Abbrev;
    }

    public GlossDef getGlossDef() {
        return GlossDef;
    }

    public void setGlossDef(GlossDef GlossDef) {
        this.GlossDef = GlossDef;
    }

    public String getGlossSee() {
        return GlossSee;
    }

    public void setGlossSee(String GlossSee) {
        this.GlossSee = GlossSee;
    }
}
