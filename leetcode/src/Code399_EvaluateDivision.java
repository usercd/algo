import java.util.*;

/**
 * @author CD
 * @date 11/6/2024
 * @description
 */
public class Code399_EvaluateDivision {
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Step 1: 构建图
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(a).put(b, value);
            graph.get(b).put(a, 1.0 / value);
        }

        // Step 2: 处理查询
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);
            if (!graph.containsKey(x) || !graph.containsKey(y)) {
                results[i] = -1.0;
            } else {
                Set<String> visited = new HashSet<>();
                results[i] = dfs(graph, x, y, 1.0, visited);
            }
        }
        return results;
    }

    // DFS 递归方法
    private static double dfs(Map<String, Map<String, Double>> graph, String current, String target, double accProduct, Set<String> visited) {
        if (current.equals(target)) return accProduct;  // 找到目标节点，返回累积乘积
        visited.add(current);

        Map<String, Double> neighbors = graph.get(current);
        for (Map.Entry<String, Double> neighbor : neighbors.entrySet()) {
            String nextNode = neighbor.getKey();
            if (!visited.contains(nextNode)) {
                double result = dfs(graph, nextNode, target, accProduct * neighbor.getValue(), visited);
                if (result != -1.0) {  // 找到路径返回结果
                    return result;
                }
            }
        }

        return -1.0;  // 无法找到路径返回 -1.0
    }
}
