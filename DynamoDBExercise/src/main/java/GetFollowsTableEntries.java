import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;

public class GetFollowsTableEntries extends FollowsTableCommon
{
    public static void main(String[] args)
    {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_WEST_2).build();

        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable(followsTableName);

        GetItemSpec spec = new GetItemSpec().withPrimaryKey(hashKey, hashKeyValue, rangeKey, rangeKeyValue);

        try
        {
            Item outcome = table.getItem(spec);
            System.out.println("GetItem succeeded".concat(outcome.toString()));
        }
        catch (Exception e)
        {
            System.err.println(String.format("Unable to read item: {\"%s\":\"%s\", \"%s\":\"%s\""));
            System.err.println(String.format(e.getMessage()));
        }
    }
}
