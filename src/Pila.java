public class Pila {
    Node front;
    Node rear;

    // Constructor para almacenar una lista enlazada que simule una pila.
    public Pila() {
        this.front = null;
        this.rear = null;
    }

    // Función para introducir un elemento de tipo String al principio de la lista enlazada en una estructura de pila.
    public void push(String data) {
        Node newNode = new Node(data);
        newNode.next = front;
        front = newNode;
    }

    // Función para remover el elemento introducido más reciente.
    public void pop() {
        if (front == null) {
            System.out.println("La pila está vacía");
            return;
        }
        if (front == rear){
            front = rear = null;
        } else {
            front = front.next;
        }

    }
    // Función que devuelve el elemento introducido más recientemente.
    public String peek () {
            if (front == null) {
                System.out.println("La pila está vacía");
                return null;
            }
            return front.data;
    }

    // Función para mostrar la lista creada hasta el momento.
    public void display () {
        if (front == null) {
                System.out.println("La pila está vacía");
                return;
        }
        Node temp = front;
        System.out.println("Pila: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}