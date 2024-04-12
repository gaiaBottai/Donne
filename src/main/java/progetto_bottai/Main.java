package progetto_bottai;

public class Main {
    public static void main(String[] args) {
        Bagno b1 = new Bagno();
        String[] nomi = {"Marco", "Prancesco","Lorenzo", "Sara", "Paola", "Marta","Giovanna"};
        char[] sessi = {'M','M','M','F','F','F','F'};

        for(int i=0; i<nomi.length; i++) {
            ThreadB t = new ThreadB(b1, nomi[i], sessi[i]);
            t.start();
        }
}
}