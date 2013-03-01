package my.coding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindTextIndexes {

    private boolean emptyText;
    private TrieNode root;
    
    public FindTextIndexes(String text) {
        if (text == null) {
            throw new NullPointerException("The text cannot be null.");
        }
        emptyText = "".equals(text);
        
        root = new TrieNode(text);
    }

    public List<Integer> find(String string) {
        if (emptyText) {
            return root.indexes;
        }
        return root.find(string);
    }

    
    private class TrieNode {
        private List<Integer> indexes = new ArrayList<>();
        private Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        
        public TrieNode(String text) {
            for (int i = 0; i < text.length(); i++) {
                if (!children.containsKey(text.charAt(i))) {
                    children.put(text.charAt(i), new TrieNode(text.substring(i + 1)));
                }
                children.get(text.charAt(i)).indexes.add(i);
            }
        }

        public List<Integer> find(String string) {
            if (string == null || "".equals(string)) {
                return indexes;
            }
            TrieNode child = children.get(string.charAt(0));
            if (child == null) {
                return new ArrayList<>();
            }
            return child.find(string.substring(1));
        }
        
        
    }
}
