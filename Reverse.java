public class Reverse{
    public static boolean test(){
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
}