//*************************************************************************//
// Josh Joseph

// Class: PageRank

// Java implementation of Simple Search Engine - Page Rank
//*************************************************************************//

// Import statements
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PageRank {
	public Map<String, ArrayList<String>> ranked; // Map to hold the ranked page links

	public PageRank(HashMap<String, ArrayList<String>> ranked) {
		this.ranked = ranked;
		rankLinks(ranked);
		print();
	}

	// Method to rank the page links
	public void rankLinks(HashMap<String, ArrayList<String>> rawData) {
		// Page Rank algorithm needs to be implemented. Links are assigned in a TreeMap for now
		ranked = new TreeMap<String, ArrayList<String>>(rawData);
	}

	// method to print the the page links
	public void print() {
		System.out.println("\nYour search yielded " + ranked.size() + " results:");
		for (String rankedLinks : ranked.keySet()) {
			System.out.println(rankedLinks);
		}
	}
}