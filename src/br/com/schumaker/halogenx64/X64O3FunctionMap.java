package br.com.schumaker.halogenx64;

/**
 * This class holds the name map between O3 syntax names to library function
 * names.
 *
 * @author schumaker
 * @param <T> Name of the O3 function
 * @param <V> Name of the function in the library.
 */
public class X64O3FunctionMap<T, V> {

    private final T o3Name;
    private final V inLibName;

    private X64O3FunctionMap(T t, V v) {
        this.o3Name = t;
        this.inLibName = v;
    }

    public static <F, L> X64O3FunctionMap<F, L> of(F o3Function, L libFunction) {
        return new X64O3FunctionMap<>(o3Function, libFunction);
    }

    public T getO3Name() {
        return o3Name;
    }

    public V getInLibName() {
        return inLibName;
    }
}
