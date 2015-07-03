package demoproject.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sandeep kulkarni on 7/3/2015.
 */
@Controller
public class TestController {

    @RequestMapping("/test")
    public String test() {
        return "view";
    }

    @RequestMapping("/index")
    public String indexFile() {
        return "index";
    }
}
