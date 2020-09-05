package br.com.schumaker.halogenx64.asm;

import lombok.Getter;

/**
 * This enumerator defines the variables types of NASM.
 *
 * @author Hudson Schumaker
 */
@Getter
public enum X64AsmVariableType {

    //System	 Byte	Initialized   Bits    
    //byte	 1	db	      8
    //word	 2	dw	      16
    //doubleword 4	dd	      32
    //quadword   8	dq	      64
    DB("db", ""),
    DW("dw", "0"),
    DD("dd", "0"),
    DQ("dq", "0"),
    RESB("resb", ""),
    RESW("resw", ""),
    RESD("resd", ""),
    RESQ("resq", "");

    private final String asmName;
    private final String defaultValue;

    private X64AsmVariableType(String asmName, String defaultValue) {
        this.asmName = asmName;
        this.defaultValue = defaultValue;
    }
}
