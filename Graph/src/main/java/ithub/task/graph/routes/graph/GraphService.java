package ithub.task.graph.routes.graph;

import ithub.task.graph.routes.graph.models.Edge;
import ithub.task.graph.routes.graph.models.coordinates;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GraphService {
    private HashMap<Integer, String> graphSteps = new HashMap<>();
    private HashMap<String, coordinates> coordinate = new HashMap<>();

    public String GenerateSVGByStringForGraph(String request){
        List<Edge> edges = parseGraph(request);
        return buildGraphSVG(edges);
    }

    public String NextStep(Integer step){
        try {
            return null;
        }catch (Exception err){
            throw new RuntimeException(err.getMessage());
        }
    }

    public String buildGraphSVG(List<Edge> edges) {
        StringBuilder svg = new StringBuilder();
        svg.append("<svg width=\"550\" height=\"550\">");

        svg.append("<defs>\n" +
                "    <marker\n" +
                "      id=\"arrow\"\n" +
                "      viewBox=\"0 0 10 10\"\n" +
                "      refX=\"15\"\n" +
                "      refY=\"5\"\n" +
                "      markerWidth=\"8\"\n" +
                "      markerHeight=\"8\"\n" +
                "fill=\"black\""+
                "      orient=\"auto-start-reverse\">\n" +
                "      <path d=\"M 0 0 L 10 5 L 0 10 z\" />\n" +
                "    </marker>\n" +
                "  </defs>");

        for (Edge edge : edges) {
            svg.append("<line x1=\"" + edge.getStart().getX() + "\" y1=\"" + edge.getStart().getY() + "\" x2=\"" + edge.getEnd().getX() + "\" y2=\""
                    + edge.getEnd().getY() + "\" stroke=\"black\"" + "marker-end=\"url(#arrow)\"" + "/>");

            int textX = (edge.getStart().getX() + edge.getEnd().getX()) / 2;
            int textY = (edge.getStart().getY() + edge.getEnd().getY()) / 2;
            svg.append("<text x=\"" + textX + "\" y=\"" + textY + "\" fill=\"green\">" + edge.getWeight() + "</text>");
        }

        Set<String> key = coordinate.keySet();

        for (String k:key){
            svg.append("<circle cx=\"" + coordinate.get(k).getX() +"\" " + "cy=\"" + coordinate.get(k).getY() + "\" " + " r=\"5\" fill=\"red\" />");
            svg.append("<text x=\"" + (coordinate.get(k).getX() + 8) + "\" y=\"" + (coordinate.get(k).getY() - 8) + "\">" + coordinate.get(k).getName() + "</text>");
        }

        svg.append("</svg>");
        return svg.toString();
    }

    private List<Edge> parseGraph(String input){
        try {
            Random random = new Random();
            input = input.replaceAll("\\{\"data\":\"", "")
                    .replaceAll("}", "")
                    .replaceAll("\"","");

            List<Edge> edges = new ArrayList<>();
            String bycoordinate = input.split("\\|")[0];

            for (int i = 0 ; i < bycoordinate.split(" ").length; i++){
                String name = bycoordinate.split(" ")[i];
                coordinate.put(name, new coordinates(name, random.nextInt(450), random.nextInt(450)));
            }

            for (int i = 1; i < input.split("\\|").length; i++) {
                coordinates start = coordinate.get(input.split("\\|")[i].split(" ")[0]);
                coordinates end = coordinate.get(input.split("\\|")[i].split(" ")[1]);
                edges.add(new Edge(
                        start,
                        end,
                        Integer.parseInt(input.split("\\|")[i].split(" ")[2]))
                );
            }
            return edges;
        }catch (Exception err){
            throw new RuntimeException(err.getMessage());
        }
    }
}
