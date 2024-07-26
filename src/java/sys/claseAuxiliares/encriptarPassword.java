package sys.claseAuxiliares;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class encriptarPassword {
   /**
     * Método para encriptar una cadena de texto utilizando el algoritmo SHA-512.
     *
     * @param cadena La cadena de texto a encriptar.
     * @return La cadena encriptada en formato hexadecimal.
     */
    public static String sha512(String cadena) {
        // StringBuilder para construir la cadena hexadecimal resultante
        StringBuilder sb = new StringBuilder();
        try {
            // Obtiene una instancia del algoritmo SHA-512
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            
            // Calcula el hash de la cadena de entrada y obtiene el resultado como un array de bytes
            byte[] hash = md.digest(cadena.getBytes());

            // Itera sobre cada byte del hash
            for (byte b : hash) {
                // Convierte cada byte en una cadena hexadecimal de dos dígitos y la añade a sb
                sb.append(String.format("%02x", b));
            }
        } catch (NoSuchAlgorithmException ex) {
            // Maneja la excepción en caso de que el algoritmo SHA-512 no esté disponible
            System.err.println("Error: " + ex.getMessage());
        }
        
        // Retorna la cadena hexadecimal resultante
        return sb.toString();
    }
}
