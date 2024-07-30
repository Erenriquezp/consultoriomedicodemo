package org.uce.app.consultoriomedicodemo.services;

import org.uce.app.consultoriomedicodemo.model.Receta;
import java.util.List;

public interface RecetaServiceInterface {
    boolean createReceta(Receta receta);
    List<Receta> getAllRecetas();
    Receta getRecetaById(int id);
    boolean updateReceta(Receta receta);
    boolean deleteReceta(int id);
}
