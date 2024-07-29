package TareasEntregables_PrincipiosDePoo;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Estudiante estudiante1 = new Estudiante(1, "Fernando", "Pérez", new Date(), Estudiante.Estado.MATRICULADO);
        Estudiante estudiante2 = new Estudiante(2, "Henri", "Orozco", new Date(), Estudiante.Estado.INACTIVO);

        Curso curso1 = new Curso(1, "matematicas", "Introducción a Algebra", 3, "1,0");
        Curso curso2 = new Curso(2, "programacion", "Curso de JavaScript desde 0", 2, "1,1");
        GestorAcademico gestor = new GestorAcademico();

        gestor.matricularEstudiante(estudiante1);
        gestor.matricularEstudiante(estudiante2);
        gestor.agregarCurso(curso1);
        gestor.agregarCurso(curso2);
        try {
            gestor.inscribirEstudianteCurso(estudiante1, curso1.getId());
            gestor.inscribirEstudianteCurso(estudiante2, curso2.getId());
            gestor.inscribirEstudianteCurso(estudiante1, curso1.getId()); // Esto debería lanzar una excepción
        } catch (EstudianteYaInscritoException e) {
            System.out.println(e.getMessage());
        }
        try {
            gestor.desinscribirEstudianteCurso(estudiante1.getId(), curso1.getId());
            gestor.desinscribirEstudianteCurso(estudiante1.getId(), curso1.getId());
        } catch (EstudianteNoInscritoEnCursoException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Estudiantes matriculados:"+"\n");
        for (Estudiante est : gestor.getEstudiantes()) {
            System.out.println(est);
        }
        System.out.println("Cursos disponibles:"+"\n");
        for (Curso cur : gestor.getCursos()) {
            System.out.println(cur);
        }
    }
}


