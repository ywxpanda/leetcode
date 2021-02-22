package zijie;

import java.util.*;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    len = Math.max(len, set.size());
                    set.clear();
                    break;
                }
                set.add(s.charAt(j));
            }
        }
        return Math.max(set.size(), len);
    }


    public int lengthOfLongestSubstring2(String s) {
        int len = 0;
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            String tmp = String.valueOf(s.charAt(i));

            if (res.toString().contains(tmp)) {
                len = Math.max(len, res.length());
                String[] split = res.toString().split(tmp);
                //产生一个新的 1.如果tmp在头或者尾部找到则为新的字符，否则就是中间后面的一部分加上一个新的字符
                res = new StringBuilder((split.length > 1 ? split[1] : "") + tmp);

            } else {
                res.append(tmp);
            }
        }

        return Math.max(len, res.length());
    }


    /**
     * 方法二改
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        int len = 0;
        int left = 0;
        // 字符，字符所在的位置（上一个）
        Map<Character, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

//            if (indexMap.containsKey(c)) {
//                left = Math.max(left, indexMap.get(c) + 1);
//                len = Math.max(i - left + 1, len);
//                indexMap.put(c, Math.max(i, indexMap.get(c)));
//            } else {
//                indexMap.put(c, i);
//            }

            if (indexMap.containsKey(c)) {
                //left 不一定是上一个相同的字符，也可能是之前已经排除的 例如  abba  left=1 而不是0,因为b已经被筛选过了
                left = Math.max(left, indexMap.get(c) + 1);
            }
            indexMap.put(c, i);
            len = Math.max(len, i - left + 1);

        }

        return len;
    }


    public int lengthOfLongestSubstring4(String s) {
        int len = 0;
        int left = 0;
        // 字符，字符所在的位置（上一个）,代替map
        int[] indexMap = new int[128];

        Arrays.fill(indexMap, -1);

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if (indexMap[c] >= 0) {
                left = Math.max(left, indexMap[c] + 1);
            }
            len = Math.max(len, i - left + 1);
            indexMap[c] = i;

        }

        return len;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();

        String s = "abba";

//        int i = ;/
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring4(s));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring3(s));
    }
}
