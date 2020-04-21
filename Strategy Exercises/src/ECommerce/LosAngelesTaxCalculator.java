package ECommerce;

public class LosAngelesTaxCalculator implements TaxCalculator
{
    private static TaxCalculator stateAndFederalTaxCalculator = new CaliforniaTaxCalculator();


    @Override
    public double calculateTax()
    {
        //calculate taxes for Los Angeles
        double citytax = 1e4; //just a guess but I'm probably not far off

        double otherTaxes = stateAndFederalTaxCalculator.calculateTax(/*pass in subtotal here*/);

        return citytax + otherTaxes;
    }
}
