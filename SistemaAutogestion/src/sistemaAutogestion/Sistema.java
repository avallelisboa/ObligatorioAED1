package sistemaAutogestion;

import sistemaAutogestion.Domi.Entidades.Cliente;
import sistemaAutogestion.Domi.Entidades.Producto;
import sistemaAutogestion.Domi.Entidades.Pedido;

import sistemaAutogestion.IObligatorio;
import sistemaAutogestion.Retorno;

import tads.Lista;
import tads.Cola;

public class Sistema implements IObligatorio {
    Lista<Cliente> listaClientes;
    Lista<Producto> listaProductos;
    Cola<Pedido> colaPedidos;
    private int _maxUnidadesDePedido;

    public int GetMaxUnidadesDePedidos(){
        return _maxUnidadesDePedido;
    }
    @Override
    public Retorno crearSistemaDeAutoservicio(int maxUnidadesDePedido) {
        var resultado = SistemaValidacion.esValido(maxUnidadesDePedido);
        if(resultado.resultado.equals(Retorno.Resultado.ERROR_1))
            return resultado;

        this._maxUnidadesDePedido = maxUnidadesDePedido;
        listaClientes = new Lista();
        listaProductos = new Lista();
        colaPedidos = new Cola();
        return resultado;
    }
    public Retorno agregarCliente(Cliente cl){
        return agregarCliente(cl.getNombre(),cl.getCi(),cl.getTel());
    }
    @Override
    public Retorno agregarCliente(String nombre, String ci, int tel) {
       Cliente cli= new Cliente(ci,nombre,tel);
       var resultado= ClienteValidacion.esValido(cli,listaClientes);
       if(resultado.resultado.equals(Retorno.Resultado.OK) ){
          listaClientes.agregarOrdenado(cli);
       }
       return resultado;
    }

    @Override
    public Retorno eliminarCliente(String ci) {   
      Retorno result= ClienteValidacion.ValidarBorrado(ci, listaClientes);
      if(result.resultado.equals(Retorno.Resultado.OK) ){
        Cliente cli = new Cliente(ci);
        listaClientes.borrarPorValor(cli);
      }
      return result;
    }



    @Override
    public Retorno agregarProducto(String nombre, String descripcion) {
      int nroProducto = listaProductos.getCantidad();
      Producto p= new Producto(nombre,descripcion);
      var resultado= ProductoValidacion.esValido(p, listaProductos);
      if(resultado.resultado.equals(Retorno.Resultado.OK) ){
        listaProductos.agregarFinal(p);
      }
      return resultado;
    }

    @Override
    public Retorno eliminarProducto(String nombre) {
        Retorno result = ProductoValidacion.ValidarBorrado(nombre, listaProductos,colaPedidos);
        if(result.resultado.equals(Retorno.Resultado.OK) ){
            Producto p = new Producto(nombre);
            listaProductos.borrarPorValor(p);
        }
        return result;
    }

    @Override
    public Retorno altaStockProducto(String nroProducto, int unidades) {
        Retorno result = ProductoValidacion.esValidaElAltaDeStock(unidades,Integer.parseInt(nroProducto),listaProductos);
        if(result.resultado.equals(Retorno.Resultado.OK)){
            
        }
        return result;
    }
    
    @Override
    public Retorno agregarProductoAPedido(String ciCliente, int nroProducto, int unidades) {
        Retorno result = ProductoValidacion.EsValidoAgregarProductoAPedido(ciCliente, nroProducto, unidades, listaClientes, listaProductos, _maxUnidadesDePedido);
        if(result.resultado.equals(Retorno.Resultado.OK)){
            
        }
        return result;
    }
    @Override
    public Retorno aperturaDePedido(String ciCliente) {
        Retorno result = ProductoValidacion.esValidaAperturaNuevoPedido(ciCliente, listaClientes);
        if(result.resultado.equals(Retorno.Resultado.OK)){
            
        }
        return result;
    }

    @Override
    public Retorno deshacerPedido(String ciCliente, int cantAccionesDeshacer) {
        Retorno result = ProductoValidacion.EsValidoDeshacerAgregadoProductos(ciCliente, cantAccionesDeshacer, listaClientes);
        if(result.resultado.equals(Retorno.Resultado.OK)){
            
        }
        return result;
    }

    @Override
    public Retorno cerrarPedido(String ciCliente) {
        Retorno result = ProductoValidacion.EsValidoCerrarPedido(ciCliente, listaClientes);
        if(result.resultado.equals(Retorno.Resultado.OK)){
            
        }
        return result;
    }

    @Override
    public Retorno procesarPedido(int cantPedidos) {
        Retorno result = ProductoValidacion.EsValidoTomarPedidosParaProcesamiento(cantPedidos, colaPedidos);
        if(result.resultado.equals(Retorno.Resultado.OK)){
            
        }
        return result;
    }

    @Override
    public Retorno listarClientes() {
        Retorno result = new Retorno(Retorno.Resultado.OK);
        var nodoCliente = listaClientes.getPrimero();
        while(nodoCliente != null){
            System.out.println(nodoCliente.valor.toString());
            nodoCliente = nodoCliente.siguiente;
        }
        return result;
    }

    @Override
    public Retorno listarProductos() {
        Retorno result = new Retorno(Retorno.Resultado.OK);
        var nodoProducto = listaProductos.getPrimero();
        while(nodoProducto != null){
            System.out.println(nodoProducto.valor.toString());
            nodoProducto = nodoProducto.siguiente;
        }
        return result;
    }

    @Override
    public Retorno listarPedidosAbiertos() {
        Retorno result = new Retorno(Retorno.Resultado.OK);
        var nodoPedido = colaPedidos.GetPrimerNodo();
        while(nodoPedido != null){
            if(!nodoPedido.valor.getEstaCerrado())
                System.out.println(nodoPedido.valor.toString());
            
            nodoPedido = nodoPedido.siguiente;
        }
        return result;
    }

    @Override
    public Retorno pedidosCerradosDeClientes(int ci) {
        Retorno result = ReporteValidacion.validarListarPedidosCliente(Integer.toString(ci), listaClientes);
        if(result.resultado.equals(Retorno.Resultado.OK)){
            Cliente cl = listaClientes.obtenerPorValor(new Cliente(Integer.toString(ci))).valor;
            var pilaPedidos = cl.getPedidos();
            var auxNodoPedido = pilaPedidos.GetNodoCabeza();
            while(auxNodoPedido != null){
                if(auxNodoPedido.valor.getEstaCerrado())
                    System.out.println(auxNodoPedido.valor.toString());
                
                auxNodoPedido = auxNodoPedido.siguiente;
            }
        }
        return result;
    }

    @Override
    public Retorno productosParaEntregar() {
       return  new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }

    @Override
    public Retorno reporteDePedidosSolicitadosXCliente() {
       return  new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
    }
}
