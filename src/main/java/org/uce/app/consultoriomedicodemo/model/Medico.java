package org.uce.app.consultoriomedicodemo.model;

public class Medico {
    private final String ciMedico;
    private final String apellidos;
    private final String nombres;
    private final String telefono;
    private final String email;

    private Medico(Builder builder) {
        this.ciMedico = builder.ciMedico;
        this.apellidos = builder.apellidos;
        this.nombres = builder.nombres;
        this.telefono = builder.telefono;
        this.email = builder.email;
    }

    public static class Builder {
        private String ciMedico;
        private String apellidos;
        private String nombres;
        private String telefono;
        private String email;

        public Builder() {
        }

        public Builder ciMedico(String ciMedico) {
            this.ciMedico = ciMedico;
            return this;
        }

        public Builder apellidos(String apellidos) {
            this.apellidos = apellidos;
            return this;
        }

        public Builder nombres(String nombres) {
            this.nombres = nombres;
            return this;
        }

        public Builder telefono(String telefono) {
            this.telefono = telefono;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Medico build() {
            return new Medico(this);
        }
    }

    // Getters (opcional)
    public String getCiMedico() {
        return ciMedico;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }
}
