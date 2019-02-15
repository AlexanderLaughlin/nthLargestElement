
/**
 * Write a description of class HW4 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HW4 extends HW4_AbstractClass
{
    // instance variables - replace the example below with your own
    //int left;
    //int right;
    //int k;
    //int[] A;

    /**
     * Constructor for objects of class HW4
     */
    public HW4()
    {
        // initialise instance variables

    }

    protected int selectionNew(int [] A, int left, int right, int k)
    {
        // put your code here
        int pivotIndex = findPivot(A, left, right);
        swap(A, pivotIndex, right);
        int i = partition(A, left, right-1, A[right]);
        swap(A, i, right);
        if((k-1)==i){
            System.out.println("A[i] = " + A[i]);
            return A[i];
        }
        else if(k <= i){
            return selectionNew(A, left, i -1, k);
        }
        else if(k> i +1){
            return selectionNew(A, i+1, right, k);
        }
        return 0;
    }

    //partition method provided by our textbook found at 
    //I have made a few small changes to the provided method
    int partition(int[] A, int left, int right, int pivot) {
        while (left <= right) { //(left <= right) Move bounds inward until they meet
            while (A[left]< pivot){//(A[left]< pivot)
                left++;
            }
            while ((right >= left) && (A[right] >=pivot)){//((right >= left) && (A[right] >=pivot))
                right--;
            }
            if (right > left){ //right > left
                swap(A, left, right); // Swap out-of-place values
            }
        }
        return left; // Return first position in right partition
    }

    public int findPivot(int []A, int left, int right){
        //return (left+right)/2;
        // int middle = (int)Math.floor((left + right)/2); //middle value is average of left and right
        int middle = (left+right/2);

        if(A[right]< A[middle]){ //the following three if statements swap left right and pivot to order them
            swap(A, right, middle);
        }
        if(A[middle]< A[left]){
            swap(A, middle, left);
        }
        if(A[middle]< A[right]){
            swap(A, middle, right);
        }
        //swap(A, middle, right-1); //was right-1
        return middle;  //was right-1
    }

    public int selectionNew(int [] A, int k){
        //System.out.println("A.length-1=: "+ (A.length-1));
        return selectionNew(A, 0, A.length-1, k); //recursively calls itself
    }
    //takes an array and the index of two elements to be swapped
    public void swap(int [] A, int m, int n){ 
        //System.out.println("m= "+m);
        //System.out.println("n= "+n);
        int temp = A[m];
        A[m]=A[n];
        A[n]=temp;
    }

    public static void main(String args[]){
        HW4 obj = new HW4();
        //int []A = {9,8,7,6,5,4,3,2,1};
        int []A = {1,2,3,4,5,6,7,8,9};
        //int []A = {4,3,2,1,10,20,30,40};
        //int []A = {3,2,1};
        //obj.selectionNew(A,1);
        obj.selectionNew(A,2);
        obj.selectionNew(A,3);
        obj.selectionNew(A,4);
        obj.selectionNew(A,5);
        obj.selectionNew(A,6);
        obj.selectionNew(A,7);
        obj.selectionNew(A,8);
        //obj.selectionNew(A,9);
        System.out.println("----------------");
    }
}
