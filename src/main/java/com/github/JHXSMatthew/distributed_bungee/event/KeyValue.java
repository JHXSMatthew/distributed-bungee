package com.github.JHXSMatthew.distributed_bungee.event;

/**
 * Created by JHXSMatthew on 18/6/18.
 */
public class KeyValue<K,V> {

    private K key;
    private V value;

    public KeyValue(K k, V v){
        this.key = k;
        this.value = v;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
