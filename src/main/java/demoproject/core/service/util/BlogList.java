package demoproject.core.service.util;

import demoproject.core.entity.Blog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sandeep kulkarni on 7/6/2015.
 */
public class BlogList {

    private List<Blog> blogs = new ArrayList<Blog>();

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
