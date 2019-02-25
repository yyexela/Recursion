import java.util.Arrays;
public class QuickSort{
//-----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------
//------------------------------START STRING QUICK SORT------------------------------
//-----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------
    public static boolean testString(){
        if(
        ("abcd").equals(quickSort("dcba")) &&
        ("lmnopqrst").equals(quickSort("srqomntpl")) &&
        ("acegikmo").equals(quickSort("cgkoaeim")) &&
        ("abcfgjlnpsuvxz").equals(quickSort("cgnpsjazxbvful")) &&
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
//------------------------------END STRING QUICK SORT--------------------------------
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

    public static boolean testArray(){
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
}