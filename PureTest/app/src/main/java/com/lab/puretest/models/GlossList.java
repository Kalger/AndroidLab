package com.lab.puretest.models;

class GlossList {
    /**
     * GlossEntry : {"ID":"SGML","SortAs":"SGML","GlossTerm":"Standard Generalized Markup Language","Acronym":"SGML","Abbrev":"ISO 8879:1986","GlossDef":{"para":"A meta-markup language, used to create markup languages such as DocBook.","GlossSeeAlso":["GML","XML"]},"GlossSee":"markup"}
     */

    private com.lab.puretest.models.GlossEntry GlossEntry;

    public GlossEntry getGlossEntry() {
        return GlossEntry;
    }

    public void setGlossEntry(GlossEntry GlossEntry) {
        this.GlossEntry = GlossEntry;
    }
}
