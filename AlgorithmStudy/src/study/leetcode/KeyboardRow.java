package study.leetcode;

import java.util.*;

public class KeyboardRow {
    private static int[] maps = new int[123];
    private void init(){
        maps['Q'] = 1;
        maps['W'] = 1;
        maps['E'] = 1;
        maps['R'] = 1;
        maps['T'] = 1;
        maps['Y'] = 1;
        maps['U'] = 1;
        maps['I'] = 1;
        maps['O'] = 1;
        maps['P'] = 1;
        maps['q'] = 1;
        maps['w'] = 1;
        maps['e'] = 1;
        maps['r'] = 1;
        maps['t'] = 1;
        maps['y'] = 1;
        maps['u'] = 1;
        maps['i'] = 1;
        maps['o'] = 1;
        maps['p'] = 1;

        maps['A'] = 2;
        maps['S'] = 2;
        maps['D'] = 2;
        maps['F'] = 2;
        maps['G'] = 2;
        maps['H'] = 2;
        maps['J'] = 2;
        maps['K'] = 2;
        maps['L'] = 2;
        maps['a'] = 2;
        maps['s'] = 2;
        maps['d'] = 2;
        maps['f'] = 2;
        maps['g'] = 2;
        maps['h'] = 2;
        maps['j'] = 2;
        maps['k'] = 2;
        maps['l'] = 2;

        maps['Z'] = 3;
        maps['X'] = 3;
        maps['C'] = 3;
        maps['V'] = 3;
        maps['B'] = 3;
        maps['N'] = 3;
        maps['M'] = 3;
        maps['z'] = 3;
        maps['x'] = 3;
        maps['c'] = 3;
        maps['v'] = 3;
        maps['b'] = 3;
        maps['n'] = 3;
        maps['m'] = 3;

    }
    public String[] findWords(String[] words) {
        init();

        int length = words.length;
        List<String> list = new ArrayList<>();
        for(int i = 0 ; i < length ; i ++) {
            char [] word = words[i].toCharArray();
            int jLeng = word.length;
            int tmp = 0;
            boolean possible = true;
            for(int j = 0; j < jLeng ; j ++) {
                if(j == 0 ){
                    tmp = maps[word[j]];
                }else{
                    if(tmp!=maps[word[j]]){
                        possible = false;
                        break;
                    }
                }
            }
            if(possible) list.add(words[i]);
        }
        String[] result1 = new String[list.size()];
        int index = 0;
        for(String l : list) {
            result1[index] = l;
            index ++;
        }
        return result1;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"Hello","Alaska","Dad","Peace"};
//        String[] words1=new study.baekjoon.AlphaMath1339_withBackTracking().findWords(words);
//        for(String l : words1) {
//            System.out.println(l);
//        }
    }

}