package br.com.schumaker.carla.io;

/**
 * @param <T>
 * @author Hudson Schumaker
 */
public interface Reader<T> {

    /**
     * Reads the lines from a .o3 source file. Reads line by line and return in raw.
     *
     * @param path Path of the source file.
     * @return Raw lines
     * @throws Exception FileNotFound or FileNotSupported.
     */
    T read(String path) throws Exception;
}