package demoproject.rest.dto;

import demoproject.core.entity.BlogEntry;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by sandeep kulkarni on 7/4/2015.
 */
public class BlogEntryDto extends ResourceSupport {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BlogEntry toBlogEntry() {
        BlogEntry entry = new BlogEntry();
        entry.setTitle(title);
        return entry;
    }
}
