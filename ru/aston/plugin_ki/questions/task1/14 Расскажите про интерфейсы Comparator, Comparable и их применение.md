Расскажите про интерфейсы Comparator, Comparable и их применение

Comparable — это интерфейс, входящий в пакет java.lang и используемый для сортировки классов на основе их естественного порядка. 
Интерфейс Comparable должен быть реализован в классе, который будет использоваться для сортировки. 
Этот класс можно сортировать на основе отдельных атрибутов, таких как идентификатор, имя, отдел и так далее. 
Класс, реализующий интерфейс Comparable, сравнивает себя с другими объектами. 
Реализованный класс предлагает пользовательскую реализацию int CompareTo(T o1) для пользовательской сортировки. 
Метод int CompareTo(T o1) должен быть переопределен таким образом:

1.	Он должен возвращать целое положительное значение Positive(+ve), если этот объект больше объекта сравнения.
2.	Он должен возвращать целое отрицательное значение Negative(-ve), если этот объект меньше объекта сравнения.
3.	Он должен вернуть Zero(0), если этот и сравниваемый объект равны.
При использовании класса Comparable можно сортировать только по одному атрибуту.

Пример использования:

    public class Student  implements Comparable<Student> {
        
        private Integer id;
    
        private String name;
    
        private String department;
    
        @Override
        public int compareTo(Student student) {
           return this.name.compareTo(student.name);
        }
    }

    public class StudentComparableMain {
    
        public static void main(String[] args) {
            Student student=new Student(1,"John Doe","Java");
            Student student2=new Student(2,"Jane Doe","Java");
            Student student3=new Student(3,"Mike","Java");
    
            List<Student> students = Arrays.asList(student, student2,student3);
    
            System.out.println(students);
    
            Collections.sort(students);
    
            System.out.println(students);
        }
    }

Первый метод print выведет список студентов в соответствии с порядком вставки:

    [Student(id=1, name=John Doe, department=Java),
    
    Student(id=2, name=Jane Doe, department=Java),
    
    Student(id=3, name=Mike, department=Java)],


а второй выведет список, отсортированный по именам студентов:

    [Student(id=2, name=Jane Doe, department=Java), 
    
    Student(id=1, name=John Doe, department=Java),
    
    Student(id=3, name=Mike, department=Java)]



Comparator — это интерфейс, входящий в пакет java.util, который также используется для сортировки коллекций в Java. 
В отличие от Comparable, интерфейс Comparator не обязательно должен быть реализован в исходном классе, его можно реализовать и в отдельном классе. 
Используя Comparator, мы можем сортировать список на основе различных атрибутов в соответствии с нашими требованиями. 
В компараторе два объекта передаются в метод сравнения и сравниваются друг с другом. Метод int Compare(T o1, T o2) должен быть реализован пользовательским классом компаратора. 
Метод int Compare(T o1, T o2) должен быть переопределен таким образом, чтобы:
1.	Он должен возвращать целое число положительное значение Positive(+ve), если первый объект больше второго объекта.
2.	Он должен возвращать целое отрицательное значение Negative(-ve), если первый объект меньше второго объекта.
3.	Он должен возвращать Zero(0), если оба объекта равны.
 Пример использования:

    import java.util.Comparator;
    
    class StudentDeptComparator implements Comparator<Student> {
    
        @Override
        public int compare(Student s1, Student s2) {
            return s1.getDepartment().compareTo(s2.getDepartment());
        }
    }
    
    class StudentNameComparator implements Comparator<Student> {
    
        @Override
        public int compare(Student s1, Student s2) {
            return s1.getName().compareTo(s2.getName());
        }
    }


    public class StudentDeptComparator Main {
    
        public static void main(String[] args) {
    
        Student student=new Student(1,"Jane","Java");
        
        Student student2=new Student(2,"John","React");
        
        Student student3=new Student(3,"Mike","BA");
        
        List<Student> students = Arrays.asList(student, student2,student3);
        
        // печатаем список согласно порядку вставки
        System.out.println(students);
        
        Collections.sort(students,new StudentDeptComparator());
        
        // печатаем список, отсортированный по кафедрам студентов
        System.out.println(students);
        
        Collections.sort(students,new StudentNameComparator());
        
        // печатаем список, отсортированный по именам студентов
        System.out.println(students);
        
        // сортируем список по имени и названию кафедры
        
        Collections.sort(students,new StudentNameComparator().thenComparing(new StudentDeptComparator()));
        
        System.out.println(students);
        }
    }

Первый метод print выведет список студентов в соответствии с порядком вставки:

    [Student(id=1, name=Jane, department=Java),
    
    Student(id=2, name=John, department=React),
    
    Student(id=3, name=Mike, department=BA)]

второй вернет список, отсортированный по кафедре студентов:

    [Student(id=3, name=Mike, department=BA),
    
    Student(id=1, name=Jane, department=Java),
    
    Student(id=2, name=John, department=React)]
                        




Аналогично, Comparator также можно реализовать в лямбда-выражениях без использования какого-либо внешнего класса:

    Collections.sort(
                    students,
                    (s1,s2)->{
                        return s1.getDepartment().compareTo(s2.getDepartment());
                    }
            );
    System.out.println(students);
    
    Вывод на экран:
    
    [Student(id=3, name=Mike, department=BA),
    
    Student(id=1, name=Jane, department=Java),
    
    Student(id=2, name=John, department=React)]

Ресурсы:

https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/util/Comparator.html 
https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/lang/Comparable.html 
