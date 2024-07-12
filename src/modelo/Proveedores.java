package modelo;

public class Proveedores {
    private int id;
    private String ruc;
    private String razon;
    private String contacto;
    private String telefono;
    private String email; 

    public Proveedores() {
    }

    public Proveedores(int id, String ruc, String razon, String contacto, String telefono, String email) {
        this.id = id;
        this.ruc = ruc;
        this.razon = razon;
        this.contacto = contacto;
        this.telefono = telefono;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}


