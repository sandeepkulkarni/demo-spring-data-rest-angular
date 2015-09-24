package demoproject.rest.dto.asm;

import demoproject.core.entity.Blog;
import demoproject.rest.controller.AccountController;
import demoproject.rest.controller.BlogController;
import demoproject.rest.dto.BlogDto;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
/**
 * Created by sandeep kulkarni on 7/5/2015.
 */
public class BlogDtoAsm extends ResourceAssemblerSupport<Blog, BlogDto> {
    public BlogDtoAsm() {
        super(BlogController.class, BlogDto.class);
    }

    @Override
    public BlogDto toResource(Blog blog) {
        BlogDto resource = new BlogDto();
        resource.setTitle(blog.getTitle());
        resource.add(linkTo(BlogController.class).slash(blog.getBlogId()).withSelfRel());
        resource.add(linkTo(BlogController.class).slash(blog.getBlogId()).slash("entries").withRel("entries"));
        if(blog.getOwner() != null)
            resource.add(linkTo(AccountController.class).slash(blog.getOwner().getAccountId()).withRel("owner"));
        return resource;
    }
}
