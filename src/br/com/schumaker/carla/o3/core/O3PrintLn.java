package br.com.schumaker.carla.o3.core;

import br.com.schumaker.carla.exception.ArgumentTypeNotSupportedException;
import br.com.schumaker.carla.lexer.o3.O3VariableType;
import br.com.schumaker.carla.o3.O3SyntaxFunctionTable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.Data;

/**
 *
 * @author Hudson Schumaker
 */
@Data
public class O3PrintLn {
    public static final String O3PRTSTRLN = "o3prtStrLn";
    public static final String O3PRTINTLN = "o3prtIntLn";
    public static final String O3PRTFLOATLN = "o3prtFloatLn";
    public static final String O3PRTDOUBLELN = "o3prtDoubleLn";

    private String o3Name;
    private String library;
    private List<String> coreNames = new ArrayList<>();
    // the key is a type of data.
    private Map<String, String> argTypeCoreNameMap = new HashMap<>();

    public O3PrintLn() throws Exception {
        var functionTable = new O3SyntaxFunctionTable();
        this.o3Name = O3SyntaxFunctionTable.PRT_PRINT_LN;
        this.library = functionTable.getLibNameByFunctionName(o3Name);
        this.loadCoreNames();
        this.loadTypeMap();
    }
    
    public String getCoreNameByType(O3VariableType type) {
        return Optional.ofNullable(
                argTypeCoreNameMap.get(type.getName()))
                .orElseThrow(() -> new ArgumentTypeNotSupportedException());
    }

    public void loadCoreNames() {
        this.coreNames.add(O3PRTSTRLN);
        this.coreNames.add(O3PRTINTLN);
        this.coreNames.add(O3PRTFLOATLN);
        this.coreNames.add(O3PRTDOUBLELN);
    }
    
    public void loadTypeMap() {
        this.argTypeCoreNameMap.put(O3VariableType.STRING.getName(), O3PRTSTRLN);
        this.argTypeCoreNameMap.put(O3VariableType.INT.getName(), O3PRTINTLN);
        this.argTypeCoreNameMap.put(O3VariableType.FLOAT.getName(), O3PRTFLOATLN);
        this.argTypeCoreNameMap.put(O3VariableType.DOUBLE.getName(), O3PRTDOUBLELN);  
    }
}
