package demoproject.rest.dto.asm;

import demoproject.core.entity.BlogEntry;
import demoproject.rest.controller.BlogEntryController;
import demoproject.rest.dto.BlogEntryDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
/**
 * Created by sandeep kulkarni on 7/4/2015.
 */
public class BlogEntryDtoAsm extends ResourceAssemblerSupport<BlogEntry, BlogEntryDto> {

    public BlogEntryDtoAsm(){
        super(BlogEntryController.class, BlogEntryDto.class);
    }

    @Override
    public BlogEntryDto toResource(BlogEntry blogEntry) {
        BlogEntryDto blogEntryDto = new BlogEntryDto();
        blogEntryDto.setTitle(blogEntry.getTitle());
        Link link = linkTo(methodOn(BlogEntryController.class).getBlogEntry(blogEntry.getBlogEntryId())).withSelfRel();
        blogEntryDto.add(link.withSelfRel());
        return blogEntryDto;
    }
}
