/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaAutogestion;

import tads.Lista;
import sistemaAutogestion.Domi.Entidades.Cliente;
import sistemaAutogestion.Retorno;


public class ClienteValidacion {
    //es para agregar cliente validaciones
    public static Retorno esValido(Cliente cli,Lista<Cliente> l){
       Retorno result=  new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
       //esto es para saber si ya existe
        if(_existe(cli,l)){
            result.resultado= Retorno.Resultado.ERROR_1;
        }else{
            result.resultado=Retorno.Resultado.OK;
        }
        return result;
    }
    
    
    public static boolean existe(String ci,Lista<Cliente> l){
        Cliente cli =new Cliente(ci);
        return _existe(cli,l);
    }
    
    private static boolean _existe(Cliente cli,Lista<Cliente> l){
        return l.existe(cli);
    }
    //esto es para validar borrado
    public static Retorno ValidarBorrado(String ci,Lista<Cliente> l){
        
      Retorno result=  new Retorno(Retorno.Resultado.ERROR_1);
     if(!existe(ci,l)){
        return result;
     }else if(TienePedidos(l.obtenerPorValor(new Cliente(ci)).valor)){
        result.resultado=Retorno.Resultado.ERROR_2;
     }else{
        result.resultado=Retorno.Resultado.OK;
     }
     
     return result ;  
    }
    
    private static boolean TienePedidos(Cliente cli){
        return cli.getPedidos().getCantidad()>0;
    }
}
