package demoproject.rest.controller;

import demoproject.core.entity.Blog;
import demoproject.core.entity.BlogEntry;
import demoproject.core.service.BlogService;
import demoproject.core.service.exception.BlogNotFoundException;
import demoproject.core.service.util.BlogEntryList;
import demoproject.core.service.util.BlogList;
import demoproject.rest.dto.BlogDto;
import demoproject.rest.dto.BlogEntryDto;
import demoproject.rest.dto.BlogEntryListDto;
import demoproject.rest.dto.BlogListDto;
import demoproject.rest.dto.asm.BlogDtoAsm;
import demoproject.rest.dto.asm.BlogEntryDtoAsm;
import demoproject.rest.dto.asm.BlogEntryListDtoAsm;
import demoproject.rest.dto.asm.BlogListDtoAsm;
import demoproject.rest.exception.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.URI;

/**
 * Created by sandeep kulkarni on 7/5/2015.
 */
@Controller
@RequestMapping("/rest/blogs")
public class BlogController {
    private BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<BlogListDto> findAllBlogs() {
        BlogList blogList = blogService.findAllBlogs();
        BlogListDto blogListRes = new BlogListDtoAsm().toResource(blogList);
        return new ResponseEntity<BlogListDto>(blogListRes, HttpStatus.OK);
    }


    @RequestMapping(value="/{blogId}", method = RequestMethod.GET)
    public ResponseEntity<BlogDto> getBlog(@PathVariable Long blogId) {
        Blog blog = blogService.findBlog(blogId);
        BlogDto res = new BlogDtoAsm().toResource(blog);
        return new ResponseEntity<BlogDto>(res, HttpStatus.OK);
    }

    @RequestMapping(value="/{blogId}/blog-entries", method = RequestMethod.POST)
    public ResponseEntity<BlogEntryDto> createBlogEntry(@PathVariable Long blogId,
                                                        @RequestBody BlogEntryDto sentBlogEntry) {
        BlogEntry createdBlogEntry = null;
        try {
            createdBlogEntry = blogService.createBlogEntry(blogId, sentBlogEntry.toBlogEntry());
            BlogEntryDto createdResource = new BlogEntryDtoAsm().toResource(createdBlogEntry);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(createdResource.getLink("self").getHref()));
            return new ResponseEntity<BlogEntryDto>(createdResource, headers, HttpStatus.CREATED);
        } catch (BlogNotFoundException e) {
            throw new NotFoundException(e);
        }
    }

    @RequestMapping(value="/{blogId}/blog-entries")
    public ResponseEntity<BlogEntryListDto> findAllBlogEntries(@PathVariable Long blogId) {
        try {
            BlogEntryList list = blogService.findAllBlogEntries(blogId);
            BlogEntryListDto res = new BlogEntryListDtoAsm().toResource(list);
            return new ResponseEntity<BlogEntryListDto>(res, HttpStatus.OK);
        } catch(BlogNotFoundException exception)
        {
            throw new NotFoundException(exception);
        }
    }


}
