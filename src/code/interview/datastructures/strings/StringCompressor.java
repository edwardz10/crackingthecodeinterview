package code.interview.datastructures.strings;

public class StringCompressor {
	
	private static String compress(String str) {
		int count = 1, pos = 0;
		char ch = str.charAt(0), next_ch;
		
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			pos++;
			
			if (pos == str.length()) {
				sb.append(ch);
				sb.append(count);
				break;
			}
			
			next_ch = str.charAt(pos);

			if (next_ch == ch) {
				count++;
			} else {
				sb.append(ch);
				sb.append(count);
				count = 1;
				ch = next_ch;
			}
		}

		return sb.length() < str.length() ? sb.toString() : str;
	}
	
	public static void main(String[] args) {
		String str = "aaaabbbbbccccc";
		System.out.println(compress(str));
	}
}
