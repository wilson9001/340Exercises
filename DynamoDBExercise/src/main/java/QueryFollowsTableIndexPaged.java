import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

import java.util.HashMap;
import java.util.Map;

public class QueryFollowsTableIndexPaged extends QueryFollowTableCommon
{
    private static int pageNumber;

    private static QuerySpec createQuery(Map<String, AttributeValue> lastEvaluatedKey)
    {
        Map<String, Object> valueMap = new HashMap<>();
        valueMap.put(":fe", hashKeyValueForSearch);

        QuerySpec spec = new QuerySpec().withKeyConditionExpression(String.format("%s = :fe", followTableIndexHashKey)).withValueMap(valueMap).withScanIndexForward(true).withMaxResultSize(maxPageSize);

        if(lastEvaluatedKey != null)
        {
            spec.withExclusiveStartKey(followTableIndexHashKey, lastEvaluatedKey.get(followTableIndexHashKey).getS(), followTableIndexRangeKey, lastEvaluatedKey.get(followTableIndexRangeKey).getS());
        }

        return spec;
    }

    private static Map<String, AttributeValue> processItems(ItemCollection<QueryOutcome> items)
    {
        System.out.println(String.format("Printing page %d", ++pageNumber));

        for (Item item : items)
        {
            System.out.println(item.toJSONPretty());
        }

        Map<String, AttributeValue> lastEvaluatedKey = items.getLastLowLevelResult().getQueryResult().getLastEvaluatedKey();

        if(lastEvaluatedKey == null)
        {
            System.out.println("lastEvaluatedKey is null!");
        }
        else
        {
            System.out.println(String.format("lastEvaluatedKey is: %s:%s %s:%s", followTableIndexHashKey, lastEvaluatedKey.get(followTableIndexHashKey).toString(), followTableIndexRangeKey, lastEvaluatedKey.get(followTableIndexRangeKey).toString()));
        }

        return lastEvaluatedKey;
    }

    public static void main(String[] args)
    {
        pageNumber = 0;

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_WEST_2).build();
        DynamoDB dynamoDB = new DynamoDB(client);
        Index index = dynamoDB.getTable(followsTableName).getIndex(followsTableIndexName);

        try
        {
            Map<String, AttributeValue> lastEvaluatedKey = null;

            do
            {
                QuerySpec spec = createQuery(lastEvaluatedKey);
                ItemCollection<QueryOutcome> items = index.query(spec);
                lastEvaluatedKey = processItems(items);
            } while (lastEvaluatedKey != null);
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
