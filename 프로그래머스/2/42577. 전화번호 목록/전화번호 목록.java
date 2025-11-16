import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            String cur = phone_book[i];
            String next = phone_book[i + 1];

            if (next.startsWith(cur)) {
                return false;
            }
        }

        return true;
    }
}