import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class QueryFollowsTable extends QueryFollowTableCommon
{
    public static void main(String[] args)
    {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_WEST_2).build();
        DynamoDB dynamoDB = new DynamoDB(client);
        Table table = dynamoDB.getTable(followsTableName);

        Map<String, Object> valueMap = new HashMap<>();
        valueMap.put(":fr", hashKeyValueForSearch);

        QuerySpec spec = new QuerySpec().withKeyConditionExpression(String.format("%s = :fr", hashKey)).withValueMap(valueMap).withScanIndexForward(true);

        ItemCollection<QueryOutcome> items;
        Iterator<Item> itemIterator;
        Item item;

        try
        {
            items = table.query(spec);

            itemIterator = items.iterator();
            while (itemIterator.hasNext())
            {
                item = itemIterator.next();
                System.out.println(item.getString(hashKey).concat(" ").concat(item.getString(rangeKey).concat(" ").concat(item.getString(followerNameKey).concat(" ").concat(item.getString(followeeNameKey)))));
            }
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
}
