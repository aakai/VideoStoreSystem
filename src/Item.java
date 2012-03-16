
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anearcan
 */
public class Item implements Comparable<Item>, Comparator<Item> {
	/*******************
	 * PROPERTIES
	 *******************/
	private String title;			// the name of the Item
	private String genre;			// the genre of the movie/videogame
	protected int numTimesChecked;	// the number of times the movie was checked out
	private int productID;
	private boolean isReserved;
	private boolean overDue;
	private Date dateReturned;
	private Date dateRented;
	private int noOfCopies;
	private int rentalPrice;
	private int purchasePrice;
	private String description;
	private ArrayList<MemberAccount> membersReserving;
	protected Date releaseDate;		// The date the Item was released
	
	/*******************
	 * CONSTRUCTOR(S)
	 *******************/
	public Item() {
	}

	public Item(int id, String title, String genre, Date releaseDate) {
		productID = id;
		this.title = title;
		this.genre = genre;
		this.releaseDate = releaseDate;
	}
	
        
	public Item(int id, String title, int rentPrice, int purchasePrice) {
		productID = id;
		this.title = title;
                rentalPrice = rentPrice;
                this.purchasePrice = purchasePrice;
	}

	public Item(String title, int rentPrice, int purchasePrice) {
		this.title = title;
                rentalPrice = rentPrice;
                this.purchasePrice = purchasePrice;
	}
        
        
	public Item(int id, String title, int rentPrice, int purchasePrice, int quantity) {
		productID = id;
		this.title = title;
                rentalPrice = rentPrice;
                this.purchasePrice = purchasePrice;
                noOfCopies = quantity;
	}
		
	// Implementing Comparable:
	// Comparisons based on title
	public int compareTo(Item item) {
		return title.compareTo(item.getTitle());
	}


	
	/*******************
	 * Get/set Methods
	 *******************/
	
	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public void setRentalPrice(int rentalPrice){
		this.rentalPrice = rentalPrice;
	}
	
	public int getRentalPrice(){
		return rentalPrice;
	}

        public void setPurchasePrice(int purchasePrice){
            this.purchasePrice = purchasePrice;
                     
        }
        
        public int getPurchasePrice(){
		return purchasePrice;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}


	// toString() 
	public String toString() {
		return title + ",Genre: " + genre + ",Rating: " + ",Times Checked Out: " + this.numTimesChecked
				+ ",Release Date: " + this.releaseDate;
	}

	public int getProductID() {
		
		return productID;
	}
	public void setProductID(int id) {
		
		productID = id;
	}
	public boolean getIsReserved() {
		
		return isReserved;
	}

	public boolean getIsReserved(boolean reserved) {
		
		return isReserved;
	}
	
	public void setOverDue(boolean overDue) {
		this.overDue = overDue;
	}

	public boolean isOverDue() {
		return overDue;
	}

	public void setDateReturned(Date dateReturned) {
		this.dateReturned = dateReturned;
	}

	public Date getDateReturned() {
		return dateReturned;
	}

	public void setDateRented(Date dateRented) {
		this.dateRented = dateRented;
	}

	public Date getDateRented() {
		return dateRented;
	}

        @Override
        public int compare(Item t, Item t1) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

     public ArrayList<MemberAccount> getWaitingList() {
        return membersReserving;
    }

    public int getNoOfCopies() {
        return noOfCopies;
    }
    
    public void setNoOfCopies(int number){
        noOfCopies = number;
    }

    public void setDescription(String text){
        description = text;
    }

    public String getDescription(){
        return description;
    }
}
