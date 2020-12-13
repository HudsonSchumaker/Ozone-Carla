package br.com.schumaker.carla.o3.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author Hudson Schumaker
 */
@Data
@ToString
public class O3Function {

    private String name;
    private String internalName;
    private boolean isMain;
}
