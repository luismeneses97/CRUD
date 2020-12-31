
import java.util.Scanner;


public class Principal {
    
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        String nombre = lector.nextLine();
        String correo1 = lector.nextLine();
        String celular = lector.nextLine();
        String salario = lector.nextLine();
        String correo2 = lector.nextLine();
        String celular2 = lector.nextLine();
        
        Empleado emp = new Empleado(nombre, correo1, celular, salario);
        emp.Crear();
        System.out.println("Empleado creado: "+emp.getCorreo()+", nombre: "+emp.getNombre()+", ﻿celular: "+emp.getCelular());
        
        Empleado.Actualizar(emp.getId(), nombre,"", correo2, celular2, false, salario, "");
        System.out.println("Empleado creado: "+Empleado.Leer().get((int)emp.getId()-1).getCorreo()+", nombre: "+Empleado.Leer().get((int)emp.getId()-1).getNombre()+", ﻿celular: "+Empleado.Leer().get((int)emp.getId()-1).getCelular());
        
        Empleado.Borrar(Empleado.Leer().get((int)emp.getId()-1).getId());
        System.out.print("Cantidad de empleados: "+Empleado.Leer().size());
    }
    
}