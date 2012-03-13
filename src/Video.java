/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anearcan
 */
class Video extends Item{
    String[] actors;

    public Video() {
        
    }
    
    Video(String title, int noOfCopies,  int rentPrice, int purchasePrice, String description, String[] actors, String duration, String genre, String rating, String type) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    Video(String title, int rentPrice, int purchasePrice, String description, String[] actors, String duration, String genre) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    String getActorsString() {
        //return the list of actors in a string rather than array.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    int getPurchasePrice() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    String[] getActors(){
        return actors;
    }
}
