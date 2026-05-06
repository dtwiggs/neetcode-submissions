class Solution {
    
    HashMap<Character, Character> closeToOpen = new HashMap<Character, Character>();
    ArrayList<Character> arrLi = new ArrayList<>();

    public boolean isValid(String s) {

        closeToOpen.put(')', '(');
        closeToOpen.put('}', '{');
        closeToOpen.put(']', '[');

        int lastVal = -1;
        char current;

        for (int i = 0; i < s.length(); i++) {
            current = s.charAt(i);

            if(closeToOpen.containsKey(current)) {
                if (lastVal == -1){
                    System.out.println("only a close without any opens");
                    return false;
                } else if (arrLi.get(lastVal) == closeToOpen.get(current)){
                    arrLi.remove(lastVal);
                    lastVal--;
                } else {
                    System.out.println("something wasnt closed properly");
                    return false;
                }
            } else {
                arrLi.add(current);
                lastVal++;
            }
        }
        
        if(arrLi.isEmpty()){
            System.out.println("passed through the test");
            return true;
        } else {
            System.out.println("not empty at end");
            return false;
        }
    }
}