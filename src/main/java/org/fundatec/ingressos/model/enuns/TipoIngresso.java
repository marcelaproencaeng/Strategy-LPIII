package org.fundatec.ingressos.model.enuns;

import org.fundatec.ingressos.strategy.*;

public enum TipoIngresso {
    PISTA(new PistaStrategy()),
    PISTA_PREMIUM(new PistaPremiumStrategy()),

    CAMAROTE(new CamaroteStrategy()),

    CADEIRA_INFERIOR(new CadeiraInferiorStrategy()),

    CADEIRA_SUPERIOR(new CadeiraSuperiorStrategy());

    private final TipoIngressoStrategy strategy;

    private TipoIngresso(TipoIngressoStrategy strategy){
        this.strategy=strategy;
    }

    public TipoIngressoStrategy getStrategy() {
        return strategy;
    }
}
