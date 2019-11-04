package com.okta.springbootjetty;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class WebController {

    private List<String> hikes = new ArrayList<>(Arrays.asList(
            "Wonderland Trail", "South Maroon Peak", "Tour du Mont Blanc",
            "Teton Crest Trail", "Everest Base Camp via Cho La Pass", "Kesugi Ridge"
    ));

    @GetMapping("/")
    @ResponseBody
    public String indexGet() {
        return String.join("\n", this.hikes);
    }

    @PreAuthorize("isAuthenticated")
    @PostMapping("/")
    @ResponseBody
    public String indexPost(@RequestParam String hike, HttpServletResponse response) {
        if (hike == null) {
            response.setStatus(400);
            return "Param 'hike' cannot be null.";
        } else if (this.hikes.contains(hike)) {
            response.setStatus(400);
            return "The hike '" + hike + "' already exists.";
        } else {
            this.hikes.add(hike);
            return String.join("\n", this.hikes);
        }
    }

    @PreAuthorize("isAuthenticated")
    @DeleteMapping("/")
    @ResponseBody
    public String indexDelete(@RequestParam String hike, HttpServletResponse response) {
        if (hike == null) {
            response.setStatus(400);
            return "Param 'hike' cannot be null.";
        } else {
            this.hikes.remove(hike);
            return String.join("\n", this.hikes);
        }
    }

}
