package org.uce.app.consultoriomedicodemo.services;

import org.uce.app.consultoriomedicodemo.dao.UsuarioDAO;
import org.uce.app.consultoriomedicodemo.model.Usuario;

public class AuthService implements AuthServiceInterface {

    private final UsuarioDAO usuarioDAO;

    public AuthService() {
        this.usuarioDAO = new UsuarioDAO();
    }

    @Override
    public boolean authenticate(String username, String password) {
        Usuario user = usuarioDAO.findByUsername(username);

        if (user == null) {
            return false;
        }

        return username.equals(user.getUsername()) && password.equals(user.getPassword());
    }
}
