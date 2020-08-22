package br.com.schumaker.halogenx64;

import lombok.Data;

/**
 *
 * @author schumaker
 */
@Data
public class X64Function {
        
    private String o3Name;
    private String libName;
    private X64O3FunctionMap typeLibFuncNameMap;
    
    private X64Function(String name, String libName, X64O3FunctionMap map) {
        this.o3Name = name;
        this.libName = libName;
        this.typeLibFuncNameMap = map;
    }
   
    public static X64Function of(String name, String libName, X64O3FunctionMap functionMap) {
        return new X64Function(name, libName, functionMap);
    }
}
