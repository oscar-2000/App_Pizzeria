package Modelo;

public class Clientes {

    private String id;
    private String nombre;
    private String destino;
    private String promocion;

    public Clientes()
    {
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDestino() {
        return destino;
    }

    public String getPromocion() {
        return promocion;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setPromocion(String promocion) {
        this.promocion = promocion;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n" +
                "Destino: " + destino + "\n" +
                "Promocion: " + promocion;
    }
}
