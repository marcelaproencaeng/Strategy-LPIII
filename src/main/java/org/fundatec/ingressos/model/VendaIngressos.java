package org.fundatec.ingressos.model;

import org.fundatec.ingressos.model.enuns.TipoIngresso;
import org.fundatec.ingressos.strategy.TipoIngressoStrategy;

import java.math.BigDecimal;

public class VendaIngressos {
    public BigDecimal calcularValorIngresso(TipoIngresso tipoIngresso, Usuario usuario) {


        TipoIngressoStrategy estrategiaVenda = tipoIngresso.getStrategy();
        return estrategiaVenda.calcularValorIngresso(usuario);
    }
}
