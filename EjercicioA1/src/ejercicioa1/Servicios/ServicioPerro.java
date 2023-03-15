package ejercicioa1.Servicios;

import ejercicioa1.Entidades.Perro;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Macarena Cardozo.-
 */
public class ServicioPerro {

    private ArrayList<Perro> listPerro;

    Scanner read = new Scanner(System.in).useDelimiter("\n");

    public ServicioPerro() {
        this.listPerro = new ArrayList<>();
    }

    /* pedirá una raza de perro en un bucle, el mismo se guardará
    en la lista y después se le preguntará al usuario si quiere guardar otro perro o si
    quiere salir. Si decide salir, se mostrará todos los perros guardados en el ArrayList.*/
    public void crearRazas() {

        String op = "";

        do {
            System.out.println("Ingresa la raza de la mascota:");
            String raza = read.next().toUpperCase();

            Perro p = new Perro();
            p.setRaza(raza);

            listPerro.add(p);

            System.out.println("Querés seguir agregando razas? Teclea 'SI' o 'NO'");
            op = read.next().toUpperCase();

            if (op.equals("NO")) {

                imprimir();
            }

        } while (!op.equals("NO"));

    }

    private void imprimir() {

    //Los ordenamos por el documento mediante un comparator
        listPerro.sort(Perro.compararRaza);
        
         System.out.println("Estas son las mascotas de la lista: ");
         
        for (Perro aux : listPerro) {
           
            System.out.println(aux.toString());
        }
        System.out.println("Cantidad: " + listPerro.size());

    }

    /*al usuario se le pedirá un perro y se recorrerá la lista con un Iterator, se buscará el 
    perro en la lista. Si el perro está en la lista, se eliminará el perro que ingresó el usuario 
    y se mostrará la lista ordenada. Si el perro no se encuentra en la lista, se le informará al usuario
    y se mostrará la lista ordenada.*/
    public void buscarMascota() {

        Iterator<Perro> it = listPerro.iterator();

        boolean check = false; // Usamos el booleano para mostrar si la mascota se elimino o no

        System.out.println("Ingresa el nombre de la mascota a buscar: ");
        String mascota = read.next().toUpperCase();

    //Mientras haya otro objeto en la lista hacer        
        while (it.hasNext()) {
            Perro aux = it.next();
            if (aux.getRaza().equals(mascota)) {
                it.remove();
                check = true;
                break;
            } else {
                check = false;
            }
        }

        if (check) {
            System.out.println("Encontre la raza " + mascota);
        } else {
            System.out.println("No está la raza buscada");
        }

        imprimir();
        
    }

}
