package leetcode.thirty_days_challenge.may;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
	static class Graph {
		final int V;
		List<Integer>[] adj;

		Graph(int V) {
			this.V = V;
			adj = new ArrayList[V];
			for (int i = 0; i < V; i++)
				adj[i] = new ArrayList<>();
		}

		void addEdge(int course, int prerequisite) {
			this.adj[course].add(prerequisite);
		}
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		Graph g = new Graph(numCourses);
		for (int[] prerequisite : prerequisites)
			g.addEdge(prerequisite[0], prerequisite[1]);
		return !isCycle(g, numCourses);
	}

	private boolean isCycle(Graph g, int numCourses) {
		boolean[] visited = new boolean[numCourses], recursionStack = new boolean[numCourses];
		for (int i = 0; i < numCourses; i++)
			if (isCycle(g, i, visited, recursionStack))
				return true;
		return false;
	}

	private boolean isCycle(Graph g, int vertex, boolean[] visited, boolean[] recursionStack) {
		if (recursionStack[vertex])
			return true;
		if (visited[vertex])
			return false;
		recursionStack[vertex] = true;
		visited[vertex] = true;
		for (int i : g.adj[vertex])
			if (isCycle(g, i, visited, recursionStack))
				return true;
		recursionStack[vertex] = false;
		return false;
	}

	public static void main(String[] args) {
		System.out.println(new CourseSchedule().canFinish(2, new int[][] { { 1, 0 } }));
		System.out.println(new CourseSchedule().canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } }));
	}
}
