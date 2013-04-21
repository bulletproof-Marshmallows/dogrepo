
package DogRecorder;
import java.util.ArrayList;
/**
 *
 * @author Draz
 */
public class DogQueue{
    int queueSize;
    ArrayList<Dog> dogQ;
    Exception QueueFull;
    private boolean sizeSet;
    public DogQueue(int size)
    {
        queueSize = size;
        dogQ = new ArrayList();
        QueueFull = new Exception("Queue is full");
        sizeSet =true;
    }
    public DogQueue(){
        sizeSet = false;
        dogQ = new ArrayList();
    }
    public void enqueue(Dog val) 
    {
        if(sizeSet) {
            if(dogQ.size() < queueSize) {
                dogQ.add(val);
            }
            else {
                System.out.println("Full");
                //throw QueueFull;
            }
        }else{
           dogQ.add(val); 
        }
    }
    public Dog dequeue()
    {
        return dogQ.remove(0);
    }
    public Dog front()
    {
        return dogQ.get(0);
    }
    
    public int size(){
        return dogQ.size();
    }
    
    @Override
    public String toString(){
        String string ="";
        for(int i=0;i<dogQ.size();i++){
            string+="["+dogQ.get(i).getName()+"] ";
        }
        return string;
    }

}
