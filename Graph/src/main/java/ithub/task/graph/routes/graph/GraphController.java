package ithub.task.graph.routes.graph;

import org.springframework.web.bind.annotation.*;

//*
// A B C D E
// | A B 10
// | B C 20
// | C D 10
// | D E 5
// | B A 2
// */

@RestController
@RequestMapping("/graph")
public class GraphController {
    private final GraphService graphService;

    public GraphController(GraphService graphService) {
        this.graphService = graphService;
    }

    @PostMapping("/GenerateSvgByVertex")
    public String GenerateSvgByVertex(@RequestBody String request){
        return graphService.GenerateSVGByStringForGraph(request);
    }

    @GetMapping("/NextStep/{step}")
    public String NextStep(@PathVariable Integer step){
        return graphService.NextStep(step);
    }
}
