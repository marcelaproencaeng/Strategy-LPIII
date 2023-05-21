package org.fundatec.ingressos.strategy;

import org.fundatec.ingressos.model.Usuario;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CadeiraSuperiorStrategy implements TipoIngressoStrategy {
    @Override
    public BigDecimal calcularValorIngresso(Usuario usuario) {

        BigDecimal valorTotalDoIngressoCadeiraSuperior = new BigDecimal("150");

        BigDecimal valorTotalDoIngressoCom50DeDescontoParaEstudante = new BigDecimal("0");
        BigDecimal valorTotalDoIngressoCom60DeDescontoParaIdoso = new BigDecimal("0");
        BigDecimal valorTotalDoIngressoComDescontoParaEstudanteEIdoso = new BigDecimal("0");

        BigDecimal cinquentaPorCentoDoTotal = valorTotalDoIngressoCadeiraSuperior.multiply(new BigDecimal("0.5"));
        BigDecimal sessentaPorCentoDoTotal = valorTotalDoIngressoCadeiraSuperior.multiply(new BigDecimal("0.6"));


        if (usuario.isEstudante() && usuario.getDataNascimento().getYear() - LocalDate.now().getYear() < 60) {
            valorTotalDoIngressoCom50DeDescontoParaEstudante = valorTotalDoIngressoCadeiraSuperior
                    .subtract(cinquentaPorCentoDoTotal);


            return valorTotalDoIngressoCom50DeDescontoParaEstudante;


        }
        System.out.println(valorTotalDoIngressoCom50DeDescontoParaEstudante);
        System.out.println(usuario.isEstudante());
        System.out.println(usuario.getNome());
        System.out.println(usuario.getDataNascimento());

        if (!usuario.isEstudante() && usuario.getDataNascimento().getYear() - LocalDate.now().getYear() > 60) {
            valorTotalDoIngressoCom60DeDescontoParaIdoso = valorTotalDoIngressoCadeiraSuperior
                    .subtract(sessentaPorCentoDoTotal);

            return valorTotalDoIngressoCom60DeDescontoParaIdoso;
        }
        System.out.println(valorTotalDoIngressoCom60DeDescontoParaIdoso);
        System.out.println(usuario.isEstudante());
        System.out.println(usuario.getNome());
        System.out.println(usuario.getDataNascimento());


        //Supondo valer somente o desconto de idoso para usuarios idosos e estudantes sobre o valor do ingresso

        if (usuario.isEstudante() && usuario.getDataNascimento().getYear() - LocalDate.now().getYear() > 60) {
            valorTotalDoIngressoComDescontoParaEstudanteEIdoso = valorTotalDoIngressoCadeiraSuperior
                    .subtract(sessentaPorCentoDoTotal);

            return valorTotalDoIngressoComDescontoParaEstudanteEIdoso;
        }

        System.out.println(valorTotalDoIngressoComDescontoParaEstudanteEIdoso);
        System.out.println(usuario.isEstudante());
        System.out.println(usuario.getNome());
        System.out.println(usuario.getDataNascimento());


            return valorTotalDoIngressoCadeiraSuperior;

    }
}
