package entidades.services;

import entidades.model.AluguelDeCarros;
import entidades.model.Invoice;

public class AluguelService {

    private Double precoPorHora;

    private Double precoPorDia;

    private TaxaService taxaDeServico;

    public AluguelService(Double precoPorHora, Double precoPorDia, TaxaService taxaDeServico) {
        this.precoPorHora = precoPorHora;
        this.precoPorDia = precoPorDia;
        this.taxaDeServico = taxaDeServico;
    }

    public void processaInvoice(AluguelDeCarros aluguelDeCarros){
        long t1 = aluguelDeCarros.getInicio().getTime();
        long t2 = aluguelDeCarros.getFim().getTime();

        double horas = (double) (t2 - t1) / 1000 / 60 / 60;

        double pagamentoBasico;

        if(horas <= 12.0){
            pagamentoBasico = Math.ceil(horas) * precoPorHora;
        }
        else {
            pagamentoBasico = Math.ceil(horas / 24) * precoPorDia;
        }

        double taxa = taxaDeServico.taxa(pagamentoBasico);

        aluguelDeCarros.setInvoice(new Invoice(pagamentoBasico, taxa));
    }
}