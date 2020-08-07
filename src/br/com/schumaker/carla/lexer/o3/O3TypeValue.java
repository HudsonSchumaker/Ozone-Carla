package br.com.schumaker.carla.lexer.o3;

/**
 * This class is a concrete representation of a Pair
 * @author schumaker
 * @param <T> type value
 * @param <V> value
 */
public class O3TypeValue<T, V> {
    
    private final T type;
    private V value;
    
    private O3TypeValue(T t, V v) {
        this.type = t;
        this.value = v;
    }
    
    public static <L, R> O3TypeValue<L, R> of(L left, R right) {
        return new O3TypeValue<>(left, right);
    }

    public T getType() {
        return type;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}