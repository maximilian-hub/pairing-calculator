import java.util.ArrayList;
import java.util.Scanner;

public class Start{
    private static Scanner in = new Scanner(System.in);
    private static FlavorBibleDatabase db;

    public static void main(String[] args){
        db = new FlavorBibleDatabase();

        // if args were passed in, do those
        if (args != null){
            printPairings(sharedPairings(db.getIngredientsFromNames(args)));
        }
        // otherwise, prompt for shit
        else {
            printPairings(sharedPairings(promptForIngredients()));
        }
    } // end method main

    /**
    *   Prompts the user for ingredient names, through standard i/o.
    *   @return an ArrayList of ingredients
    */
    private static ArrayList<Ingredient> promptForIngredients(){
        //TODO: implement
        return null;
    } // end method promptForIngredients

    /**
    *   Prints an ArrayList of pairings to standard output.
    *   @param pairings the list to be printed
    */
    private static void printPairings(ArrayList<Pairing> pairings){
        System.out.println("Pairings shared by those ingredients:");

        for (Pairing p : pairings){
            System.out.println("\t" + p.toString());
        }
    } // end method printPairings

    /**
    *   The meat of this thing.
    *   Finds every pairing shared by a set of ingredients.
    *
    *   Assumes that the ingredients are actually
    *   contained within the database.
    *
    *   @param ingredients the ingredients to be checked
    *   @return an ArrayList of every shared pairing
    */
    private static ArrayList<Pairing> sharedPairings(ArrayList<Ingredient> ingredients){
        // reserve space:
        ArrayList<Pairing> sharedPairings = new ArrayList();

        // for each pairing in the first ingredient:
        for (Pairing p : ingredients.get(0).pairings){
            if (pIsInAllOtherIngredients(p, ingredients)){
                sharedPairings.add(p);
            }
        }

        return sharedPairings;
    } // end method sharedPairings

    /**
    *   Tests if a pairing 'p' is contained in
    *   every other ingredient in a list.
    *
    *   Assumes p is a pairing of the first ingredient.
    *
    *   @param p a pairing of the first ingredient on the list
    *   @param ingredients a list of ingredients to be checked
    *   @return 'true' if p is a pairing of every ingredient in the list
    */
    private static boolean pIsInAllOtherIngredients(Pairing p, ArrayList<Ingredient> ingredients){
        // Starting at the 2nd ingredient, check
        // every ingredient for p:
        for (int i=1; i<ingredients.size(); i++){
            if (ingredients.get(i).hasPairing(p))
                continue;
            else
                return false;
        }

        return true;
    } // end method pIsInAllOtherIngredients

} // end class
