package org.uce.app.consultoriomedicodemo.services;

import org.uce.app.consultoriomedicodemo.model.Paciente;
import java.util.List;

public interface PacienteServiceInterface {
    boolean createPaciente(Paciente paciente);
    List<Paciente> getAllPacientes();
    Paciente getPacienteByCi(String ciPaciente);
    boolean updatePaciente(Paciente paciente);
    boolean deletePaciente(String ciPaciente);
}
