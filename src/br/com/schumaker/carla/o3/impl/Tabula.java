package br.com.schumaker.carla.o3.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author Hudson Schumaker
 */
@Data
@ToString
@AllArgsConstructor
public final class Tabula {

    private String name;
    private List<O3Function> functions;
}
