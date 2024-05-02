public class Cajera implements Runnable {
    private String nombre;
    private Cliente cliente;
    private long initialTime;

    // Constructor
    public Cajera(String nombre, Cliente cliente, long initialTime) {
        this.nombre = nombre;
        this.cliente = cliente;
        this.initialTime = initialTime;
    }

    // Método run
    @Override
    public void run() {
        System.out.println("La cajera " + this.nombre +
                           " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "
                           + cliente.getNombre() + " EN EL TIEMPO: "
                           + (System.currentTimeMillis() - this.initialTime) / 1000
                           + "seg");

        for (int i = 0; i < cliente.getCarroCompra().length; i++) {
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesado el producto " + (i + 1)
                               + " del cliente " + this.cliente.getNombre() +
                               "->Tiempo: " + (System.currentTimeMillis() - this.initialTime) / 1000
                               + "seg");
        }

        System.out.println("La cajera " + this.nombre + " HA TERMINADO DE PROCESAR "
                           + cliente.getNombre() + " EN EL TIEMPO: "
                           + (System.currentTimeMillis() - this.initialTime) / 1000
                           + "seg");
    }

    // Método para simular el escaneo de productos
    private void esperarXsegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
