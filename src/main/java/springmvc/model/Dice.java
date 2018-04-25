package springmvc.model;

import java.util.List;

/**
 * @author paula on 09/04/18.
 */
public class Dice {
    private long id;
    private List<Integer> results;

    public Dice(){
        this.id = 0;
    }

    public Dice(long id, List<Integer> results){
        this.id = id;
        this.results = results;
    }

    /**
     *
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     *
     * @return results
     */
    public List<Integer> getResults() {
        return results;
    }

    /**
     *
     * @param results
     */
    public void setResults(List<Integer> results) {
        this.results = results;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Dice))
            return false;
        Dice other = (Dice) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        String tostring = "Dice [id=" + id + ", results=[";

        for(int index = 0; index < results.size(); index++){
            tostring += results.get(index);
            if(index < results.size()-1){
                tostring +=  ", ";
            }
        }
        tostring +=  "]";

        return tostring;
    }
}
