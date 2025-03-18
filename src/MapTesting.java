import java.util.*;
import java.util.stream.Collectors;

public class MapTesting {

    public static void main(String[] args) {
        Map<Integer, Employee> map = new HashMap<>();
        Employee e1 = new Employee(1, "deepak");
        Employee e2 = new Employee(4, "amit");
        Employee e3 = new Employee(3, "charu");

        map.put(21, e1);
        map.put(11, e2);
        map.put(15, e3);

        System.out.println("before sorting ----------- "+map);
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
        System.out.println("===================================");
        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing((Employee::getId))))
                .forEach(System.out::println);

        System.out.println("=====================================");

        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(Employee::getName)))
                .forEach(System.out::println);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(e1);employeeList.add(e2);employeeList.add(e3);

        System.out.println(employeeList);

        List<Employee> updatedList = employeeList.stream().sorted(Comparator.comparing(Employee::getId)).collect(Collectors.toList());
        System.out.println(updatedList);
    }
}

class Employee {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return this.name + " == "+this.id;
    }

}

