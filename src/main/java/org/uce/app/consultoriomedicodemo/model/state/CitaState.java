package org.uce.app.consultoriomedicodemo.model.state;

import org.uce.app.consultoriomedicodemo.model.Cita;

public interface CitaState {
    void programar(Cita cita);
    void completar(Cita cita);
    void cancelar(Cita cita);
    String getEstado();
}
