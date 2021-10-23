package _01_TestMatchingBrackets;

public class TestMatchingBrackets {
    /*
     * Use a Stack to complete the method for checking if every opening bracket
     * has a matching closing bracket
     */

    public static boolean doBracketsMatch(String b) {
    	int bracketsClose = 0;
    	for(int i = 0; i < b.length(); i++) {
    	if(i == 0 ) {
    		if(b.charAt(i) == '}')
    			return false;
    	}
    		if(b.charAt(i) == '{') {
    			bracketsClose ++;
    		}else {
    			bracketsClose --;
    		}
    	}
    	if(bracketsClose == 0) {
        return true;
    	}
    	return false;
    }
}