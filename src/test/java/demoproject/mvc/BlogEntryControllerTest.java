package demoproject.mvc;

import demoproject.core.entity.BlogEntry;
import demoproject.core.service.BlogEntryService;
import demoproject.rest.controller.BlogEntryController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Created by sandeep kulkarni on 7/3/2015.
 */
public class BlogEntryControllerTest {

    @InjectMocks
    private BlogEntryController blogEntryController;

    @Mock
    private BlogEntryService blogEntryService;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(blogEntryController).build();
    }

    @Test
    public void test() throws Exception {

        //Build the test request
        //Do post of below sample request and using json path verify that the title sent is what we get
        mockMvc.perform(post("/test")
                        .content("{\"title\":\"My Test Blog Title\"}")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(jsonPath("$.title", is("My Test Blog Title")))
            .andDo(print());
    }

    @Test
    public void getExistingBlogEntry() throws Exception {
        BlogEntry entry = new BlogEntry();
        entry.setBlogEntryId(1L);
        entry.setTitle("Test Title");

        when(blogEntryService.find(1L)).thenReturn(entry);

        mockMvc.perform(get("/rest/blog-entries/1"))
                .andExpect(jsonPath("$.title", is(entry.getTitle())))
                .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/rest/blog-entries/1"))))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void getNonExistingBlogEntry() throws Exception {
        when(blogEntryService.find(1L)).thenReturn(null);

        mockMvc.perform(get("/rest/blog-entries/1"))
                .andExpect(status().isNotFound());
    }

}

