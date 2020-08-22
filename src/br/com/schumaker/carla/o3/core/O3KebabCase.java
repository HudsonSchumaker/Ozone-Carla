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
 * kebab-case.
 *
 * @author Hudson Schumaker
 */
@Data
public class O3KebabCase {

    public static final String O3STR_KEBAB_CASE = "o3kebabCase";

    private String o3Name;
    private String library;
    private List<String> coreNames = new ArrayList<>();
    private Map<String, String> argTypeCoreNameMap = new HashMap<>();

    public O3KebabCase() throws Exception {
        var functionTable = new O3SyntaxFunctionTable();
        this.o3Name = O3SyntaxFunctionTable.STR_KEBAB_CASE;
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
        this.coreNames.add(O3STR_KEBAB_CASE);
    }

    public void loadTypeMap() {
        this.argTypeCoreNameMap.put(O3VariableType.STRING.getName(), O3STR_KEBAB_CASE);
    }
}