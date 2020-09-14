package old.br.com.schumaker.halogenx64;

/**
 *
 * @author Hudson Schumaker
 * @param <A>
 */
public class X64O3VariableMap<N, A> {
    
    private final N internalName;
    private final A asmType;

    private X64O3VariableMap(N n, A a) {
        this.internalName = n;
        this.asmType = a;
    }

    public static <N, T> X64O3VariableMap<N, T> of(N internalName, T type) {
        return new X64O3VariableMap<>(internalName, type);
    }

    public N getInternalName() {
        return internalName;
    }

    public A getAsmType() {
        return asmType;
    }
}
