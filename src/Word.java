
// validate words for invalid string
public class Word implements Comparable<Word> {
	//Word class is comparable to comparable word
	String w;
	public Word(String words) {
		w = words;
	}
		@Override
		//Use toString to convert the key into a readable string
		public String toString() {
			// compare the word inside w to the word inside comparable
			return this.w;
		}
		//Use compareTo to compare values so that the return value will be correct
		@Override
		public int compareTo(Word com) {
			return this.w.compareTo(com.w);
		}
}
