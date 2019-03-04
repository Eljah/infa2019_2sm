package containers.map;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by eljah32 on 3/1/2019.
 */
public class RandomizedSemesterWorkDistribution {
    public static void main(String[] args) {

        List<String> semesterWork = new ArrayList<String>();
        semesterWork.add("Merge sort");
        semesterWork.add("Tree sort");
        semesterWork.add("Timsort");
        semesterWork.add("Bucket sort");
        semesterWork.add("Stooge sort");
        semesterWork.add("Comb sort");
        semesterWork.add("Heap sort");
        semesterWork.add("Smooth sort");
        semesterWork.add("Quicksort");
        semesterWork.add("Introsort");
        semesterWork.add("Patience sort");
        semesterWork.add("Shell sort");
        semesterWork.add("Radix sort");
        semesterWork.add("Topological sort");
        semesterWork.add("Поиск подстрок. Алгоритм Кнута-Морриса-Пратта");
        semesterWork.add("Поиск подстрок. Алгоритм Бойера-Мура");
        semesterWork.add("Кратчайший путь в графе. Алгоритм Флойда-Уоршелла");
        semesterWork.add("Кратчайший путь в графе. Алгоритм Беллмана-Форда");
        semesterWork.add("Кратчайший путь в графе. Алгоритм Левита");
        semesterWork.add("Построение минимального остовного дерева. Алгоритм Краскала");
        semesterWork.add("Построение минимального остовного дерева. Алгоритм Прима");
        semesterWork.add("Построение выпуклой оболочки. Алгоритм Грэхема");
        semesterWork.add("Построение выпуклой оболочки. Алгоритм Джарвиса");
        semesterWork.add("Построение выпуклой оболочки. Алгоритм Чана");
        System.out.println("Количество тем: " + semesterWork.size());

        Set<Student> students = new TreeSet<Student>();
        students.add(new Student("Алиев", "Эмин"));
        students.add(new Student("Афанасьев", "Никита"));
        students.add(new Student("Блинов", "Ренат"));
        students.add(new Student("Буланова", "Камилла"));
        students.add(new Student("Гатауллин", "Эдгар"));
        students.add(new Student("Гатин", "Камиль"));
        students.add(new Student("Гильмутдинов", "Ильназ"));
        students.add(new Student("Гимазов", "Булат"));
        students.add(new Student("Гордеев", "Сергей"));
        students.add(new Student("Губайдуллин", "Рамис"));
        students.add(new Student("Дмитриев", "Михаил"));
        students.add(new Student("Егорова", "Анастасия"));
        students.add(new Student("Кадыров", "Самат"));
        students.add(new Student("Корченов", "Руслан"));
        students.add(new Student("Мамедов", "Радимир"));
        students.add(new Student("Мухутдинова", "Алия"));
        students.add(new Student("Мухутдинова", "Алия"));
        students.add(new Student("Мялицин", "Максим"));
        students.add(new Student("Низамов", "Салават"));
        students.add(new Student("Самигуллин", "Илья"));
        students.add(new Student("Хакимов", "Артем"));
        students.add(new Student("Харисов", "Эмиль"));
        students.add(new Student("Чербаева", "Дарья"));
        students.add(new Student("Шигабутдинов", "Марат"));
        students.add(new Student("Иванов", "Артем"));

        System.out.println("Всего студентов: " + students.size());
        System.out.println(students.toString());

        Map<Student, Set<String>> distribution = new TreeMap<>();
        Iterator<Student> studentsIterator = students.iterator();

        while (studentsIterator.hasNext()) {
            Student student = studentsIterator.next();
            distribution.put(student, new HashSet<>());
            while(distribution.get(student).size()< 3){
                int randomNum = ThreadLocalRandom.current().nextInt(0, semesterWork.size());
                distribution.get(student).add(semesterWork.get(randomNum));
            }
        }
        ;
        System.out.println();
        System.out.println("Готово!");
        System.out.println();
        for (Map.Entry<Student, Set<String>> entry : distribution.entrySet()) {
            System.out.println(entry.getKey().getSecondName() + " " + entry.getKey().getFirstName() + ": " + entry.getValue().toString());
        }
    }
}
