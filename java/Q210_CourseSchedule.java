/**
 * @author stingchang
 * */

package com.leet.q201;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Q210_CourseSchedule {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		// step 1: build a graph
		Graph graph = new Graph(numCourses);
		for (int p = 0; p < prerequisites.length; p++) {
			graph.addPrerequisite(prerequisites[p][0], prerequisites[p][1]);
		}
		Deque<Integer> queue = new ArrayDeque<>();
		// step 2: do dfs for all nodes and put into queue
		for (int i = 0; i < graph.courses.size(); i++) {
			if (graph.state.get(i) == -1) {
				dfs(i, graph, queue);
			}
			//
			else if (graph.state.get(i) == 0) {
				int[] result = new int[0];
				return result;
			}
		}
		int count = 0;
		int[] result = new int[queue.size()];
		while (!queue.isEmpty()) {
			result[count++] = queue.removeLast();
		}
		return result;
	}

	public void dfs(int i, Graph graph, Deque<Integer> queue) {
		graph.state.put(i,0);// visiting
		if (graph.prerequisiteList.containsKey(i)) {
			for (int pre : graph.prerequisiteList.get(i)) {
				if (graph.state.get(pre) == -1) {
					dfs(pre, graph, queue);
				} else if (graph.state.get(pre) == 0) {
					return;
				}
			}
		}

		queue.addFirst(i);
		graph.state.put(i, 1);
	}

	class Graph {
		List<Integer> courses;
		Map<Integer, Integer> state; // -1 not visited, 0 visiting, 1 visited
		// Map<Integer, Boolean> visiting; // traversed state
		Map<Integer, Set<Integer>> prerequisiteList;

		public Graph(int course) {
			courses = new ArrayList<>();
			state = new HashMap<>();
			for (int i = 0; i < course; i++) {
				courses.add(i);
				state.put(i, -1);
			}
			prerequisiteList = new HashMap<>();

		}

		public void addPrerequisite(int course, int prerequisite) {
			if (!prerequisiteList.containsKey(course)) {
				Set<Integer> set = new HashSet<>();
				set.add(prerequisite);
				prerequisiteList.put(course, set);
			} else {
				prerequisiteList.get(course).add(prerequisite);
			}

		}
	}

	public static void main(String[] args) {
		Q210_CourseSchedule q = new Q210_CourseSchedule();
		int[][] prerequisites = { { 0, 1 }, { 1, 0 } };
		int[] order = q.findOrder(2, prerequisites);
		System.out.println(Arrays.toString(order));

	}
}
