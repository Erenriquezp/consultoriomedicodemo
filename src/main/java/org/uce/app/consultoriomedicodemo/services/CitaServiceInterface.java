package org.uce.app.consultoriomedicodemo.services;

import org.uce.app.consultoriomedicodemo.model.Cita;
import java.util.List;

public interface CitaServiceInterface {
    boolean createCita(Cita cita);
    List<Cita> getAllCitas();
    Cita getCitaById(String id);
    boolean updateCita(Cita cita);
    boolean deleteCita(String id);
}
