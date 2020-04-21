import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec;

public class DeleteFollowTableEntries extends FollowsTableCommon
{
    public static void main(String[] args)
    {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_WEST_2).build();
        DynamoDB dynamoDB = new DynamoDB(client);
        Table table = dynamoDB.getTable(followsTableName);

        DeleteItemSpec spec = new DeleteItemSpec().withPrimaryKey(hashKey, hashKeyValue, rangeKey, rangeKeyValue);

        try
        {
            table.deleteItem(spec);
            System.out.println("DeleteItem succeeded");
        }
        catch (Exception e)
        {
            System.err.println("Unable to delete item: ".concat(hashKeyValue).concat(" ").concat(rangeKeyValue));
            System.err.println(e.getMessage());
        }
    }
}
