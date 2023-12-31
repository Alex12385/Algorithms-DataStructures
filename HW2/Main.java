//Необходимо реализовать метод разворота связного списка (двухсвязного или односвязного на выбор).

package HW2;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        SingleLinkList<Contact> contactList = new SingleLinkList<>();

        contactList.addToEnd(new Contact(234, "Иванов Иван Иванович", "+79682365716"));
        contactList.addToEnd(new Contact(345, "Егоров Аркадий Александрович", "+79854186234"));
        contactList.addToEnd(new Contact(456, "Смирнов Владимир Валентинович", "+79765847596"));
        contactList.addToEnd(new Contact(678, "Герасимов Владислав Сергеевич", "+79241569856"));
        contactList.addToEnd(new Contact(789, "Панкратов Алексей Андреевич", "+79623584986"));

        for (Object contact : contactList) {
            System.out.println(contact);
        }
        contactList.reverse();

        System.out.println("_-#-_-#-_-#-_-#-_-#-_-#-_-#-_-#-_-#-_-#-_-#-_");

        for (Object contact : contactList) {
            System.out.println(contact);
        }
    }

    static class Contact {
        int id;
        String name;
        String phone;

        public Contact(int id, String name, String phone) {
            this.id = id;
            this.name = name;
            this.phone = phone;
        }

        @Override
        public String toString() {
            return "Contact{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", phone='" + phone + '\'' +
                    '}';
        }
    }

    /**
     * Класс списка
     *
     * @param <T>
     */
    public static class SingleLinkList<T> implements Iterable {
        ListItem<T> head;
        ListItem<T> tail;

        @Override
        public Iterator iterator() {
            return new Iterator<T>() {
                ListItem<T> current = head;

                @Override
                public boolean hasNext() {
                    return current != null;
                }

                @Override
                public T next() {
                    T data = current.data;
                    current = current.next;
                    return data;
                }
            };
        }

        /**
         * Класс отдельного элемента
         *
         * @param <T>
         */
        private static class ListItem<T> {
            T data;
            ListItem<T> next;
        }

        public boolean isEmpty() {
            return head == null;
        }

        
        public void addToEnd(T item) {

            
            ListItem<T> newItem = new ListItem<>();
            newItem.data = item;

            
            if (isEmpty()) {
                head = newItem;
                tail = newItem;

            
            } else {
                tail.next = newItem;
                tail = newItem;
            }
        }

        
        public void reverse() {
            if (!isEmpty() && head.next != null) { 
                tail = head;
                ListItem<T> current = head.next;
                head.next = null;
                while (current != null) {
                    ListItem<T> next = current.next;
                    current.next = head;
                    head = current;
                    current = next;
                }
            }
        }
    }
}