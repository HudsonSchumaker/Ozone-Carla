package br.com.schumaker.carla.nasm;

/**
 *
 * @author Hudson Schumaker
 */
public final class NasmCommon {
    private NasmCommon() {}
    
    public static final String OFFSET = "0x2000000";
    public static final String EXIT   = "0x02000001";
    public static final String FORK   = "0x02000002";
    public static final String READ   = "0x02000003";
    public static final String WRITE  = "0x02000004";
    public static final String OPEN   = "0x02000005";
    public static final String CLOSE  = "0x02000006";    
}
