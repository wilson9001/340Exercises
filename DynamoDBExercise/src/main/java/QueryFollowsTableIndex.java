import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class QueryFollowsTableIndex extends QueryFollowTableCommon
{
    public static void main(String[] args)
    {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_WEST_2).build();
        DynamoDB dynamoDB = new DynamoDB(client);
        Index index = dynamoDB.getTable(followsTableName).getIndex(followsTableIndexName);

        Map<String, Object> valueMap = new HashMap<>();
        valueMap.put(":fe", hashKeyValueForSearch);

        QuerySpec spec = new QuerySpec().withKeyConditionExpression(String.format("%s = :fe", followTableIndexHashKey)).withValueMap(valueMap).withScanIndexForward(false);

        ItemCollection<QueryOutcome> items;
        Iterator<Item> itemIterator;
        Item item;

        try
        {
            items = index.query(spec);

            itemIterator = items.iterator();
            while (itemIterator.hasNext())
            {
                item = itemIterator.next();
                System.out.println(item.getString(followTableIndexHashKey).concat(" ").concat(item.getString(followTableIndexRangeKey).concat(" ").concat(item.getString(followeeNameKey).concat(" ").concat(item.getString(followerNameKey)))));
            }
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
}
