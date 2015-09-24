package demoproject.core.service;

import demoproject.core.entity.Blog;
import demoproject.core.entity.BlogEntry;
import demoproject.core.service.util.BlogEntryList;
import demoproject.core.service.util.BlogList;

import java.util.List;

/**
 * Created by sandeep kulkarni on 7/5/2015.
 */
public interface BlogService {
    public BlogEntry createBlogEntry(Long blogId, BlogEntry data);

    // find all Blogs
    public BlogList findAllBlogs();

    // find all blog entries associated with blog
    public BlogEntryList findAllBlogEntries(Long blogId);

    public Blog findBlog(Long blogId);
}
