public class Stackk {
    private int max;
    private int[] stackArray;
    private int top;

    Stackk(int size) {
        max = size;
        stackArray = new int[size];
        top = -1;
    }

    public void push(int val) {
        if (isFull()) {
            System.out.println("stack is full");
        } else {
            stackArray[++top] = val;
            System.out.println(val + " is pushed to stack");
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            int popValue = stackArray[top--];
            System.out.println(popValue + " is popped from stack");
            return popValue;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("stack is empty");
            return -1;
        } else {
            return stackArray[top];
        }
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == max - 1);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("stack is empty");
        } else {
            System.out.println("stack elements are : ");
            for (int i = top; i >= 0; i--) {
                System.out.println(stackArray[i]);
            }
        }
    }

    // Corrected sortStack method
    public void sortStack() {
        if (!isEmpty()) {
            // Remove the top item
            int temp = pop();
            
            // Sort remaining stack
            sortStack();
            
            // Insert the top item in sorted order
            sortedInsert(temp);
        }
    }

    // Helper method to insert an element in sorted order
    private void sortedInsert(int value) {
        if (isEmpty() || value > peek()) {
            push(value);
        } else {
            int temp = pop();
            sortedInsert(value);
            push(temp);
        }
    }

    public static void main(String[] args) {
        Stackk st = new Stackk(5);

        st.push(30);
        st.push(20);
        st.push(40);
        st.push(10);
        st.push(50);

        System.out.println("Before sorting:");
        st.display();

        System.out.println("Sorting the stack...");
        st.sortStack();

        System.out.println("After sorting:");
        st.display();

        st.pop();
        st.pop();
        st.display();

        System.out.println("Stack is full? " + st.isFull());
    }
}
