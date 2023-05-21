package org.fundatec.ingressos;

import org.fundatec.ingressos.model.Ingresso;
import org.fundatec.ingressos.model.Usuario;
import org.fundatec.ingressos.model.VendaIngressos;
import org.fundatec.ingressos.model.enuns.TipoIngresso;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws RuntimeException {

        List<Usuario> usuarios = new ArrayList<>();
        Usuario usuario = new Usuario(
                "Maria",
                LocalDate.of(1990, 10, 20),
                false
        );
        Usuario usuario1 = new Usuario(
                "Paulo",
                LocalDate.of(1958, 2, 15),
                false
        );
        Usuario usuario2 = new Usuario(
                "Pedro",
                LocalDate.of(2005, 5, 12),
                true
        );
        Usuario usuario3 = new Usuario(
                "Marcelo",
                LocalDate.of(2000, 3, 4),
                true
        );
        Usuario usuario4 = new Usuario(
                "Marco",
                LocalDate.of(1960, 8, 10),
                false
        );
        usuario.verificarIdadeParaDesconto(usuario);
        usuario.verificarIdadeParaDesconto(usuario1);
        usuario.verificarIdadeParaDesconto(usuario2);
        usuario.verificarIdadeParaDesconto(usuario3);
        usuario.verificarIdadeParaDesconto(usuario4);

        usuarios.add(usuario);
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
        usuarios.add(usuario4);

        System.out.println(usuarios);

        List<Ingresso> ingressos = new ArrayList<>();

        Ingresso ingresso = new Ingresso(new BigDecimal(750), usuario, TipoIngresso.CAMAROTE);
        Ingresso ingresso1 = new Ingresso(new BigDecimal(400), usuario1, TipoIngresso.PISTA_PREMIUM);
        Ingresso ingresso2 = new Ingresso(new BigDecimal(250), usuario2, TipoIngresso.PISTA);
        Ingresso ingresso3 = new Ingresso(new BigDecimal(200), usuario3, TipoIngresso.CADEIRA_INFERIOR);
        Ingresso ingresso4 = new Ingresso(new BigDecimal(150), usuario4, TipoIngresso.CADEIRA_SUPERIOR);

        ingresso.getValor();
        ingresso1.getValor();
        ingresso2.getValor();
        ingresso3.getValor();
        ingresso4.getValor();

        ingressos.add(ingresso);
        ingressos.add(ingresso1);
        ingressos.add(ingresso2);
        ingressos.add(ingresso3);
        ingressos.add(ingresso4);

        System.out.println(ingressos);



        VendaIngressos vendaIngressos = new VendaIngressos();

        vendaIngressos.calcularValorIngresso(TipoIngresso.CAMAROTE, usuario);
        vendaIngressos.calcularValorIngresso(TipoIngresso.PISTA_PREMIUM, usuario1);
        vendaIngressos.calcularValorIngresso(TipoIngresso.PISTA, usuario2);
        vendaIngressos.calcularValorIngresso(TipoIngresso.CADEIRA_INFERIOR, usuario3);
        vendaIngressos.calcularValorIngresso(TipoIngresso.CADEIRA_SUPERIOR, usuario4);

        System.out.println("R$ 750 * 1)=" + vendaIngressos.calcularValorIngresso(TipoIngresso.CAMAROTE, usuario));
        System.out.println("R$400 -(R$400 * 0.5)=" + vendaIngressos.calcularValorIngresso(TipoIngresso.PISTA_PREMIUM, usuario1));
        System.out.println("R$250 -(R$250 * 0.5)=" + vendaIngressos.calcularValorIngresso(TipoIngresso.PISTA, usuario2));
        System.out.println("R$200-(R$200 * 0.5))=" + vendaIngressos.calcularValorIngresso(TipoIngresso.CADEIRA_INFERIOR, usuario3));
        System.out.println("R$150-(R$150 * 0.6)=" + vendaIngressos.calcularValorIngresso(TipoIngresso.CADEIRA_SUPERIOR, usuario4));


    }
}
