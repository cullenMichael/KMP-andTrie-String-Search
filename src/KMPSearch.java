
public class KMPSearch {

  /* reference was taken from the lecture notes
   * Bus Service Questions:
   *
   * 1. How many total vehicles is there information on?
   *    987
   *
   * 2. Does the file contain information about the vehicle number 16555?
   *    yes
   *
   * 3. Locate the first record about a bus heading to HAMPTON PARK
   *    76th record on the file
   *
   * 4. Does the file contain information about the vehicle number 9043409?
   *    No 
   */

   /*
    * The method checks whether a pattern pat occurs at least once in String txt.
    *
    */
	
	private static int[][] index(String pattern) {

		int[][] index = new int[256][pattern.length()];
		int x = 0;
		index[pattern.charAt(0)][0] = 1;
		for (int j = 1; j < pattern.length(); j++) {
			for (int k = 0; k < 256; k++) {
				index[k][j] = index[k][x];
			}
			index[pattern.charAt(j)][j] = j + 1;
			x = index[pattern.charAt(j)][x];
		}
		return index;
	}

	public static boolean contains(String txt, String pat) {

		if (pat.length() != 0) {
			int len = txt.length();
			int patlen = pat.length();
			int[][] index = index(pat);
			int val = 0;

			for (int i = 0; i < len; i++) {
				val = index[txt.charAt(i)][val];
				if (val == patlen) {
					return true;
				}
			}
			
		}
		return false;

	}

	/*
	 * The method returns the index of the first ocurrence of a pattern pat in
	 * String txt. It should return -1 if the pat is not present
	 */
	public static int searchFirst(String txt, String pat) {

		if (pat.length() == 0) {
			return -1;
		}
		int patlen = pat.length();
		int[][] index = index(pat);
		int val = 0;
		int len = txt.length();
		int i = 0;
		for (; i < len; i++) {
			val = index[txt.charAt(i)][val];
			if (val == patlen) {
				return i - patlen +1;
			}
		}
		
		return -1;
	}

	/*
	 * The method returns the number of non-overlapping occurences of a pattern pat
	 * in String txt.
	 */
	public static int searchAll(String txt, String pat) {

		int count = 0;
		if (pat.length() != 0) {
			int len = txt.length();
			int patlen = pat.length();
			int[][] index = index(pat);
			int val = 0;
			
			for (int i = 0; i < len; i++) {
				val = index[txt.charAt(i)][val];
				if (val == patlen) {
					count++;
					val = 0;
				}
			}
		}
		return count;
	}
}