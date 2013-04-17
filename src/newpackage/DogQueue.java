
package DogRecorder;
import java.util.Queue;
/**
 *
 * @author Draz
 */
public class DogQueue{
    int queueSize;
    Queue<Dog> dogQ;
    
    public DogQueue(int size)
    {
        queueSize = size;
        
    }
    public void enqueue(Dog val)
    {
        if(dogQ.size() < queueSize)
        dogQ.add(val);
        else
            System.out.println("This queue is full");
    }
    public Dog dequeue()
    {
        return dogQ.remove();
    }
    public Dog front()
    {
        return dogQ.peek();
    }
}
