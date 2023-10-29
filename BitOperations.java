/*
Given a string of '0' and '1' and an array of request containing two type of request.
Request 1: "Count:<index>" find no.of 1's in the string before and including the specified 0-based index
Request 2: "flip" Flip all the elements in the string

Return: An array where index contains the output/answer for the count request

Asked in eBay
 */




import java.util.Arrays;

public class BitOperations {

    public static int[] solution(String bitString, String[] requests) {

        int[] zerors = new int[bitString.length()];
        int[] ones = new int[bitString.length()];

        for(int i=0; i< bitString.length(); i++){
            zerors[i] = 0;
            ones[i] =0;
        }

        int cntZero = 0;
        int cntOne = 0;
        int flips =0;
        int ansLen = 0;

        for(String req: requests) {
            if(req.equals("flip")) {
                continue;
            } else{
                ansLen = ansLen +1;
            }
        }
        int[] ans = new int[ansLen];
        String[] bitArr = bitString.split("");

        for (int i=0; i< bitArr.length; i++) {
            if(bitArr[i].equals("0")) {
                cntZero = cntZero + 1;
                zerors[i] = cntZero;
                ones[i] = cntOne;
            } else {
                cntOne = cntOne + 1;
                zerors[i] = cntZero;
                ones[i] = cntOne;
            }
        }
        int k=0;
        for(String req: requests) {
            if(req.equals("flip")) {
                flips = flips +1;
            } else {
                int index = Integer.parseInt(req.split(":")[1]);
                int actualFlip = flips%2;
                if(actualFlip == 1) {
                    ans[k] = zerors[index];
                } else {
                    ans[k] = ones[index];
                }
                k = k+1;
            }
        }

        return ans;
    }


    public static void main(String[] args){
        String bitString = "1110111011100001";
        String[] requests = new String[]{"Count:1", "Count:4", "flip", "Count:4", "Count:6"};
        int[] sol = solution(bitString, requests);
        System.out.println(Arrays.toString(sol));
    }

}
