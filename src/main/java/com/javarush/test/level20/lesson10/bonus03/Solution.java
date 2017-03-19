package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {

    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> words = detectAllWords(crossword, "home", "same");
        for (Word word : words)
        {
            System.out.println(word);
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words)
    {
        List<Word> listWords = new ArrayList<>();
        for (int i = 0; i < words.length; i++)
        {
            List<Word> foundWord = searchWord(crossword, words[i]);
            listWords.addAll(foundWord);
        }
        return listWords;
    }

    private static List<Word> searchWord(int[][] crossword, String text)
    {
        Word word = null;
        List<Word> listWords = new ArrayList<>();
        for (int j = 0; j < crossword.length; j++)
        {

            for (int i = 0; i < crossword[j].length; i++)
            {
                if (text.charAt(0) == crossword[j][i])
                {
                    word = checkThisBegining(crossword, text, j, i);
                    if (word != null)
                        listWords.add(word);
                }
            }

        }
        return listWords;
    }

    private static Word checkThisBegining(int[][] crossword, String text, int j, int i)
    {
        Word word = checkByHorizontal(crossword, text, j, i);

        return word;
    }
    private static Word checkByHorizontal(int[][] crossword, String text, int j, int i)
    {
        int maxHorizontalLenght = crossword[j].length;
        Word word = null;
        if (i + text.length() - 1 <= maxHorizontalLenght)
        {
            for (int s = 0, i1 = i; s < text.length(); s++, i1++)
            {
                if (text.charAt(s) != crossword[j][i1])
                    break;
                else if (s == text.length() - 1)
                {
                    word = new Word(text);
                    word.setStartPoint(i, j);
                    word.setEndPoint(i + text.length() - 1, j);
                }
            }
        }

        if (word == null && i - text.length() + 1 >= 0)
        {

            for (int s = 0, i1 = i; s < text.length(); s++, i1--)
            {

                if (text.charAt(s) != crossword[j][i1])
                {
                    break;
                }

                if (s == text.length() - 1)
                {
                    word = new Word(text);
                    word.setStartPoint(i, j);
                    word.setEndPoint(i - text.length() + 1, j);
                }
            }
        }

        if (word == null)
        {
            word = checkByVertical(crossword, text, j, i);
        }

        return word;
    }

    private static Word checkByVertical(int[][] crossword, String text, int j, int i)
    {

        int maxVerticalLenght = crossword.length;
        Word word = null;
        if (j + text.length() - 1 <= maxVerticalLenght)
        {
            for (int s = 0, i1 = j; s < text.length(); s++, i1++)
            {
                if (text.charAt(s) != crossword[i1][i])
                    break;
                else if (s == text.length() - 1)
                {
                    word = new Word(text);
                    word.setStartPoint(i, j);
                    word.setEndPoint(i, j + text.length() - 1);
                }
            }
        }


        if (j - text.length() + 1 >= 0 && word == null)
        {
            for (int s = 0, i1 = j; s < text.length(); s++, i1--)
            {
                if (text.charAt(s) != crossword[i1][i])
                {
                    break;
                }
                else if (s == text.length() - 1)
                {
                    word = new Word(text);
                    word.setStartPoint(i, j);
                    word.setEndPoint(i, j - text.length() + 1);
                }
            }
        }

        if (word == null)
        {
            word = checkByDiagonal(crossword, text, j, i);
        }

        return word;
    }

    private static Word checkByDiagonal(int[][] crossword, String text, int j, int i)
    {

        int maxVerticalLenght = crossword.length;
        int verticalLengthDown = j + text.length();
        int verticalLengthUp = j - text.length();
        Word word = null;
        //right-bottom

        if (verticalLengthDown <= maxVerticalLenght && i + text.length() <= crossword[verticalLengthDown - 1].length)
        {
            int jj = j;
            int ii = i;
            for (int s = 0; s < text.length(); s++)
            {
                if (text.charAt(s) != crossword[jj][ii])
                    break;
                else if (s == text.length() - 1)
                {
                    word = new Word(text);
                    word.setStartPoint(i, j);
                    word.setEndPoint(ii, jj);
                }
                jj++;
                ii++;
            }
        }

        //left-bottom
        if (word == null && verticalLengthDown <= maxVerticalLenght && i - text.length() + 1 >= 0)
        {
            int jj = j;
            int ii = i;
            for (int s = 0; s < text.length(); s++)
            {
                if (text.charAt(s) != crossword[jj][ii])
                    break;
                else if (s == text.length() - 1)
                {
                    word = new Word(text);
                    word.setStartPoint(i, j);
                    word.setEndPoint(ii, jj);
                }
                jj++;
                ii--;
            }
        }

        //left-up
        if (word == null && verticalLengthUp + 1 >= 0 && i - text.length() + 1 >= 0)
        {
            int jj = j;
            int ii = i;

            for (int s = 0; s < text.length(); s++)
            {

                if (text.charAt(s) != crossword[jj][ii])
                    break;
                else if (s == text.length() - 1)
                {
                    word = new Word(text);
                    word.setStartPoint(i, j);
                    word.setEndPoint(ii, jj);
                }
                jj--;
                ii--;
            }
        }

        //right-up
        if (word == null && verticalLengthUp + 1 >= 0 && i + text.length() <= crossword[verticalLengthUp + 1].length)
        {
            int jj = j;
            int ii = i;

            for (int s = 0; s < text.length(); s++)
            {

                if (text.charAt(s) != crossword[jj][ii])
                    break;
                else if (s == text.length() - 1)
                {
                    word = new Word(text);
                    word.setStartPoint(i, j);
                    word.setEndPoint(ii, jj);
                }
                jj--;
                ii++;
            }
        }

        return word;

    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
