package Exercise1;

import java.util.Map;

public class Main {
    public static void main(String[] args) {

        EmployeeRepository repository = new EmployeeRepository();


        repository.addEmployee(new Employee(1, "Alex", "Naymenko", Gender.MALE, 30, 60000, 5, Speciality.BACKAND_DEVELOPER));
        repository.addEmployee(new Employee(2, "Maria", "Dmytrenko", Gender.FEMALE, 29, 48000, 3, Speciality.QA));
        repository.addEmployee(new Employee(3, "Bohdan", "Makarenko", Gender.MALE, 55, 55000, 21, Speciality.DEV_OPS));
        repository.addEmployee(new Employee(4, "Anya", "Shamenko", Gender.FEMALE, 32, 50000, 7, Speciality.QA));
        repository.addEmployee(new Employee(5,"Vika", "Burchak",Gender.FEMALE,22,32000,2,Speciality.QA));
        repository.addEmployee(new Employee(6,"Vadim","Palama",Gender.MALE,19,28000,4,Speciality.DEV_OPS));
        repository.addEmployee(new Employee(1, "Kolya", "Dryga", Gender.MALE, 30, 49000, 5, Speciality.PM));
        repository.addEmployee(new Employee(2, "Sasha", "Shmygol", Gender.FEMALE, 28, 45000, 3, Speciality.QA));
        repository.addEmployee(new Employee(3, "Alex", "Shomko", Gender.MALE, 55, 58000, 21, Speciality.BACKAND_DEVELOPER));
        repository.addEmployee(new Employee(4, "Mira", "Litvyn", Gender.FEMALE, 32, 44000, 8, Speciality.FRONTEND_DEVELOPER));
        repository.addEmployee(new Employee(5,"Kolya", "Novikov",Gender.MALE,18,22000,2,Speciality.PM));
        repository.addEmployee(new Employee(6,"Kate","Chernikova",Gender.FEMALE,19,28000,4,Speciality.QA));



        // топ 3 зарплатні
        String[] topThreeSalariesAndNames = repository.getNameAndSurnameOfTop3BySalary();
        System.out.println("Top 3 Salaries and Names: ");
        for (String entry : topThreeSalariesAndNames) {
            System.out.println(entry);
        }
        //зарплата жінок QA
        int totalSalary = repository.getSalaryByHugeCriteriaList();
        System.out.println("Total Salary for Women in QA: " + totalSalary);
        //пошук працівника з досвідом більше 20 років
        boolean result = repository.checkIfPresentEmployeeWithWorkExperienceMoreThanTwenty();
        System.out.println("Man who have experience 20 year : " + result);
        //сортування
        String result2 = repository.getDescendingSalaryWithFullName();
        System.out.println("Sorted Employees : " + result2);
        //середня зарплата посади
        Map<Speciality, Double> averageSalaries = repository.getAverageSalaryBySpeciality();
        System.out.println("Average Salaries for Each Exercise1.Speciality: " + averageSalaries);
    }





}