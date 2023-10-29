/*
Given a string which represents a line of documentation in a programming language.
String has function, variable and constant enclose in backticks (`).
Function, variable and constants are written in snake case.
Function and variable name consists of lowercase english letter.
Constants are in uppercase.

Convert snake case to camel case. Constants should not be changed.

Asked in eBay Coding assessment
 */




public class TextCompiler {


    public static String solution(String docString){

        String[] docArr = docString.split(" ");
        String ans = "";
        int index = -1;
        for(String doc: docArr) {
            if(doc.contains("_") && !checkAllUpper(doc)) {
                String[] tempArr = doc.split("");
                for(int i=0; i< tempArr.length; i++) {
                    if(tempArr[i].equals("_")){
                        index = i;
                        break;
                    }
                }
                String temp ="";
                for(int i =0; i< tempArr.length; i++) {
                    if(i == index +1){
                        continue;
                    } else if (i == index) {
                        temp = temp + tempArr[i+1].toUpperCase();
                    }
                    temp = temp + tempArr[i];
                }

                ans = ans + temp + " ";
            }
            else {
                ans = ans + doc + " ";
            }
        }
        return ans.substring(0, ans.length()-1);
    }

    public static boolean checkAllUpper(String doc) {
        return doc.equals(doc.toUpperCase());
    }


    public static void main(String[] args){
        String docString = "This is a `snake_case` example: `func_name` `var_name` `NOT_TO_BE_CHANGED` .";
        String sol = solution(docString);
        System.out.println(sol);
    }

}
