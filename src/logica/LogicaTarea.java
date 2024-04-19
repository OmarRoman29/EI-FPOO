package logica;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import persistencia.entidad.Tarea;
import persistencia.repositorio.RepoTarea;

public class LogicaTarea extends Logica<Tarea> {
    public LogicaTarea(String pathArchivo) throws IOException{
        repo = new RepoTarea(pathArchivo);
    }

    /**
     * @param responsable id del responsable a buscar
     * @return si no se encuentran valores devuelve una lista
     * vacía */
    public List<Tarea> buscar_por_responsable(int responsable){
        List<Tarea> busqueda = new ArrayList<>();
        for (Tarea tarea : repo.getLista()) {
            if(tarea.getResponsable() == responsable){
                busqueda.add(tarea);
            }
        }

        busqueda.getLast();

        return busqueda;
    }

    /**
     * @param Fecha inicio de la tarea a buscar
     * @return si no se encuentran valores devuelve una lista
     * vacía */
    public List<Tarea> buscar_por_fInicio(LocalDate fInicio){
        List<Tarea> b = new ArrayList<>();
        for(Tarea t:repo.getLista()){
            if(t.getfInicio().equals(fInicio)){
                b.add(t);
            }
        }

        return b;
    }

    /**
     * @param Fecha fin de la tarea a buscar
     * @return si no se encuentran valores devuelve una lista
     * vacía */
    public List<Tarea> buscar_por_fFin(LocalDate fFin){
        List<Tarea> b = new ArrayList<>();
        for(Tarea t:repo.getLista()){
            if(t.getfFin().equals(fFin)){
                b.add(t);
            }
        }

        return b;
    }

    /**
     * @param objeto con algunos valores modificados, aquellos que no
     * desean sobreescribirse se mantienen o en -1 o null */ 
    public void modificar(Tarea t, Tarea tModificado) throws IOException {
        if (tModificado.getCodigo() != -1)
            t.setCodigo(tModificado.getCodigo());

        if (tModificado.getResponsable() != -1)
            t.setResponsable(tModificado.getResponsable());

        if(tModificado.getfInicio() != null)
            t.setfInicio(tModificado.getfInicio());

        if(tModificado.getfFin() != null)
            t.setfFin(tModificado.getfFin());

        this.repo.save();
    }

    @Override
    public void add(Tarea t){
        //validaciones
        
        // agregar y determinar codigo
        super.add(t);
    }
}