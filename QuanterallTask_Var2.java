import java.util.ArrayList;
import java.util.Arrays;

public class QuanterallTask_Var2 {
    public static void main(String[] args) {

        String[] input = new String[]{"University", "Java", "JavaScript", "PHP", "HTML", "CSS", "Spring", "Vue", "Angular", "CSS", "CSS"};

//        System.out.println(result(input, 2, 1, "CSS"));
//        System.out.println(result(input,2,1,""));
//        System.out.println(result(input,2,1,"Missing String"));
//        String [] emptyArray = new String [5];
//        System.out.println(result(emptyArray,2,1,"Missing String"));


    }

    public static String result(String[] input, int wordsPerPage, int pageNumber, String keyWord) {

        if (input[0] == null) {
            return "Списъкът е празен";
        }

        boolean isKeyWordPresent = false;
        int numberOfKeyWords = 0;

    /*
    COUNTS HOW MANY TIMES YOU CAN MEET
    THE KEYWORD IN THE ARRAY
     */
        if (keyWord.equals("")) {
            isKeyWordPresent = true;
        } else {
            for (int i = 0; i < input.length; i++) {
                if (input[i].equals(keyWord)) {
                    numberOfKeyWords++;
                    isKeyWordPresent = true;
                }
            }
        }

    /*
    IF THE ARRAY DOES NOT CONTAINS THE KEYWORD,
    IT WILL RETURN "Няма резултат"
     */
        if (isKeyWordPresent == false) {
            return "Няма резултат";
        }

    /*
    IF KEYWORD IS PRESENT MORE THAN 0 TIMES
    */
        if (numberOfKeyWords > 0) {
            return calculationsIfKeyWordIsPresent(numberOfKeyWords, wordsPerPage, pageNumber, keyWord);
        }

    /*
    IF input IS EMPTY STRING
    */
        if (numberOfKeyWords == 0 && isKeyWordPresent) {
            return calculationsIfKeyWordIsEmpty(input, wordsPerPage, pageNumber);
        }
        return null;
    }

    public static String calculationsIfKeyWordIsPresent(int numberOfKeyWords, int wordsPerPage, int pageNumber, String keyWord) {

        int numberOfTotalPagesToShow = 1;
        // if wordsArr are less than wordsPerPage then it will show only one(first) page
        if (numberOfKeyWords > wordsPerPage) {
            if (numberOfKeyWords % wordsPerPage != 0) {
                numberOfTotalPagesToShow = (numberOfKeyWords / wordsPerPage) + 1;
            } else {
                numberOfTotalPagesToShow = numberOfKeyWords / wordsPerPage;
            }
        }
        /*
        CREATES PAGES WITH WORDS
         */
        String[][] pagesAndWords = new String[numberOfTotalPagesToShow][wordsPerPage];
        int keyWordCounter = numberOfKeyWords;
        for (int i = 0; i < numberOfTotalPagesToShow; i++) {
            for (int j = 0; j < wordsPerPage; j++) {
                if (keyWordCounter == 0) {
                    pagesAndWords[i][j] = "";
                    break;
                }
                if (keyWordCounter < wordsPerPage) {
                    pagesAndWords[i][j] = keyWord;
                    keyWordCounter--;

                } else {
                    pagesAndWords[i][j] = keyWord;
                    keyWordCounter--;
                }
            }
        }

        String wordsToShow = "";
        // CHECKS IF THERE IS KEYWORD INSIDE THE PAGE
        try {
            // ADDS KEYWORDS TO STRING
            for (int i = 0; i < wordsPerPage; i++) {
                if (i + 1 == wordsPerPage) {
                    wordsToShow += pagesAndWords[pageNumber - 1][i];
                } else {
                    wordsToShow += pagesAndWords[pageNumber - 1][i] + ", ";
                }
            }
        } catch (Exception e) {
            wordsToShow = "Страницата е празна";
        }

        //REMOVES COMMA AND EMPTY SPACE AT THE END
        if (wordsToShow.charAt(wordsToShow.length() - 1) == ' ') {
            wordsToShow = wordsToShow.substring(0, wordsToShow.length() - 2);
        }

        return "Items: " + wordsToShow + "; " + "Total Items: " + numberOfKeyWords + "; " + "Total Pages: " + numberOfTotalPagesToShow;

    }

    public static String calculationsIfKeyWordIsEmpty(String[] input, int wordsPerPage, int pageNumber) {
        int numberOfKeyWords = input.length;
        int numberOfTotalPagesToShow = 1;
        if (numberOfKeyWords > wordsPerPage) {
            if (numberOfKeyWords % wordsPerPage != 0) {
                numberOfTotalPagesToShow = (numberOfKeyWords / wordsPerPage) + 1;
            } else {
                numberOfTotalPagesToShow = numberOfKeyWords / wordsPerPage;
            }
        }
        /*
        CREATES PAGES WITH WORDS
         */
        String[][] pagesAndWords = new String[numberOfTotalPagesToShow][wordsPerPage];
        int wordCounter = 0;
        int token = input.length;
        for (int i = 0; i < numberOfTotalPagesToShow; i++) {
            for (int j = 0; j < wordsPerPage; j++) {
                // FILL PAGES WITH WORDS
                if (wordCounter == token) {
                    pagesAndWords[i][j] = "";
                    break;
                } else {
                    pagesAndWords[i][j] = input[wordCounter];
                    wordCounter++;
                }
            }
        }

        String wordsToShow = "";
        // CHECKS IF THERE IS WORDS INSIDE THE PAGE
        try {
            // ADDS WORDS TO STRING
            for (int i = 0; i < wordsPerPage; i++) {
                if (i + 1 == wordsPerPage) {
                    wordsToShow += pagesAndWords[pageNumber - 1][i];
                } else {
                    wordsToShow += pagesAndWords[pageNumber - 1][i] + ", ";
                }
            }
        } catch (Exception e) {
            wordsToShow = "Страницата е празна";
        }

        //REMOVES COMMA AND EMPTY SPACE AT THE END
        if (wordsToShow.charAt(wordsToShow.length() - 1) == ' ') {
            wordsToShow = wordsToShow.substring(0, wordsToShow.length() - 2);
        }

        return "Items: " + wordsToShow + "; " + "Total Items: " + numberOfKeyWords + "; " + "Total Pages: " + numberOfTotalPagesToShow;
    }

}
