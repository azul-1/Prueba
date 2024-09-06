
package personal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class Personal {
    public static void main(String[] args) {
        Scanner scanner =new Scanner (System.in);
        
        //SOLICITAR DATOS DE UNA PERSONA 
        System.out.println("Ingresa tu nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingresa tus apellidos: ");
        String apellido = scanner.nextLine();
        System.out.println("Ingresa tu edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingresa tu sexo(M/F):");
        String sexo = scanner.nextLine();
        System.out.println("Ingresa tu curp: ");
        String curp = scanner.next();
        
        scanner.close();
        //condiciones para la conexion a la base de datos 
        
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/persona","root","123456");
            PreparedStatement stmt = conn.prepareStatement("Insert into personas (nombre,apellido,edad,sexo,crup)Values(?,?,?,?,?)");
            
            stmt.setString(1, nombre);
            stmt.setString(2,apellido);
            stmt.setInt(3, edad);
            stmt.setString(4,sexo);
            stmt.setString(5, curp);
            
            stmt.executeUpdate();
            
            System.out.println("Datos ingresados corectamente");
            
            conn.close();
        } catch (Exception e ){
            System.out.println("Error al guardar datos :"+e.getMessage());
        }
    }
}
