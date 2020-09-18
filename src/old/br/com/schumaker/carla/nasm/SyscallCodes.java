package old.br.com.schumaker.carla.nasm;

import br.com.schumaker.carla.exception.LoadSysCallCodesException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Hudson Schumaker
 */
public final class SyscallCodes {

    public SyscallCodes() {
    }

    public static final String MACOS_OFFSET = "0x2000000";
    public static final String MACOS_EXIT = "0x02000001";
    public static final String MACOS_FORK = "0x02000002";
    public static final String MACOS_READ = "0x02000003";
    public static final String MACOS_WRITE = "0x02000004";
    public static final String MACOS_OPEN = "0x02000005";
    public static final String MACOS_CLOSE = "0x02000006";

    public static final String LINUX_EXIT = "60";
    public static final String LINUX_FORK = "57";
    public static final String LINUX_READ = "0";
    public static final String LINUX_WRITE = "1";
    public static final String LINUX_OPEN = "2";
    public static final String LINUX_CLOSE = "3";

    private Map<String, String> LinuxsysCalls = new HashMap<>();

    public Map<String, String> getMacOsSysCallMap() {
        Map<String, String> macosSysCalls = new HashMap<>();;
        Class<?> thisClass = null;
        try {
            thisClass = Class.forName(this.getClass().getName());
            Field[] aClassFields = thisClass.getDeclaredFields();
            for (Field f : aClassFields) {
                if (f.getName().startsWith("MACOS_")) {
                    var name = f.getName();
                    var codeName = name.substring(name.indexOf("_") + 1, name.length());
                    macosSysCalls.put(codeName, (String) f.get(this));
                }
            }
        } catch (Exception e) {
            throw new LoadSysCallCodesException();
        }
        return macosSysCalls;
    }

}
