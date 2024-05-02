public class MainRunnable {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Cliente 1", new int[]{2, 2, 1, 5, 2, 3});
        Cliente cliente2 = new Cliente("Cliente 2", new int[]{1, 3, 5, 1, 1});

        // Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();

        // Creación de los objetos Cajera y Thread
        Cajera cajera1 = new Cajera("Cajera 1", cliente1, initialTime);
        Cajera cajera2 = new Cajera("Cajera 2", cliente2, initialTime);

        Thread hiloCajera1 = new Thread(cajera1);
        Thread hiloCajera2 = new Thread(cajera2);

        // Inicio de los hilos
        hiloCajera1.start();
        hiloCajera2.start();
    }
}
