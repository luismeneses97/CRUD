/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class EmpleadoTest {
    
    public EmpleadoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }




    /**
     * Test of Crear method, of class Empleado.
     */
    @Test
    public void testCrear() {
        System.out.println("Crear");
        Empleado empl = new Empleado("luis","@norte","3245674435","10000000");
        empl.Crear();
        Empleado empDeBaseDatos = Empleado.Leer().get((int)empl.getId()-1);
        assertEquals(empl, empDeBaseDatos);
    }

    /**
     * Test of Actualizar method, of class Empleado.
     */
//    @Test
//    public void testActualizar() {
//        System.out.println("Actualizar");
//        long id = 0L;
//        String nombre = "";
//        String apellido = "";
//        String correo = "";
//        String celular = "";
//        Boolean esProveedor = null;
//        String salario = "";
//        String cargo = "";
//        Empleado.Actualizar(id, nombre, apellido, correo, celular, esProveedor, salario, cargo);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of Borrar method, of class Empleado.
//     */
//    @Test
//    public void testBorrar() {
//        System.out.println("Borrar");
//        long id = 0L;
//        Empleado.Borrar(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of Leer method, of class Empleado.
//     */
//    @Test
//    public void testLeer() {
//        System.out.println("Leer");
//        ArrayList<Empleado> expResult = null;
//        ArrayList<Empleado> result = Empleado.Leer();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
