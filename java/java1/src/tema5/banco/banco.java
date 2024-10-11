package tema5.banco;

public class banco {
    private String nombre, cuenta;
    private double saldo, tipoInteres;

    public banco() {}

    public banco(String nombre, String cuenta, double saldo, double tipoInteres) throws Exception {
        asignarNombre(nombre);
        asignarCuenta(cuenta);
        ingreso(saldo);
        asignarTipoInteres(tipoInteres);
    }

    public void asignarNombre(String nombre) throws Exception {
        if (nombre.length() == 0) {
            throw new Exception("Error: cadena vacía");
        } else {
            this.nombre = nombre;
        }
    }

    public String obtenerNombre() {
        return nombre;
    }

    public void asignarCuenta(String cuenta) throws Exception {
        if (cuenta.length() == 24) {
            this.cuenta = cuenta;
        } else {
            throw new Exception("La cuenta debe tener exactamente 24 caracteres.");
        }
    }

    public String obtenerCuenta() {
        return cuenta;
    }

    public void asignarTipoInteres(double tipoInteres) throws Exception {
        if (tipoInteres < 0) {
            throw new Exception("El interes no puede ser negativo");
        } else {
            this.tipoInteres = tipoInteres;
        }
    }

    public double obtenerTipoInteres() {
        return tipoInteres;
    }

    public double estado() {
        return saldo;
    }

    public void ingreso(double cantidad) throws Exception {
        if (cantidad <= 0) {
            throw new Exception("El ingreso debe ser una cantidad positiva");
        } else {
            saldo += cantidad;
        }
    }

    public void reintegro(double cantidad) throws Exception {
        if (saldo - cantidad < 0) {
            throw new Exception("No dispone de saldo");
        } else {
            saldo -= cantidad;
        }
    }
    
    @Override
public String toString(){
    try {
        return "Información de la cuenta: \nNombre: " + obtenerNombre() + "\nNúmero de cuenta: " + obtenerCuenta() + "\nTipo de interés: " + obtenerTipoInteres() + "\nSaldo: " + estado();
    } catch (Exception e) {
        e.printStackTrace();
        return "Error al obtener la información de la cuenta.";
    }
}
}
