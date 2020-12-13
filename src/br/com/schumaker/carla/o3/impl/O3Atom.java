package br.com.schumaker.carla.o3.impl;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author Hudson Schumaker
 */
@Data
@AllArgsConstructor
public final class O3Atom {

    private String name;
    private List<O3Function> functions;
}
