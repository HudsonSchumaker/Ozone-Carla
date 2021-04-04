package br.com.schumaker.carla.run;

/**
 * @author Hudson Schumaker
 */
public final class Main {
    public static void main(String[] args) throws Exception {
        if (args.length > 0) {
            new Compiler(args).start();
        } else {
            System.exit(1);
        }
    }
}
