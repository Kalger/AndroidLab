package com.lab.puretest.models;

class Glossary {
    /**
     * title : example glossary
     * GlossDiv : {"title":"S","GlossList":{"GlossEntry":{"ID":"SGML","SortAs":"SGML","GlossTerm":"Standard Generalized Markup Language","Acronym":"SGML","Abbrev":"ISO 8879:1986","GlossDef":{"para":"A meta-markup language, used to create markup languages such as DocBook.","GlossSeeAlso":["GML","XML"]},"GlossSee":"markup"}}}
     */

    private String title;
    private com.lab.puretest.models.GlossDiv GlossDiv;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public GlossDiv getGlossDiv() {
        return GlossDiv;
    }

    public void setGlossDiv(GlossDiv GlossDiv) {
        this.GlossDiv = GlossDiv;
    }
}
