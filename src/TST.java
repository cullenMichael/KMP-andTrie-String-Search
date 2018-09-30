
import java.util.LinkedList;

public class TST<Value> {

	/* Referecnce was taken from the lecture notes and BST question
	 * 1. Bus Service Questions: 1. How many unique destinations is there in the file? 
	 *     171
	 * 
	 * 2. Is there a bus going to the destination "SOUTHSIDE"?
	 *     No
	 * 
	 * 3. How many records is there about the buses going to the destination beginning with "DOWN"?
	 *     70
	 *
	 * 4. Google Books Common Words Questions: 4. How many words is there in the file? 
	 *     97565
	 * 
	 * 5. What is the frequency of the word "ALGORITHM"? 
	 *     14433021
	 * 
	 * 6. Is the word "EMOJI" present?
	 *      no
	 *   
	 * 7. IS the word "BLAH" present?
	 *   	Yes -   429098 times
	 *    
	 * 8. How many words are there that start with "TEST"? 
	 * 	   39
	 */
	/*
	 * A Node in your trie containing a Value val and a pointer to its children
	 */

	private int number = 0;
	LinkedList<String> l;

	private static class TrieNode<Value> {
		private char c; // character
		private TrieNode<Value> left, mid, right;   // left, middle, and right
													// subtries
		private Value val; 							// value associated with string
	}


	private TrieNode<Value> root = new TrieNode<Value>();

	/*
	 * Returns the number of words in the trie
	 */
	public int size() {
		return number;
	}

	/*
	 * returns true if the word is in the trie, false otherwise
	 */
	public boolean contains(String key) {
		if (key != null) {
			if (get(key) != null) {
				return true;
			}
		}
		return false;
	}

	/*
	 * return the value stored in a node with a given key, returns null if word is
	 * not in trie
	 */
	@SuppressWarnings("null")
	public Value get(String key) {
		if ((key != null) && (key.length() != 0)) {
			TrieNode<Value> n = get(root, key, 0);
			if (n != null) {
				return n.val;
			}
		}
		return null;
	}
	

	private TrieNode<Value> get(TrieNode<Value> node, String key, int val) {
		if (node == null) {
			return null;
		}
		char c = node.c;
		char character = key.charAt(val);
		if (character < c)
			return get(node.left, key, val);
		else if (character > c)
			return get(node.right, key, val);
		else if (val != key.length() - 1)
			return get(node.mid, key, val + 1);
		else
			return node;
	}

	/*
	 * stores the Value val in the node with the given key
	 */
	public void put(String key, Value val) {

		if (key != null) {
			if(!contains(key)) {
				number++;
			}
			put(root, key, val, 0);
		}
	}

	private TrieNode<Value> put(TrieNode<Value> root2, String key, Value val, int value) {
		char c = key.charAt(value);
		if (root2 == null) {
			root2 = new TrieNode<Value>();
			root2.c = c;
			
		}
		char character = root2.c;
		if (c < character)
			root2.left = put(root2.left, key, val, value);
		else if (c > character)
			root2.right = put(root2.right, key, val, value);
		else if (value != key.length() - 1)
			root2.mid = put(root2.mid, key, val, value + 1);
		else
			root2.val = val;
		return root2;
	}

	/*
	 * returns the linked list containing all the keys present in the trie that
	 * start with the prefix passes as a parameter, sorted in alphabetical order
	 */
	public LinkedList<String> keysWithPrefix(String prefix) {

		if ((prefix.length() == 0)) {
			return null;
		}

		LinkedList<String> l = new LinkedList<>();
		TrieNode<Value> x = get(root, prefix, 0);
		if (x != null) {
			if (x.val != null) {
				l.add(prefix);
			}
			Check(x.mid, prefix, l);
		}
		return l;
	}

	private void Check(TrieNode<Value> node, String prefix, LinkedList<String> l) {

		if (node == null) {
			return;
		}
		Check(node.left, prefix, l);
		if (node.val != null) {
			l.add(prefix + node.c);
		}
		Check(node.mid, prefix + node.c, l);
		Check(node.right, prefix, l);
	}
}