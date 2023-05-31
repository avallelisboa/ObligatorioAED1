/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaAutogestion;

/**
 *
 * @author avall
 */
public class SistemaValidacion {
    public static Retorno esValido(int maxUnidadesDePedido){
        Retorno retorno = new Retorno(Retorno.Resultado.ERROR_1);
        retorno.resultado = maxUnidadesDePedido > 3 ? Retorno.Resultado.OK : Retorno.Resultado.ERROR_1;
        return retorno;
    }
}
