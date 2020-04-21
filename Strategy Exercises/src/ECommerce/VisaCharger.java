package ECommerce;

public class VisaCharger implements AccountCharger
{
    @Override
    public boolean chargeAccount()
    {
        //charge visa account
        return false;
    }

    @Override
    public boolean reverseCharge()
    {
        //reverse visa charge
        return false;
    }
}
