package com.example.demo7.web;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Vector;

public class WordLadder {

    private String beginWord;
    private String endWord;
    private HashSet dict;

    public WordLadder(String beginWord, String endWord) {
        this.beginWord = beginWord;
        this.endWord = endWord;
        try{
            HashSet dictSet = new HashSet();
            Resource resource = new ClassPathResource("D:/C++/dictionary.txt");
            File file = resource.getFile();
            FileInputStream in = new FileInputStream(file);
            InputStreamReader reader = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(reader);

            String line;
            while ((line = br.readLine()) != null) {
                dictSet.add(line.trim());
            }
            this.dict = dictSet;
            br.close();
        }
        catch(Exception e){
            System.out.println("Can't find this file!");
        }
    }

    public void setBeginWord(String beginWord) {
        this.beginWord = beginWord;
    }

    public void setEndWord(String endWord) {
        this.endWord = endWord;
    }

    public void setDict(HashSet dict) {
        this.dict = dict;
    }

    public Vector<String> findSolution() {
        beginWord.toLowerCase();
        endWord.toLowerCase();
        Vector<String> first = new Vector<String>();
        first.add(beginWord);
        ArrayDeque<Vector<String>> solutions = new ArrayDeque<Vector<String>>();
        solutions.add(first);
        while (!solutions.isEmpty()) {
            Vector<String> firstElement = solutions.poll();
            String currentWord = firstElement.lastElement();
            //   System.out.println(currentWord+" "+endWord);
            if (endWord.equals(currentWord)) {
                return firstElement;
            }
            for (int i = 0; i < currentWord.length(); ++i) {
                char currentChar = currentWord.charAt(i);
                for (char c = 'a'; c <= 'z'; ++c) {
                    if (c == currentChar) {
                        continue;
                    }
                    String nextWord = currentWord.substring(0, i) + c + currentWord.substring(i + 1, currentWord.length());
                    if (dict.contains(nextWord)) {
                        //   System.out.println(nextWord);
                        dict.remove(nextWord);
                        Vector<String> next = new Vector<String>(firstElement);
                        next.add(nextWord);
                        solutions.add(next);
                    }
                }
            }
        }
        return null;
    }

}
