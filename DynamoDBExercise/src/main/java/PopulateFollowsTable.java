import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;

import java.util.HashMap;
import java.util.Map;

public class PopulateFollowsTable extends FollowsTableCommon
{
    public static void main(String[] args)
    {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_WEST_2).build();

        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable(followsTableName);

        //final Map<String, String> infoMap = new HashMap<String, String>();

        for(int followerNumber = 0; followerNumber < totalNumberedUsers; followerNumber++)
        {
            for(int followeeNumber = 0; followeeNumber < totalNumberedUsers; followeeNumber++)
            {
                if (followerNumber != followeeNumber)
                {
                    try
                    {
                        PutItemOutcome outcome = table.putItem(new Item()
                                .withPrimaryKey(hashKey, String.format("@User%d", followerNumber), rangeKey, String.format("@User%d", followeeNumber))
                                .withString(followerNameKey, String.format("User %d", followerNumber))
                                .withString(followeeNameKey, String.format("User %d", followeeNumber)));

                        System.out.println("PutItem succeeded: \n".concat(outcome.getPutItemResult().toString()));
                    }
                    catch (Exception e)
                    {
                        System.err.println(String.format("Unable to add item: { \"%s\":\"@User%d\", \"%s\":\"@User%d\", \"%s\":\"User %d\", \"%s\":\"User %d\" }",
                                hashKey, followerNumber,
                                rangeKey, followeeNumber,
                                followerNameKey, followerNumber,
                                followeeNameKey, followeeNumber));
                        System.err.println(e.getMessage());
                    }
                }
            }
        }
    }
}
