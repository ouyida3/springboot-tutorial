package com.example.demo.object;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class NeighbourNode {

    private String enRoadNodeId;
    private String exRoadNodeId;

    /**
     * IDEA自动生成后修改。
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        NeighbourNode that = (NeighbourNode) o;

//        return Objects.equals(enRoadNodeId, that.enRoadNodeId) &&
//                Objects.equals(exRoadNodeId, that.exRoadNodeId);

        return enRoadNodeId.equals(that.enRoadNodeId) &&
                exRoadNodeId.equals(that.exRoadNodeId);
    }

    /**
     * IDEA自动生成后修改。
     */
    @Override
    public int hashCode() {
        // 该方案效率中等
//        return Objects.hash(enRoadNodeId, exRoadNodeId);

        // 该方案效率较高
        int result = enRoadNodeId.hashCode();
        return result * 31 + exRoadNodeId.hashCode();
    }

    /**
     * IDEA自动生成。
     */
    @Override
    public String toString() {
        return "NeighbourNode{" +
                "enRoadNodeId='" + enRoadNodeId + '\'' +
                ", exRoadNodeId='" + exRoadNodeId + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Map<NeighbourNode, Integer> map = new HashMap<>();

        NeighbourNode neighbourNode = new NeighbourNode();
        neighbourNode.setEnRoadNodeId("1234507400000300");
        neighbourNode.setExRoadNodeId("1234507400009230");
        map.put(neighbourNode, 7500);

        NeighbourNode neighbourNode2 = new NeighbourNode();
        neighbourNode2.setEnRoadNodeId("1234507400000300");
        neighbourNode2.setExRoadNodeId("1234507400009230");
        int result = map.get(neighbourNode2);

        System.out.println(result);
    }
}
