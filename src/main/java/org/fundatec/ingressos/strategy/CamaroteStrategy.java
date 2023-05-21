package org.fundatec.ingressos.strategy;

import org.fundatec.ingressos.model.Usuario;

import java.math.BigDecimal;

public class CamaroteStrategy implements TipoIngressoStrategy {
    @Override
    public BigDecimal calcularValorIngresso(Usuario usuario) {
        BigDecimal valorTotalDoIngressoCamarote = new BigDecimal("750");
        valorTotalDoIngressoCamarote=valorTotalDoIngressoCamarote.multiply(new BigDecimal("1"));

        System.out.println(valorTotalDoIngressoCamarote);
        System.out.println("valorTotalDoIngressoCamarote # =" + "Não há desconto para estudantes e/ou idosos");

        return valorTotalDoIngressoCamarote;

    }

}
