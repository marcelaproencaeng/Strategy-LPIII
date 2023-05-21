package org.fundatec.ingressos.model;

import org.fundatec.ingressos.model.enuns.TipoIngresso;

import java.math.BigDecimal;

public class Ingresso {
    private BigDecimal valor;
    private Usuario usuario;
    private TipoIngresso tipoIngresso;

    public Ingresso(BigDecimal valor, Usuario usuario, TipoIngresso tipoIngresso) {
        this.valor = valor;
        this.usuario = usuario;
        this.tipoIngresso = tipoIngresso;
    }

    public BigDecimal getValor() {
        return valor;
    }


    public Usuario getUsuario() {
        return usuario;
    }


    public TipoIngresso getTipoIngresso() {
        return tipoIngresso;
    }


    @Override
    public String toString() {
        return "Ingresso{" +
                "valor=" + valor +
                ", usuario=" + usuario +
                ", tipoIngresso=" + tipoIngresso +
                '}';
    }
}
