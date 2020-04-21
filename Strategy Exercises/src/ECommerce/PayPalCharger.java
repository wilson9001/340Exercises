package ECommerce;

public class PayPalCharger implements AccountCharger
{
    @Override
    public boolean chargeAccount()
    {
        //charge paypal account
        return false;
    }

    @Override
    public boolean reverseCharge()
    {
        //reverse paypal charge
        return false;
    }
}
