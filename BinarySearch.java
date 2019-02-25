public class BinarySearch{
    public static boolean test(){
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