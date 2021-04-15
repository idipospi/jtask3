package com.lol;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        //1
        System.out.println(solutions(1, 4, 2));
        //2
        System.out.println(findZip("zip archive is not rar, it's zip"));
        //3
        System.out.println(checkPerfect(6));
        //4
        System.out.println(flipEndChars("в этом тексте первый и последний символы поменяются местами"));
        //5
        System.out.println(isValidHexCode("#F156AC"));
        //6
        int[] A = {1, 6, 3, 3, 1, 6, 5};
        int[] B = {1, 2, 3, 4, 2, 3, 4};
        System.out.println(same(A, B));
        //7
        System.out.println(isKaprekar(297));
        //8
        System.out.println(longestZero("01100001011000"));
        //9
        System.out.println(nextPrime(24));
        //10
        System.out.println(rightTriangle(5, 4, 3));
    }
    //1
    public static int solutions(int a, int b, int c){
        int count = 0;
        int disk = (b*b)-(4*a*c);
        if (disk > 0) count = 2;
        else if (disk == 0) count = 1;
        return count;
    }
    //2
    public static int findZip(String str){
        return str.indexOf("zip", str.indexOf("zip") + 1);
    }
    //3
    public static boolean checkPerfect(int a) {
        int sum = 0;
        int i = 1;
        while (i < a) {
            if (a % i == 0) {
                sum += i;
                i++;
            } else {
                i++;
                continue;
            }
            if (sum == a) {
                return true;
            }
        }
        return false;
    }
    //4
    public static String flipEndChars(String pred){
        if(pred.length() < 2 || pred.charAt(0) == pred.charAt(pred.length() - 1)){
            if (pred.length() < 2) return "несовместимо.";
            else return "два-это пара.";
        }
        return pred.substring(pred.length() - 1) + pred.substring(1, pred.length() - 1) + pred.substring(0,1);
    }
    //5
    public static boolean isValidHexCode(String str){
        char h = str.charAt(0);
        if (h != '#' || str.length() != 7) return false;
        boolean ex = true;
        char[] mass_prov = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        'A', 'B', 'C', 'D', 'E', 'F', 'a', 'b', 'c', 'd', 'e', 'f'};
        for (int i = 1; i < str.length(); i++){
            for (int j = 0; j < mass_prov.length; j++){
                if(str.charAt(i) == mass_prov[j]) ex = false;
            }
            if(ex) return false;
            ex = true;
        }

        return true;
    }
    //6
    public static boolean same(int[] A, int[] B){
        Map<Integer, Integer> counterA = new HashMap<>();
        for (int x : A) {
            int newValue = counterA.getOrDefault(x, 0) + 1;
            counterA.put(x, newValue);
        }
        Map<Integer, Integer> counterB = new HashMap<>();
        for (int x : A) {
            int newValue = counterB.getOrDefault(x, 0) + 1;
            counterB.put(x, newValue);
        }
        int countA = 0;
        int countB = 0;
        for (int value : counterA.values()) {
            if (value > 1) {
                countA++;
            }
        }
        for (int value : counterB.values()) {
            if (value > 1) {
                countB++;
            }
        }
        int chA = A.length - countA;
        int chB = B.length - countB;
        if (chA == chB) return true;
        return false;
    }
    //7
    static boolean isKaprekar(int x){
        int n=x*x;
        String str=Integer.toString(n);
        String l = str.substring(0, str.length()/2);
        String r = str.substring(str.length()/2);
        if (l.isEmpty()) l = "0";
        return x == (Integer.parseInt(l)+Integer.parseInt(r));
    }
    //8
    static String longestZero(String lz){
        char[] ch = lz.toCharArray();
        StringBuilder otv = new StringBuilder();
        int t=0, max=0, i=0;
        for(int j:ch) if(j == '0') t++;
        else {
            if(t > max) max = t;
            t = 0;
        }
        while(i < max) {
            otv.append('0');
            i++;
        }
        return otv.toString();
    }
    //9
    static int nextPrime(int x){
        int f=0;
        for(;;x++) {
            for (int i = 2; i < x; i++)
                if (x % i == 0) {
                    f = 1;
                    break;
                }

            if (f == 0) break;
            else f = 0;
        }
        return x;
    }
    //10
    public static boolean rightTriangle(int a, int b, int c){
        if(a > b && a > c) return a * a == b * b + c * c;
        if(b > a && b > c) return b * b == a * a + c * c;
        if(c > b && c > a) return c * c == b * b + a * a;
        return false;
    }
}

