public class ImprimirJoseEspadas {
    public void imprimirDatosJulioHornos(String nombre, String apellido, String dni, String ciudadNac) {

        if (ciudadNac.equalsIgnoreCase("Madrid")) {
            System.out.println("El alumno estudia en la misma ciudad que nació");
        } else {
            System.out.println("El alumno NO estudia en la misma ciudad que nació");
        }


        int contador = 0;
        String caracter;

        for (int i = 0; i < nombre.length(); i++) {
            caracter = nombre.substring(i, i + 1).toLowerCase();
            if (caracter.equals("a")) contador++;
            if (caracter.equals("e")) contador++;
            if (caracter.equals("i")) contador++;
            if (caracter.equals("o")) contador++;
            if (caracter.equals("u")) contador++;
        }

        if (contador < 3) System.out.println("El nombre tiene pocas vocales");
        else System.out.println("El nombre tiene suficientes vocales");


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

        contador = 0;
        for (int i = 0; i < apellido.length(); i++) {
            caracter = apellido.substring(i, i + 1).toLowerCase();
            if (caracter.equals("a")) contador++;
            if (caracter.equals("e")) contador++;
            if (caracter.equals("i")) contador++;
            if (caracter.equals("o")) contador++;
            if (caracter.equals("u")) contador++;

        }

        if (contador < 3) System.out.println("El apellido tiene pocas vocales");
        else System.out.println("El apellido tiene suficientes vocales");

        if (dniValido) System.out.println("El DNI es válido");
    }
}
