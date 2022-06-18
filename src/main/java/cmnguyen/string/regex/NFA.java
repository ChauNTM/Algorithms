package main.java.cmnguyen.string.regex;

import main.java.cmnguyen.graph.digraph.Digraph;
import main.java.cmnguyen.graph.digraph.DirectedDFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NFA {
    private Digraph graph;
    private char[] re;
    private int M;

    public NFA(String regex) {
        re = regex.toCharArray();
        M = regex.length();

        Stack<Integer> stack = new Stack<>();
        graph = new Digraph(M + 1);
        for (int i=0; i < M; i++) {
            int lp = i;
            if (re[i] == '(' || re[i] == '|') stack.push(i);
            else if (re[i] == ')') {
                int or = stack.pop();
                if (re[or] == '|') {
                    lp = stack.pop();
                    graph.addEdge(lp, or + 1);
                    graph.addEdge(or, i);
                } else {
                    lp = or;
                }
            }
            if (i < M-1 && re[i+1] == '*') {
                graph.addEdge(lp, i + 1);
                graph.addEdge(i + 1, lp);
            }
            if (re[i] == '(' || re[i] == '*' || re[i] == ')')
                graph.addEdge(i, i+1);
        }
    }

    public boolean recognizes(String text) {
        List<Integer> pc = new ArrayList<>();
        DirectedDFS directedDFS = new DirectedDFS(graph, 0);
        for (int v=0; v < graph.V(); v++) {
            if (directedDFS.marked(v)) pc.add(v);
        }

        for (int i=0; i < text.length(); i++) {
            List<Integer> match = new ArrayList<>();
            for (int v: pc) {
                if (v < M && (text.charAt(i) == re[v] || re[v] == '.')) {
                    match.add(v + 1);
                }
            }
            DirectedDFS dfs = new DirectedDFS(graph, match);
            for (int v=0; v < graph.V(); v++) {
                if (dfs.marked(v)) pc.add(v);
            }
        }
        for (int v: pc) if (v == M) return true;
        return false;
    }
}
