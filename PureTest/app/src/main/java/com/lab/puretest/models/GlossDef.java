package com.lab.puretest.models;

import java.util.List;

class GlossDef {
    /**
     * para : A meta-markup language, used to create markup languages such as DocBook.
     * GlossSeeAlso : ["GML","XML"]
     */

    private String para;
    private List<String> GlossSeeAlso;

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para;
    }

    public List<String> getGlossSeeAlso() {
        return GlossSeeAlso;
    }

    public void setGlossSeeAlso(List<String> GlossSeeAlso) {
        this.GlossSeeAlso = GlossSeeAlso;
    }
}
