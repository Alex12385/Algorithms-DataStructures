// Необходимо превратить собранное на семинаре дерево поиска в полноценное левостороннее красно-черное дерево. И реализовать в нем метод добавления новых элементов с балансировкой.
package HW3;

public class Main {
    public static void main(String[] args) {

        BinTree<Integer> tree = new BinTree<>();

        tree.add(6);
        tree.add(3);
        tree.add(2);
        tree.add(4);
        tree.add(5);
        tree.add(1);
        tree.add(9);
        tree.add(7);
        tree.add(11);
        tree.add(8);
        tree.add(12);
        tree.add(15);
        tree.add(10);

        tree.print();

    }
}
