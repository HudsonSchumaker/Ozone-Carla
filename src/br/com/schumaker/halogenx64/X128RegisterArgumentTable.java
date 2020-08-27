package br.com.schumaker.halogenx64;

import br.com.schumaker.carla.exception.X128RegisterNotFound;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @author Hudson Schumaker
 */
public class X128RegisterArgumentTable {
    public static final String XMM0 = "xmm0"; //1st argument	
    public static final String XMM1 = "xmm1"; //2nd argument	
    public static final String XMM2 = "xmm2"; //3rd argument	
    public static final String XMM3 = "xmm3"; //4th argument
    public static final String XMM4 = "xmm4"; //5th argument
    public static final String XMM5 = "xmm5"; //6th argument
    public static final String XMM6 = "xmm6"; //7th argument
    private static final Integer SIZE = 7;

    private static List<String> arguments;
    private static  Map<Integer, String> x128RegMap = new HashMap<>();
    
    static {
        loadArgumentList();
        for (int k = 0; k < SIZE; k++) {
            x128RegMap.put(k, arguments.get(k));
        }
    }
    
    public static String getParamRegisterNameByIndex(int index) {
        return Optional.ofNullable(
                x128RegMap.get(index))
                .orElseThrow(() -> new X128RegisterNotFound());
    }

    private static void loadArgumentList() {
        arguments = Arrays.asList(XMM0, XMM1, XMM2, XMM3, XMM4, XMM5, XMM6);
    }
}
