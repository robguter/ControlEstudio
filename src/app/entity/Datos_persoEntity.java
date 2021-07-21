package app.entity;

import java.sql.Date;

public class Datos_persoEntity {
    private int id;
    private String cedula;
    private String nombre;
    private String apellido;
    private String sexo;
    private Date fecnac;
    private String telefono;
    private String direccion;
    private String email;

    public Datos_persoEntity(int id, String cedula, String nombre, String apellido,
                             String sexo, Date fecnac, String telefono, String direccion, String email) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.fecnac = fecnac;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFecnac() {
        return fecnac;
    }
    public void setFecnac(Date fecnac) {
        this.fecnac = fecnac;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
