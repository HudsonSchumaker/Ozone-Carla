package br.com.schumaker.carla.run;

/**
 *
 * @author schumaker
 */
public class CarlaCompiler {
    public static void main(String[] args) throws Exception {
        if (args.length > 0) {
            new Maestro(args).start();
        } else {
            System.exit(1);
        }
    }
}