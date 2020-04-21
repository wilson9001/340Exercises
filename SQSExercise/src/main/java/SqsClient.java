import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;

public class SqsClient
{
    public static void main(String[] args)
    {
        String messageBody = "This is a test post";
        String queueUrl = "https://sqs.us-west-2.amazonaws.com/073776183233/PostStatus";

        SendMessageRequest sendMessageRequest = new SendMessageRequest().withQueueUrl(queueUrl).withMessageBody(messageBody).withDelaySeconds(5);

        AmazonSQS sqs = AmazonSQSClientBuilder.standard().withRegion(Regions.US_WEST_2).build();

        SendMessageResult sendMessageResult = sqs.sendMessage(sendMessageRequest);

        String messageID = sendMessageResult.getMessageId();

        System.out.println("Message ID: " + messageID);
    }
}
