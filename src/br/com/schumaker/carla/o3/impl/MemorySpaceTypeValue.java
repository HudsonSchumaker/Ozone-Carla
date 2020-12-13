package br.com.schumaker.carla.o3.impl;

/**
 * @author Hudson Schumaker
 */
public class MemorySpaceTypeValue<MemorySpaceType, V> {
    private final MemorySpaceType type;
    private V value;

    private MemorySpaceTypeValue(MemorySpaceType t, V v) {
        this.type = t;
        this.value = v;
    }

    public static <MemorySpaceType, V> MemorySpaceTypeValue<MemorySpaceType, V> of(MemorySpaceType type, V value) {
        return new MemorySpaceTypeValue<>(type, value);
    }

    public MemorySpaceType getType() {
        return type;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}