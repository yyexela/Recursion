public class Recursion{
    public static void main(String[] args){
        System.out.println("Program start");

        /*
        System.out.println(fibonacci(4));
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(6));
        */

        
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7};
        System.out.println(binarySearch(nums, 6, 0, nums.length));

        //System.out.println(reverse("TESTING"));
    }

    public static int fibonacci(int n){
        if(n == 1 || n == 2) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static String reverse(String str){
        if(str.length() == 1) return str;
        return reverse(str.substring(1, str.length())) + str.substring(0,1);
    }

    public static boolean binarySearch(int[] nums, int num, int start, int end){

        //int end is not inclusive, int start is inclusive
        int center = start + ((end - start) / 2);

        System.out.println("num: " + num + ", start: " + start + ", end: " + end + ", center: " + center);
        
        //Base case
        System.out.println("Checking center: nums[" + center + "]: " + nums[center]);
        if(nums[center] == num){
            System.out.println("num(" + num + ") == nums[" + center + "]: " + nums[center]);
            return true;
        }

        if(nums.length <= 2){
            System.out.println("num(" + num + ") not found in nums[]");
            return false;
        }

        //Iterative
        if(num > nums[center]){
            System.out.println("num(" + num + ") > nums[" + center + "]: " + nums[center]);
            return binarySearch(nums, num, center, end);
        } 
        else if(num < nums[center]){
            System.out.println("num(" + num + ") < nums[" + center + "]: " + nums[center]);
            return binarySearch(nums, num, start, center);
        }
        return false;
    }
}