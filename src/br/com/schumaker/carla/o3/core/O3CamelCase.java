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
 * camelCase.
 *
 * @author Hudson Schumaker
 */
@Data
public class O3CamelCase implements IO3CoreFunction {

    public static final String O3STR_CAMEL_CASE = "o3camelCase";

    private String o3Name;
    private String library;
    private List<String> coreNames = new ArrayList<>();
    private Map<String, String> argTypeCoreNameMap = new HashMap<>();

    public O3CamelCase() throws Exception {
        this(new O3SyntaxFunctionTable());
    }

    /**
     * Highly advised to use this constructor with a reference of a function
     * table otherwise all CoreFunction class will have their own reference to a
     * function table.
     *
     * @param functionTable
     * @throws Exception
     */
    public O3CamelCase(O3SyntaxFunctionTable functionTable) throws Exception {
        this.o3Name = O3SyntaxFunctionTable.STR_CAMEL_CASE;
        this.library = functionTable.getLibNameByFunctionName(o3Name);
        this.loadCoreNames();
        this.loadTypeMap();
    }

    @Override
    public String getCoreNameByType(O3VariableType type) {
        return Optional.ofNullable(
                argTypeCoreNameMap.get(type.getName()))
                .orElseThrow(() -> new ArgumentTypeNotSupportedException());
    }

    @Override
    public List<String> getOverloadMethods() {
        List list = new ArrayList(argTypeCoreNameMap.values());
        return list;
    }

    public void loadCoreNames() {
        this.coreNames.add(O3STR_CAMEL_CASE);
    }

    public void loadTypeMap() {
        this.argTypeCoreNameMap.put(O3VariableType.STRING.getName(), O3STR_CAMEL_CASE);
    }
}
