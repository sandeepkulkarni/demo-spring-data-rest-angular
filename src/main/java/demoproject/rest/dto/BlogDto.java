package demoproject.rest.dto;

import demoproject.core.entity.Blog;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by sandeep kulkarni on 7/5/2015.
 */
public class BlogDto extends ResourceSupport {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Blog toBlog() {
        Blog blog = new Blog();
        blog.setTitle(title);
        return blog;
    }
}
