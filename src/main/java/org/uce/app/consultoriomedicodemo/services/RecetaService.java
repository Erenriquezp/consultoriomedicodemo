package org.uce.app.consultoriomedicodemo.services;

import org.uce.app.consultoriomedicodemo.dao.RecetaDAO;
import org.uce.app.consultoriomedicodemo.model.Receta;
import java.util.List;

public class RecetaService implements RecetaServiceInterface {
    private final RecetaDAO recetaDAO;

    public RecetaService() {
        this.recetaDAO = new RecetaDAO();
    }

    @Override
    public boolean createReceta(Receta receta) {
        return recetaDAO.createReceta(receta);
    }

    @Override
    public List<Receta> getAllRecetas() {
        return recetaDAO.getAllRecetas();
    }

    @Override
    public Receta getRecetaById(int id) {
        return recetaDAO.getRecetaById(id);
    }

    @Override
    public boolean updateReceta(Receta receta) {
        return recetaDAO.updateReceta(receta);
    }

    @Override
    public boolean deleteReceta(int id) {
        return recetaDAO.deleteReceta(id);
    }
}
