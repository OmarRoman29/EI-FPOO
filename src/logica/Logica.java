package logica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import persistencia.entidad.Almacenable;
import persistencia.repositorio.Repositorio;

public abstract class Logica<T extends Almacenable> {
    Repositorio<T> repo;


    public Repositorio<T> getRepo(){
        return repo;
    }

    /** 
     * "Validacion" de el agregado de una tarea al repositorio
     * @param r Un objeto tarea el cual ya debe tener los datos 
     * necesarios pero sin el codigo asignado (-1)
     */
    public boolean add(T r) throws IOException {
        r.setCodigo(repo.getLista().isEmpty() ? 1 : repo.getLista().getLast().getCodigo()+1);
        repo.add(r);
        return true;
    }

    
    /**
     * Eliminacion producto de una previa busqueda del elemento que
     * se quiere eliminar
     * @param r referencia al registro a eliminar
     */
    public void remove(T r) throws IOException{
        repo.remove(r);
    }

    
    /**
     * Busqueda por código de un registro
     * @param codigo el código a buscar
     * @return retorna la referencia al registro en cuestion
     * de lo contrario retorna null
     */
    public List<T> buscar_por_id(int codigo){
        List<T> busqueda = new ArrayList<>();

        for(T r:repo.getLista()){
            if(r.getCodigo() == codigo){
                busqueda.add(r);
                break;
            }
        }

        return busqueda;
    }
}
