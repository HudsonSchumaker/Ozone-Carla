package br.com.schumaker.carla.o3.impl;

/**
 * @author Hudson Schumaker
 */
public class VariableType<MemoryType, V> {
    private final MemoryType type;
    private V value;

    private VariableType(MemoryType t, V v) {
        this.type = t;
        this.value = v;
    }

    public static <MemoryType, V> VariableType<MemoryType, V> of(MemoryType type, V value) {
        return new VariableType<>(type, value);
    }

    public MemoryType getType() {
        return type;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}