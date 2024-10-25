package edu.au.cpsc.module7;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class PolygraphDatabase implements Serializable {
    private List<ScheduledPolygraph> polygraphs;

    public PolygraphDatabase() {
        polygraphs = new ArrayList<>();
    }
    public List<ScheduledPolygraph> getScheduledPolygraphs() {
        return polygraphs;
    }
    public void addScheduledPolygraph(ScheduledPolygraph sf) {
        polygraphs.add(sf);
    }
    public void removeScheduledPolygraph(ScheduledPolygraph sf) {
        polygraphs.remove(sf);
    }
    public void updateScheduledPolygraph(ScheduledPolygraph sf) {

    }
}
