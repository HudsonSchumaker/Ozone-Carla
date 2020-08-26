package br.com.schumaker.carla.o3;

import br.com.schumaker.carla.exception.LoadSyntaxFunctionException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Hudson Schumaker
 */
public class O3SyntaxFunctionTable {

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
    public static final String STR_REVERSE_CASE = "reverseCase";

    // Math uses MATH as identifier
    public static final String MATH_POW = "pow";
    public static final String MATH_SQRT = "sqrt";
    public static final String MATH_ABS = "abs";
    public static final String MATH_MIN = "min";
    public static final String MATH_MAX = "max";

    private List<String> allFunction = new ArrayList<>();
    private Map<String, String> allFunctionMap = new HashMap<>();

    public O3SyntaxFunctionTable() throws Exception {
        this.loadValues();
        this.loadStringLib();
        this.loadPrintLib();
    }

    public boolean functionExists(String name) {
        return allFunction.contains(name);
    }

    /**
     * Returns the name of the object lib where the method is constructed.
     *
     * @param name Name of the function to get Lib name.
     * @return returns Lib object name or empty if method was not found.
     */
    public String getLibNameByFunctionName(String name) {
        if (this.functionExists(name)) {
            return allFunctionMap.get(name);
        } else {
            return "";
        }
    }

    /**
     * Load all function from all libraries.
     *
     * @throws Exception
     */
    private void loadValues() {
        Class<?> thisClass = null;
        try {
            thisClass = Class.forName(this.getClass().getName());
            Field[] aClassFields = thisClass.getDeclaredFields();
            for (Field f : aClassFields) {
                if (f.getName().startsWith("STR_")
                        || f.getName().startsWith("PRT_")) { //|| f.getName().startsWith("MATH_")

                    String aux = (String) f.get(this);
                    allFunction.add(aux);
                }
            }
        } catch (Exception e) {
            throw new LoadSyntaxFunctionException();
        }
    }

    private void loadStringLib() {
        Class<?> thisClass = null;
        try {
            thisClass = Class.forName(this.getClass().getName());
            Field[] aClassFields = thisClass.getDeclaredFields();
            for (Field f : aClassFields) {
                if (f.getName().startsWith("STR_")) {
                    allFunctionMap.put((String) f.get(this), O3SyntaxLibrary.STRINGS_O);
                }
            }
        } catch (Exception e) {
            throw new LoadSyntaxFunctionException();
        }
    }

    private void loadPrintLib() throws Exception {
        Class<?> thisClass = null;
        try {
            thisClass = Class.forName(this.getClass().getName());
            Field[] aClassFields = thisClass.getDeclaredFields();
            for (Field f : aClassFields) {
                if (f.getName().startsWith("PRT_")) {
                    allFunctionMap.put((String) f.get(this), O3SyntaxLibrary.PRINT_O);
                }
            }
        } catch (Exception e) {
            throw new LoadSyntaxFunctionException();
        }
    }
}
