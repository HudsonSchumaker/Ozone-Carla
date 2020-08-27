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
 * Print.
 *
 * @author Hudson Schumaker
 */
@Data
public class O3Print implements IO3CoreFunction {

    public static final String O3PRTSTR = "o3prtStr";
    public static final String O3PRTINT = "o3prtInt";
    public static final String O3PRTFLOAT = "o3prtFloat";
    public static final String O3PRTDOUBLE = "o3prtDouble";

    private String o3Name;
    private String library;
    private List<String> coreNames = new ArrayList<>();
    private Map<String, String> argTypeCoreNameMap = new HashMap<>(); // the key is a type of data.
    private Map<String, Integer> signatureArgumentMap = new HashMap<>();
    private Map<String, List<String>> signatureRegisterMap = new HashMap<>();

    public O3Print() throws Exception {
        this(new O3SyntaxFunctionTable());
    }

    public O3Print(O3SyntaxFunctionTable functionTable) {
        this.o3Name = O3SyntaxFunctionTable.PRT_PRINT;
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

    private void loadCoreNames() {
        this.coreNames.add("_" + O3PRTSTR);
        this.coreNames.add("_" + O3PRTINT);
        this.coreNames.add("_" + O3PRTFLOAT);
        this.coreNames.add("_" + O3PRTDOUBLE);
    }

    private void loadTypeMap() {
        this.argTypeCoreNameMap.put(O3VariableType.STRING.getName(), O3PRTSTR);
        this.argTypeCoreNameMap.put(O3VariableType.INT.getName(), O3PRTINT);
        this.argTypeCoreNameMap.put(O3VariableType.FLOAT.getName(), O3PRTFLOAT);
        this.argTypeCoreNameMap.put(O3VariableType.DOUBLE.getName(), O3PRTDOUBLE);
    }
    
    private void loadArgumentMap() {
        for (var name : coreNames) {
            this.signatureArgumentMap.put(name, 1);
        }
    }
    
    private void loadRegisterMap() {
        this.signatureRegisterMap.put("_" + O3PRTSTR, 
                Arrays.asList(X64RegisterArgumentTable.getParamRegisterNameByIndex(0)));
        
        this.signatureRegisterMap.put("_" + O3PRTINT, 
                Arrays.asList(X64RegisterArgumentTable.getParamRegisterNameByIndex(0)));
        
        this.signatureRegisterMap.put("_" + O3PRTFLOAT,
                Arrays.asList(X128RegisterArgumentTable.getParamRegisterNameByIndex(0)));
        
        this.signatureRegisterMap.put("_" + O3PRTDOUBLE,
                 Arrays.asList(X128RegisterArgumentTable.getParamRegisterNameByIndex(0)));
    }
}
