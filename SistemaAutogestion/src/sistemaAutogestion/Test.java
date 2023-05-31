/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaAutogestion;

import sistemaAutogestion.Domi.Entidades.Cliente;
import sistemaAutogestion.Domi.Entidades.Pedido;
import tads.Lista;

/**
 *
 * @author Usuario
 */
public class Test extends Prueba {
    
   private void _testCrearSistema(){
       Sistema sistema = new Sistema();
       Retorno re1 = sistema.crearSistemaDeAutoservicio(3);
       Retorno re2 = sistema.crearSistemaDeAutoservicio(0);
       Retorno re3 = sistema.crearSistemaDeAutoservicio(-1);
       Retorno re4 = sistema.crearSistemaDeAutoservicio(9);
       
       ver(re1.resultado,Retorno.Resultado.ERROR_1,"El número máximo de unidades no es correcto");
       ver(re2.resultado,Retorno.Resultado.ERROR_1,"El número máximo de unidades no es correcto");
       ver(re3.resultado,Retorno.Resultado.ERROR_1,"El número máximo de unidades no es correcto");
       ver(re4.resultado,Retorno.Resultado.OK,"El número máximo de unidades es correcto");   
   }
   
   private void _testAgregarCliente(){
       Sistema sistema =new Sistema();
       sistema.crearSistemaDeAutoservicio(12);
     
       Retorno re=  sistema.agregarCliente("viky", "53198305", 0);
       Retorno re2=sistema.agregarCliente("viky","53198305", 2);
        ver(re.resultado, Retorno.Resultado.OK, "se  agrego correctamente");//funciona
       //agrego un cliente que ya esta en el sistema
       ver(re2.resultado,Retorno.Resultado.ERROR_1,"se espera que no se pueda agregar");//funciona
   }
   
   private void _testEliminarCliente(){
       Sistema sistema = new Sistema();      
       sistema.crearSistemaDeAutoservicio(12);
       
       Cliente cl2 = new Cliente("1234", "pep2", 1);       
       
       sistema.agregarCliente("pepe1", "53198305", 1);
       sistema.agregarCliente("pep3","123456",1234567);
       
       Retorno eliminarCliente=sistema.eliminarCliente("53198305");//no anda
       Retorno eliminarCliente2=sistema.eliminarCliente("5319830");
        //elimino un cliente que su cedula existe
       ver(eliminarCliente.resultado,Retorno.Resultado.OK,"se elimino correctamente");
       //no existe cliente con esa ci
       ver(eliminarCliente2.resultado,Retorno.Resultado.ERROR_1,"no hay clientes con es ci");
     
   }
    private void _testAgregarProducto(){
       Sistema sistema =new Sistema();
       sistema.crearSistemaDeAutoservicio(12);
       
       Retorno agregarProducto1=sistema.agregarProducto("arroz", "blanco");//funciona
       Retorno agregarProducto2=sistema.agregarProducto("arroz", "blanco");//funciona
         //agregar producto bien
      ver(agregarProducto1.resultado,Retorno.Resultado.OK,"se agrego bien");//funciona
       //agregar producto con el mismo nombre de orto
      ver(agregarProducto2.resultado,Retorno.Resultado.ERROR_1,"no se puede agregar si tiene un nombre igual que otro producto");//funciona
    }
    private void _testEliminarProducto(){
       Sistema sistema=new Sistema();
       sistema.crearSistemaDeAutoservicio(12);
       
       sistema.agregarProducto("arrozz", "blanco");//funciona
       Retorno eliminarProducto=sistema.eliminarProducto("arrozz");
       Retorno eliminarProducto2=sistema.eliminarProducto("arr");
      // Retorno eliminarProductoEnPedido=sistema.eliminarProducto("jabon");
        //eliminar producto
      ver(eliminarProducto.resultado,Retorno.Resultado.OK,"se elimino correctamente");
      //eliminar con un nombre que no existe
      ver(eliminarProducto2.resultado,Retorno.Resultado.ERROR_1,"no hay producto con es elemento");
      //el producto se encuentra en un pedido
      //ver(eliminarProductoEnPedido.resultado,Retorno.Resultado.ERROR_2,"no se puede eliminar el producto esta en un pedido");
      
    }
   public void testDatos() {
      _testCrearSistema();
      _testAgregarCliente();
      _testEliminarCliente();//1
      _testAgregarProducto();
      _testEliminarProducto();//1
      
   } 
    

   public static void main(String[] args) {
     
     Test test =new Test();
    
     test.testDatos();
     
     test.imprimirResultadosPrueba();
   }
    
}
