/**
 * @author CD
 * @date 10/17/2024
 * @description
 */
public class Code208_PrefixTree {
    // TrieNode表示前缀树中的一个节点
    public static class TrieNode {
        // 每个节点包含26个子节点，因为字母表有26个字母
        TrieNode[] children = new TrieNode[26];
        // 是否是一个完整单词的标志
        boolean isEndOfWord = false;
    }

    // 根节点
    private final TrieNode root;

    // 构造函数，初始化Trie树
    public Code208_PrefixTree() {
        root = new TrieNode();  // 根节点是一个空节点
    }

    // 插入单词
    public void insert(String word) {
        TrieNode node = root;
        // 遍历单词中的每个字符
        for (char c : word.toCharArray()) {
            int index = c - 'a';  // 获取字符在数组中的索引
            // 如果没有该字符对应的节点，则创建一个新节点
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            // 移动到下一个节点
            node = node.children[index];
        }
        // 到达单词末尾，设置isEndOfWord为true，表示该节点为一个完整单词的结束
        node.isEndOfWord = true;
    }

    // 搜索单词
    public boolean search(String word) {
        TrieNode node = root;
        // 遍历单词中的每个字符
        for (char c : word.toCharArray()) {
            int index = c - 'a';  // 获取字符在数组中的索引
            // 如果没有该字符对应的节点，返回false
            if (node.children[index] == null) {
                return false;
            }
            // 移动到下一个节点
            node = node.children[index];
        }
        // 判断当前节点是否为完整单词的结束
        return node.isEndOfWord;
    }

    // 判断是否有前缀
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        // 遍历前缀中的每个字符
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';  // 获取字符在数组中的索引
            // 如果没有该字符对应的节点，返回false
            if (node.children[index] == null) {
                return false;
            }
            // 移动到下一个节点
            node = node.children[index];
        }
        // 能找到该前缀，返回true
        return true;
    }
}
