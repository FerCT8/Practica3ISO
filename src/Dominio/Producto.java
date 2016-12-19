package Dominio;


public class Producto extends Listado {

    private int Codigo;
    private int Nombre;

    Producto(String Codigo, String Nombre) {
        super(Codigo,Nombre);
        
    }

    public int getCodigo() {
        return this.Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public int getNombre() {
        return this.Nombre;
    }

    public void setNombre(int Nombre) {
        this.Nombre = Nombre;
    }

    
    @Override
    public String toString() {

        String mensaje = "Codigo: " + this.Codigo + "-Nombre: " + this.Nombre;
        return mensaje;
    }


}
