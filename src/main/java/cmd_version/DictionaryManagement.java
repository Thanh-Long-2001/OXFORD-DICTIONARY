package cmd_version;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class DictionaryManagement extends Dictionary {
    public static void insertFromCommandline() {
        Scanner sc = new Scanner(System.in);

        int numberOfWords = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numberOfWords; i++) {
            String ip_word_target = sc.nextLine();
            String ip_word_explain = sc.nextLine();

            Word ip = new Word(ip_word_target, ip_word_explain);

            dic.addd(ip);
        }

        sc.close();
        ;
    }

    // tra cuu tu
    public static void dictionaryLookup(String search) {
        if ((dic.findWord(search)) != null) {
            System.out.println("Meaning : " + dic.findWord(search).getWord_explain());
        } else {
            System.out.println("Không tìm thấy trong từ điển");
        }
    }

    // tim kiem tu vung co chua chuoi x o dau
    public static void dictionarySearch(String x) {
        // check if wrong
        List<Word> pr = dic.searchWord(x);

        for (int i = 0; i < pr.size(); i++) {
            System.out.println("- " + pr.get(i).getWord_target());
        }
    }

    public static void insertFromFile() throws IOException {
        dic.importF();
    }

    // xuat tu ra file
    public static void dictionaryExportToFile() throws IOException {
        dic.exportF();
    }

    // them du lieu tu vung
    public static void add_Word(Word x) {
        dic.addd(x);
    }

    // sua du lieu tu vung
    public static void fix_Word(String tg, String ep) {
        dic.fix(tg, ep);
    }

    // xoa du lieu tu vung
    public static void remove_Word(String x) {
        dic.remove(x);
    }
}