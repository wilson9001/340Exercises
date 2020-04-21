public abstract class FollowsTableCommon
{
    protected static final String followsTableName = "follows";
    protected static final String hashKey = "follower_handle";
    protected static final String followerNameKey = "follower_name";
    protected static final String rangeKey = "followee_handle";
    protected static final String followeeNameKey = "followee_name";
    protected static final int totalNumberedUsers = 10;
    protected static final String hashKeyValue = "@User0";
    protected static final String rangeKeyValue = "@User1";
}
