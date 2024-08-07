package org.example;


import org.example.entity.Employee;

import javax.imageio.plugins.tiff.ExifInteroperabilityTagSet;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(4, "Burak", "Cevizli"));
        employees.add(null);




        System.out.println(findUniques(employees));
    }
      public static List<Employee> findDuplicates(List<Employee> employee) {
        List<Employee> tekrarEtmeyenler = new LinkedList<>();
        List<Employee> tekrarEdenler = new LinkedList<>();

        for(Employee emp : employee) {
            if(!tekrarEtmeyenler.contains(emp)){
                tekrarEtmeyenler.add(emp);
        }else{
                tekrarEdenler.add(emp);
            }
      }
          return tekrarEdenler;
    }

    public static Map<Integer,Employee>  findUniques(List<Employee> employee) {
        Map<Integer,Employee> listem = new HashMap();

        for(Employee emp : employee){
            if(!findDuplicates(employee).contains(emp) && emp != null){
                listem.put(emp.getId(),emp);
            }else if(findDuplicates(employee).contains(emp) && !listem.containsKey(emp.getId())){
                listem.put(emp.getId(),emp);
            }
        }
        return listem;
    }

    public static List<Employee> removeDuplicates(List<Employee> employee) {
        List<Employee> bos = new LinkedList<>();

        for(Employee emps : employee){
            if (Collections.frequency(employee,emps) == 1 && emps != null) {
                    bos.add(emps);
            }
        }
        return bos;
    }


}