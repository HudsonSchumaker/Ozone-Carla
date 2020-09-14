package old.br.com.schumaker.halogenx64;

import br.com.schumaker.carla.build.exception.X64RegisterNotFound;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @author Hudson Schumaker
 */
public class X64RegisterArgumentTable {

    public static final String RDI = "rdi"; //1st argument	
    public static final String RSI = "rsi"; //2nd argument	
    public static final String RDX = "rdx"; //3rd argument	
    public static final String RCX = "rcx"; //4th argument
    public static final String R8 = "r8";   //5th argument
    public static final String R9 = "r9";   //6th argument
    private static final Integer SIZE = 6;

    private static List<String> arguments;
    private static Map<Integer, String> x64RegMap = new HashMap<>();

    static {
        loadArgumentList();
        for (int k = 0; k < SIZE; k++) {
            x64RegMap.put(k, arguments.get(k));
        }
    }

    public static String getParamRegisterNameByIndex(int index) {
        return Optional.ofNullable(
                x64RegMap.get(index))
                .orElseThrow(() -> new X64RegisterNotFound());
    }

    private static void loadArgumentList() {
        arguments = Arrays.asList(RDI, RSI, RDX, RCX, R8, R9);
    }
}
