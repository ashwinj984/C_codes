class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> emps = new HashMap<>();
        for(Employee emp : employees) {
            emps.put(emp.id, emp);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);
        int importance = 0;
        
        while(!queue.isEmpty()) {
            int curID = queue.poll();
            Employee emp = emps.get(curID);
            importance += emp.importance;
            
            for(int subID : emp.subordinates) {
                queue.offer(subID);
            }
        }
        
        return importance;
    }
}
