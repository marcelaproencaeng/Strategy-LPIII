package org.fundatec.ingressos.strategy;

import org.fundatec.ingressos.model.Usuario;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PistaStrategy implements TipoIngressoStrategy {
    @Override
    public BigDecimal calcularValorIngresso(Usuario usuario) {
        BigDecimal valorTotalDoIngressoPista = new BigDecimal("250");
        BigDecimal valorTotalDoIngressoCom50DeDescontoParaEstudanteEIdoso = new BigDecimal("0");
        BigDecimal valorTotalDoIngressoCom50DeDescontoParaEstudanteOuIdoso = new BigDecimal("0");
        BigDecimal cinquentaPorCentoDoTotal = valorTotalDoIngressoPista.multiply(new BigDecimal("0.5"));
        //Considerando que incide apenas
        // para usuario estudante e idoso o desconto de idoso
        // e não os dois descontos sobre o valor total do ingresso Pista

        if (usuario.isEstudante() && usuario.getDataNascimento().getYear() - LocalDate.now().getYear() > 60) {
            valorTotalDoIngressoCom50DeDescontoParaEstudanteEIdoso = valorTotalDoIngressoPista.subtract(cinquentaPorCentoDoTotal);
            System.out.println(valorTotalDoIngressoCom50DeDescontoParaEstudanteEIdoso);
            System.out.println(usuario.getNome());
            System.out.println(usuario.getDataNascimento());

            return valorTotalDoIngressoCom50DeDescontoParaEstudanteEIdoso;

        }
        if (usuario.isEstudante() | usuario.getDataNascimento().getYear() - LocalDate.now().getYear() > 60) {
            valorTotalDoIngressoCom50DeDescontoParaEstudanteOuIdoso = valorTotalDoIngressoPista.subtract(cinquentaPorCentoDoTotal);
            System.out.println(valorTotalDoIngressoCom50DeDescontoParaEstudanteOuIdoso);
            System.out.println(usuario.getNome());
            System.out.println(usuario.getNome());
            return valorTotalDoIngressoCom50DeDescontoParaEstudanteOuIdoso;
        }
        return valorTotalDoIngressoPista;
    }

}
