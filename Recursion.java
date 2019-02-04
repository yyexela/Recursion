public class Recursion{
    public static void main(String[] args){
        System.out.println("Program start");
        System.out.println("Testing fibonacci: " + testFibonacci());
        System.out.println("Testing reverse: " + testReverse());
        System.out.println("Testing binarySearch: " + testBinarySearch());
    }

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

    public static boolean testReverse(){
        if(
        reverse("TESTING").equals("GNITSET") &&
        reverse("KGMAI").equals("IAMGK") &&
        reverse("").equals("")
        ) return true;
        else return false;
    }

    public static String reverse(String str){
        if(str.length() <= 1) return str;
        return reverse(str.substring(1, str.length())) + str.substring(0,1);
    }

    public static boolean testBinarySearch(){
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7};
        int[] nums2 = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] nums3 = new int[0];
        int[] nums4 = new int[1];
        int[] nums5 = new int[10];
        if(
        (binarySearch(nums, 0, 0, nums.length) == true) &&
        (binarySearch(nums, 1, 0, nums.length) == true) &&
        (binarySearch(nums, 2, 0, nums.length) == true) &&
        (binarySearch(nums, 3, 0, nums.length) == true) &&
        (binarySearch(nums, 4, 0, nums.length) == true) &&
        (binarySearch(nums, 5, 0, nums.length) == true) &&
        (binarySearch(nums, 6, 0, nums.length) == true) &&
        (binarySearch(nums, 7, 0, nums.length) == true) &&
        (binarySearch(nums2, 0, 0, nums2.length) == true) &&
        (binarySearch(nums2, 8, 0, nums2.length) == true) &&
        (binarySearch(nums, 9, 0, nums.length) == false) &&
        (binarySearch(nums2, 9, 0, nums2.length) == false) && 
        (binarySearch(nums3, 9, 0, nums3.length) == false) &&
        (binarySearch(nums4, 9, 0, nums4.length) == false) &&
        (binarySearch(nums5, 9, 0, nums5.length) == false)
        ) return true;
        return false;
    }

    public static boolean binarySearch(int[] nums, int num, int start, int end){
        if(nums.length == 0) return false;

        //int end is not inclusive, int start is inclusive
        int center = start + ((end - start) / 2);

        //System.out.println("num: " + num + ", start: " + start + ", end: " + end + ", center: " + center);
        
        //Base case
        //System.out.println("Checking center: nums[" + center + "]: " + nums[center]);
        if(nums[center] == num){
            //System.out.println("num(" + num + ") == nums[" + center + "]: " + nums[center]);
            return true;
        }

        if(end - start <= 1){
            //System.out.println("num(" + num + ") not found in nums[]");
            return false;
        }

        //Iterative
        if(num > nums[center]){
            //System.out.println("num(" + num + ") > nums[" + center + "]: " + nums[center]);
            return binarySearch(nums, num, center, end);
        } 
        else if(num < nums[center]){
            //System.out.println("num(" + num + ") < nums[" + center + "]: " + nums[center]);
            return binarySearch(nums, num, start, center);
        }
        return false;
    }
}