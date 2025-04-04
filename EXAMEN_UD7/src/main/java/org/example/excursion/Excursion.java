package org.example.excursion;

import java.util.*;

public class Excursion {
    static Scanner entrada = new Scanner(System.in);

    private String nombre_actividad;
    private String localidad;
    private double precio;
    private List<String> profesores;
    private List<Estudiante> listaAsistentes;

    public Excursion(String nombre_actividad, String localidad, double precio) {
        this.nombre_actividad = nombre_actividad;
        this.localidad = localidad;
        this.precio = precio;
        profesores = new ArrayList<>();
        listaAsistentes = new ArrayList<>();
    }

    public void insertarProfesor (){
        System.out.println("Introduce el nombre del profesor/a paara la excursión en Benidorm");
        String profe = entrada.nextLine();
        profesores.add(profe);
        System.out.println("Profesor añadido correctamente a la excursión "+getNombre_actividad());
    }

    public void inscribirAsistente(){
        try{
            boolean comp = true;

            System.out.println("Creando estudiante...");
            System.out.println("Inserta los apellidos:");
            String apellidos = entrada.nextLine();
            System.out.println("Inserta el nombre:");
            String nombre = entrada.nextLine();
            System.out.println("Inserta el curso");
            String curso = entrada.nextLine();
            System.out.println("Inserta su edad:");
            int edad = entrada.nextInt();
            entrada.nextLine();

            Estudiante estud = new Estudiante(apellidos,nombre,curso,edad);

            for (Estudiante estudiante : listaAsistentes){
                if (estud.equals(estudiante)){
                    System.out.println("El estudiante ya existe en loa lista de asistentes a la actividad "+getNombre_actividad());
                    comp = false;
                }
            }
            if (comp){
                listaAsistentes.add(estud);
                System.out.println("Añadido correctamente el estudiante "+nombre+" "+apellidos+" del curso "+curso);
            }
        }catch (InputMismatchException err){
            System.out.println("ERROR. Has introducido mal el dato, no se añadira el asistente");
            entrada.nextLine();
        }
    }

    public double calcularImporteIngreso(){
        return precio*listaAsistentes.size();
    }

    public void verAsistentes(){
        int cont = 1;
        for (Estudiante estudiante : listaAsistentes){
            System.out.println("["+cont+"]. "+estudiante.getCurso()+" - "+estudiante.getApellido()+" "+estudiante.getNombre()+" ("+estudiante.getEdad()+" años).");
            cont++;
        }
    }

    public void eliminarAsistentesPorEdad(int edad){
        Iterator<Estudiante> iterator = listaAsistentes.iterator();

        while (iterator.hasNext()){
            Estudiante estudiante = iterator.next();
            if (estudiante.getEdad()<edad){
                iterator.remove();
            }
        }
    }

    public String getNombre_actividad() {
        return nombre_actividad;
    }


    public String getLocalidad() {
        return localidad;
    }
}
