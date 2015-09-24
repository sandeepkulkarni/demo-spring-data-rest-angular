package demoproject.rest.controller;

import demoproject.core.entity.BlogEntry;
import demoproject.core.service.BlogEntryService;
import demoproject.rest.dto.BlogEntryDto;
import demoproject.rest.dto.asm.BlogEntryDtoAsm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sandeep kulkarni on 7/3/2015.
 */
@Controller
@RequestMapping("/rest/blog-entries")
public class BlogEntryController {
    private BlogEntryService service;

    public BlogEntryController(BlogEntryService service)
    {
        this.service = service;
    }

    @RequestMapping(value="/{blogEntryId}", method = RequestMethod.GET)
    public ResponseEntity<BlogEntryDto> getBlogEntry(@PathVariable Long blogEntryId) {
        BlogEntry entry = service.findBlogEntry(blogEntryId);
        if(entry != null) {
            BlogEntryDto blogEntryDto = new BlogEntryDtoAsm().toResource(entry);
            return new ResponseEntity<BlogEntryDto>(blogEntryDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<BlogEntryDto>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/{blogEntryId}",method = RequestMethod.DELETE)
    public ResponseEntity<BlogEntryDto> deleteBlogEntry(@PathVariable Long blogEntryId) {
        BlogEntry entry = service.deleteBlogEntry(blogEntryId);
        if(entry != null) {
            BlogEntryDto blogEntryDto = new BlogEntryDtoAsm().toResource(entry);
            return new ResponseEntity<BlogEntryDto>(blogEntryDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<BlogEntryDto>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/{blogEntryId}", method = RequestMethod.PUT)
    public ResponseEntity<BlogEntryDto> updateBlogEntry(@PathVariable Long blogEntryId,
                                                        @RequestBody BlogEntryDto sentBlogEntry) {
        BlogEntry updatedEntry = service.updateBlogEntry(blogEntryId, sentBlogEntry.toBlogEntry());
        if(updatedEntry != null) {
            BlogEntryDto res = new BlogEntryDtoAsm().toResource(updatedEntry);
            return new ResponseEntity<BlogEntryDto>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<BlogEntryDto>(HttpStatus.NOT_FOUND);
        }
    }
}
