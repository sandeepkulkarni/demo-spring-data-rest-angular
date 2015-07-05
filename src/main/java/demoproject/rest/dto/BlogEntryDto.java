package demoproject.rest.dto;

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
}
