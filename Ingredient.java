import java.util.ArrayList;

public class Ingredient{
    public String name;
    public ArrayList<Pairing> pairings;




    public Ingredient(String name){
        this.name = name;
        this.pairings = new ArrayList();
    } // end constructor

    public Ingredient(String name, Pairing ...pairing){
        this.name = name;
        for (Pairing p: pairing){
            this.pairings.add(p);
        }
    } // end constructor



    /**
    *   Add a new pairing to this ingredient.
    *   @param name     the name of the pairing
    *   @param affinity the strength of the pairing
    */
    public void addPairing(String name, int affinity){
        this.pairings.add(new Pairing(name, affinity));
    } // end addPairing

    /**
    *   Print every pairing of this ingredient
    *   to the standard output.
    */
    public void printPairings(){
        for(Pairing pairing : pairings){
            System.out.println("\t" + pairing.toString());
        }
    } // end method printPairings

    /**
    *   Tests if this Ingredient has
    *   a particular pairing.
    *
    *   @param pairing the pairing to search for
    *   @return 'true' if the parameter is a pairing of this ingredient
    */
    public boolean hasPairing(Pairing pairing){
        for (Pairing p : this.pairings){
            if (p.ingredient.equals(pairing.ingredient))
                return true;
        }

        return false;
    } // end method hasPairing


} // end class Ingredient
