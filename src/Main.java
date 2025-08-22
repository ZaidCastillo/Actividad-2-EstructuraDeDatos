import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean seguir = true;

        // Menú principal del sistema operativo simulado.
        while (seguir) {
            try {
                // Menú principal.
                System.out.println("\nBienvenido a OSeano");
                System.out.print("\nQué quieres hacer hoy? \n1. Abrir una aplicación\n2. Ejecutar la línea de comandos\n3. Salir\n ");
                int opcion = scanner.nextInt();
                scanner.nextLine();
                if (opcion < 1 || opcion > 4) {
                    throw new IllegalArgumentException("Valor fuera del rango.");
                }
                switch (opcion) {
                    // Menú interno para utilizar las funciones de la lista de cola.
                    case 1:
                        Queue cola = new Queue();
                        boolean submenu1 = true;
                        while (submenu1) {
                            try {
                                System.out.print("\n¿Qué quieres hacer?\n1. Empezar una app\n2. Mostrar las apps abiertas \n3. Cerrar primera app abierta\n4. Salir de este menú\n ");
                                int datoElegido = scanner.nextInt();
                                scanner.nextLine();
                                if (datoElegido < 1 || datoElegido > 4) {
                                    throw new IllegalArgumentException("Valor fuera del rango.");
                                }
                                switch (datoElegido) {
                                    case 1:
                                        System.out.print("\nIngresa el nombre de la app por abrir: ");
                                        String app = scanner.nextLine();
                                        if (app.isBlank()){
                                            throw new IllegalArgumentException("Campo en blanco, intenta de nuevo.");
                                        }
                                        cola.enqueue(app);
                                        System.out.println("Aplicación "+ app + " exitosamente empezada.");
                                        break;
                                    case 2:
                                        System.out.println("\nCola de apps abiertas:");
                                        cola.display();
                                        break;
                                    case 3:
                                        System.out.println("\nSe cerrará la primera aplicación que se abrió ("+cola.peek()+")");
                                        cola.dequeue();
                                        break;
                                    case 4:
                                        System.out.println("Devolviéndote al menú principal...");
                                        submenu1 = false;
                                        break;
                                }
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            } catch (InputMismatchException e) {
                                System.out.println("Ingresa un número válido.");
                                scanner.nextLine();
                            }
                        }
                        break;
                    // Menú interno para utilizar las funciones de la lista de pila.
                    case 2:
                        Pila comandos = new Pila();
                        submenu1 = true;
                        while (submenu1) {
                            try {
                                System.out.print("\n¿Qué harás en la CLI?\n1. Ejecutar un comando\n2. Mostrar historial de comandos\n3. Control+Z(borrar el comando más reciente)\n4. Salir de este menú\n ");
                                int datoElegido = scanner.nextInt();
                                scanner.nextLine();
                                if (datoElegido < 1 || datoElegido > 4) {
                                    throw new IllegalArgumentException("Valor fuera del rango.");
                                }
                                switch (datoElegido) {
                                    case 1:
                                        System.out.print("\nIngresa el comando a ejecutar: ");
                                        String comando = scanner.nextLine();
                                        if (comando.isBlank()){
                                            throw new IllegalArgumentException("Campo en blanco, intenta de nuevo.");
                                        }
                                        System.out.println("Ejecutando comando...");
                                        if(comando.equalsIgnoreCase("dir")){
                                            System.out.println("Mostrando archivos/carpetas...");
                                        }
                                        else if(comando.equalsIgnoreCase("ls")){
                                            System.out.println("Listando archivos/carpetas...");
                                        }
                                        else if(comando.equalsIgnoreCase("cd")){
                                            System.out.println("Cambiando de directorio...");
                                        }
                                        comandos.push(comando);
                                        break;
                                    case 2:
                                        System.out.println("\nHistorial de comandos que has ejecutado.");
                                        comandos.display();
                                        break;
                                    case 3:
                                        System.out.println("\nCTRL+Z aplicado a "+comandos.peek());
                                        comandos.pop();
                                        break;
                                    case 4:
                                        System.out.println("Devolviéndote al menú principal...");
                                        submenu1 = false;
                                        break;
                                }
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            } catch (InputMismatchException e) {
                                System.out.println("Ingresa un número válido.");
                                scanner.nextLine();
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Apagando el sistema...");
                        seguir = false;
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Ingresa un número adecuado.");
            } catch (InputMismatchException e) {
                System.out.println("Ingresa un número.");
                scanner.nextLine();
            }
        }}}
