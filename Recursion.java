public class Recursion{
    public static void main(String[] args){
        System.out.println("Program start");
        testFunctions();
    }
    
    public static void testFunctions(){
        System.out.println("Testing fibonacci: " + Fibonacci.test());
        System.out.println("Testing reverse: " + Reverse.test());
        System.out.println("Testing binarySearch: " + BinarySearch.test());
        System.out.println("Testing padjenacci: " + Padjenacci.test());
        System.out.println("Testing quickSort String: " + QuickSort.testString());
        System.out.println("Testing quickSort Array: " + QuickSort.testArray());
        System.out.println("Testing mergeSort String: " + MergeSort.testString());
        System.out.println("Testing mergeSort ArrayList: " + MergeSort.testArrayList());
    }
}