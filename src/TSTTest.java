import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

public class TSTTest {

	@Test
	public void testEmpty() {
		TST<Long> trie = new TST<>();
		assertEquals("size of an empty trie should be 0", 0, trie.size());
		assertFalse("searching an empty trie should return false", trie.contains(""));
		assertNull("getting from an empty trie should return null", trie.get(""));
		assertNull(trie.keysWithPrefix(""));

	}
	@Test
	public void testNull() {
		TST<Long> trie = new TST<>();
		Long d = (long) 11;
		assertEquals("size of an empty trie should be 0", 0, trie.size());
		assertFalse("searching an empty trie should return false", trie.contains(null));
		assertNull("getting from an empty trie should return null", trie.get(null));
		trie.put(null, d);
		assertFalse("searching an empty trie should return false", trie.contains(null));
		
	}
	
	
	@Test 
	public void testInsert() {
		TST<Long> trie = new TST<>();
		String a = "a";
		Long d = (long) 11;
		trie.put(a, d);
		trie.get(a);
		d = (long) 100;
		trie.put(a,d);
		assertEquals(d, trie.get(a));
			
	}

	@Test
	public void testValues() {

		TST<Long> trie = new TST<>();
		String a = "a";
		String b = "b";
		String c = "c";
		String z = "z";
		Long d = (long) 11;
		Long e = (long) 22;
		Long f = (long) 87;
		trie.put(a, d);
		trie.put(b, e);
		trie.put(c, f);
		assertEquals(true, trie.contains(a));
		assertEquals(false, trie.contains(z));
		assertEquals(true, trie.contains(c));
	}

	@Test
	public void testGet() {

		TST<Long> trie = new TST<>();
		String a = "a";
		String b = "b";
		String c = "c";
		String z = "z";
		Long d = (long) 11;
		Long e = (long) 22;
		Long f = (long) 87;
		trie.put(a, d);
		trie.put(b, e);
		trie.put(c, f);

		assertEquals(d, trie.get(a));
		assertEquals(null, trie.get(z));
	}

	@Test
	public void testSize() {

		TST<Long> trie = new TST<>();
		assertEquals(0, trie.size());
		String a = "a";
		String b = "b";
		String c = "c";
		Long d = (long) 11;
		Long e = (long) 22;
		Long f = (long) 87;
		trie.put(a, d);
		trie.put(b, e);
		trie.put(c, f);

		assertEquals(3, trie.size());
	}
	
	
	@Test
	public void testLinkedList(){
		
		TST<Long> trie = new TST<>();
		assertEquals(0, trie.size());

		String a = "a";
		String b = "ab";
		String c = "abc";
		String q = "ghikj";
		Long d = (long) 11;
		Long e = (long) 22;
		Long f = (long) 87;
		trie.put(a, d);
		trie.put(b, e);
		trie.put(c, f);
		trie.put(q, f);
		
		
		LinkedList<String> l = trie.keysWithPrefix("ghikj");
		String s1 = "ghikj";
		String s = "";
		for(int i = 0; i < l.size(); i++){
			s += l.get(i);
		}
		assertEquals(s,s1);	
	}
	
	
	

//	@SuppressWarnings({ "unchecked", "null" })
//	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
//		TST<Long> trie = new TST<>();
//		JSONParser parser = new JSONParser();
//		Object obj = parser.parse(new FileReader("C:/Users/Michael/Documents/bus.json"));
//		JSONArray array = (JSONArray) obj;
//
//		Iterator<JSONObject> iterator = array.iterator();
//		int x = 0;
//		String s = "";
//		Long t;
//		int x1 = 0;
//
//		while (iterator.hasNext()) {
//			JSONObject jsonObject2 = (JSONObject) iterator.next();
//			s = jsonObject2.get("Destination").toString();
//			t = trie.get(s);
//			if (t == null) {
//				t = (long) 0;
//				x++;
//			}
//			Long t1 = (Long) t + 1;
//			trie.put(s, t1);
//			
//
//		}
//		
//
//		t = trie.get("SOUTHSIDE");
//		if (t == null) {
//			System.out.println("SOUTHSIDE IS IN THE DATA");
//		}
//		else {
//			System.out.println("SOUTHSIDE IS NOT IN THE DATA");
//		}
//		System.out.println("amount of unique stops: " + x);
//		
//		int z = 0;
//		
//		LinkedList<String> l = trie.keysWithPrefix("DOWN");
//		
//		for(int i = 0; i < l.size();i++) {
//			
//			z += trie.get(l.get(i));	
//		}
//		System.out.println("Amount of prefix down: " + z);
//
//		In in;
//		in = new In("google.txt");
//
//		String[] str = in.readAllStrings();
//		
//		trie = new TST<>();
//		int val = 1;
//		Long v = null;
//		int key = 0;
//		String k = "";
//
//		for (; val < str.length;) {
//
//			v = Long.valueOf(str[val]).longValue();
//			k = str[key];
//			trie.put(k, v);
//			val = val + 2;
//			key = key + 2;
//		}
//		
//		System.out.println("length of google: " + trie.size());
//
//		v = trie.get("ALGORITHM");
//		System.out.println("ALGORITHM COUNT: " + v);
//
//		v = trie.get("EMOJI");
//		System.out.println("EMOJI COUNT: " + v);
//
//		v = trie.get("BLAH");
//		System.out.println("BLAH COUNT: " + v);
//		
//		 l = trie.keysWithPrefix("TEST");
//		System.out.println("TEST COUNT: " + l.size());
//	}
}
