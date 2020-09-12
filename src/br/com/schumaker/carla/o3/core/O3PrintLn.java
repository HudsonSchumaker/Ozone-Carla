package br.com.schumaker.carla.o3.core;

import br.com.schumaker.carla.exception.ArgumentTypeNotSupportedException;
import br.com.schumaker.carla.exception.FunctionNotFoundException;
import br.com.schumaker.carla.lexer.o3.O3VariableType;
import br.com.schumaker.carla.o3.O3SyntaxFunctionTable;
import br.com.schumaker.halogenx64.X128RegisterArgumentTable;
import br.com.schumaker.halogenx64.X64RegisterArgumentTable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.Data;

/**
 * PrintLn.
 *
 * @author Hudson Schumaker
 */
@Data
public final class O3PrintLn implements IO3CoreFunction {

    public static final String O3PRT_STRLN = "o3prtStrLn";
    public static final String O3PRT_INTLN = "o3prtIntLn";
    public static final String O3PRTF_FLOATLN = "o3prtFloatLn";
    public static final String O3PRT_DOUBLELN = "o3prtDoubleLn";

    private String o3Name;
    private String library;
    private List<String> coreNames = new ArrayList<>();
    private Map<String, String> argTypeCoreNameMap = new HashMap<>(); // the key is a type of data.
    private Map<String, Integer> signatureArgumentMap = new HashMap<>();
    private Map<String, List<String>> signatureRegisterMap = new HashMap<>();

    public O3PrintLn() throws Exception {
        this(new O3SyntaxFunctionTable());
    }

    public O3PrintLn(O3SyntaxFunctionTable functionTable) {
        this.o3Name = O3SyntaxFunctionTable.PRT_PRINT_LN;
        this.library = functionTable.getLibNameByFunctionName(o3Name);
        this.loadCoreNames();
        this.loadTypeMap();
        this.loadArgumentMap();
        this.loadRegisterMap();
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
    public O3VariableType getReturnType(String name) {
        return O3VariableType.VOID;
    }

    public void loadCoreNames() {
        this.coreNames.add("_" + O3PRT_STRLN);
        this.coreNames.add("_" + O3PRT_INTLN);
        this.coreNames.add("_" + O3PRTF_FLOATLN);
        this.coreNames.add("_" + O3PRT_DOUBLELN);
    }

    public void loadTypeMap() {
        this.argTypeCoreNameMap.put(O3VariableType.STRING.getName(), O3PRT_STRLN);
        this.argTypeCoreNameMap.put(O3VariableType.INT.getName(), O3PRT_INTLN);
        this.argTypeCoreNameMap.put(O3VariableType.FLOAT.getName(), O3PRTF_FLOATLN);
        this.argTypeCoreNameMap.put(O3VariableType.DOUBLE.getName(), O3PRT_DOUBLELN);
    }

    public void loadArgumentMap() {
        for (var name : coreNames) {
            this.signatureArgumentMap.put(name, 1);
        }
    }

    private void loadRegisterMap() {
        this.signatureRegisterMap.put("_" + O3PRT_STRLN,
                Arrays.asList("mov " + X64RegisterArgumentTable.getParamRegisterNameByIndex(0)));

        this.signatureRegisterMap.put("_" + O3PRT_INTLN,
                Arrays.asList("mov " + X64RegisterArgumentTable.getParamRegisterNameByIndex(0)));

        this.signatureRegisterMap.put("_" + O3PRTF_FLOATLN,
                Arrays.asList("movss " + X128RegisterArgumentTable.getParamRegisterNameByIndex(0)));

        this.signatureRegisterMap.put("_" + O3PRT_DOUBLELN,
                Arrays.asList("movsd " + X128RegisterArgumentTable.getParamRegisterNameByIndex(0)));
    }
}
