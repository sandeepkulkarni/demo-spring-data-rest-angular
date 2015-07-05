package demoproject.core.entity;

/**
 * Created by sandeep kulkarni on 7/4/2015.
 */
public class BlogEntry {
    private Long blogEntryId;
    private String title;

    public Long getBlogEntryId() {
        return blogEntryId;
    }

    public void setBlogEntryId(Long blogEntryId) {
        this.blogEntryId = blogEntryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
