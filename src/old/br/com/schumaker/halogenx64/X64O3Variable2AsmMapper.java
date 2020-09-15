package old.br.com.schumaker.halogenx64;

import br.com.schumaker.carla.exception.ArgumentTypeNotSupportedException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import lombok.Getter;
import old.br.com.schumaker.carla.lexer.o3.O3VariableType;
import old.br.com.schumaker.halogenx64.asm.X64AsmVariableType;

/**
 *
 * @author Hudson Schumaker
 */
@Getter
public class X64O3Variable2AsmMapper {
    private Map<String, String> o3Var2AsmVarTypeMap = new HashMap<>();
    private Map<String, String> o3Var2AsmBssVarTypeMap = new HashMap<>();
    
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
        this.loadSectionDataTypes();
        this.loadSectionBssTypes(); 
    }
    
    /**
     * Use these method to find the types for the asm Data.
     * 
     * @param o3type
     * @return 
     */
    public String getAsmType(String o3type) {
        return Optional.ofNullable(
                o3Var2AsmVarTypeMap.get(o3type))
                .orElseThrow(() -> new ArgumentTypeNotSupportedException());
    }
    
    /**
     * Use these method to find the types for the asm Block Started by Symbol.
     * 
     * @param o3type
     * @return 
     */
    public String getAsmBssType(String o3type) {
        return Optional.ofNullable(
                o3Var2AsmBssVarTypeMap.get(o3type))
                .orElseThrow(() -> new ArgumentTypeNotSupportedException());
    }
    
    public void loadSectionDataTypes() {
        this.o3Var2AsmVarTypeMap.put(O3VariableType.STRING.getName(), X64AsmVariableType.DB.getAsmName());
        this.o3Var2AsmVarTypeMap.put(O3VariableType.INT.getName(), X64AsmVariableType.DD.getAsmName());
        this.o3Var2AsmVarTypeMap.put(O3VariableType.FLOAT.getName(), X64AsmVariableType.DD.getAsmName());
        this.o3Var2AsmVarTypeMap.put(O3VariableType.DOUBLE.getName(), X64AsmVariableType.DQ.getAsmName());
        this.o3Var2AsmVarTypeMap.put(O3VariableType.RETURN_STRING.getName(), X64AsmVariableType.RESQ.getAsmName());
        this.o3Var2AsmVarTypeMap.put(O3VariableType.RETURN_INTEGER.getName(), X64AsmVariableType.RESD.getAsmName());
        this.o3Var2AsmVarTypeMap.put(O3VariableType.RETURN_FLOAT.getName(), X64AsmVariableType.RESD.getAsmName());
        this.o3Var2AsmVarTypeMap.put(O3VariableType.RETURN_DOUBLE.getName(), X64AsmVariableType.RESQ.getAsmName());
    }
    
    public void loadSectionBssTypes() {
        this.o3Var2AsmBssVarTypeMap.put(O3VariableType.BOOL.getName(), X64AsmVariableType.RESB.getAsmName());
        this.o3Var2AsmBssVarTypeMap.put(O3VariableType.STRING.getName(), X64AsmVariableType.RESQ.getAsmName());
        this.o3Var2AsmBssVarTypeMap.put(O3VariableType.INT.getName(), X64AsmVariableType.RESD.getAsmName());
        this.o3Var2AsmBssVarTypeMap.put(O3VariableType.FLOAT.getName(), X64AsmVariableType.RESD.getAsmName());
        this.o3Var2AsmBssVarTypeMap.put(O3VariableType.DOUBLE.getName(), X64AsmVariableType.RESQ.getAsmName());
    }
}
