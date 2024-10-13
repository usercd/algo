import java.util.HashMap;

/**
 * @author CD
 * @date 10/11/2024
 * @description
 */
public class Code146_LRUCache {
    // 定义双向链表节点类
    public static class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final HashMap<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private final int capacity;
    private final DLinkedNode head;
    private final DLinkedNode tail;

    // 初始化 LRU 缓存
    public Code146_LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    // 获取数据
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;  // 如果 key 不存在，返回 -1
        }
        // 如果 key 存在，移动该节点到头部（表示最近使用过）
        moveToHead(node);
        return node.value;
    }

    // 写入数据
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if (node == null) {
            // 如果 key 不存在，创建一个新节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);  // 将新节点添加到链表头部
            size++;

            if (size > capacity) {
                // 如果超出容量，移除链表尾部的节点
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            // 如果 key 存在，更新节点的值，并移动到头部
            node.value = value;
            moveToHead(node);
        }
    }

    // 将节点移动到链表头部
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    // 将节点添加到链表头部
    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    // 删除节点
    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 移除链表尾部的节点
    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

}
