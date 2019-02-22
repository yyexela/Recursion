import java.util.*;
import java.util.Arrays;

public class Recursion{
    public static void main(String[] args){
        System.out.println("Program start");
        testFunctions();
    }
    
    public static void testFunctions(){
        System.out.println("Testing fibonacci: " + testFibonacci());
        System.out.println("Testing reverse: " + testReverse());
        System.out.println("Testing binarySearch: " + testBinarySearch());
        System.out.println("Testing padjenacci: " + testPadjenacci());
        System.out.println("Testing quickSort String: " + testQuickSortString());
        System.out.println("Testing quickSort Array: " + testQuickSortArray());
        System.out.println("Testing mergeSort String: " + testMergeSortString());
        System.out.println("Testing mergeSort ArrayList: " + testMergeSortArrayList());
    }
    
//-----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------
//------------------------------START STRING QUICK SORT------------------------------
//-----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------

    public static boolean testQuickSortString(){
        if(
        ("abcd").equals(quickSort("dcba")) &&
        ("lmnopqrst").equals(quickSort("srqomntpl")) &&
        ("acegikmo").equals(quickSort("cgkoaeim")) &&
        ("abcdefghijk").equals(quickSort("abcdefghijk"))
        ) return true;
        else return false;
    }

    //Overloaded convenience function
    public static String quickSort(String str){
        return quickSort(str, 0, str.length() );
    }

    public static String quickSort(String str, int start, int end){
        //Shrink string
        str = str.substring(start, end);

        if(str.length() <= 1) return str;
        
        //Choose pivot randomly
        int index = (int) (Math.random() * (str.length()));
        String pivot = str.substring(index, index + 1);
        //System.out.println("String: " + str + ", pivot: " + pivot);

        //Re-order array
        int left = 0;
        String str1 = str.substring(index, index+1);
        for(int i = 0; i < str.length(); i++){
            String check = str.substring(i, i+1);
            if(str.substring(i,i+1).compareTo(pivot) > 0){
                str1 = str1 + check;
                //System.out.println("Prepending " + check);
            }
            else if(str.substring(i,i+1).compareTo(pivot) < 0){
                str1 = check + str1;
                left++;
                //System.out.println("Appending " + check);
            }
        }
        //System.out.println("Pivoted: " + str1 + " Left is: " + left);
        //System.out.println("Sending string: " + str.substring(0, left) + ", and: " + str.substring(left, str.length()) );
        return quickSort(str1, 0, left) + quickSort(str1, left, str.length());
    }

//-----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------
//-------------------------------END STRING QUICK SORT-------------------------------
//-----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------

//-----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------
//------------------------------START ARRAY QUICK SORT-------------------------------
//-----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------

    public static String arrayString(int[] nums){
        String complete = "";
        for(int i = 0; i < nums.length; i++){
            complete += nums[i] + ", ";
        }
        return complete;
    }

    public static boolean testQuickSortArray(){
        int[] nums = {0, 6, 2, 4, 7, 9, 2, 2};
        int[] sorted = {0, 2, 2, 2, 4, 6, 7, 9};
        return Arrays.equals(quickSort(nums), sorted);
    }

    //Overloaded convenience function
    public static int[] quickSort(int[] nums){
        return quickSort(nums, 0, nums.length);
    }

    public static int[] quickSort(int[] nums, int start, int end){
        //Create new array
        nums = shrink(nums, start, end);

        //Base case
        if(nums.length <= 1) return nums;

        //Choose pivot randomly
        int index = (int) (Math.random() * (nums.length));

        //Re-order array
        int[] nums1 = new int[nums.length];
        int nums1Left = 0;
        int nums1Right = nums.length-1;
        for(int i = 0; i < nums.length; i++){
            //System.out.println("Checking pivot " + nums[index] + " with " + nums[i]);
            if(nums[i] < nums[index]){
                nums1[nums1Left] = nums[i];
                //System.out.println("Added " + nums[i] + " to index " + nums1Left);
                nums1Left++;
            }
            else if(nums[i] > nums[index]){
                nums1[nums1Right] = nums[i];
                //System.out.println("Added " + nums[i] + " to index " + nums1Right);
                nums1Right--;
            }
        }
        //Add pivot(s)
        for(int i = nums1Left; i <= nums1Right; i++){
            nums1[i] = nums[index];
            //System.out.println("Added " + nums[index] + " to index " + i);
        }

        //System.out.println("Pivot of num '" + nums[index] + "' : " + arrayString(nums1));
        return combineArrays(quickSort(nums1, 0, nums1Left+1), quickSort(nums1, nums1Left+1, nums1.length));
    }

    public static int[] shrink(int[] nums, int start, int end){
        //System.out.println("End " + end + " start " + start);
        int[] complete = new int[end - start];
        //System.out.println("Shrinking " + arrayString(nums) + " from (inclusive) " + start + " to (exlusive) " + end);
        for(int i = 0; i < complete.length; i++){
            complete[i] = nums[start + i];
        }
        //System.out.println("Shrunk to " + arrayString(complete));
        return complete;
    }

    public static int[] combineArrays(int[] array1, int[] array2){
        int[] complete = new int[array1.length + array2.length];
        for(int i = 0; i < array1.length; i++){
            complete[i] = array1[i];
        }
        for(int i = 0; i < array2.length; i++){
            complete[i + array1.length] = array2[i];
        }
        return complete;
    }

//-----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------
//------------------------------END ARRAY QUICK SORT---------------------------------
//-----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------

//-----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------
//-----------------------------START STRING MERGE SORT-------------------------------
//-----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------

public static boolean testMergeSortString(){
    if(
        ("abcd").equals(mergeSort("dcba")) &&
        ("lmnopqrst").equals(mergeSort("srqomntpl")) &&
        ("acegikmo").equals(mergeSort("cgkoaeim")) &&
        ("abcdefghijk").equals(mergeSort("abcdefghijk"))
    ) return true;
    else return false;
}

public static String mergeSort(String str){
    //Split
    if(str.length() > 1){
        int center = str.length()/2;
        return merge(mergeSort( str.substring(0, center) ), mergeSort( str.substring(center, str.length())));
    }
    return str;
}

public static String merge(String str1, String str2){
    String complete = "";
    int index1 = 0;
    int index2 = 0;
    //System.out.println("Merge called for strings: " + str1 + ", " + str2);
    
    for(int i = 0; i < str1.length() + str2.length(); i++){
        //str1 and str2 both have more characters
        if(index1 < str1.length() && index2 < str2.length()){
            //System.out.println("Comparing " + str1.substring(index1, index1+1) + " and " + str2.substring(index2, index2+1));
            //str1 is earlier
            if(str1.substring(index1, index1+1).compareTo(str2.substring(index2, index2+1)) < 0){
                complete += str1.substring(index1,index1+1);
                index1++;
            } 
            //list2 is earlier
            else if(str1.substring(index1, index1+1).compareTo(str2.substring(index2, index2+1)) > 0){
                complete += str2.substring(index2,index2+1);
                index2++;
            }
            //same
            else if(str1.substring(index1, index1+1).compareTo(str2.substring(index2, index2+1)) == 0){
                complete += str1.substring(index1,index1+1);
                index1++;
            }
        }
        //str1 is used up
        else if(index1 >= str1.length()){
            complete += str2.substring(index2,index2+1);
            index2++;
        }
        //str2 is used up
        else if(index2 >= str2.length()){
            complete += str1.substring(index1,index1+1);
            index1++;
        }
        //System.out.println("Added " + complete.get(i) + '\n');
    }
    return complete;
}

//-----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------
//-----------------------------END STRING MERGE SORT---------------------------------
//-----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------

//-----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------
//-----------------------START ARRAY LIST MERGE SORT---------------------------------
//-----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------

    public static String arrayListString(ArrayList<String> list){
        String complete = "";
        for(int i = 0; i < list.size(); i++){
            complete += list.get(i) + ", ";
        }
        return complete;
    }

    public static boolean testMergeSortArrayList(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("j");
        list.add("i");
        list.add("h");
        list.add("g");
        list.add("f");
        list.add("e");
        list.add("d");
        list.add("c");
        list.add("b");
        list.add("a");

        ArrayList<String> listSorted = new ArrayList<String>();
        listSorted.add("a");
        listSorted.add("b");
        listSorted.add("c");
        listSorted.add("d");
        listSorted.add("e");
        listSorted.add("f");
        listSorted.add("g");
        listSorted.add("h");
        listSorted.add("i");
        listSorted.add("j");

        //System.out.println("list: " + arrayListString(list) + '\n');
        //System.out.println("sorted: " + arrayListString( mergeSort(list)));
        return (arrayListString(listSorted).equals(arrayListString( mergeSort(list))));
    }

    public static void testMerge(){
        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList<String> list2 = new ArrayList<String>();

        list1.add("a");
        list1.add("e");
        list1.add("h");
        list1.add("k");
        list1.add("q");

        list2.add("e");
        list2.add("f");
        list2.add("l");
        list2.add("p");
        list2.add("z");

        System.out.println("list1: " + arrayListString(list1));
        System.out.println("list2: " + arrayListString(list2));
        System.out.println("sorted: " + arrayListString( merge(list1, list2) ));
    }

    public static ArrayList<String> shrink(ArrayList<String> list, int start, int end){
        ArrayList<String> complete = new ArrayList<String>();
        for(int i = start; i < end; i++){
            complete.add(list.get(i));
        }
        return complete;
    }

    public static ArrayList<String> mergeSort(ArrayList<String> list){
        //Split
        if(list.size() > 1){
            int center = list.size()/2;
            return merge(mergeSort(shrink(list, 0, center)), mergeSort(shrink(list, center, list.size())));
        }
        return list;
    }

    public static ArrayList<String> merge(ArrayList<String> list1, ArrayList<String> list2){
        ArrayList<String> complete = new ArrayList<String>();

        //System.out.println("Merge called for lists: ");
        //System.out.println(arrayListString(list1));
        //System.out.println(arrayListString(list2) + '\n');

        int index1 = 0;
        int index2 = 0;

        
        for(int i = 0; i < list1.size() + list2.size(); i++){
            //list1 and list 2 has more
            if(index1 < list1.size() && index2 < list2.size()){
                //System.out.println("Comparing " + list1.get(index1) + " and " + list2.get(index2));
                //list1 is earlier
                if(list1.get(index1).compareTo(list2.get(index2)) < 0){
                    complete.add(list1.get(index1));
                    index1++;
                } 
                //list2 is earlier
                else if(list1.get(index1).compareTo(list2.get(index2)) > 0){
                    complete.add(list2.get(index2));
                    index2++;
                }
                //same
                else if(list1.get(index1).compareTo(list2.get(index2)) == 0){
                    complete.add(list1.get(index1));
                    index1++;
                }
            }
            //list1 is used up
            else if(index1 >= list1.size()){
                complete.add(list2.get(index2));
                index2++;
            }
            //list 2 is used up
            else if(index2 >= list2.size()){
                complete.add(list1.get(index1));
                index1++;
            }
            //System.out.println("Added " + complete.get(i) + '\n');
        }
        return complete;
    }

//-----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------
//---------------------------END ARRAY LIST MERGE SORT-------------------------------
//-----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------

//-----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------
//------------------------------START PADJENACCI-------------------------------------
//-----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------

    public static boolean testPadjenacci(){
        if(
        padjenacci(1) == 1 && 
        padjenacci(2) == 2 && 
        padjenacci(3) == 3 && 
        padjenacci(4) == 6 && 
        padjenacci(5) == 31 && 
        padjenacci(6) == 934 && 
        padjenacci(7) == 871431
        ) return true;
        else return false;
    }

    public static long padjenacci(long n){
        //Base case
        if(n < 1) return 0;
        else if(n == 1) return 1;
        else if(n == 2) return 2;
        else if(n == 3) return 3;
        
        //Iterative
        return (padjenacci(n-1) * padjenacci(n-1) - padjenacci(n-2) * padjenacci(n-2) + padjenacci(n-3) * padjenacci(n-3));
    }

//-----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------
//----------------------------------END PADJENACCI-----------------------------------
//-----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------

//-----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------
//------------------------------START FIBONACCI--------------------------------------
//-----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------

    public static boolean testFibonacci(){
        if(
        fibonacci(0) == 1 && 
        fibonacci(1) == 1 && 
        fibonacci(2) == 2 && 
        fibonacci(3) == 3 && 
        fibonacci(4) == 5 && 
        fibonacci(5) == 8 && 
        fibonacci(6) == 13 
        ) return true;
        else return false;
    }

    public static int fibonacci(int n){
        if(n == 0 || n == 1) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }

//-----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------
//-------------------------------END FIBONACCI---------------------------------------
//-----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------

//-----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------
//------------------------------START REVERSE----------------------------------------
//-----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------

    public static boolean testReverse(){
        if(
        reverse("TESTING").equals("GNITSET") &&
        reverse("KGMAI").equals("IAMGK") && 
        reverse("+").equals("+") && 
        reverse("").equals("")
        ) return true;
        else return false;
    }

    public static String reverse(String str){
        if(str.length() <= 1) return str;
        return reverse(str.substring(1, str.length())) + str.substring(0,1);
    }

//-----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------
//--------------------------------END REVERSE----------------------------------------
//-----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------

//-----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------
//------------------------------START BINARY SERACH----------------------------------
//-----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------

    public static boolean testBinarySearch(){
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7};
        int[] nums2 = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] nums3 = new int[0];
        int[] nums4 = new int[1];
        int[] nums5 = new int[10];
        if(
        (binarySearch(nums, 0) == true) &&
        (binarySearch(nums, 1) == true) &&
        (binarySearch(nums, 2) == true) &&
        (binarySearch(nums, 3) == true) &&
        (binarySearch(nums, 4) == true) &&
        (binarySearch(nums, 5) == true) &&
        (binarySearch(nums, 6) == true) &&
        (binarySearch(nums, 7) == true) &&
        (binarySearch(nums2, 0) == true) &&
        (binarySearch(nums2, 8) == true) &&
        (binarySearch(nums, 9) == false) &&
        (binarySearch(nums2, 9) == false) && 
        (binarySearch(nums3, 9) == false) &&
        (binarySearch(nums4, 9) == false) &&
        (binarySearch(nums5, 9) == false)
        ) return true;
        return false;
    }
    //Overloaded 'convenience method'
    public static boolean binarySearch(int[] nums, int target){
        return binarySearch(nums, target, 0, nums.length);
    }

    public static boolean binarySearch(int[] nums, int target, int start, int end){
        if(nums.length == 0) return false;

        //int end is not inclusive, int start is inclusive
        int center = start + ((end - start) / 2);

        //Base case
        if(nums[center] == target) return true;
        if(end - start <= 1) return false;

        //Iterative
        if(target > nums[center]) return binarySearch(nums, target, center, end);
        if(target < nums[center]) return binarySearch(nums, target, start, center);
        return false;
    }
}

//-----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------
//-------------------------------END BINARY SERACH-----------------------------------
//-----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------