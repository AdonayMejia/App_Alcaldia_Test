package sv.edu.alcaldiaapp.Model;

import java.io.Serializable;

public class EventoSocialResponse implements Serializable {

    private int id;
    private String Nombre;
    private String Lugar;
    private String Foto;
    private String Descripcion;
    private String Fecha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = Nombre;
    }

    public String getLugar() {
        return Lugar;
    }

    public void setLugar(String lugar) {
        this.Lugar = Lugar;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String foto) {
        this.Foto = Foto;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        this.Fecha = Fecha;
    }

    @Override
    public String toString() {
        return "EventoSocialResponse{" +
                "id=" + id +
                ", Nombre='" + Nombre + '\'' +
                ", Lugar='" + Lugar + '\'' +
                ", Foto='" + Foto + '\'' +
                ", Descripcion='" + Descripcion + '\'' +
                ", Fecha ='" + Fecha + '\'' +
                '}';
    }
}
