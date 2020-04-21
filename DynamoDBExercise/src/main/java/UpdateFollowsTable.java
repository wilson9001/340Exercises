import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.UpdateItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.ReturnValue;

public class UpdateFollowsTable extends FollowsTableCommon
{
    private static final String updatedFollowerName = "User 0 Updated";
    private static final String updatedFolloweeName = "User 1 Updated";

    public static void main(String[] args)
    {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_WEST_2).build();
        DynamoDB dynamoDB = new DynamoDB(client);
        Table table = dynamoDB.getTable(followsTableName);

        UpdateItemSpec updateItemSpec = new UpdateItemSpec()
                .withPrimaryKey(hashKey, hashKeyValue, rangeKey, rangeKeyValue)
                .withUpdateExpression(String.format("set %s = :fr, %s = :fe", followerNameKey, followeeNameKey))
                .withValueMap(new ValueMap().withString(":fr", updatedFollowerName).withString(":fe", updatedFolloweeName))
                .withReturnValues(ReturnValue.UPDATED_NEW);

        try
        {
            UpdateItemOutcome outcome = table.updateItem(updateItemSpec);
            System.out.println("UpdateItem succeeded:\n".concat(outcome.getItem().toJSONPretty()));
        }
        catch (Exception e)
        {
            System.err.println("Unable to update item: ".concat(hashKey).concat(" ").concat(rangeKey));
            System.err.println(e.getMessage());
        }
    }
}
