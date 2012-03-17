
import java.util.ArrayList;
import java.util.Date;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anearcan
 */
class Game extends Item{
	private String rating;
	private String category;
	private String developer;
	private String publisher;
	private ArrayList<String> system; // "PS3"/"Xbox360"/"Wii"
        
    public Game() {
 
    }

    
    public Game(int id, String title, String genre, Date releaseDate) {
		this.setProductID(id);
		this.setTitle(title);
		this.setGenre(genre);
		this.releaseDate = releaseDate;
    }
	
        
    public Game(int id, String title, int rentPrice, int purchasePrice) {
		super.setProductID(id);
		super.setTitle(title);
                super.setRentalPrice(rentPrice);
                super.setPurchasePrice(purchasePrice);
    }
	
    Game(String title, int rentPrice, int purchasePrice, String description, String console, String genre) {
 
    }

    public Game(String title, int rentPrice, int purchasePrice, String description, ArrayList<String> console, String genre,
            String developer, String publisher) {
    
    }
    
    public Game(String title,int rentPrice, int purchasePrice, String description, String rating, ArrayList<String> console, String genre,
            String developer, String publisher) {
            super(title, rentPrice, purchasePrice);
    }
    public Game(int id, String title,int rentPrice, int purchasePrice, String description, String rating,
            ArrayList<String> console, String genre,
            String developer, String publisher) {
            super(id, title, rentPrice, purchasePrice);
    }
    public Game(int id,String title, String genre, String averageRating, int numTimesChecked, Date releaseDate, ArrayList<String> console) {
            super(id, title, genre, releaseDate);
            setConsole(console);
    }
	

    String getRating(){
        return rating;
    }


    String getDeveloper() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    String getPublisher() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
        public ArrayList<String> getConsole() {
		return system;
	}
	
	public void setConsole(ArrayList<String> system) {
		this.system = system;
	}


	// toString
	public String toString() {
		return super.toString() + ",Platform: " + this.system;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getCategory() {
		return category;
	}


	public void setDeveloper(String developer) {
		this.developer = developer;
	}



	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


}

 
 