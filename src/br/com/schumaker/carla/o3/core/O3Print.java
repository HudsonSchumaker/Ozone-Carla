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
public class O3Print {
    
    public static final String O3PRTSTR = "o3prtStr";
    public static final String O3PRTINT = "o3prtInt";
    public static final String O3PRTFLOAT = "o3prtFloat";
    public static final String O3PRTDOUBLE = "o3prtDouble";

    private String o3Name;
    private String library;
    private List<String> coreNames = new ArrayList<>();
    // the key is a type of data.
    private Map<String, String> argTypeCoreNameMap = new HashMap<>();

    public O3Print() throws Exception {
        var functionTable = new O3SyntaxFunctionTable();
        this.o3Name = O3SyntaxFunctionTable.PRT_PRINT;
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
        this.coreNames.add(O3PRTSTR);
        this.coreNames.add(O3PRTINT);
        this.coreNames.add(O3PRTFLOAT);
        this.coreNames.add(O3PRTDOUBLE);
    }
    
    public void loadTypeMap() {
        this.argTypeCoreNameMap.put(O3VariableType.STRING.getName(), O3PRTSTR);
        this.argTypeCoreNameMap.put(O3VariableType.INT.getName(), O3PRTINT);
        this.argTypeCoreNameMap.put(O3VariableType.FLOAT.getName(), O3PRTFLOAT);
        this.argTypeCoreNameMap.put(O3VariableType.DOUBLE.getName(), O3PRTDOUBLE);  
    }
}
