package org.fundatec.ingressos.strategy;

import org.fundatec.ingressos.model.Usuario;

import java.math.BigDecimal;

public interface TipoIngressoStrategy {
    BigDecimal calcularValorIngresso(Usuario usuario);
}
