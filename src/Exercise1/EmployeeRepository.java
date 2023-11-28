package Exercise1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeRepository {
    private List<Employee> employees;

    public EmployeeRepository() {
        this.employees = new ArrayList<>();
    }

    // Add employee to the repository
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public String[] getNameAndSurnameOfTop3BySalary() {
        return employees.stream()
            .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
            .limit(3)
            .map(employee -> employee.getName() + " " + employee.getLastName() +
                    " - Salary: " + employee.getSalary())
            .toArray(String[]::new);
}

      
    }
    //загальна зарплата жінок в QA
    public int getSalaryByHugeCriteriaList() {
        return employees.stream()
                .filter(employee ->
                        employee.getGender() == Gender.FEMALE &&
                                employee.getAge() <= 30 &&
                                employee.getSpeciality() == Speciality.QA &&
                                employee.getWorkExperience() <= 5)
                .mapToInt(Employee::getSalary)
                .sum();
    }

    // перевірка працівника чоловічої статі з відділу Backand_Developer vs DEV_OPS
    public boolean checkIfPresentEmployeeWithWorkExperienceMoreThanTwenty() {
        return employees.stream()
                .anyMatch(employee ->
                        employee.getGender() == Gender.MALE &&
                                (employee.getSpeciality() == Speciality.BACKAND_DEVELOPER || employee.getSpeciality() == Speciality.DEV_OPS) &&
                                employee.getWorkExperience() > 20);
    }

    //name surname salary
    public String getDescendingSalaryWithFullName() {
        return employees.stream()
                .sorted((e1, e2) -> Integer.compare(e2.getSalary(), e1.getSalary())) // Sort by salary in descending order
                .map(employee -> String.format("(%s %s %d)", employee.getName(), employee.getLastName(), employee.getSalary()))
                .collect(Collectors.joining("; "));
    }

    // середня зарплата спеціальності
    public Map<Speciality, Double> getAverageSalaryBySpeciality() {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getSpeciality,
                        Collectors.averagingDouble(Employee::getSalary)));
    }
      
}
