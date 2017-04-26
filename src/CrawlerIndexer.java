//*************************************************************************//
// Josh Joseph

// Class: CrawlerIndexer

// Java implementation of Simple Search Engine - Crawler and Indexer
//*************************************************************************//

// Import statements
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.*;

public class CrawlerIndexer {

	HashMap<String, ArrayList<String>> crawledData = new HashMap();
	ArrayList<String> linkList = new ArrayList<>();

	// Constructor which takes in the website to crawl along with search keyword
	// and calls the crawler method
	public CrawlerIndexer(String linkToCrawl, String keyword) throws IOException {
		crawler(linkToCrawl, keyword);
	}

	// Crawler
	// Method to crawl the pages using jsoup and index the page links
	public void crawler(String url, String key) throws IOException {
		Document doc;
		try {
			doc = Jsoup.connect(url).userAgent("Chrome").get();
		} catch (IOException e) {
			doc = null;
		}

		Elements links = doc.select("a[href]"); // finds href elements from the page

		for (int j = 0; j < links.size(); ++j) {
			Document doc1;
			try {
				doc1 = Jsoup.connect(links.get(j).attr("abs:href")).userAgent("Chrome").ignoreHttpErrors(true)
						.timeout(20000).get();
			} catch (IOException e) {
				doc1 = null;
			}

			String pureLinks = new String(links.get(j).attr("abs:href")); // gets the website links

			if (doc1.text().contains(key)) { // checks for the keyword user entered in page
				Elements e = doc1.select("a[href]");
				for (int i = 0; i < e.size(); ++i) {
					linkList.add(e.get(i).attr("abs:href")); // indexer - ArrayList<String>
				}
				crawledData.put(pureLinks, linkList); // indexer - HashMap<String, ArrayList<String>>
			}
		}
	}

	// Mock Indexer
	public HashMap<String, ArrayList<String>> getCrawledData() {
		return crawledData;
	}
}