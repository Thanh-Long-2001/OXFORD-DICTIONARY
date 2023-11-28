package cmd_version;

import java.io.*;
import java.util.*;

public class Dictionary extends Word {
    public Word[] words = new Word[666]; // danh sách từ vựng
    private int cnt = 0;
    private int maxLengthTargetWord = 0;
    private int maxLengthExplainWord = 0;

    public static Dictionary dic = new Dictionary();

    public Dictionary() {
        for (int i = 0; i < words.length; i++) {
            words[i] = new Word("", "");
        }
    }

    // them tu
    public void addd(Word word) {
        words[cnt] = word;
        cnt++;

        maxLengthTargetWord = Math.max(maxLengthTargetWord, word.getWord_target().length());
        maxLengthExplainWord = Math.max(maxLengthExplainWord, word.getWord_target().length());
    }

    // sua tu
    public void fix(String tg, String ep) {
        for (Word w : words) {
            if (w.getWord_target().equals(tg)) {
                w.setWord_explain(ep);
            }
        }
    }

    // xoa tu
    public void remove(String x) {
        for (int i = 0; i < cnt; i++) {
            if (words[i].getWord_target().equals(x)) {
                for (int j = i; j < cnt - 1; j++) {
                    words[j] = words[j + 1];
                }
                cnt--;
                break;
            }
        }
    }

    public void showWord() {
        Arrays.sort(words, 0, cnt, new Comparator<Word>() {
            @Override
            public int compare(Word word1, Word word2) {
                return word1.getWord_target().compareToIgnoreCase(word2.getWord_target());
            }
        });

        formatShowWord();
    }

    // tim tu
    public Word findWord(String search) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].getWord_target().equals(search)) {
                return words[i];
            }
        }

        return null;
    }

    // search word has started with x
    public List<Word> searchWord(String x) {
        List<Word> res = new ArrayList<>();

        for (int i = 0; i < cnt; i++) {
            if (similar(x, words[i].getWord_target())) {
                res.add(words[i]);
            }
        }

        return res;
    }

    // check -^
    public boolean similar(String x, String wd) {
        if (x.length() > wd.length()) {
            return false;
        }

        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) != wd.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public void importF() throws IOException {
        FileReader reader = new FileReader("src/main/java/cmd_version/wordd.txt");
        String ip_word_target;
        String ip_word_explain;
        Scanner sc = new Scanner(reader);

        while (sc.hasNextLine()) {
            String w = sc.nextLine();
            ip_word_target = w.split("\t")[0];
            ip_word_explain = w.split("\t")[1];
            Word ip = new Word(ip_word_target, ip_word_explain);
            addd(ip);
        }
        sc.close();
    }

    public void exportF() throws IOException {
        FileWriter fileWriter = new FileWriter("src/main/java/cmd_version/worddEP.txt");

        for (int i = 0; i < cnt; i++) {
            fileWriter.write(words[i].getWord_target() + "\t" + words[i].getWord_explain() + "\n");
        }

        fileWriter.close();
    }


    private void formatShowWord() {
        int x = 2;

        // format first line
        String fl = "No";
        for (int i = 0; i < Integer.toString(cnt).length() - 1; i++) {
            fl += " ";
            x++;
        }
        fl += "| English";
        for (int z = 0; z < maxLengthTargetWord - 7; z++) {
            fl += " ";
        }
        fl += " | Vietnamese";
        System.out.println(fl);

        //print word
        for (int i = 0; i < cnt; i++) {
            String english = words[i].getWord_target();
            String vietnamese = words[i].getWord_explain();

            // format
            String res = (i + 1) + "";
            for (int j = 0; j < x - Integer.toString(i + 1).length(); j++) {
                res += " ";
            }
            res += "| " + english;
            for (int j = 0; j < maxLengthTargetWord - english.length(); j++) {
                res += " ";
            }
            res += " | " + vietnamese;

            System.out.println(res);
        }
    }
}