package demoproject.rest.dto.asm;

import demoproject.core.service.util.BlogEntryList;
import demoproject.rest.controller.BlogController;
import demoproject.rest.dto.BlogEntryDto;
import demoproject.rest.dto.BlogEntryListDto;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

/**
 * Created by sandeep kulkarni on 7/6/2015.
 */
public class BlogEntryListDtoAsm extends ResourceAssemblerSupport<BlogEntryList, BlogEntryListDto> {
    public BlogEntryListDtoAsm() {
        super(BlogController.class, BlogEntryListDto.class);
    }

    @Override
    public BlogEntryListDto toResource(BlogEntryList list) {
        List<BlogEntryDto> resources = new BlogEntryDtoAsm().toResources(list.getEntries());
        BlogEntryListDto listResource = new BlogEntryListDto();
        listResource.setEntries(resources);
        listResource.add(linkTo(methodOn(BlogController.class).findAllBlogEntries(list.getBlogId())).withSelfRel());
        return listResource;
    }
}