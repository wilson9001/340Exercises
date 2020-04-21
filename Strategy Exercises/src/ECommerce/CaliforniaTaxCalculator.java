package ECommerce;

public class CaliforniaTaxCalculator implements TaxCalculator
{
    private static TaxCalculator federalTaxCalculator = new USATaxCalculator();

    //other private variables to calculate California taxes go here

    @Override
    public double calculateTax(/*pass in subtotal here*/)
    {
        //calculate state taxes
        double stateTax = 1e4; //just a guess but I'm probably not far off

        double otherTaxes = federalTaxCalculator.calculateTax(/*pass in subtotal here*/);

        return stateTax + otherTaxes;
    }
}
