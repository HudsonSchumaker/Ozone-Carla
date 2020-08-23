package br.com.schumaker.carla.o3.core;

import java.util.List;

/**
 *
 * @author Hudson Schumaker
 */
public interface IO3CoreLibrary {
    void addCoreFunction(IO3CoreFunction coreFunction);
    List<IO3CoreFunction> getCoreLibs();
    IO3CoreFunction getByName(String name);
}
