package progetto_bottai;

public class Bagno {
    private boolean disponibile = true;
    private int numFemmineInAttesa=0;
     private int contaDonne=0;

    public synchronized void entra(ThreadB b) {
        String name = Thread.currentThread().getName();
        char sesso=b.getSesso();


        if(sesso=='F'){
            numFemmineInAttesa++;
            
        }


        try {
            while ( ! disponibile || (sesso == 'M' && numFemmineInAttesa>0 && contaDonne<=3)) {
               //  System.out.println(name + " in attesa di entrare...");
               
                wait();
            
               }
            
            
            disponibile = false;
            if(sesso=='F'){
                numFemmineInAttesa--;
                  contaDonne++;//conta le donne entrate
            }
            System.out.println(name + " entra in bagno");
        } catch ( InterruptedException e) {}

    }
    public synchronized void esci() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " esce dal bagno");
        disponibile = true;
        notifyAll();
    }
}
