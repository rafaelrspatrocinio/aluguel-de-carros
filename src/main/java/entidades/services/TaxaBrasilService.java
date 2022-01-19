package entidades.services;

public class TaxaBrasilService implements TaxaService {

    public double taxa(double montante){
        if (montante <= 100){
            return montante * 0.2;
        }
        else {
            return montante * 0.15;
        }
    }

}
