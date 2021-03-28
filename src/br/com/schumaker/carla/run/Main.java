package br.com.schumaker.carla.run;

/**
 * @author Hudson Schumaker
 */
public class Main {
    public static void main(String[] args) throws Exception {


        System.out.println(System.getProperty("user.country"));


        if (args.length > 0) {
            new Maestro(args).start();
        } else {
            System.exit(1);
        }
    }
}
