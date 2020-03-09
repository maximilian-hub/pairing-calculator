/**
*
*/
public class Pairing{
    public String ingredient;

    /**
    *   Represents the pairing's ranking.
    *   Possible values range from -1 to 3:
    *       0  = regular
    *       1  = recommended
    *       2  = very highly recommended
    *       3  = "Holy Grail" pairing
    *       -1 = avoid
    */
    private int affinity;




    public Pairing(String ingredient, int affinity){
        this.ingredient = ingredient;
        this.setAffinity(affinity);
    } // end constructor





    /**
    *   Sets the affinity of this pairing.
    *
    *   Assumes (-1 <= x <= 3).
    */
    public void setAffinity(int x){
        this.affinity = x;
    } // end method setAffinity

    public String toString(){
        return ("" + this.ingredient + " (" + this.affinity + ")");
    } // end method toString

} // end class
