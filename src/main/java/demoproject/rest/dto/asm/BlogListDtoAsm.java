package demoproject.rest.dto.asm;

import demoproject.core.service.util.BlogList;
import demoproject.rest.controller.BlogController;
import demoproject.rest.dto.BlogListDto;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

/**
 * Created by sandeep kulkarni on 7/6/2015.
 */
public class BlogListDtoAsm extends ResourceAssemblerSupport<BlogList, BlogListDto> {

    public BlogListDtoAsm()
    {
        super(BlogController.class, BlogListDto.class);
    }

    @Override
    public BlogListDto toResource(BlogList blogList) {
        BlogListDto res = new BlogListDto();
        res.setBlogs(new BlogDtoAsm().toResources(blogList.getBlogs()));
        return res;
    }
}
