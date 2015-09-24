package demoproject.rest.dto;

import org.springframework.hateoas.ResourceSupport;

import java.util.List;

/**
 * Created by sandeep kulkarni on 7/6/2015.
 */
public class BlogEntryListDto extends ResourceSupport {
    private String title;

    private List<BlogEntryDto> entries;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<BlogEntryDto> getEntries() {
        return entries;
    }

    public void setEntries(List<BlogEntryDto> entries) {
        this.entries = entries;
    }
}
