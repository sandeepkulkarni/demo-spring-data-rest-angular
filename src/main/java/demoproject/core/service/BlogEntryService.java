package demoproject.core.service;

import demoproject.core.entity.BlogEntry;

/**
 * Created by sandeep kulkarni on 7/4/2015.
 */
public interface BlogEntryService {

    // Returns the BlogEntry or null if it can't be found
    public BlogEntry findBlogEntry(Long blogEntryId);

    // Deletes the found BlogEntry or returns null if it can't be found
    public BlogEntry deleteBlogEntry(Long blogEntryId);

    public BlogEntry updateBlogEntry(Long blogEntryId, BlogEntry blogEntry);
}
