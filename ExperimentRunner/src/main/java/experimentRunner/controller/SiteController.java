

package experimentRunner.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
public class SiteController {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/home")
    public String home() {
        return "index";
    }

}
