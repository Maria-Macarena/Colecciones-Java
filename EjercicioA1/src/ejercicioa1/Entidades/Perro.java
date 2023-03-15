package ejercicioa1.Entidades;

import java.util.Comparator;

/**
 *
 * @author Macarena Cardozo.-
 */
public class Perro {

    //atributos
    private String raza;

    //constructores
    public Perro() {
    }

    public Perro(String raza) {
        this.raza = raza;

    }

    //get y set
    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    //Creamos un objeto comparator
    public static Comparator<Perro> compararRaza = new Comparator<Perro>() {
        @Override // Usamos el override para traer un metodo de otra clase y poder usarlo
        public int compare(Perro p1, Perro p2) { // Le pasamos dos objetos a comparar
            return p1.getRaza().compareTo(p2.getRaza()); // Los comparamos usando el get y el compareTo
        }
    };

    @Override
    public String toString() {
        return " RAZA: " + raza;
    }

}
