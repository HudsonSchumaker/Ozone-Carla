package br.com.schumaker.carla.o3;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Hudson Schumaker
 */
public class O3SyntaxLibrary {
    
    public static final List<String> LIB_ID = Arrays.asList("STR_", "PRT_", "MATH_", "FILE");
   
    // String lib
    public static final String STRINGS_O = "O3String.o";
    public static final String STRINGS_C = "O3String.c";
    
    // Print lib
    public static final String PRINT_O = "O3Print.o";
    public static final String PRINT_C = "O3Print.c";

    // File lib
    public static final String FILE_O = "O3File.o";
    public static final String FILE_C = "O3File.c";
}
