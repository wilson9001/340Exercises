package ECommerce;

public class OrderCheckout
{
    private AccountCharger accountCharger;
    private ShippingInitializer shippingInitializer;
    private TaxCalculator taxCalculator;

    //other private variables related to order details go here

    public OrderCheckout(AccountCharger accountCharger, ShippingInitializer shippingInitializer, TaxCalculator taxCalculator)
    {
        this.accountCharger = accountCharger;
        this.shippingInitializer = shippingInitializer;
        this.taxCalculator = taxCalculator;

        //initialize other order detail variables here
    }

    public boolean checkoutOrder()
    {
        double taxAmount = taxCalculator.calculateTax(/*pass in subtotal here*/);

        //add tax amount to subtotal

        //confirm user wants to be charged total amount with tax and return false if no

        boolean accountCharged = accountCharger.chargeAccount();

        if (!accountCharged)
            return false;

        boolean shippingInitialized = shippingInitializer.createShippingOrder(/*pass in order information here*/);

        if(!shippingInitialized)
        {
            accountCharger.reverseCharge();
            return false;
        }

        return true;
    }
}
