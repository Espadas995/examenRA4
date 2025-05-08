/**
 * Generación de una clase {@code ImprimirJoseEspadas}
 * Utilizada para listar todos los datos que se conocen sobre un alumno.
 */
public class ImprimirJoseEspadas {

    /**
     * Method de la clase para imprimir por pantalla una serie de características sobre el alumno.
     * Deben pasarse los siguientes argumentos como {@code String}:
     * @param nombre Nombre del alumno
     * @param apellido Apellido del alumno
     * @param dni DNI del alumno
     * @param ciudadNac Ciudad de nacimiento del alumno
     */
    public void imprimirDatosJoseEspadas(String nombre, String apellido, String dni, String ciudadNac) {

        /**
         * Enseñar por consola información respecto a la ciudad donde estudia.
         */
        if (ciudadNac.equalsIgnoreCase("Madrid")) {
            System.out.println("El alumno estudia en la misma ciudad que nació");
        } else {
            System.out.println("El alumno NO estudia en la misma ciudad que nació");
        }

        /**
         * Enseñar por consola si su nombre tiene 3 o más vocales
         */
        int contadorNombre = getContadorVocales(nombre);
        if (contadorNombre < 3) System.out.println("El nombre tiene pocas vocales");
        else System.out.println("El nombre tiene suficientes vocales");

        /**
         * Enseñar por consola si su apellido tiene 3 o más vocales
         */
        int contadorApellido = getContadorVocales(apellido);
        if (contadorApellido < 3) System.out.println("El apellido tiene pocas vocales");
        else System.out.println("El apellido tiene suficientes vocales");

        /**
         * Comprobación de validez del DNI
         * Enseña el resultado de la comprobación de validez del DNI
         */
        boolean dniValido = comprobacionValidezDni(dni);
        if (dniValido) System.out.println("El DNI es válido");
    }

    /**
     * Method para comprobar si un DNI es válido
     * @param dni Toma el valor de DNI suministrado en la creación de la clase
     * @return {@code true} si el DNI es válido, {@code false} si el DNI es falso o no cumple los requisitos
     */
    public boolean comprobacionValidezDni(String dni) {
        String letraMayuscula = "";
        boolean dniValido = true;

        // Aquí excluimos cadenas distintas a 9 caracteres que debe tener un dni y también si el último caracter no es una letra
        if (dni.length() != 9 || Character.isLetter(dni.charAt(8)) == false) {
            System.out.println("El DNI intriducido no es válido");
            dniValido = false;
        } else {
            // Al superar la primera restricción, la letra la pasamos a mayúscula
            letraMayuscula = (dni.substring(8)).toUpperCase();
            try {
                // Pasamos a integer la parte numérica del DNI
                Integer myDni = Integer.parseInt(dni.substring(0, 8));
                int resto = 0;
                String[] asignacionLetra = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J",
                        "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};

                resto = myDni % 23;
                if (letraMayuscula.equals(asignacionLetra[resto])) {
                    System.out.println("La letra indicada en el DNI no es la esperada");
                    dniValido = false;
                }
                ;
            } catch (Exception e) {
                System.out.println("Los 8 primeros caracteres deben ser numéricos");
                dniValido = false;
            }
        }
        return dniValido;
    }

    /**
     * Method para comprobar cuantas vocales hay en una cadena.
     * @param cadena Cadena de texto
     * @return {@code int} con el valor de vocales totales
     */
    public int getContadorVocales(String cadena) {
        int contador = 0;
        String caracter;

        for (int i = 0; i < cadena.length(); i++) {
            caracter = cadena.substring(i, i + 1).toLowerCase();
            if (caracter.equals("a")) contador++;
            if (caracter.equals("e")) contador++;
            if (caracter.equals("i")) contador++;
            if (caracter.equals("o")) contador++;
            if (caracter.equals("u")) contador++;
        }
        return contador;
    }
}
