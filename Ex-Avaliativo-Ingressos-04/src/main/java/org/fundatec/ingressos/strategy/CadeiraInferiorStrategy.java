package org.fundatec.ingressos.strategy;

import org.fundatec.ingressos.model.Usuario;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CadeiraInferiorStrategy implements TipoIngressoStrategy {
    @Override
    public BigDecimal calcularValorIngresso(Usuario usuario) {
        BigDecimal valorTotalDoIngressoCadeiraInferior = new BigDecimal("200");

        BigDecimal valorTotalDoIngressoCom50DeDescontoParaEstudante = new BigDecimal("0");
        BigDecimal valorTotalDoIngressoCom60DeDescontoParaIdoso = new BigDecimal("0");
        BigDecimal valorTotalDoIngressoComDescontoParaEstudanteEIdoso = new BigDecimal("0");

        BigDecimal cinquentaPorCentoDoTotal = valorTotalDoIngressoCadeiraInferior.multiply(new BigDecimal("0.5"));
        BigDecimal sessentaPorCentoDoTotal = valorTotalDoIngressoCadeiraInferior.multiply(new BigDecimal(0.6));

        if (usuario.isEstudante() && usuario.getDataNascimento().getYear() - LocalDate.now().getYear() < 60) {
            valorTotalDoIngressoCom50DeDescontoParaEstudante = valorTotalDoIngressoCadeiraInferior
                    .subtract(cinquentaPorCentoDoTotal);
            return valorTotalDoIngressoCom50DeDescontoParaEstudante;


        }


        if (!usuario.isEstudante() && usuario.getDataNascimento().getYear() - LocalDate.now().getYear() > 60) {
            valorTotalDoIngressoCom60DeDescontoParaIdoso = valorTotalDoIngressoCadeiraInferior
                    .subtract(sessentaPorCentoDoTotal);
            return valorTotalDoIngressoCom60DeDescontoParaIdoso;

        }



        if (usuario.isEstudante() && usuario.getDataNascimento().getYear() - LocalDate.now().getYear() > 60) {
            valorTotalDoIngressoComDescontoParaEstudanteEIdoso = valorTotalDoIngressoCadeiraInferior
                    .subtract(sessentaPorCentoDoTotal);
            return valorTotalDoIngressoComDescontoParaEstudanteEIdoso;

        }


        return valorTotalDoIngressoCadeiraInferior;


    }


}
