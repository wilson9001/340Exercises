public abstract class QueryFollowTableCommon extends FollowsTableCommon
{
    protected static final String followsTableIndexName = "follows_index";
    protected static final String followTableIndexHashKey = "followee_handle";
    protected static final String followTableIndexRangeKey = "follower_handle";
    protected static final String hashKeyValueForSearch = "@User1";
    protected static final int maxPageSize = 5;
}
