package aplicacao;

import entidades.model.AluguelDeCarros;
import entidades.model.Veiculo;
import entidades.services.AluguelService;
import entidades.services.TaxaBrasilService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");

        System.out.println("Entre com os dados do aluguel");
        System.out.print("Modelo do carro: ");

        String modeloDoCarro = sc.nextLine();

        System.out.print("Entrada: ");

        Date inicio = sdf.parse(sc.nextLine());

        System.out.print("Saída: ");

        Date fim = sdf.parse(sc.nextLine());

        AluguelDeCarros aluguelDeCarros = new AluguelDeCarros(inicio, fim, new Veiculo(modeloDoCarro));

        System.out.print("Digite o preço por hora: ");

        double precoPorHora = sc.nextDouble();

        System.out.print("Digite o preço por dia: ");

        double precoPorDia = sc.nextDouble();

        AluguelService aluguelService = new AluguelService(precoPorHora, precoPorDia, new TaxaBrasilService());

        aluguelService.processaInvoice(aluguelDeCarros);

        System.out.println("INVOICE: ");

        System.out.println("Pagamento Basico: " + String.format("%.2f", aluguelDeCarros.getInvoice().getPagamentoBasico()));

        System.out.println("Taxa: " + String.format("%.2f", aluguelDeCarros.getInvoice().getTaxa()));

        System.out.println("Pagamento Total: " + String.format("%.2f", aluguelDeCarros.getInvoice().getPagamentoTotal()));

        sc.close();
    }

}
