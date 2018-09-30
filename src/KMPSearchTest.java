import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

public class KMPSearchTest {

	@Test
	public void testEmpty() {
		assertEquals("Empty text or pattern is invalid", -1, KMPSearch.searchFirst("", ""));
		assertEquals("Empty text or pattern is invalid", 0, KMPSearch.searchAll("", ""));
		assertFalse("Empty text or pattern is invalid", KMPSearch.contains("", ""));
	}

	@Test
	public void TestSearchTrue() {
		String txt = "AABAABAAABBABCAABBABABC";
		String pat = "ABC";

		assertEquals(true, KMPSearch.contains(txt, pat));
		assertEquals(11, KMPSearch.searchFirst(txt, pat));
		assertEquals(2, KMPSearch.searchAll(txt, pat));
	}

	@Test
	public void testNoOverLap() {
		String txt = "AABAABAAABBABCAABBABABC";
		String pat = "DEF";

		assertEquals(false, KMPSearch.contains(txt, pat));
		assertEquals(-1, KMPSearch.searchFirst(txt, pat));
		assertEquals(0, KMPSearch.searchAll(txt, pat));

	}

	@Test
	public void TestSearchFalse() {
		String txt = "AABAABAAABBABbAABBABABa";
		String pat = "ABC";

		assertEquals(false, KMPSearch.contains(txt, pat));
		assertEquals(-1, KMPSearch.searchFirst(txt, pat));
		assertEquals(0, KMPSearch.searchAll(txt, pat));
	}
	
	@Test
	public void multiple() {
		
		String txt = "ABCABCABCABCABC";
		String pat = "ABC";
		
		assertEquals(true, KMPSearch.contains(txt, pat));
		assertEquals(0, KMPSearch.searchFirst(txt, pat));
		assertEquals(5, KMPSearch.searchAll(txt, pat));
		
		
	}
	


//	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
//		 JSONParser parser = new JSONParser();
//		 Object obj = parser.parse(new
//		 FileReader("C:/Users/Michael/Documents/bus.json"));
//		 JSONArray array = (JSONArray) obj;
//		 String s;
//		 
//		
//		 String txt = array.toString();
//		 String pat;
//		 int amount;
//		
//		 pat = "16555";
//		 Boolean hit = false;
//		 hit = KMPSearch.contains(txt, pat);
//		 System.out.println("Contains 16555?: " + hit);
//		
//		 
//		
//		for(int i =0; i < array.size(); i++) {
//			
//		JSONObject obj1 =(JSONObject) array.get(i);
//		s = obj1.toString();
//		if(KMPSearch.contains(s, "\"Destination\":\"HAMPTON PARK\"")) {
//			System.out.println("INDEX: " + i);
//			break;
//		}
//			
//			
//			
//			
//		}
//		
//		 pat = "HAMPTON PARK";
//		 amount = KMPSearch.searchFirst(txt, pat);
//		 System.out.println("Index of HAMPTON PARK: " + amount);
//		
//		 pat = " 9043409";
//		 hit = KMPSearch.contains(txt, pat);
//		 System.out.println("Contains 9043409?: " + hit);
//
//	}

}