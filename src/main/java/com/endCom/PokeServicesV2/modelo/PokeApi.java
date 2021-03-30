package com.endCom.PokeServicesV2.modelo;

import java.util.List;

public class PokeApi {
    private int count;
    private String next;
    private String previus;
   private List<Result> results;



    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevius() {
        return previus;
    }

    public void setPrevius(String previus) {
        this.previus = previus;
    }


    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public PokeApi(int count, String next, String previus, List<Result> results) {
        this.count = count;
        this.next = next;
        this.previus = previus;
        this.results = results;
    }
}
