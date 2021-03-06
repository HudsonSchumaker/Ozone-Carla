package br.com.schumaker.carla.o3.impl;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Hudson Schumaker
 */
@Data
@AllArgsConstructor
public final class O3EntryPoint {

    private O3Class clazz;
    private O3Function main;
}
