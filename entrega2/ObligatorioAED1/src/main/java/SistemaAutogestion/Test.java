/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaAutogestion;

import SistemaAutogestion.Dominio.Entidades.Cliente;
import SistemaAutogestion.Dominio.Entidades.Pedido;
import TADS.Lista;

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
       ver(re2.resultado,Retorno.Resultado.ERROR_1,"se espera que no se pueda agregar");//funciona
   }
   
   private void _testEliminarCliente(){
       Sistema sistema = new Sistema();      
       sistema.crearSistemaDeAutoservicio(12);
       
       Cliente cl2 = new Cliente("1234", "pep2", 1);       
       
       sistema.agregarCliente("pepe1", "53198305", 1);
       sistema.agregarCliente("pep3","123456",1234567);
       
       Retorno eliminarCliente=sistema.eliminarCliente("53198305");
       Retorno eliminarCliente2=sistema.eliminarCliente("5319830");
       
       ver(eliminarCliente.resultado,Retorno.Resultado.OK,"se elimino correctamente");
       ver(eliminarCliente2.resultado,Retorno.Resultado.ERROR_1,"no hay clientes con es ci");
     
   }
    private void _testAgregarProducto(){
       Sistema sistema =new Sistema();
       sistema.crearSistemaDeAutoservicio(12);
       
       Retorno agregarProducto1=sistema.agregarProducto("arroz", "blanco");
       Retorno agregarProducto2=sistema.agregarProducto("arroz", "blanco");
         
       ver(agregarProducto1.resultado,Retorno.Resultado.OK,"se agrego bien");       
       ver(agregarProducto2.resultado,Retorno.Resultado.ERROR_1,"no se puede agregar si tiene un nombre igual que otro producto");//funciona
    }
    private void _testEliminarProducto(){
        Sistema sistema=new Sistema();
        sistema.crearSistemaDeAutoservicio(12);

        sistema.agregarProducto("arrozz", "blanco");
        Retorno eliminarProducto=sistema.eliminarProducto("arrozz");
        Retorno eliminarProducto2=sistema.eliminarProducto("arr");
        
        sistema.agregarProducto("arroz", "blanco");
        sistema.agregarProducto("leche","Entera");
        sistema.agregarProducto("huevos", "1 docena");
        
        Retorno eliminarProducto3 = sistema.eliminarProducto("arroz");
        Retorno eliminarProducto4 = sistema.eliminarProducto("leche");
        Retorno eliminarProducto5 = sistema.eliminarProducto("huevos");        

        ver(eliminarProducto.resultado,Retorno.Resultado.OK,"se elimino correctamente");
        ver(eliminarProducto2.resultado,Retorno.Resultado.ERROR_1,"no hay producto con es elemento");
        ver(eliminarProducto3.resultado,Retorno.Resultado.OK,"se elimino correctamente");
        ver(eliminarProducto4.resultado,Retorno.Resultado.OK,"se elimino correctamente");
        ver(eliminarProducto5.resultado,Retorno.Resultado.OK,"se elimino correctamente");
    }
    private void _testAltaDeStockAProducto(){
        Sistema sistema=new Sistema();
        sistema.crearSistemaDeAutoservicio(12);

        sistema.agregarProducto("arrozz", "blanco");
        int nroProducto = sistema.listaProductos.getPrimero().valor.getId();
        
        Retorno resultado1 = sistema.altaStockProducto(Integer.toString(nroProducto), 10);
        Retorno resultado2 = sistema.altaStockProducto(Integer.toString(2), 10);
        Retorno resultado3 = sistema.altaStockProducto(Integer.toString(nroProducto),0);
        Retorno resultado4 = sistema.altaStockProducto(Integer.toString(nroProducto),-1);
        
        ver(resultado1.resultado,Retorno.Resultado.OK,"Se elimino correctamente");
        ver(resultado2.resultado,Retorno.Resultado.ERROR_1,"No existe producto con ese numero");
        ver(resultado3.resultado,Retorno.Resultado.ERROR_2,"El numero de unidades debse ser mayor a 0");
        ver(resultado4.resultado,Retorno.Resultado.ERROR_2,"El numero de unidades debse ser mayor a 0");
    }
    private void _testAbrirNuevoPedido(){
        Sistema sistema=new Sistema();
        sistema.crearSistemaDeAutoservicio(12);
        
        sistema.agregarCliente(new Cliente("55477648","Andres Valle Lisboa"));
        
        Retorno resultado1 = sistema.aperturaDePedido("55477648");
        Retorno resultado2 = sistema.aperturaDePedido("55477648");
        Retorno resultado3 = sistema.aperturaDePedido("55477649");
        
        ver(resultado1.resultado,Retorno.Resultado.OK,"El pedido fue abierto");
        ver(resultado2.resultado,Retorno.Resultado.ERROR_2, "El cliente ya tiene un pedido abierto");
        ver(resultado3.resultado,Retorno.Resultado.ERROR_1,"El cliente no existe");
    }
    private void _testAgregarProductosAPedido(){
        
    }
    private void _testDeshacerAgregadoDeProductos(){
        
    }
    private void _testCerrarPedido(){
        
    }
    private void _testTomarPedidoParaProcesamiento(){
        
    }
    private void _testListarClientes(){
        
    }
    private void _testListarPedidosAbiertos(){
        
    }
    private void _testListarPedidosCerradosDeCliente(){
        
    }
    private void _testListarPedidosListosParaEntrega(){
        
    }
    private void _testReporteDeEnviosPorProducto(){
        
    }
    
    
   public void testDatos() {
      _testCrearSistema();
      _testAgregarCliente();
      _testEliminarCliente();//1
      _testAgregarProducto();
      _testEliminarProducto();//1
      _testAltaDeStockAProducto();
      _testAbrirNuevoPedido();
      _testAgregarProductosAPedido();
      _testDeshacerAgregadoDeProductos();
      _testCerrarPedido();
      _testTomarPedidoParaProcesamiento();
      _testListarClientes();
      _testListarPedidosAbiertos();
      _testListarPedidosCerradosDeCliente();
      _testListarPedidosListosParaEntrega();
      _testReporteDeEnviosPorProducto();      
   } 
    

   public static void main(String[] args) {
     
     Test test =new Test();
    
     test.testDatos();
     
     test.imprimirResultadosPrueba();
   }
    
}
