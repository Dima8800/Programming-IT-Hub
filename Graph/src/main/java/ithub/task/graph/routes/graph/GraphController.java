package ithub.task.graph.routes.graph;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//*
// A B C D E
// | A B 10
// | B C 20
// | C D -10
// | D E
// | B A
// */

@RestController
@RequestMapping("/vector")
public class GraphController {
    private final GraphService graphService;

    public GraphController(GraphService graphService) {
        this.graphService = graphService;
    }

    @PostMapping("/GenerateSvgByVertex")
    public String GenerateSvgByVertex(@RequestBody String request){
        return graphService.GenerateSVGByStringForGraph(request);
    }
}
