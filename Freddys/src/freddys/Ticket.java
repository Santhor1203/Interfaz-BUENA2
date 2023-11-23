/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package freddys;

/**
 *
 * @author srg12
 */
import javax.swing.JOptionPane;

public class Ticket {
 // Tamaño máximo del vector de contactos
        int contacmax = 100;
        // Vector para almacenar la información de los contactos
        String[][] contactos = new String[contacmax][6];
        int contador = 0;
public void cuerpo(){
        while (true) {
            // Mostrar el menú
            String[] opciones = { "Registrar un contacto", "Buscar un contacto", "Eliminar un contacto", "Modificar un contacto", "Salir" };
            int seleccion = JOptionPane.showOptionDialog(null, "Seleccione una opción\n"+"(Gaby,aqui debe de ir la orden del cliente)"+
                    "Los botones modificalos para que solo sean 2 uno para modificar la lista y el otro para pagar ", "Carrito", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

            switch (seleccion) {
                case 0: // Registrar un contacto
                    if (contador < contacmax) {
                        contactos[contador][0] = JOptionPane.showInputDialog("Nombre:");
                        contactos[contador][1] = JOptionPane.showInputDialog("Apellido:");
                        contactos[contador][2] = JOptionPane.showInputDialog("Teléfono:");
                        contactos[contador][3] = JOptionPane.showInputDialog("Correo electrónico:");
                        contactos[contador][4] = JOptionPane.showInputDialog("Dirección:");
                        contactos[contador][5] = JOptionPane.showInputDialog("Fecha de cumpleaños:");
                        contador++;
                    } else {
                        JOptionPane.showMessageDialog(null, "La lista de contactos está llena.");
                    }
                    break;

                case 1: // Buscar un contacto
                    String listaContactos = "Contactos registrados:\n";
                    for (int i = 0; i < contador; i++) {
                        listaContactos += (i + 1) + ". " + contactos[i][0] + " " + contactos[i][1] + "\n";
                    }
                    int indice = Integer.parseInt(JOptionPane.showInputDialog(listaContactos + "Ingrese el número de contacto:")) - 1;
                    if (indice >= 0 && indice < contador) {
                        String contacto = "Nombre: " + contactos[indice][0] + "\n";
                        contacto += "Apellido: " + contactos[indice][1] + "\n";
                        contacto += "Teléfono: " + contactos[indice][2] + "\n";
                        contacto += "Correo electrónico: " + contactos[indice][3] + "\n";
                        contacto += "Dirección: " + contactos[indice][4] + "\n";
                        contacto += "Fecha de cumpleaños: " + contactos[indice][5] + "\n";
                        JOptionPane.showMessageDialog(null, contacto, "Información de Contacto", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Número de contacto inválido.");
                    }
                    break;

                case 2: // Eliminar un contacto
                  listaContactos = "Contactos registrados:\n";
                    for (int i = 0; i < contador; i++) {
                        listaContactos += (i + 1) + ". " + contactos[i][0] + " " + contactos[i][1] + "\n";
                    }
                    int Eliminar = Integer.parseInt(JOptionPane.showInputDialog(listaContactos + "Ingrese el número de contacto a eliminar:")) - 1;
                    if (Eliminar >= 0 && Eliminar < contador) {
                        for (int i = Eliminar; i < contador - 1; i++) {
                            for (int j = 0; j < 6; j++) {
                                contactos[i][j] = contactos[i + 1][j];
                            }
                        }
                        contador--;
                        JOptionPane.showMessageDialog(null, "Contacto eliminado.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Número de contacto inválido.");
                    }
                    break;

                case 3: // Modificar un contacto
                    listaContactos = "Contactos registrados:\n";
                    for (int i = 0; i < contador; i++) {
                        listaContactos += (i + 1) + ". " + contactos[i][0] + " " + contactos[i][1] + "\n";
                    }
                    int Modificador = Integer.parseInt(JOptionPane.showInputDialog(listaContactos+"Ingrese el número de contacto a modificar:")) - 1;
                    if (Modificador >= 0 && Modificador < contador) {
                        contactos[Modificador][0] = JOptionPane.showInputDialog("Nuevo nombre:", contactos[Modificador][0]);
                        contactos[Modificador][1] = JOptionPane.showInputDialog("Nuevo apellido:", contactos[Modificador][1]);
                        contactos[Modificador][2] = JOptionPane.showInputDialog("Nuevo teléfono:", contactos[Modificador][2]);
                        contactos[Modificador][3] = JOptionPane.showInputDialog("Nuevo correo electrónico:",
                                contactos[Modificador][3]);
                        contactos[Modificador][4] = JOptionPane.showInputDialog("Nueva dirección:",
                                contactos[Modificador][4]);
                        contactos[Modificador][5] = JOptionPane.showInputDialog("Nueva fecha de cumpleaños:",
                                contactos[Modificador][5]);
                        JOptionPane.showMessageDialog(null, "Contacto modificado.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Número de contacto inválido.");
                    }
                    break;

                case 4: // Salir
                    System.exit(0);
                    break;
            }
        }
}

}
