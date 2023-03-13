/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogot� - Colombia)
 * Departamento de Tecnolog�as de la Informaci�n y Comunicaciones
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
     * Vector de cl�nicas manejadas por la central
     */
    private ArrayList<String> listaClinicas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea una nueva central sin pacientes y con una lista predefinida de cl�nicas
     */
    public CentralPacientes() {
        pacientes = new ArrayList<>();

        listaClinicas = new ArrayList<>();
        listaClinicas.add("Cl�nica del Country");
        listaClinicas.add("Cl�nica Palermo");
        listaClinicas.add("Cl�nica Reina Sof�a");
        listaClinicas.add("Cl�nica El Bosque");
        listaClinicas.add("Cl�nica San Ignacio");
        listaClinicas.add("Otra");
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el n�mero de pacientes de la cl�nica
     *
     * @return El n�mero de pacientes de la cl�nica
     */
    public int darNumeroPacientes() {
        return pacientes.size();
    }

    /**
     * Adiciona un paciente al principio de la lista
     *
     * @param pac El paciente a ser agregado al comienzo de la lista. <br>
     *            pac!=null y no existe un paciente con c�digo igual a pac.codigo
     */
    public void agregarPacienteAlComienzo(Paciente pac) {
        // TODO: Realiar el m�todo que agrega al principio

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
     * Adiciona un paciente al final de la lista. Si la lista est� vac�a el paciente queda de primero
     *
     * @param pac El paciente a ser agregado al final la lista. <br>
     *            pac!=null y no existe un paciente con c�digo igual a pac.codigo
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
     * Adiciona un paciente a la lista de pacientes antes del paciente con el c�digo especificado. <br>
     */
    public void agregarPacienteAntesDe(int cod, Paciente pac) throws NoExisteException {
        // TODO: Agrega un paciente despu�s del paciente con el c�digo dado
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
     * Adiciona un paciente a la lista de pacientes despu�s del paciente con el c�digo especificado.
     */
    public void agregarPacienteDespuesDe(int cod, Paciente pac) throws NoExisteException {
        // TODO: Agrega un paciente despu�s del paciente con el c�digo cod

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
     * Busca el paciente con el c�digo dado en la lista de pacientes.
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
     * Elimina el paciente con el c�digo especificado.
     */
    public void eliminarPaciente(int cod) throws NoExisteException {
        // TODO: Si no existe el paciente con el c�digo dado, genera la excepci�n

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
     * Retorna la lista de cl�nicas manejadas por la central
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
    // Puntos de Extensi�n
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
        String[] nombresClinicas = {"Cl�nica del Country", "Cl�nica Palermo", "Cl�nica Reina Sof�a", "Cl�nica El Bosque", "Cl�nica San Ignacio", "Otra"};
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
