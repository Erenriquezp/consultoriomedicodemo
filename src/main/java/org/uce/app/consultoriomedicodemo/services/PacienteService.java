package org.uce.app.consultoriomedicodemo.services;

import org.uce.app.consultoriomedicodemo.dao.PacienteDAO;
import org.uce.app.consultoriomedicodemo.model.Paciente;
import java.util.List;

public class PacienteService implements PacienteServiceInterface {

    private final PacienteDAO pacienteDAO;

    public PacienteService() {
        this.pacienteDAO = new PacienteDAO();
    }

    @Override
    public boolean createPaciente(Paciente paciente) {
        return pacienteDAO.createPaciente(paciente);
    }

    @Override
    public List<Paciente> getAllPacientes() {
        return pacienteDAO.getAllPacientes();
    }

    @Override
    public Paciente getPacienteByCi(String ciPaciente) {
        return pacienteDAO.getPacienteByCi(ciPaciente);
    }

    @Override
    public boolean updatePaciente(Paciente paciente) {
        return pacienteDAO.updatePaciente(paciente);
    }

    @Override
    public boolean deletePaciente(String ciPaciente) {
        return pacienteDAO.deletePaciente(ciPaciente);
    }
}
