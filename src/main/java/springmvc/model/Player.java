package springmvc.model;

/**
 * @author paula on 09/04/18.
 */
public class Player {
    private long id;
    private String name;
    private int score;
    private boolean stand;

    public Player(){
        this.id = 0;
    }

    public Player(long id, String name){
        this.id = id;
        this.name = name;
        this.score = 0;
        this.stand = true;
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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     *
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     *
     * @return stand
     */
    public boolean isStand() {
        return stand;
    }

    /**
     *
     * @param stand
     */
    public void setStand(boolean stand) {
        this.stand = stand;
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
        if (!(obj instanceof Player))
            return false;
        Player other = (Player) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Player [id=" + id + ", name=" + name + ", score=" + score
                + ", stand=" + stand + "]";
    }
}
