package old.br.com.schumaker.carla.o3.core;

import br.com.schumaker.carla.build.exception.ArgumentTypeNotSupportedException;
import br.com.schumaker.carla.build.exception.FunctionNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.Data;
import old.br.com.schumaker.carla.lexer.o3.O3VariableType;
import old.br.com.schumaker.carla.o3.O3SyntaxFunctionTable;
import old.br.com.schumaker.halogenx64.X128RegisterArgumentTable;
import old.br.com.schumaker.halogenx64.X64RegisterArgumentTable;

/**
 *
 * @author Hudson Schumaker
 */
@Data
public class O3Add implements IO3CoreFunction {

    public static final String O3MATH_ADDI = "o3addi";
    public static final String O3MATH_ADDF = "o3addf";
    public static final String O3MATH_ADDD = "o3addd";

    private String o3Name;
    private String library;
    private List<String> coreNames = new ArrayList<>();
    private Map<String, String> argTypeCoreNameMap = new HashMap<>();
    private Map<String, Integer> signatureArgumentMap = new HashMap<>();
    private Map<String, List<String>> signatureRegisterMap = new HashMap<>();

    public O3Add() throws Exception {
        this(new O3SyntaxFunctionTable());
    }

    public O3Add(O3SyntaxFunctionTable functionTable) {
        this.o3Name = O3SyntaxFunctionTable.MATH_ADD;
        this.library = functionTable.getLibNameByFunctionName(o3Name);
        //this.loadMethod();
    }

    @Override
    public String getCoreNameByType(String type) {
        return "_" + Optional.ofNullable(
                argTypeCoreNameMap.get(type))
                .orElseThrow(() -> new ArgumentTypeNotSupportedException());
    }

    @Override
    public String getCoreNameByType(O3VariableType type) {
        return this.getCoreNameByType(type.getName());
    }

    @Override
    public Integer getArgumentSizeByO3Name(String name) {
        return Optional.ofNullable(
                signatureArgumentMap.get(name))
                .orElseThrow(() -> new FunctionNotFoundException());
    }

    @Override
    public List<String> getOverloadMethods() {
        List list = new ArrayList(argTypeCoreNameMap.values());
        return list;
    }

    @Override
    public List<String> getRegistersByCoreName(String name) {
        return Optional.ofNullable(
                signatureRegisterMap.get(name))
                .orElseThrow(() -> new FunctionNotFoundException());
    }

    @Override
    public O3VariableType getReturnType(String name) {
        return O3VariableType.VOID;
    }

    private void loadCoreNames() {
        this.coreNames.add("_" + O3MATH_ADDI);
        this.coreNames.add("_" + O3MATH_ADDF);
        this.coreNames.add("_" + O3MATH_ADDD);
    }

    private void loadTypeMap() {
        this.argTypeCoreNameMap.put(O3VariableType.INT.getName(), O3MATH_ADDI);
        this.argTypeCoreNameMap.put(O3VariableType.FLOAT.getName(), O3MATH_ADDF);
        this.argTypeCoreNameMap.put(O3VariableType.DOUBLE.getName(), O3MATH_ADDD);
    }

    private void loadArgumentMap() {
        for (var name : coreNames) {
            this.signatureArgumentMap.put(name, 2);
        }
    }

    private void loadRegisterMap() {
        this.signatureRegisterMap.put("_" + O3MATH_ADDI,
                Arrays.asList("mov " + X64RegisterArgumentTable.getParamRegisterNameByIndex(0)));

        this.signatureRegisterMap.put("_" + O3MATH_ADDF,
                Arrays.asList("movss " + X64RegisterArgumentTable.getParamRegisterNameByIndex(0)));

        this.signatureRegisterMap.put("_" + O3MATH_ADDD,
                Arrays.asList("movsd " + X128RegisterArgumentTable.getParamRegisterNameByIndex(0)));

        
    }
    

}
