package com.leetcode.io.comp.biweek147;

import java.util.*;

public class Leetcode2 {

    static class TaskManager {

        private Map<Integer, int[]> taskMap;
        private List<int[]> taskList;


        public TaskManager(List<List<Integer>> tasks) {
            taskMap = new HashMap<>();
            taskList = new ArrayList<>();


            for (List<Integer> task : tasks) {
                int userId = task.get(0);
                int taskId = task.get(1);
                int priority = task.get(2);
                taskMap.put(taskId, new int[]{userId, priority});
                taskList.add(new int[]{taskId, userId, priority});
            }
        }


        public void add(int userId, int taskId, int priority) {
            taskMap.put(taskId, new int[]{userId, priority});
            taskList.add(new int[]{taskId, userId, priority});
        }

        public void edit(int taskId, int newPriority) {
            int[] taskInfo = taskMap.get(taskId);
            if (taskInfo != null) {
                int userId = taskInfo[0];
                taskMap.put(taskId, new int[]{userId, newPriority});
                for (int[] task : taskList) {
                    if (task[0] == taskId) {
                        task[2] = newPriority;
                        break;
                    }
                }
            }
        }

        public void rmv(int taskId) {
            int[] taskInfo = taskMap.get(taskId);
            if (taskInfo != null) {
                taskMap.remove(taskId);
                taskList.removeIf(task -> task[0] == taskId);
            }
        }

        public int execTop() {
            if (taskList.isEmpty()) {
                return -1;
            }

            // Find the task with the highest priority and highest taskId
            int[] topTask = null;
            for (int[] task : taskList) {
                if (topTask == null || task[2] > topTask[2] ||
                        (task[2] == topTask[2] && task[0] > topTask[0])) {
                    topTask = task;
                }
            }

            if (topTask != null) {
                int taskId = topTask[0];
                int userId = topTask[1];
                // Remove the executed task
                taskMap.remove(taskId);
                taskList.remove(topTask);
                return userId;
            }

            return -1;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> tasks = Arrays.asList(
                Arrays.asList(1, 101, 10),
                Arrays.asList(2, 102, 20),
                Arrays.asList(3, 103, 15)
        );

        TaskManager taskManager = new TaskManager(tasks);
        taskManager.add(4, 104, 5);
        taskManager.edit(102, 8);
        System.out.println(taskManager.execTop()); // Outputs 3
        taskManager.rmv(101);
        taskManager.add(5, 105, 15);
        System.out.println(taskManager.execTop()); // Outputs 5
    }
}