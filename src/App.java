//*************************************************************************//
// Josh Joseph

// Class: App

// Java implementation of Simple Search Engine
//*************************************************************************//

// Import statements
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		String ans = "";
		try {
			do {
				// prompts the user to enter a keyword to search
				System.out.print("Please enter a keyword to search: ");
				Scanner scan = new Scanner(System.in);
				String keyword = scan.next();

				// Crawls and indexes from www.oldwestbury.edu using the keyword
				// entered by the user
				CrawlerIndexer crawler = new CrawlerIndexer("https://www.oldwestbury.edu/", keyword);
				PageRank ranker = new PageRank(crawler.getCrawledData()); // calls the PageRank method
																			// and prints the links
				System.out.print("\nContinue(Y/N): ");
				ans = scan.next();

			} while (ans.equals("y") || ans.equals("Y")); // loops until user wants to quit
			System.out.print("\nThank you for using our search engine!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}