
import java.util.Date;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anearcan
 */
class Video extends Item{
        private int actorCount = 0;
	private String [] actors;
	private String director;
	private String rating;
	private String runTime;
	private String Category;
	private String medium; // DVD/Blu-Ray
	
	/*******************
	 * CONSTRUCTOR(S)
	 *******************/
	public Video(){
                super();
	}


	public Video(int id, String title, int rentalPrice, int purchasePrice) {
		super(id, title, rentalPrice, purchasePrice);
	
	}
	
	public Video(int id, String title, String genre, Date releaseDate) {
		super(id,title, genre,releaseDate);
	}
	
        public Video(int productID, String title,String [] actors,String director,String rating, 
                String duration, String category, String medium, int noOfCopies, int rentPrice, int purchasePrice){
            super(productID, title, rentPrice, purchasePrice, noOfCopies);
            super.setGenre(category);
           runTime = duration;
           this.director = director;
           this.rating = rating;
           this.medium = medium;
           actorCount = actors.length;
                     
        }
           
	// Clone

	/*******************
	 * Get/set Methods
	 *******************/
	public String getFormat() {
		return medium;
	}
	
	public void setFormat(String format) {
		this.medium = format;
	}
	
	
	// toString
	public String toString() {
		return super.toString() + ",Medium: " + this.medium;
	}

	public void addActor(String actor) {
		this.actors[actorCount] = actor;
                actorCount++;
	}

	public void setActor(String [] actor) {
		this.actors = actor;
	}

        
	public String[] getActors() {
		return actors;
	}


	public void setDirector(String director) {
		this.director = director;
	}


	public String getDirector() {
		return director;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}


	public String getRating() {
		return rating;
	}


	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}


	public String getRunTime() {
		return runTime;
	}

	public void setCategory(String category) {
		Category = category;
	}


	public String getCategory() {
		return Category;
	}


	public void setMedium(String medium) {
		this.medium = medium;
	}


	public String getMedium() {
		return medium;
	}

}
