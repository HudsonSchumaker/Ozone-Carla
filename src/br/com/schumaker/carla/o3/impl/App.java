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
public final class App {

    private String name;
    private List<O3Class> classes;
    private O3EntryPoint entryPoint;
}
