/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnologías de la Información y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Central de Pacientes.
 * Adaptado de CUPI2 (Uniandes)
 * Fecha: Febrero 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package centralPacientes.mundo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Esta clase representa una central en la que se maneja una lista de pacientes
 */
public class CentralPacientes {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Lista de pacientes
     */
    private ArrayList<Paciente> pacientes;

    /**
     * Vector de clínicas manejadas por la central
     */
    private ArrayList<String> listaClinicas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea una nueva central sin pacientes y con una lista predefinida de clínicas
     */
    public CentralPacientes() {
        pacientes = new ArrayList<>();

        listaClinicas = new ArrayList<>();
        listaClinicas.add("Clínica del Country");
        listaClinicas.add("Clínica Palermo");
        listaClinicas.add("Clínica Reina Sofía");
        listaClinicas.add("Clínica El Bosque");
        listaClinicas.add("Clínica San Ignacio");
        listaClinicas.add("Otra");
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el número de pacientes de la clínica
     *
     * @return El número de pacientes de la clínica
     */
    public int darNumeroPacientes() {
        return pacientes.size();
    }

    /**
     * Adiciona un paciente al principio de la lista
     *
     * @param pac El paciente a ser agregado al comienzo de la lista. <br>
     *            pac!=null y no existe un paciente con código igual a pac.codigo
     */
    public void agregarPacienteAlComienzo(Paciente pac) {
        // TODO: Realiar el método que agrega al principio

        boolean esta = false;

        if (pacientes != null && pacientes.size() > 0){
            for (Paciente e: darPacientes()) {
                if (e.darCodigo() == pac.darCodigo()){
                    esta = true;
                }
            }
        }
        if (esta == false){
            pacientes.add(pac);
        }

    }



    /**
     * Adiciona un paciente al final de la lista. Si la lista está vacía el paciente queda de primero
     *
     * @param pac El paciente a ser agregado al final la lista. <br>
     *            pac!=null y no existe un paciente con código igual a pac.codigo
     */
    public void agregarPacienteAlFinal(Paciente pac) {
        // TODO: Agragar un paciente al final de la lista
        boolean esta = false;

        if (pacientes != null && pacientes.size() > 0){
            for (Paciente e: darPacientes()) {
                if (e.darCodigo() == pac.darCodigo()){
                    esta = true;
                }
            }
        }

        if (esta == false){
            pacientes.add(pac);
        }
    }


    /**
     * Adiciona un paciente a la lista de pacientes antes del paciente con el código especificado. <br>
     */
    public void agregarPacienteAntesDe(int cod, Paciente pac) throws NoExisteException {
        // TODO: Agrega un paciente después del paciente con el código dado
        boolean esta = false;
        boolean encontrado = false;
        int indice = -1;

        if (pacientes != null && pacientes.size() > 0){
            for (Paciente e: darPacientes()) {
                if (e.darCodigo() == pac.darCodigo()){
                    esta = true;
                }
            }
        }

        for (Paciente paciente : pacientes) {
            if (paciente.darCodigo() == cod) {
                indice = pacientes.indexOf(paciente);
                encontrado = true;

                break;
            }
        }
        if (esta == false && encontrado == true){
            pacientes.add(indice, pac);
            System.out.println("clinicas " + darListaClinicas());
            System.out.println("clinica ingresada " + pac.darClinica());
        }

    }

    /**
     * Adiciona un paciente a la lista de pacientes después del paciente con el código especificado.
     */
    public void agregarPacienteDespuesDe(int cod, Paciente pac) throws NoExisteException {
        // TODO: Agrega un paciente después del paciente con el código cod

        boolean esta = false;
        boolean encontrado = false;
        int indice = -1;

        if (pacientes != null && pacientes.size() > 0){
            for (Paciente e: darPacientes()) {
                if (e.darCodigo() == pac.darCodigo()){
                    esta = true;
                }
            }
        }

        for (Paciente paciente : pacientes) {
            if (paciente.darCodigo() == cod) {
                indice = pacientes.indexOf(paciente);
                encontrado = true;
                indice ++;
                break;
            }
        }
        if (esta == false && encontrado == true){
            pacientes.add(indice, pac);
        }

    }

    /**
     * Busca el paciente con el código dado en la lista de pacientes.
     */
    public Paciente localizar(int codigo) {

        Paciente pacienteEncontrado = null;

        for (Paciente paciente : pacientes) {
            if (paciente.darCodigo() == codigo) {
                pacienteEncontrado = paciente;
                break; // detener el bucle una vez que se encuentra el paciente
            }
        }

        return pacienteEncontrado;
    }


    /**
     * Elimina el paciente con el código especificado.
     */
    public void eliminarPaciente(int cod) throws NoExisteException {
        // TODO: Si no existe el paciente con el código dado, genera la excepción

        boolean encontrado = false;
        int indice = -1;


        for (Paciente paciente : pacientes) {
            if (paciente.darCodigo() == cod) {
                indice = pacientes.indexOf(paciente);
                encontrado = true;
                break;
            }
        }
        if (encontrado == true){
            pacientes.remove(indice);
        }

    }

    /**
     * Devuelve una lista con los pacientes de la central
     */
    public ArrayList<Paciente> darPacientes() {
        return pacientes;
    }

    /**
     * Retorna la lista de clínicas manejadas por la central
     */
    public ArrayList<String> darListaClinicas() {
        return listaClinicas;
    }

    /**
     * Retorna la longitud de la lista
     */
    private int darLongitud() {
        return pacientes.size();
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Retorna la cantidad de hombres que hay en la lista
     */
    public int cantHombres() {
        int cont = 0;

        for (Paciente e: pacientes) {
            if (e.darSexo() == 1){
                cont ++;
            }
        }

        return cont;
    }

    /**
     * Retorna la cantidad de mujeres que hay en la lista
     */
    public int cantMujeres() {
        int cont = 0;

        for (Paciente e: pacientes) {
            if (e.darSexo() == 2){
                cont ++;
            }
        }

        return cont;

    }

    public String metodo4() {
        String[] nombresClinicas = {"Clínica del Country", "Clínica Palermo", "Clínica Reina Sofía", "Clínica El Bosque", "Clínica San Ignacio", "Otra"};
        int[] contadorClinicas = new int[6];
        int pacientesClinicaMasOcupada = 0;
        int indiceClinicaMasOcupada = -1;
        

        for (Paciente paciente : pacientes) {
            String clinica = paciente.darClinica();
            int indiceClinica = Arrays.asList(nombresClinicas).indexOf(clinica);
            if (indiceClinica != -1) {
                contadorClinicas[indiceClinica]++;
            }
        }

        for (int i = 0; i < contadorClinicas.length; i++) {
            if (contadorClinicas[i] > pacientesClinicaMasOcupada) {
                pacientesClinicaMasOcupada = contadorClinicas[i];
                indiceClinicaMasOcupada = i;
            }
        }

        return nombresClinicas[indiceClinicaMasOcupada];
    }
}
