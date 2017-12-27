package hackerrank.implementation;

public class BinaryString {
    static int findAdjacent010SubStrings(String B) {
        int pos = 0, lastPos = 0;

        pos = B.indexOf("010", lastPos);
        
        if (pos != -1) {
            lastPos = pos;
            
            do {
                pos = B.indexOf("010", lastPos + 1);

                if (pos == lastPos + 2) {
                    System.out.println("Found adjacent 010 at position: " + pos);
                    return pos;
                }

                lastPos = pos;
            } while (pos != -1);
        }
        
        return -1;
    }

    static int count010Strings(String B) {
    	int lastPos = -1;
    	int pos = 0, count = 0;
    	
    	do {
    		if (lastPos == -1) {
    			pos = B.indexOf("010");
    		} else {
    			pos = B.indexOf("010", lastPos);
    		}

    		if (pos != -1) {
    			count++;
    			lastPos = pos + 1;
    		}
    		
    	} while(pos != -1);
    	
        return count;
    }
    
    static int minSteps(int n, String B) {
        StringBuilder str = new StringBuilder(B);
        int count = 0;
        int pos = 0;
        
        while ((pos = findAdjacent010SubStrings(str.toString())) != -1) {
            count++;
            str.setCharAt(pos, '1');
            System.out.println("Updated string: " + str);
        }

        count += count010Strings(str.toString());
        return count;
    }

    public static void main(String[] args) {
    	int result = minSteps(7, "0101010");
        System.out.println(result);
    }
}
