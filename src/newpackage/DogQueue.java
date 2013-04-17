
package DogRecorder;
import java.util.Stack;
/**
 *
 * @author Draz
 */
public class DogQueue{
    int queueSize;
    Stack<Dog> dogQ;
    
    public DogQueue(int size)
    {
        queueSize = size;
        dogQ = new Stack();
        
    }
    public void enqueue(Dog val)
    {
        if(dogQ.size() < queueSize) {
            dogQ.add(val);
        }
        else {
            System.out.println("This queue is full");
        }
    }
    public Dog dequeue()
    {
        return dogQ.pop();
    }
    public Dog front()
    {
        return dogQ.peek();
    }
}
