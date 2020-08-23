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
    
    public X64O3Variable2AsmMapper() {
        // TODO do the others types.
        this.o3Var2AsmVarTypeMap.put(O3VariableType.STRING.getName(), X64AsmVariableType.DB.getAsmName());
        this.o3Var2AsmVarTypeMap.put(O3VariableType.INT.getName(), X64AsmVariableType.DD.getAsmName());
        this.o3Var2AsmVarTypeMap.put(O3VariableType.FLOAT.getName(), X64AsmVariableType.DD.getAsmName());
    }
}
