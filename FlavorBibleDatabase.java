import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.IOException;
import java.lang.ClassLoader;
import java.util.ArrayList;

public class FlavorBibleDatabase{
    private ArrayList<Ingredient> database;

    public FlavorBibleDatabase(){
        this.database = new ArrayList();

        try{
            this.buildDatabase();
        } catch (IOException e){
            System.out.println("Error building database!");
        }
    } // end constructor

    /**
    *   Fills this database with the "data.csv" file
    *   that should be in the same directory.
    *
    *   IOException might be thrown by readLine()
    */
    private void buildDatabase() throws IOException{
        // build a reader from the .csv in this directory:
        BufferedReader reader = getLocalReader();

        // skip the first line:
        reader.readLine();

        // load the data line by line:
        String row;
        while ((row = reader.readLine()) != null){
            database.add( buildIngredient(row) );
        }
    } // end method buildDatabase

    /**
    *   @return a BufferedReader for the .csv in this directory
    */
    private BufferedReader getLocalReader(){
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("data.csv");
        return new BufferedReader(new InputStreamReader(is));
    } // end method getLocalReader

    /**
    *   Builds an ingredient from a line in "data.csv"
    *
    *   @param row a line from "data.csv"
    *   @return a new ingredient built from that line
    */
    private Ingredient buildIngredient(String row){
        // split the line into arguments:
        String[] data = row.split(",");

        // first argument is the new ingredient's name:
        Ingredient newIngredient = new Ingredient(data[0]);

        // after that, every 2 arguments represent the
        // name & affinity of a new pairing:
        for(int i=1; i<data.length; i+=2){
            newIngredient.addPairing(data[i], Integer.parseInt(data[i+1]));
        }

        return newIngredient;
    } // end method buildIngredient

    /**
    *   Tests if the database contains a particular ingredient name.
    *   @param ingredient the name of the ingredient we're searching for
    *   @return 'true' if the database contains an ingredient with that name
    */
    public boolean contains(String ingredient){
        //TODO: implement
        return false;
    } // end method contains

    /**
    *   Converts an array of names to an ArrayList of
    *   their corresponding ingredients.
    *
    *   Assumes the names are all valid.
    *
    *   @param names an array of ingredient names
    *   @return an ArrayList of corresponding Ingredients
    */
    public ArrayList<Ingredient> getIngredientsFromNames(String[] names){
        ArrayList<Ingredient> ingredients = new ArrayList();

        // look at each name:
        for (String name : names){
            ingredients.add(getIngredientFromName(name));
        }

        return ingredients;
    } // end method getIngredientsFromNames

    /**
    *   Converts a name to its corresponding ingredient.
    *
    *   Assumes the name is a valid name.
    *
    *   @param name the name to search
    *   @return the corresponding Ingredient
    */
    public Ingredient getIngredientFromName(String name){
        for (Ingredient i : this.database){
            if ( i.name.equals(name) ){
                return i;
            }
        }

        return new Ingredient("dirt"); // this shouldn't happen
    } // end method getIngredientFromName

    /**
    *   Prints the entire database to standard output.
    */
    public void printDatabase(){
        for(Ingredient i : this.database){
            System.out.println(i.name + ":");
            i.printPairings();
        }
    } // end method printDatabase

} // end class
