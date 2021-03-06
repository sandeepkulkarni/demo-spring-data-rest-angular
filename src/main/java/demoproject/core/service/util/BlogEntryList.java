package demoproject.core.service.util;

import demoproject.core.entity.BlogEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sandeep kulkarni on 7/6/2015.
 */
public class BlogEntryList {
    private List<BlogEntry> entries = new ArrayList<BlogEntry>();
    private Long blogId;

    public List<BlogEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<BlogEntry> entries) {
        this.entries = entries;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }
}