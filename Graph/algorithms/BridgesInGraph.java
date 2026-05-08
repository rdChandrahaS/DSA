package algorithms;

import java.util.ArrayList;
import java.util.List;

public class BridgesInGraph {
    List<List<Integer>> graph;
    int V;
    boolean isSolved;
    boolean isList;
    
    BridgesInGraph(List<List<Integer>> graph , int V, boolean isList){
        this.graph = graph;
        this.V = V;
        isSolved = false;
        this.isList = isList;
    }


    public List<List<Integer>> bridges(){
        List<List<Integer>> ans = new ArrayList<>();
        int[] arrivalTime = new int[V];
        int[] lowestTime = new int[V];
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < V ; i++){
            if(arrivalTime[i] == 0){
                dfs(i , i , arrivalTime , lowestTime , 1 , isList , list);
            }
        }
        return ans;
    }

    private int dfs(int curr, int parent, int[] arrivalTime, int[] lowestTime, int currentTime, boolean isList, List<Integer> list) {
        if(arrivalTime[curr] != 0){
            return lowestTime[curr];
        } 
        arrivalTime[curr] = lowestTime[curr] = currentTime;
        List<Integer> childs = graph.get(curr);
        if(!childs.isEmpty()){
            for(int child : childs){
                lowestTime[curr] = Math.min(lowestTime[curr] , dfs(child, curr, arrivalTime, lowestTime, currentTime , ));
            }
        }
        
    }
}