class Solution {
    public int[] plusOne(int[] digits) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            str.append(digits[i]);
        }

        long num = Long.parseLong(str.toString());
        num++;

        String resString = Long.toString(num);
        int[] res = new int[resString.length()];

        for (int i = 0; i < resString.length(); i++) {
            res[i] = (int) resString.charAt(i) - '0';
        }
        return res;
    }
}
