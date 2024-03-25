package tests;

import data_structures.LRUCache;

public class TestLRU {
    public static void main(String[] args) {
        LRUCache<String, Integer> cache = new LRUCache<>(3);
        System.out.println(cache);  // []
        cache.put("foo", 69);
        cache.put("bar", 420);
        System.out.println(cache);  // [420, 69]

        cache.put("baz", 1337);
        System.out.println(cache);  // [1337, 420, 69]

        cache.put("ball", 69420);
        System.out.println(cache);  // [69420, 1337, 420]
        System.out.println(cache.size());  // 3
        cache.put("foo", 69);
        System.out.println(cache);  // [69, 69420, 1337]

        System.out.println(cache.get("bar") == null);  // true
    }
}
