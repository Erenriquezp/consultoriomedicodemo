package org.uce.app.consultoriomedicodemo.services;

import org.uce.app.consultoriomedicodemo.model.Cita;
import java.time.LocalDateTime;
import java.util.List;

public class CitaServiceProxy implements CitaServiceInterface {
    private final CitaService citaService;

    public CitaServiceProxy(CitaService citaService) {
        this.citaService = citaService;
    }

    @Override
    public boolean createCita(Cita cita) {
        logActivity("Creating cita: " + cita.getIdCita() + " at " + LocalDateTime.now());
        boolean result = citaService.createCita(cita);
        logActivity("Cita created: " + cita.getIdCita() + " result: " + result + " at " + LocalDateTime.now());
        return result;
    }

    @Override
    public List<Cita> getAllCitas() {
        logActivity("Fetching all citas at " + LocalDateTime.now());
        List<Cita> result = citaService.getAllCitas();
        logActivity("Fetched all citas: " + result.size() + " at " + LocalDateTime.now());
        return result;
    }

    @Override
    public Cita getCitaById(String id) {
        logActivity("Fetching cita by id: " + id + " at " + LocalDateTime.now());
        Cita result = citaService.getCitaById(id);
        logActivity("Fetched cita by id: " + id + " result: " + (result != null) + " at " + LocalDateTime.now());
        return result;
    }

    @Override
    public boolean updateCita(Cita cita) {
        logActivity("Updating cita: " + cita.getIdCita() + " at " + LocalDateTime.now());
        boolean result = citaService.updateCita(cita);
        logActivity("Cita updated: " + cita.getIdCita() + " result: " + result + " at " + LocalDateTime.now());
        return result;
    }

    @Override
    public boolean deleteCita(String id) {
        logActivity("Deleting cita: " + id + " at " + LocalDateTime.now());
        boolean result = citaService.deleteCita(id);
        logActivity("Cita deleted: " + id + " result: " + result + " at " + LocalDateTime.now());
        return result;
    }

    private void logActivity(String message) {
        // Implementación del registro de actividades
        System.out.println(message); // Simplificado para el ejemplo
    }
}
