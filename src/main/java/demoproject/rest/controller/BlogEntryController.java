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
public class BlogEntryController {

    private BlogEntryService blogEntryService;

    public BlogEntryController(BlogEntryService blogEntryService){
        this.blogEntryService = blogEntryService;
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public @ResponseBody BlogEntry test(@RequestBody BlogEntry blogEntry) {
//        BlogEntry blogEntry = new BlogEntry();
//        blogEntry.setTitle("Test title of Blog");
        return blogEntry;
    }
//
//    @RequestMapping("/index")
//    public String indexFile() {
//        return "index";
//    }

    @RequestMapping(value = "/rest/blog-entries/{blogEntryId}", method = RequestMethod.GET)
    public ResponseEntity<BlogEntryDto> getBlogEntry(@PathVariable Long blogEntryId){
        BlogEntry blogEntry = blogEntryService.find(blogEntryId);
        if(blogEntry != null)
        {
            BlogEntryDto dto = new BlogEntryDtoAsm().toResource(blogEntry);
            return new ResponseEntity<BlogEntryDto>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<BlogEntryDto>(HttpStatus.NOT_FOUND);
        }
    }
}
