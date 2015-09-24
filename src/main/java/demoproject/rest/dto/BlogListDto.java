package demoproject.rest.dto;

import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sandeep kulkarni on 7/6/2015.
 */
public class BlogListDto extends ResourceSupport {
    private List<BlogDto> blogs = new ArrayList<BlogDto>();

    public List<BlogDto> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<BlogDto> blogs) {
        this.blogs = blogs;
    }
}
