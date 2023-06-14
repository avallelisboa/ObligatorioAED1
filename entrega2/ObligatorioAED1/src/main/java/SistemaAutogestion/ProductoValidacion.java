
package SistemaAutogestion;

import SistemaAutogestion.Dominio.Entidades.Cliente;
import SistemaAutogestion.Dominio.Entidades.Pedido;
import SistemaAutogestion.Dominio.Entidades.Producto;
import TADS.Cola;

import TADS.Lista;


public class ProductoValidacion {
    public static Retorno esValido(Producto pro,Lista<Producto> l){
        Retorno result = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
      //esto es para saber si ya existe
       if(_existe(pro,l)){
           result.resultado= Retorno.Resultado.ERROR_1;
       }else{
           result.resultado=Retorno.Resultado.OK;
       }
       return result;
    }
    
    public static Retorno esValidaElAltaDeStock(int nroProducto, int unidades, Lista<Producto> productos){
        if(unidades <= 0)
            return new Retorno(Retorno.Resultado.ERROR_2);
        
        Retorno resultado = new Retorno(Retorno.Resultado.ERROR_1);
        
        var nodoProducto = productos.getPrimero();
        while(nodoProducto != null){
            if(nodoProducto.valor.getId() == nroProducto){
                resultado.resultado = Retorno.Resultado.OK;
                break;
            }
            
            nodoProducto = nodoProducto.siguiente;
        }
        
        return resultado;
    }
    
    public static Retorno esValidaAperturaNuevoPedido(String ci, Lista<Cliente> clientes){
        var nodo = clientes.obtenerPorValor(new Cliente(ci));
        if(nodo == null)
           return new Retorno(Retorno.Resultado.ERROR_1);
        
        Cliente cl = nodo.valor;
        var pedidos = cl.getPedidos();
        if(pedidos.mirar() == null)
            return new Retorno(Retorno.Resultado.OK);
        if(!pedidos.mirar().getEstaCerrado())
            return new Retorno(Retorno.Resultado.ERROR_2);
        
        return new Retorno(Retorno.Resultado.OK);
    }
     
    public static boolean existe(String nom,Lista<Producto> l){
        Producto p =new Producto(nom);
        return _existe(p,l);
    }
    
    private static boolean _existe(Producto pro,Lista<Producto> l){
        return l.existe(pro);
    }
    
    public static Retorno ValidarBorrado(String nom,Lista<Producto> l,Cola<Pedido> p){
      Retorno result = new Retorno(Retorno.Resultado.OK) ;  
      if(!existe(nom,l)) 
        result.resultado=Retorno.Resultado.ERROR_1;
      
      Producto prod = new Producto(0);
      var nodoProducto = l.getPrimero();
      while(nodoProducto != null){
        if(nodoProducto.valor.getNombre().equals(nom)){
            prod = nodoProducto.valor;
            break;
        }
        nodoProducto = nodoProducto.siguiente;
      }
      
      var nodoPedido = p.GetPrimerNodo();
      while(nodoPedido != null){
        var productos = nodoPedido.valor.getProductos();
        var auxNodoProducto = productos.GetNodoCabeza();
        while(auxNodoProducto != null){
          if(auxNodoProducto.valor.equals(prod)){
            result.resultado = Retorno.Resultado.ERROR_2;
            break;
          }

          auxNodoProducto = auxNodoProducto.anterior;
        }
      }
      
      return result;
    }
    
    public static Retorno EsValidoAgregarProductoAPedido(String ci, int nroProducto, int unidades, Lista<Cliente>cls, Lista<Producto> ps, int maxUnidadesPedido){
       if(!cls.existe(new Cliente(ci)))
           return new Retorno(Retorno.Resultado.ERROR_1);
       if(!ps.existe(new Producto(nroProducto)))
           return new Retorno(Retorno.Resultado.ERROR_2);
       
       Cliente cl = cls.obtenerPorValor(new Cliente(ci)).valor;
       Pedido p = cl.getPedidos().mirar();
       
       if(p.getUnidades() + unidades > maxUnidadesPedido)
           return new Retorno(Retorno.Resultado.ERROR_3);
       
       return new Retorno(Retorno.Resultado.OK);
    }
    
    public static Retorno EsValidoDeshacerAgregadoProductos(String ci, int nroAcciones, Lista<Cliente>cls){
        if(!cls.existe(new Cliente(ci)))
           return new Retorno(Retorno.Resultado.ERROR_1);
        if(nroAcciones <= 0)
            return new Retorno(Retorno.Resultado.ERROR_2);
        Cliente cl = cls.obtenerPorValor(new Cliente(ci)).valor;
        if (cl.getPedidos().mirar().getUnidades() < nroAcciones)
            return new Retorno(Retorno.Resultado.ERROR_3);
        
        return new Retorno(Retorno.Resultado.OK);
    }
    
    public static Retorno EsValidoCerrarPedido(String ciCliente, Lista<Cliente> cls){
        Retorno res = new Retorno(Retorno.Resultado.OK);
        Cliente cl = cls.obtenerPorValor(new Cliente(ciCliente)).valor;
        res.resultado = cl == null ? Retorno.Resultado.ERROR_1 : Retorno.Resultado.OK; 
        
        return res;
    }
    
    public static Retorno EsValidoTomarPedidosParaProcesamiento(int cantPedidos, Cola<Pedido> pedidos){
        Retorno res = new Retorno(Retorno.Resultado.ERROR_1);
        res.resultado =  cantPedidos > 0 ? Retorno.Resultado.OK : Retorno.Resultado.ERROR_1;        
        return res;
    }
}
