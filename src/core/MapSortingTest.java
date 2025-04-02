package core;

import java.util.HashMap;
import java.util.Map;

public class MapSortingTest {

    public static void main(String[] args) {
        Employee e1 = new Employee(23, "deepak");
        Employee e2 = new Employee(12, "kanishk");
        Employee e3 = new Employee(21, "lavanya");
        Employee e4 = new Employee(15, "shagun");

        Map<Employee, Integer> map = new HashMap<>();
        map.put(e1, 111);
        map.put(e2, 101);
        map.put(e3, 211);
        map.put(e4, 89);

        System.out.println("before sorting===========");
        System.out.println(map);

        System.out.println("sort by employee name===============");
        map.entrySet().stream().sorted(Map.Entry.comparingByKey((em1, em2) -> em1.getName().compareToIgnoreCase(em2.getName())))
                .forEach(e -> System.out.println(e));

        System.out.println("sort by employee id=================");
        map.entrySet().stream().sorted(Map.Entry.comparingByKey((em1, em2) -> em1.getId() > em2.getId() ? 1 : -1))
                .forEach(System.out::println);

        System.out.println("sort by values of map ==================");
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);


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

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
