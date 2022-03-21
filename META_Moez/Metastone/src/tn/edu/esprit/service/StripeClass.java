package tn.edu.esprit.service;

import java.util.HashMap;
import java.util.Map;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Card;
import com.stripe.model.Customer;
import com.stripe.model.EphemeralKey;
import com.stripe.model.PaymentIntent;
import com.stripe.model.Token;
import com.stripe.net.RequestOptions;
import java.util.ArrayList;
import java.util.List;
import tn.edu.esprit.service.stripeInterface;

/**
 *
 * @author Moez
 */
public class StripeClass {
// use this method when you create an account
    public String makeCustomerIdForUser() throws StripeException {
        Stripe.apiKey = "sk_test_51KYVo2FCSQ0FKZUZdjzWzm9xR5IIoMvD5v3oAyAVIO3cwRzORgKHx71e982IVhZFOAlKHkELn2GvQsm5dGg0Umli00rxnB6zFl";
        Map<String, Object> params = new HashMap<>();
        params.put(
                "description",
                "This is my first customer Id"
        );

        Customer customer = Customer.create(params);
        return customer.getId();
    }
//ignore
    public void createEphemeralKey(String customerId) throws StripeException {
        Stripe.apiKey = "sk_test_51KYVo2FCSQ0FKZUZdjzWzm9xR5IIoMvD5v3oAyAVIO3cwRzORgKHx71e982IVhZFOAlKHkELn2GvQsm5dGg0Umli00rxnB6zFl";
        Map<String, Object> params = new HashMap<>();
        params.put(
                "customer", customerId
        );
        RequestOptions options = RequestOptions.getDefault();
        EphemeralKey.create(params, options);
    }
//demand Mtc and pay them from stripe
    public String createPaymentIntent(Integer Mtc, String customerId) throws StripeException {
        Stripe.apiKey = "sk_test_51KYVo2FCSQ0FKZUZdjzWzm9xR5IIoMvD5v3oAyAVIO3cwRzORgKHx71e982IVhZFOAlKHkELn2GvQsm5dGg0Umli00rxnB6zFl";
        Integer amount = this.convertMtcToDollar(Mtc);
        List<Object> paymentMethodTypes
                = new ArrayList<>();
        paymentMethodTypes.add("card");
        Map<String, Object> params = new HashMap<>();
        params.put("amount", amount * 100);
        params.put("customer", customerId);
        params.put("currency", "usd");
        params.put(
                "payment_method_types",
                paymentMethodTypes
        );

        PaymentIntent paymentIntent = PaymentIntent.create(params);
        return paymentIntent.getId();
        
    }
    //this method is called to verify if intent is payed on stripe
    public Boolean verifIfIntentPayed(String intentId) throws StripeException{
        Stripe.apiKey = "sk_test_51KYVo2FCSQ0FKZUZdjzWzm9xR5IIoMvD5v3oAyAVIO3cwRzORgKHx71e982IVhZFOAlKHkELn2GvQsm5dGg0Umli00rxnB6zFl";
        PaymentIntent paymentIntent = PaymentIntent.retrieve(intentId);
        return paymentIntent.getStatus().equals("succeeded");
    }
    //convert Mtc to dollar
    public Integer convertMtcToDollar(Integer Mtc) {
        return Mtc * 30;
    }
// pay intent in stripe and return payment status that will be used to verify if the intent is payed if it is charge MTc
    public Boolean payOrder(String intentId) throws StripeException {
        Stripe.apiKey = "sk_test_51KYVo2FCSQ0FKZUZdjzWzm9xR5IIoMvD5v3oAyAVIO3cwRzORgKHx71e982IVhZFOAlKHkELn2GvQsm5dGg0Umli00rxnB6zFl";
        PaymentIntent paymentIntent = PaymentIntent.retrieve(intentId);
        Map<String, Object> params = new HashMap<>();
        params.put("payment_method", "pm_card_visa");

        PaymentIntent updatedPaymentIntent
                = paymentIntent.confirm(params);
        return this.verifIfIntentPayed(intentId);
        
    }

}
