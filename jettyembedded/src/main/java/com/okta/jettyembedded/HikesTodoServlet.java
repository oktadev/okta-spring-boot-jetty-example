package com.okta.jettyembedded;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "HikesTodoServlet", urlPatterns = {"hikes"}, loadOnStartup = 1)
public class HikesTodoServlet extends HttpServlet {

    // Not synchronized
    private List<String> hikes = new ArrayList<>(Arrays.asList(
            "Wonderland Trail", "South Maroon Peak", "Tour du Mont Blanc",
            "Teton Crest Trail", "Everest Base Camp via Cho La Pass", "Kesugi Ridge"
    ));

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        response.getWriter().print(String.join("\n", this.hikes));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        String hike = request.getParameter("hike");
        if (hike == null) {
            response.setStatus(400);
            response.getWriter().print("Param 'hike' cannot be null.");
        }
        else if (this.hikes.contains(hike)) {
            response.setStatus(400);
            response.getWriter().print("The hike '"+hike+"' already exists.");
        }
        else {
            this.hikes.add(hike);
            response.getWriter().print(String.join("\n", this.hikes));
        }
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        String hike = request.getParameter("hike");
        if (hike == null) {
            response.setStatus(400);
            response.getWriter().print("Param 'hike' cannot be null.");
        }
        else {
            this.hikes.remove(hike);
            response.getWriter().print(String.join("\n", this.hikes));
        }
    }

}

