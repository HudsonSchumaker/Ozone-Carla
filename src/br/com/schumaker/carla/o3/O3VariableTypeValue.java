package br.com.schumaker.carla.o3;

/**
 *
 * @author schumaker
 * @param <O3VariableType>
 * @param <V>
 */
public class O3VariableTypeValue<O3VariableType, V> {
    private final O3VariableType type;
    private V value;
    
    private O3VariableTypeValue(O3VariableType t, V v) {
        this.type = t;
        this.value = v;
    }
    
    public static <O3VariableType, V> O3VariableTypeValue<O3VariableType, V> of(O3VariableType left, V right) {
        return new O3VariableTypeValue<>(left, right);
    }

    public O3VariableType getType() {
        return type;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
