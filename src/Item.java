import java.sql.Date;


public class Item {

	private boolean video;//true means the item of interest is a video(i.e. movie or tv show), whereas false means item of interst is a videogame
    private String title; //Title of the video or videogame
	private String info;  //This is a brief synopsis of the video or videogame.
    private double purchasePrice; // Price a customer pays to purchase video.
    private int numberOfCopies; // Number of copies available in stock
    private Date rentDate; //Date the item is being rented
    private Date returnDate;// Latest date the item should be returned 
    
    
    public Item(){
    	video = true;
    	title = "Untitled";
    	info = " ";
    	purchasePrice = 0;
    	numberOfCopies = 0;
    }
    public Item(boolean video, String title, String description, double price, int numCopies, Date returnDate){
    	this.video = video;
    	this.title = title;
    	info = description;
    	purchasePrice = price;
    	numberOfCopies = numCopies;
    	
    }
    
 

}
