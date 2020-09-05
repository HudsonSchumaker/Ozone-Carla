package br.com.schumaker.halogenx64;

import br.com.schumaker.carla.lexer.o3.O3Variable;

/**
 *
 * @author Hudson Schumaker
 */
public class Halogenx64Variable {

    private final X64O3Variable2AsmMapper mapper = new X64O3Variable2AsmMapper();

    public String resolveTypeValue(O3Variable o3Var) {
        StringBuffer buffer = new StringBuffer();

        // internal name
        buffer.append(o3Var.getInternalName());
        buffer.append(HalogenX64Machinery.SPACES_2);

        // type
        buffer.append(mapper.getAsmType(o3Var.getTypeValue().getType().getName()));
        buffer.append(HalogenX64Machinery.SPACES_2);

        // value
        var value = o3Var.getTypeValue().getValue();
        if (value instanceof String) {
            buffer.append(value);
            buffer.append(", 0x0");
        } else {
            buffer.append(value);
        }
        buffer.append("\n");
        return buffer.toString();
    }
}
