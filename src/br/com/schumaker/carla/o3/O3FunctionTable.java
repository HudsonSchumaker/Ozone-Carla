package br.com.schumaker.carla.o3;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author schumaker
 */
public class O3FunctionTable {
    
     // Print uses PRT as indentifier
    public static final String PRT_PRINT = "print";
    public static final String PRT_PRINT_LN = "printLn";
    
    // Strings uses STR as indentifier
    public static final String STR_UPPER_CASE = "upperCase";
    public static final String STR_LOWER_CASE = "lowerCase";
    public static final String STR_CAMEL_CASE = "camelCase";
    public static final String STR_PASCAL_CASE = "pascalCase";
    public static final String STR_SNAKE_CASE = "snakeCase";
    public static final String STR_KEBAB_CASE = "kebabCase";
        
    // Math uses MATH as identifier
    public static final String MATH_POW = "pow";
    public static final String MATH_SQRT = "sqrt";
    public static final String MATH_ABS = "abs";
    public static final String MATH_MIN = "min";
    public static final String MATH_MAX = "max";
    
    private List<String> allFunction = new ArrayList<>();
    private Map<String, String> strings = new HashMap<>();
    private Map<String, String> print = new HashMap<>();

    public O3FunctionTable() throws Exception {
        this.loadValues();
        this.loadStringLib();
        this.loadPrintLib();
    }
            
    public boolean functionExists(String name) {
        return allFunction.contains(name);
    }
    
    private void loadValues() throws Exception {
        Class<?> thisClass = null;
        try {
            thisClass = Class.forName(this.getClass().getName());
            Field[] aClassFields = thisClass.getDeclaredFields();
            for (Field f : aClassFields) {
                if (f.getName().startsWith("STR_") 
                        || f.getName().startsWith("PRT_")
                        || f.getName().startsWith("MATH_")) {
                    
                    String aux = (String)f.get(this);
                    allFunction.add(aux);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    private void loadStringLib() throws Exception {
        Class<?> thisClass = null;
        try {
            thisClass = Class.forName(this.getClass().getName());
            Field[] aClassFields = thisClass.getDeclaredFields();
            for (Field f : aClassFields) {
                if (f.getName().startsWith("STR_")) {
                    strings.put((String)f.get(this), O3Library.STRINGS_O);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    private void loadPrintLib() throws Exception {
        Class<?> thisClass = null;
        try {
            thisClass = Class.forName(this.getClass().getName());
            Field[] aClassFields = thisClass.getDeclaredFields();
            for (Field f : aClassFields) {
                if (f.getName().startsWith("PRT_")) {
                    print.put((String)f.get(this), O3Library.PRINT_O);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
