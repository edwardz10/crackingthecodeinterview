package code.interview.datastructures.trees;

import java.util.HashMap;
import java.util.Map;

public class TrieExample {

	public static class Node {
        int occurences;
        Map<Character, Node> children = new HashMap<Character, Node>();
        
        public Node() {
            occurences = 1;
        }
    }

	public static class Trie {
		Node root;
		
		public Trie() {
			root = new Node();
		}

		public void addContact(String contact) {
			Character c;
			Node n, r = root;

			for (int i = 0; i < contact.length(); i++) {
				c = contact.charAt(i);
				n = r.children.get(c);
				
				if (n == null) {
					n = new Node();
					n.occurences = 1;
					r.children.put(c, n);
				} else {
					n.occurences++;
				}
				
				r = n;
			}
		}

		public int findOccurancies(String contact) {
			int count = 0; 
			Character c;
			Node n, r = root;
			
			for (int i = 0; i < contact.length(); i++) {
				c = contact.charAt(i);
				n = r.children.get(c);
				
				if (n == null) {
					count = 0;
					break;
				} else {
					count = n.occurences;
					r = n;
				}
				
			}

			return count;
		}
	}
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.addContact("hack");
		trie.addContact("hackerrank");
		System.out.println(trie.findOccurancies("hac"));
		System.out.println(trie.findOccurancies("hak"));
	}
}
