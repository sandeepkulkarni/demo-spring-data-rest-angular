package demoproject.core.entity;

/**
 * Created by sandeep kulkarni on 7/5/2015.
 */
public class Blog {
    private Long blogId;
    private String title;
    private Account owner;

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Account getOwner() {
        return owner;
    }

    public void setOwner(Account owner) {
        this.owner = owner;
    }
}
