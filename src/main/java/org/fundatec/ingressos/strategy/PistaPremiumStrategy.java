package org.fundatec.ingressos.strategy;

import org.fundatec.ingressos.model.Usuario;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PistaPremiumStrategy implements TipoIngressoStrategy {
    @Override
    public BigDecimal calcularValorIngresso(Usuario usuario) {
        BigDecimal valorTotalDoIngressoPistaPremium = new BigDecimal("400");
        BigDecimal valorTotalDoIngressoCom50DeDescontoParaEstudante = new BigDecimal("0");
        BigDecimal valorTotalDoIngressoCom50DeDescontoParaIdoso = new BigDecimal("0");
        BigDecimal valorTotalDoIngressoCom50DeDescontoParaIdosoEstudante = new BigDecimal("0");
        BigDecimal cinquentaPorCentoDoTotal = valorTotalDoIngressoPistaPremium.multiply(new BigDecimal("0.5"));

        if (usuario.isEstudante() && usuario.getDataNascimento().getYear() - LocalDate.now().getYear() < 60) {
            valorTotalDoIngressoCom50DeDescontoParaEstudante = valorTotalDoIngressoPistaPremium.subtract(cinquentaPorCentoDoTotal);

            return valorTotalDoIngressoCom50DeDescontoParaEstudante;
        }
        System.out.println(valorTotalDoIngressoCom50DeDescontoParaEstudante);
        System.out.println(usuario.getNome());
        System.out.println(usuario.getDataNascimento());
        System.out.println(usuario.isEstudante());

        if (usuario.isEstudante() && usuario.getDataNascimento().getYear() - LocalDate.now().getYear() > 60) {
            valorTotalDoIngressoCom50DeDescontoParaIdoso = valorTotalDoIngressoPistaPremium.subtract(cinquentaPorCentoDoTotal);
            return valorTotalDoIngressoCom50DeDescontoParaIdoso;
        }
        System.out.println(valorTotalDoIngressoCom50DeDescontoParaIdoso);
        System.out.println(usuario.getNome());
        System.out.println(usuario.getDataNascimento());
        System.out.println(usuario.isEstudante());

        if (usuario.isEstudante() && usuario.getDataNascimento().getYear() - LocalDate.now().getYear() > 60) {
            valorTotalDoIngressoCom50DeDescontoParaIdosoEstudante = valorTotalDoIngressoPistaPremium.subtract(cinquentaPorCentoDoTotal);
            return valorTotalDoIngressoCom50DeDescontoParaIdosoEstudante;
        }
        System.out.println(valorTotalDoIngressoCom50DeDescontoParaIdosoEstudante);
        System.out.println(usuario.getNome());
        System.out.println(usuario.getDataNascimento());
        System.out.println(usuario.isEstudante());

        return valorTotalDoIngressoCom50DeDescontoParaIdosoEstudante;
    }
}

