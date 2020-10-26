package com.lab.puretest.models;

class GlossDiv {
    /**
     * title : S
     * GlossList : {"GlossEntry":{"ID":"SGML","SortAs":"SGML","GlossTerm":"Standard Generalized Markup Language","Acronym":"SGML","Abbrev":"ISO 8879:1986","GlossDef":{"para":"A meta-markup language, used to create markup languages such as DocBook.","GlossSeeAlso":["GML","XML"]},"GlossSee":"markup"}}
     */

    private String title;
    private com.lab.puretest.models.GlossList GlossList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public GlossList getGlossList() {
        return GlossList;
    }

    public void setGlossList(GlossList GlossList) {
        this.GlossList = GlossList;
    }
}
