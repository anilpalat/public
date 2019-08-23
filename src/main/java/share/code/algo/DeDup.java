package share.code.algo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class DeDup {
    public int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,
            20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,
            13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};

    /*
    This method uses the Java HashSet which internally stores its elements in a HashMap to hold the unique elements.
    This solution can be used when we need a performance efficient fast solution.
    Positive :
    This solution is best performing even with large data sets
    Does not require the array to be sorted
    Negative :
    This solution has a time complexity O(n) due to iterating through the input array for each array element
    and space complexity O(n) due to HashSet
    This solution does not guarantee to retain the original ordering due to HashSet implementation
    Alternate for negative factors:
    Space complexity can be reduced by using primitive array as shown in the method spaceEfficientDeDup(int[] inArray) below.
    Original ordering can be retained as implemented in retainOrderDeDup(int[] inArray) below.
    */
    public Integer[] fastestDeDup(int[] inArray){
        Integer[] outArray=null;
        try {
            if (null == inArray) {
                throw new NullPointerException("input array can't be null");
            }else {
                Set<Integer> intSet = new HashSet<Integer>();
                for (int element : inArray) {
                    intSet.add(element);
                }
                outArray=new Integer[intSet.size()];
                intSet.toArray(outArray);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());;//best practice is to log or notify the exception
        }
        return outArray;
    }

    /*
    This method uses the Java LinkedHashSet which internally stores its elements in a LinkedHashMap
    to hold the unique elements.
    This solution can be used when we need to retain original order with slight performance overhead than HashSet implementation.
    Positive :
    This solution retains the insertion order and perform well with large data sets
    Does not require the array to be sorted
    Negative :
    This solution has a time complexity O(n) due to iterating through the input array for each array element
    and space complexity O(n) due to LinkedHashSet
    This solution is performance wise sligtly lower than the HashSet implementation due to its overhead of maintaining
    a LinkedList internally to retain the insertion order
    Alternate for negative factors:
    Space complexity can be reduced by using primitive array as shown in the method spaceEfficientDeDup(int[] inArray) below.
    Performance can be improved by the fastestDeDup(int[] inArray) as above.
    */
    public Integer[] retainOrderDeDup(int[] inArray){
        Integer[] outArray=null;
        try {
            if (null == inArray) {
                throw new NullPointerException("input array can't be null");
            }else {
                Set<Integer> intSet = new LinkedHashSet<Integer>();
                for (int element : inArray) {
                    intSet.add(element);
                }
                outArray=new Integer[intSet.size()];
                intSet.toArray(outArray);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());;//best practice is to log or notify the exception
        }
        return outArray;
    }

    /*
    This method uses primitive array backed solution and iterates through each element n times to identify the duplicate.
    This solution can be used when space is an issue instead of Java Collections.
    Positive :
    Does not require the array to be sorted
    Less space requirement due to primitive array backed solution
    Negative :
    This solution has a time complexity O(n^2) due to iterating through the input array for each array element n times
    The performance will be poor for large data sets
    Does not retain the original order
    Alternate for negative factors:
    Performance can be improved by the fastestDeDup(int[] inArray) and order retained with retainOrderDeDup(int[] inArray) as above.
    */
    public int[] spaceEfficientDeDup(int[] inArray){
        int[] outArray=null;
        try {
            if (null == inArray) {
                throw new NullPointerException("input array can't be null");
            } else {
                int inArrayLength = inArray.length;
                for (int i = 0; i < inArrayLength; i++) {
                    for (int j = i + 1; j < inArrayLength; j++) {
                        if (inArray[i] == inArray[j]) {
                            inArray[j] = inArray[inArrayLength - 1];
                            inArrayLength--;
                            j--;
                        }
                    }
                }
                outArray=Arrays.copyOf(inArray,inArrayLength);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());;//best practice is to log or notify the exception
        }
        return outArray;
    }

    public static void main(String [] args) {
        DeDup deDup=new DeDup();
        System.out.println(deDup.randomIntegers.length);
        System.out.println(deDup.fastestDeDup(deDup.randomIntegers).length);
        System.out.println(deDup.retainOrderDeDup(deDup.randomIntegers).length);
        System.out.println(deDup.spaceEfficientDeDup(deDup.randomIntegers).length);
    }
}
