// Gestión de Muelles y Puertos | Analisis de algoritmos - Taller Multilistas Java

// Main.java
// Importación de paquetes necesarios
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Definición de la clase Elemento
class Elemento {
    String nombre;

    // Constructor de Elemento
    public Elemento(String nombre) {
        this.nombre = nombre;
    }

    // Método para editar el nombre del elemento
    public void editarNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }
}

// Definición de la clase Contenedor
class Contenedor {
    String codigo;
    List<Elemento> elementos;

    // Constructor de Contenedor
    public Contenedor(String codigo) {
        this.codigo = codigo;
        this.elementos = new ArrayList<>();
    }

    // Método para agregar un elemento al contenedor
    public void agregarElemento(Elemento elemento) {
        elementos.add(elemento);
    }

     // Método para editar el código del contenedor
    public void editarCodigo(String nuevoCodigo) {
        this.codigo = nuevoCodigo;
    }
}

// Definición de la clase Barco
class Barco {
    String nombre;
    List<Contenedor> contenedores;

    // Constructor de Barco
    public Barco(String nombre) {
        this.nombre = nombre;
        this.contenedores = new ArrayList<>();
    }

    // Método para agregar un contenedor al barco
    public void agregarContenedor(Contenedor contenedor) {
        contenedores.add(contenedor);
    }

    // Método para editar el nombre del barco
    public void editarNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }
}

// Definición de la clase Muelle
class Muelle {
    String nombre;
    List<Barco> barcos;

    // Constructor de Muelle
    public Muelle(String nombre) {
        this.nombre = nombre;
        this.barcos = new ArrayList<>();
    }

    // Método para agregar un barco al muelle
    public void agregarBarco(Barco barco) {
        barcos.add(barco);
    }

    // Método para editar el nombre del muelle
    public void editarNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }
}

// Definición de la clase Puerto
class Puerto {
    String nombre;
    List<Muelle> muelles;

    // Constructor de Puerto
    public Puerto(String nombre) {
        this.nombre = nombre;
        this.muelles = new ArrayList<>();
    }

    // Método para agregar un muelle al puerto
    public void agregarMuelle(Muelle muelle) {
        muelles.add(muelle);
    }

    // Método para editar el nombre del puerto
    public void editarNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }
}

// Clase principal
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<Puerto> puertos = new ArrayList<>();

            while (true) {
                // Menú principal
                System.out.println("\nMenú:");
                System.out.println("1. Agregar un nuevo puerto");
                System.out.println("2. Buscar un puerto");
                System.out.println("3. Mostrar la lista de puertos");
                System.out.println("4. Editar nombre de un puerto");
                System.out.println("5. Agregar un nuevo muelle");
                System.out.println("6. Buscar un muelle");
                System.out.println("7. Mostrar muelles en un puerto");
                System.out.println("8. Editar nombre de un muelle");
                System.out.println("9. Salir");
                System.out.print("\nSeleccione una opción: ");

                int opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                switch (opcion) {
                    case 1:
                        //Agregar un nuevo puerto
                        System.out.print("Ingrese el nombre del puerto: ");
                        String nombrePuerto = scanner.nextLine().trim();
                        if (nombrePuerto.isEmpty()) {
                            System.out.println("El nombre del puerto no puede estar en blanco.");
                        } else if (buscarPuerto(nombrePuerto, puertos) != null) {
                            System.out.println("El puerto ya existe en la lista.");
                        } else {
                            Puerto nuevoPuerto = new Puerto(nombrePuerto);
                            puertos.add(nuevoPuerto);
                            System.out.println("Puerto agregado con éxito.");
                        }
                        break;
                    case 2:
                        // Buscar un puerto existente
                        System.out.print("Ingrese el nombre del puerto a buscar: ");
                        String nombreBuscar = scanner.nextLine().trim();
                        Puerto puertoEncontrado = buscarPuerto(nombreBuscar, puertos);
                        if (puertoEncontrado != null) {
                            System.out.println("Puerto encontrado: " + puertoEncontrado.nombre);
                        } else {
                            System.out.println("Puerto no encontrado.");
                        }
                        break;
                    case 3:
                        // Listar puertos existentes
                        System.out.println("\nLista de Puertos:");
                        mostrarPuertos(puertos);
                        break;
                    case 4:
                        // Editar el nombre de un puerto
                        System.out.print("Ingrese el nombre del puerto a editar: ");
                        String nombrePuertoEditar = scanner.nextLine().trim();
                        Puerto puertoEditar = buscarPuerto(nombrePuertoEditar, puertos);
                        if (puertoEditar != null) {
                            System.out.print("Ingrese el nuevo nombre del puerto: ");
                            String nuevoNombrePuerto = scanner.nextLine().trim();
                            if (nuevoNombrePuerto.isEmpty()) {
                                System.out.println("El nombre del puerto no puede estar en blanco.");
                            } else if (buscarPuerto(nuevoNombrePuerto, puertos) != null) {
                                System.out.println("El nuevo nombre ya existe en la lista.");
                            } else {
                                puertoEditar.editarNombre(nuevoNombrePuerto);
                                System.out.println("Nombre del puerto actualizado con éxito.");
                            }
                        } else {
                            System.out.println("Puerto no encontrado.");
                        }
                        break;
                    case 5:
                        // Agregar un nuevo muelle
                        System.out.print("Ingrese el nombre del puerto al que desea agregar un muelle: ");
                        String nombrePuertoAgregarMuelle = scanner.nextLine().trim();
                        Puerto puertoAgregarMuelle = buscarPuerto(nombrePuertoAgregarMuelle, puertos);
                        if (puertoAgregarMuelle != null) {
                            System.out.print("Ingrese el nombre del nuevo muelle: ");
                            String nombreMuelle = scanner.nextLine().trim();
                            if (nombreMuelle.isEmpty()) {
                                System.out.println("El nombre del muelle no puede estar en blanco.");
                            } else {
                                Muelle nuevoMuelle = new Muelle(nombreMuelle);
                                puertoAgregarMuelle.agregarMuelle(nuevoMuelle);
                                System.out.println("Muelle agregado con éxito.");
                            }
                        } else {
                            System.out.println("Puerto no encontrado.");
                        }
                        break;
                    case 6:
                        // Buscar un muelle existente
                        System.out.print("Ingrese el nombre del puerto en el que desea buscar un muelle: ");
                        String nombrePuertoBuscarMuelle = scanner.nextLine().trim();
                        Puerto puertoBuscarMuelle = buscarPuerto(nombrePuertoBuscarMuelle, puertos);
                        if (puertoBuscarMuelle != null) {
                            System.out.print("Ingrese el nombre del muelle a buscar: ");
                            String nombreMuelleBuscar = scanner.nextLine().trim();
                            Muelle muelleEncontrado = buscarMuelle(nombreMuelleBuscar, puertoBuscarMuelle.muelles);
                            if (muelleEncontrado != null) {
                                System.out.println("Muelle encontrado: " + muelleEncontrado.nombre);
                            } else {
                                System.out.println("Muelle no encontrado.");
                            }
                        } else {
                            System.out.println("Puerto no encontrado.");
                        }
                        break;
                    case 7:
                        // Listar muelles en un puerto
                        System.out.print("Ingrese el nombre del puerto del que desea ver la lista de muelles: ");
                        String nombrePuertoMostrarMuelles = scanner.nextLine().trim();
                        Puerto puertoMostrarMuelles = buscarPuerto(nombrePuertoMostrarMuelles, puertos);
                        if (puertoMostrarMuelles != null) {
                            System.out.println("\nLista de Muelles en " + puertoMostrarMuelles.nombre + ":");
                            mostrarMuelles(puertoMostrarMuelles.muelles);
                        } else {
                            System.out.println("Puerto no encontrado.");
                        }
                        break;
                    case 8:
                        //  Editar un muelle en el puerto
                        System.out.print("Ingrese el nombre del puerto en el que desea editar un muelle: ");
                        String nombrePuertoEditarMuelle = scanner.nextLine().trim();
                        Puerto puertoEditarMuelle = buscarPuerto(nombrePuertoEditarMuelle, puertos);
                        if (puertoEditarMuelle != null) {
                            System.out.print("Ingrese el nombre del muelle a editar: ");
                            String nombreMuelleEditar = scanner.nextLine().trim();
                            Muelle muelleEditar = buscarMuelle(nombreMuelleEditar, puertoEditarMuelle.muelles);
                            if (muelleEditar != null) {
                                System.out.print("Ingrese el nuevo nombre del muelle: ");
                                String nuevoNombreMuelle = scanner.nextLine().trim();
                                if (nuevoNombreMuelle.isEmpty()) {
                                    System.out.println("El nombre del muelle no puede estar en blanco.");
                                } else {
                                    muelleEditar.editarNombre(nuevoNombreMuelle);
                                    System.out.println("Nombre del muelle actualizado con éxito.");
                                }
                            } else {
                                System.out.println("Muelle no encontrado.");
                            }
                        } else {
                            System.out.println("Puerto no encontrado.");
                        }
                        break;
                    case 9:
                        // Salir del sistema
                        System.out.println("Saliendo del programa.");
                        System.exit(0);
                    default:
                        System.out.println("Opción no válida.");
                }
            }
        }
    }

    // Función para buscar un puerto en la lista de puertos
    public static Puerto buscarPuerto(String nombre, List<Puerto> puertos) {
        for (Puerto puerto : puertos) {
            if (puerto.nombre.equalsIgnoreCase(nombre)) {
                return puerto;
            }
        }
        return null;
    }

    // Función para mostrar la lista de puertos
    public static void mostrarPuertos(List<Puerto> puertos) {
        for (Puerto puerto : puertos) {
            System.out.println("Puerto: " + puerto.nombre);
        }
    }

    // Función para buscar un muelle en la lista de muelles
    public static Muelle buscarMuelle(String nombre, List<Muelle> muelles) {
        for (Muelle muelle : muelles) {
            if (muelle.nombre.equalsIgnoreCase(nombre)) {
                return muelle;
            }
        }
        return null;
    }

    // Función para mostrar la lista de muelles
    public static void mostrarMuelles(List<Muelle> muelles) {
        for (Muelle muelle : muelles) {
            System.out.println("Muelle: " + muelle.nombre);
        }
    }
}