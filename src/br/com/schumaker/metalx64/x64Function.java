package br.com.schumaker.metalx64;

import java.util.Map;
import lombok.Data;

/**
 *
 * @author schumaker
 */
@Data
public class x64Function {
    
    private x64Function(String name, String libName, Map map) {
        this.o3Name = name;
        this.libName = libName;
        this.typeLibFuncNameMap = map;
    }
    
    private String o3Name;
    private String libName;
    private Map<String, String> typeLibFuncNameMap;
    
    public static x64Function of(String name, String libName, Map map) {
        return new x64Function(name, libName, map);
    }
}
