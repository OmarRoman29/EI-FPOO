package persistencia.entidad;

import java.time.LocalDate;


public class Tarea implements Almacenable {
    protected int codigo = -1;
    protected int responsable = -1;
    protected LocalDate fInicio = null;
    protected LocalDate fFin = null;

    public Tarea() {
        this.codigo = -1;
        this.responsable = -1;
        this.fInicio = null;
        this.fFin = null;
    }

    public Tarea(int codigo, int responsable, LocalDate fInicio, LocalDate fFin) {
        this.codigo = codigo;
        this.responsable = responsable;
        this.fInicio = fInicio;
        this.fFin = fFin;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getResponsable() {
        return responsable;
    }

    public void setResponsable(int responsable) {
        this.responsable = responsable;
    }

    public LocalDate getfInicio() {
        return fInicio;
    }

    public void setfInicio(LocalDate fInicio) {
        this.fInicio = fInicio;
    }

    public LocalDate getfFin() {
        return fFin;
    }

    public void setfFin(LocalDate fFin) {
        this.fFin = fFin;
    }

    @Override
    public String toString() {
        return codigo + " " + responsable + " " + fInicio + " " + fFin;
    }
}
