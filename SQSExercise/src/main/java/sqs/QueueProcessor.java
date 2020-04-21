package sqs;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;

public class QueueProcessor implements RequestHandler<SQSEvent, Void>
{

    @Override
    public Void handleRequest(SQSEvent sqsEvent, Context context)
    {
        for (SQSEvent.SQSMessage msg : sqsEvent.getRecords())
        {
            System.out.println("SQS Event Message:");
            System.out.println(msg.toString());
        }

        return null;
    }
}
