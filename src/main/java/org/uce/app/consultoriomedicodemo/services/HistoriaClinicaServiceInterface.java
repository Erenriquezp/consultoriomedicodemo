package org.uce.app.consultoriomedicodemo.services;

import org.uce.app.consultoriomedicodemo.model.HistoriaClinica;
import java.util.List;

public interface HistoriaClinicaServiceInterface {
    boolean createHistoriaClinica(HistoriaClinica historiaClinica);
    List<HistoriaClinica> getAllHistoriasClinicas();
    HistoriaClinica getHistoriaClinicaById(String id);
    boolean updateHistoriaClinica(HistoriaClinica historiaClinica);
    boolean deleteHistoriaClinica(String id);
}
