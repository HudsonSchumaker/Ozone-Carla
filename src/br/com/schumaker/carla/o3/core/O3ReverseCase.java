package br.com.schumaker.carla.o3.core;

import br.com.schumaker.carla.exception.ArgumentTypeNotSupportedException;
import br.com.schumaker.carla.exception.FunctionNotFoundException;
import br.com.schumaker.carla.lexer.o3.O3VariableType;
import br.com.schumaker.carla.o3.O3SyntaxFunctionTable;
import br.com.schumaker.halogenx64.X64RegisterArgumentTable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.Data;

/**
 * ReserseCase.
 *
 * @author Hudson Schumaker
 */
@Data
public final class O3ReverseCase implements IO3CoreFunction {

    public static final String O3STR_REVERSE_CASE = "o3reverseCase";

    private String o3Name;
    private String library;
    private List<String> coreNames = new ArrayList<>();
    private Map<String, String> argTypeCoreNameMap = new HashMap<>();
    private Map<String, Integer> signatureArgumentMap = new HashMap<>();
    private Map<String, List<String>> signatureRegisterMap = new HashMap<>();

    public O3ReverseCase() throws Exception {
        this(new O3SyntaxFunctionTable());
    }

    public O3ReverseCase(O3SyntaxFunctionTable functionTable) {
        this.o3Name = O3SyntaxFunctionTable.STR_REVERSE_CASE;
        this.library = functionTable.getLibNameByFunctionName(o3Name);
        this.loadMethod();
    }

    @Override
    public String getCoreNameByType(String type) {
        return Optional.ofNullable(
                argTypeCoreNameMap.get(type))
                .orElseThrow(() -> new ArgumentTypeNotSupportedException());
    }

    @Override
    public String getCoreNameByType(O3VariableType type) {
        return this.getCoreNameByType(type.getName());
    }

    @Override
    public List<String> getOverloadMethods() {
        List list = new ArrayList(argTypeCoreNameMap.values());
        return list;
    }

    @Override
    public Integer getArgumentSizeByO3Name(String name) {
        return Optional.ofNullable(
                signatureArgumentMap.get(name))
                .orElseThrow(() -> new FunctionNotFoundException());
    }

    @Override
    public List<String> getRegistersByCoreName(String name) {
        return Optional.ofNullable(
                signatureRegisterMap.get(name))
                .orElseThrow(() -> new FunctionNotFoundException());
    }
    
    @Override
    public O3VariableType getReturnType() {
        return O3VariableType.STRING;
    }

    private void loadMethod() {
        this.coreNames.add(O3STR_REVERSE_CASE);
        this.argTypeCoreNameMap.put(O3VariableType.STRING.getName(), O3STR_REVERSE_CASE);
        
        for (var name : coreNames) {
            this.signatureArgumentMap.put(name, 1);
        }
        
        this.signatureRegisterMap.put("_" + O3STR_REVERSE_CASE,
                Arrays.asList(X64RegisterArgumentTable.getParamRegisterNameByIndex(0)));
    }
}
