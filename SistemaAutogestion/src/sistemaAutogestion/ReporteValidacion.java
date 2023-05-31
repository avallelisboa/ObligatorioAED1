package sistemaAutogestion;

import sistemaAutogestion.Domi.Entidades.Cliente;
import sistemaAutogestion.Retorno.Resultado;
import tads.Lista;

public class ReporteValidacion {
    public static Retorno validarListarPedidosCliente(String ci, Lista<Cliente> cls){
        Retorno res = new Retorno(Retorno.Resultado.ERROR_1);
        res.resultado = cls.existe(new Cliente(ci)) ? Retorno.Resultado.OK : Retorno.Resultado.ERROR_1;
        return res;
    }
    public static Retorno validarListarPedidosListosParaEntregar(String ci, Lista<Cliente> cls){
        Retorno res = new Retorno(Retorno.Resultado.ERROR_1);
        res.resultado = cls.existe(new Cliente(ci)) ? Retorno.Resultado.OK : Retorno.Resultado.ERROR_1;
        return res;
    }
}