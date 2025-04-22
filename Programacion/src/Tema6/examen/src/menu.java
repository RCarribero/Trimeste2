import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class menu {
    static List<paciente> listPacientes = new ArrayList<>();
    static List<medico> listMedicos = new ArrayList<>();
    static List<departementoMedico> listDepartamenos = new ArrayList<>();
    static List<cita> listcitas = new ArrayList<>();
    static int opcion, edad;
    static Scanner input = new Scanner(System.in);
    static boolean verificacion;
    static String dni, nombreApellido, telefono;

    public static void main(String[] args) {
        do {
            try {
                verificacion = true;
                mostrarMenu();
                switch (opcion) {
                    case 1:
                        registarNuevoPaciente();
                        break;
                    case 2:
                        registarNuevoMedico();
                        break;
                    case 3:
                        registarNuevoDepartamento();
                        break;
                    case 4:
                        asignarMedicoDepartamento();
                        break;
                    case 5:
                        actualizarEspecialidadYAños();
                        break;
                    case 6:
                        eliminarPaciente();
                        break;
                    case 7:
                        buscarPacienteGrupoSanguineo();
                        break;
                    case 8:
                        listarPersonalSanitarioDeUnDepartamento();
                        break;
                    case 9:
                        System.out.println("Gracias por usar nuestro programa");
                        break;
                    case 10:
                        fusionarDepartamentos();
                        break;
                    default:
                        System.out.println("Opcion incorrecta");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (opcion != 9);
    }

    public static void fusionarDepartamentos() {
        departementoMedico departamento1 = buscarDepartamento();
        departementoMedico departamento2 = buscarDepartamento();
        if (departamento1 == departamento2)
            throw new IllegalArgumentException("No se puede fusionar un departamento consigo mismo");
        departementoMedico nuevoDepartamento = new departementoMedico();
        do {
            try {
                verificacion = true;
                System.out.println("Introduce codigo de departamento");
                nuevoDepartamento.setCodigoDepartamento(input.nextLine());
            } catch (Exception e) {
                System.out.println(e);
                verificacion = false;
            }
        } while (!verificacion);
        do {
            try {
                verificacion = true;
                System.out.println("Introduce nombre de departamento");
                nuevoDepartamento.setNombreDepartamento(input.nextLine());
            } catch (Exception e) {
                System.out.println(e);
                verificacion = false;
            }
        } while (!verificacion);
        do {
            try {
                verificacion = true;
                System.out.println("Introduce planta de departamento");
                nuevoDepartamento.setPlanta(input.nextInt());
                input.nextLine();
            } catch (Exception e) {
                input.nextLine();
                System.out.println(e);
                verificacion = false;
            }
        } while (!verificacion);
        for (personalSanitario personalSanitario : departamento1.getListPersonal()) {
            try {
                nuevoDepartamento.setListPersonal(personalSanitario);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        for (personalSanitario personalSanitario : departamento2.getListPersonal()) {
            try {
                nuevoDepartamento.setListPersonal(personalSanitario);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        listDepartamenos.remove(departamento2);
        listDepartamenos.remove(departamento1);
        listDepartamenos.add(nuevoDepartamento);
    }

    public static void listarPersonalSanitarioDeUnDepartamento() {
        departementoMedico departemento = buscarDepartamento();
        for (personalSanitario personal : departemento.getListPersonal()) {
            System.out.println("\t" + personal.getNombreApellido() + ", edad:" + personal.getEdad() + ", DNI: "
                    + personal.getDni() + ", Identificador:" + personal.getNumeroColegiado() + "\n");
        }
    }

    public static void buscarPacienteGrupoSanguineo() {
        if (listPacientes.isEmpty())
            throw new IllegalArgumentException("Lista vacia");
        System.out.println("Indique grupo sanguineo");
        String grupo = input.nextLine();
        for (paciente paciente : listPacientes) {
            if (grupo.equals(paciente.getGrupoSanguineo()))
                System.out.println(paciente.getNombreApellido() + ", edad:" + paciente.getEdad() + ", DNI: "
                        + paciente.getDni() + ", grupo: " + paciente.getGrupoSanguineo() + "\n");
        }
    }

    public static void eliminarPaciente() {
        paciente paciente = buscarPaciente();
        listPacientes.remove(paciente);
        for (medico medico : listMedicos) {
            medico.getPacientesAsignados().remove(paciente);
        }
    }

    public static void actualizarEspecialidadYAños() {
        medico medico = buscarMedico();
        System.out.println("Introduce nueva especialidad");
        medico.setEspecialidad(input.nextLine());
        System.out.println("Introduce nuevos años de experiencia");
        medico.setAñosExperiencia(input.nextInt());
    }

    public static void asignarMedicoDepartamento() {
        departementoMedico departamento = buscarDepartamento();
        medico medico = buscarMedico();
        medico.setDepartamento(departamento);
        departamento.setListPersonal(medico);
    }

    public static void registarNuevoDepartamento() {
        departementoMedico departamento = new departementoMedico();
        do {
            try {
                verificacion = true;
                System.out.println("Introduce codigo de departamento");
                departamento.setCodigoDepartamento(input.nextLine());
            } catch (Exception e) {
                System.out.println(e);
                verificacion = false;
            }
        } while (!verificacion);
        do {
            try {
                verificacion = true;
                System.out.println("Introduce nombre de departamento");
                departamento.setNombreDepartamento(input.nextLine());
            } catch (Exception e) {
                System.out.println(e);
                verificacion = false;
            }
        } while (!verificacion);
        do {
            try {
                verificacion = true;
                System.out.println("Introduce planta de departamento");
                departamento.setPlanta(input.nextInt());
                input.nextLine();
            } catch (Exception e) {
                input.nextLine();
                System.out.println(e);
                verificacion = false;
            }
        } while (!verificacion);
    }

    public static void registarNuevoMedico() {
        medico medico = new medico();
        persona();
        medico.setDni(dni);
        medico.setNombreApellido(nombreApellido);
        medico.setEdad(edad);
        medico.setTelefono(telefono);
        do {
            try {
                verificacion = true;
                System.out.println("Introduce numero de colegiado");
                medico.setNumeroColegiado(input.nextLine());
            } catch (Exception e) {
                System.out.println(e);
                verificacion = false;
            }
        } while (!verificacion);
        do {
            try {
                verificacion = true;
                System.out.println("Introduce años de experiencia");
                medico.setAñosExperiencia(input.nextInt());
            } catch (Exception e) {
                System.out.println(e);
                verificacion = false;
            }
        } while (!verificacion);
        do {
            try {
                verificacion = true;
                System.out.println("Introduce especialidad");
                medico.setEspecialidad(input.nextLine());
            } catch (Exception e) {
                System.out.println(e);
                verificacion = false;
            }
        } while (!verificacion);
        listMedicos.add(medico);
    }

    public static void registarNuevoPaciente() {
        paciente paciente = new paciente();
        persona();
        paciente.setDni(dni);
        paciente.setNombreApellido(nombreApellido);
        paciente.setEdad(edad);
        paciente.setTelefono(telefono);
        do {
            try {
                verificacion = true;
                System.out.println("Introduce grupo sangineo");
                paciente.setGrupoSanguineo(input.nextLine());
            } catch (Exception e) {
                System.out.println(e);
                verificacion = false;
            }
        } while (!verificacion);
        do {
            try {
                verificacion = true;
                System.out.println("Introduce nuemero de historial ");
                paciente.setNumeroHistoriaClinica(input.nextLine());
            } catch (Exception e) {
                System.out.println(e);
                verificacion = false;
            }
        } while (!verificacion);
        do {
            try {
                verificacion = true;
                System.out.println("Introduce alergias");
                paciente.setAlergias(input.nextLine());
            } catch (Exception e) {
                System.out.println(e);
                verificacion = false;
            }
        } while (!verificacion);
        listPacientes.add(paciente);
    }

    public static void mostrarMenu() {
        do {
            try {
                verificacion=true;
                System.out.println("-----MENU PRINCIPAL----- \n" +
                        "\t1️⃣.Registar nuevo paciente\n" +
                        "\t2️⃣.Registrar nuevo medico\n" +
                        "\t3️⃣.Crear nuevo departamento\n" +
                        "\t4️⃣.Asignar medico a departamento\n" +
                        "\t5️⃣.Actualizar especialidad y años de experiencia de un medico\n" +
                        "\t6️⃣.Eliminar paciente del sistema\n" +
                        "\t7️⃣.Buscar pacientes por grupo sangineo\n" +
                        "\t8️⃣.Listar personal de un departamento\n" +
                        "\t9️⃣.Salir del programa\n" +
                        "\t🔟.Realizar reorganizacion departamental");
                opcion = input.nextInt();
                input.nextLine();
            } catch (Exception e) {
                verificacion=false;
                input.nextLine();
                System.out.println(e);
            }
        } while (!verificacion);

    }

    public static void persona() {
        do {
            try {
                verificacion = true;
                System.out.println("Introduce el dni");
                dni = input.nextLine();
            } catch (Exception e) {
                System.out.println(e);
                verificacion = false;
            }
        } while (!verificacion);
        do {
            try {
                verificacion = true;
                System.out.println("Introduce el nombre y apellido");
                nombreApellido = input.nextLine();
            } catch (Exception e) {
                System.out.println(e);
                verificacion = false;
            }
        } while (!verificacion);
        do {
            try {
                verificacion = true;
                System.out.println("Introduce la edad");
                edad = input.nextInt();
                input.nextLine();
            } catch (Exception e) {
                input.nextLine();
                System.out.println(e);
                verificacion = false;
            }
        } while (!verificacion);
        do {
            try {
                verificacion = true;
                System.out.println("Introduce el telefono");
                telefono = input.nextLine();
            } catch (Exception e) {
                System.out.println(e);
                verificacion = false;
            }
        } while (!verificacion);
    }

    public static paciente buscarPaciente() {
        verificacion = false;
        paciente pacienteTemporal = new paciente();
        if (listPacientes.isEmpty())
            throw new IllegalArgumentException("Lista vacia");
        for (paciente paciente : listPacientes) {
            System.out.println(paciente.getNombreApellido() + ", edad:" + paciente.getEdad() + ", DNI: "
                    + paciente.getDni() + "\n");
        }
        System.out.println("Introduce el dni del paciente");
        dni = input.nextLine();
        for (paciente paciente : listPacientes) {
            if (dni.equals(paciente.getDni())) {
                pacienteTemporal = paciente;
                verificacion = true;
            }
        }
        if (!verificacion) {
            throw new IllegalArgumentException("Paciente no encontrado");
        }
        verificacion = true;
        return pacienteTemporal;
    }

    public static medico buscarMedico() {
        verificacion = false;
        medico medicoTemporal = new medico();
        if (listMedicos.isEmpty())
            throw new IllegalArgumentException("Lista vacia");
        for (medico medico : listMedicos) {
            System.out.println(
                    medico.getNombreApellido() + ", edad:" + medico.getEdad() + ", DNI: " + medico.getDni() + "\n");
        }
        System.out.println("Introduce el dni del medico");
        dni = input.nextLine();
        for (medico medico : listMedicos) {
            if (dni.equals(medico.getDni())) {
                medicoTemporal = medico;
                verificacion = true;
            }
        }
        if (!verificacion) {
            throw new IllegalArgumentException("medico no encontrado");
        }
        verificacion = true;
        return medicoTemporal;
    }

    public static departementoMedico buscarDepartamento() {
        verificacion = false;
        departementoMedico deptamento = new departementoMedico();
        if (listMedicos.isEmpty())
            throw new IllegalArgumentException("Lista vacia");
        for (departementoMedico departementoMedico : listDepartamenos) {
            System.out.println(departementoMedico.getCodigoDepartamento() + ", nombre:"
                    + departementoMedico.getNombreDepartamento() + "\n");
        }
        System.out.println("Introduce el codigo del departementoMedico");
        dni = input.nextLine();
        for (departementoMedico departementoMedico : listDepartamenos) {
            if (dni.equals(departementoMedico.getCodigoDepartamento())) {
                deptamento = departementoMedico;
                verificacion = true;
            }
        }
        if (!verificacion) {
            throw new IllegalArgumentException("departamento no encontrado");
        }
        verificacion = true;
        return deptamento;
    }
}
