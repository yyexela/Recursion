import java.util.*;

public class MergeSort{

//-----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------
//------------------------------START STRING MERGE SORT------------------------------
//-----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------

    public static boolean testString(){
        if(
            ("abcd").equals(mergeSort("dcba")) &&
            ("lmnopqrst").equals(mergeSort("srqomntpl")) &&
            ("acegikmo").equals(mergeSort("cgkoaeim")) &&
            ("abcfgjlnpsuvxz").equals(mergeSort("cgnpsjazxbvful")) &&
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
//------------------------------END STRING MERGE SORT--------------------------------
//-----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------

//-----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------
//------------------------------START ARRAY LIST MERGE SORT--------------------------
//-----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------

    public static String arrayListString(ArrayList<String> list){
        String complete = "";
        for(int i = 0; i < list.size(); i++){
            complete += list.get(i) + ", ";
        }
        return complete;
    }

    public static boolean testArrayList(){
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
//--------------------------------END ARRAY LIST MERGE SORT--------------------------
//-----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------
}