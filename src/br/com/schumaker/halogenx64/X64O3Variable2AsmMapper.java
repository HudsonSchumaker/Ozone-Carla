package br.com.schumaker.halogenx64;

import br.com.schumaker.carla.exception.ArgumentTypeNotSupportedException;
import br.com.schumaker.carla.lexer.o3.O3VariableType;
import br.com.schumaker.halogenx64.asm.X64AsmVariableType;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import lombok.Getter;

/**
 *
 * @author Hudson Schumaker
 */
@Getter
public class X64O3Variable2AsmMapper {
    private Map<String, String> o3Var2AsmVarTypeMap = new HashMap<>();
    
    public String getAsmType(String o3type) {
        return Optional.ofNullable(
                o3Var2AsmVarTypeMap.get(o3type))
                .orElseThrow(() -> new ArgumentTypeNotSupportedException());
    }
    /**
     * BYTE     byte,  1byte (db), 8 bits.
     * BOOL     byte,  1byte (db), 8 bits.
     * CHAR     byte,  1byte (db), 8 bits.
     * STRING   ??
     * INT      doubleword, 4bytes (dd), 32bits.
     * LONG     quadword,   8bytes (dq), 64bits.
     * FLOAT    doubleword, 4bytes (dd), 32bits.
     * DOUBLE   quadword,   8bytes (dq), 64bits.
     */
    public X64O3Variable2AsmMapper() {
        // TODO do the others types.
        this.o3Var2AsmVarTypeMap.put(O3VariableType.STRING.getName(), X64AsmVariableType.DB.getAsmName());
        this.o3Var2AsmVarTypeMap.put(O3VariableType.INT.getName(), X64AsmVariableType.DD.getAsmName());
        this.o3Var2AsmVarTypeMap.put(O3VariableType.FLOAT.getName(), X64AsmVariableType.DD.getAsmName());
        this.o3Var2AsmVarTypeMap.put(O3VariableType.DOUBLE.getName(), X64AsmVariableType.DQ.getAsmName());
    }
}
