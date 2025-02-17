package ITHub.task;

public class Main {
    public static void main(String[] args) {

        Stack s1 = new Stack();
        for (int i = 1; i < 6; i++) s1.push(i);

        // Создаем новые стеки и копируем элементы
        Stack s2 = new Stack();
        for (int i = 0; i < s1.size(); i++) s2.push(s1.getItem(i));

        Stack s3 = new Stack();
        for (int i = 0; i < s1.size(); i++) s3.push(s1.getItem(i));

        Stack s4 = new Stack();
        for (int i = 0; i < s1.size(); i++) s4.push(s1.getItem(i));

        Stack s5 = new Stack();
        for (int i = 0; i < s1.size(); i++) s5.push(s1.getItem(i));
        
        if (!s3.isEmpty()) {
            s3.pop(); // удаляю первый элемент из s3
        }

        if (!s5.isEmpty()) {
            s5.pop(); // удаляю первый элемент из s5
        }

        s4.push(2); // добавляю 2 в s4

        if (!s5.isEmpty()) {
            s5.push(9); // добавляю 9 в s5
        }

        System.out.println("s1 == s2 is " + (s1.equals(s2) ? "true" : "false"));
        System.out.println("s1 == s3 is " + (s1.equals(s3) ? "true" : "false"));
        System.out.println("s1 == s4 is " + (s1.equals(s4) ? "true" : "false"));
        System.out.println("s1 == s5 is " + (s1.equals(s5) ? "true" : "false"));
    }
}
