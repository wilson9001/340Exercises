package ses;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

// these are the imports for SDK v1
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.simpleemail.*;
import com.amazonaws.services.simpleemail.model.*;
import com.amazonaws.regions.Regions;

public class EmailSender {
    public EmailResult handleRequest(EmailRequest request, Context context) {

        LambdaLogger logger = context.getLogger();
        logger.log("Entering send_email");

        try {
            AmazonSimpleEmailService client =
                    AmazonSimpleEmailServiceClientBuilder.standard()

                            // Replace US_WEST_2 with the AWS Region you're using for
                            // Amazon SES.
                            .withRegion(Regions.US_WEST_2).build();

            // TODO:
            // Use the AmazonSimpleEmailService object to send an email message
            // using the values in the EmailRequest parameter object
            String fromAddress = request.from;
            List<String> toList = new ArrayList<>();
            toList.add(request.to);
            Destination destination = new Destination(toList);
            Content subject = new Content(request.subject);
            Content htmlContent = new Content(request.htmlBody);
            Body body = new Body(htmlContent);
            Message message = new Message(subject, body);
            SendEmailRequest sendRequest = new SendEmailRequest(fromAddress, destination, message);

            SendEmailResult result = client.sendEmail(sendRequest);

            logger.log("Email sent!");

            return new EmailResult(result.toString(), new Timestamp(System.currentTimeMillis()).toString());

        } catch (Exception ex) {
            logger.log("The email was not sent. Error message: " + ex.getMessage());
            throw new RuntimeException(ex);
        }
        finally {
            logger.log("Leaving send_email");
        }

        // TODO:
        // Return EmailResult
    }

}