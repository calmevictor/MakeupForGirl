package fr.domain.vc.makeupformygirl.model;

import java.util.List;

public class RestMakeUpResponse {
    //private int count;
    //private String next;
    private List<MakeUp> results;

    /*public int getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }
*/
    public List<MakeUp> getResults() {
        return results;
    }
}
