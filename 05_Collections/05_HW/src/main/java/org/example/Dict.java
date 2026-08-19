package org.example;


import javax.sound.midi.Soundbank;
import java.util.*;

public class Dict {
    private Map<String, List<String>> dictionary = new HashMap<>();
    private Map<String, Integer> wordPopularity = new HashMap<>();
    private String name;
    private Scanner scanner = new Scanner(System.in);

    public void startDictionary() {

        System.out.print("Enter Dictionary name: ");
        this.name = scanner.next();
        while (true) {


            System.out.println("[ 1 ] - Show Dictionary\n[ 2 ] - CRUD Word\n[ 3 ] - CRUD Translations\n[ 4 ] - Top 10 Words\n[ 5 ] - Show translation by Word\n[ 0 ] - Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showAllTranslations();
                    break;
                case 2:
                    System.out.print("\n [ 1 ] - Add new word\n[ 2 ] - Remove word\n[ 3 ] - Update word");
                    int choiceWord = scanner.nextInt();

                    switch (choiceWord) {
                        case 1:
                            addNewWord();
                            break;
                        case 2:
                            removeWord();
                            break;
                        case 3:
                            editWord();
                            break;
                        default:
                            System.out.println("Wrong Choice");
                            break;
                    }
                    break;
                case 3:
                    System.out.print("\n [ 1 ] - Add translation\n[ 2 ] - Remove translation\n[ 3 ] - Update translation");
                    int choiceTrans = scanner.nextInt();

                    switch (choiceTrans) {
                        case 1:
                            addTranslationToWord();
                            break;
                        case 2:
                            deleteTranslation();
                            break;
                        case 3:
                            replaceTranslation();
                            break;
                        default:
                            System.out.println("Wrong Choice");
                            break;
                    }
                    break;
                case 4:
                    System.out.print("\n[ 1 ] - Top 10 popular words\n[ 2 ] - Top 10 unpopular words");
                    int choiceTop = scanner.nextInt();

                    switch (choiceTop) {
                        case 1:
                            showTop10Popular();
                            break;
                        case 2:
                            showTop10Unpopular();
                            break;
                        default:
                            System.out.println("Wrong Choice");
                            break;
                    }
                    break;
                case 5:
                    readTranslation();
                    break;

                case 0:
                    System.out.println("Bye");
                    return;
                default:
                    break;
            }
        }
    }

    private void showAllTranslations() {
        if (dictionary.isEmpty()) {
            System.out.println("Dictionary is empty!");
        } else {
            dictionary.forEach((key, traslations) -> System.out.println(key + ": " + traslations));
        }
    }

    private void addNewWord() {
        System.out.print("\nEnter Word to Translate: ");
        String key = scanner.next().toLowerCase();
        System.out.print("\nEnter Translation: ");
        //якщо ключа немає створ новий список і приписує до нього ключ
        dictionary.computeIfAbsent(key, k -> new ArrayList<>()).add(scanner.next().toLowerCase());
    }

    private void removeWord() {
        System.out.print("\nEnter Word to delete: ");
        String key = scanner.next().toLowerCase();
        if (dictionary.containsKey(key)) {
            dictionary.remove(key);

            if (wordPopularity.containsKey(key)) {
                wordPopularity.remove(key);
            }
            System.out.printf("\nWord %s was removed", key);
        }
    }

    private void editWord() {
        System.out.print("\nEnter Word to Edit");
        String word = scanner.next().toLowerCase();

        if (dictionary.containsKey(word)) {
            System.out.print("\nEnter new word: ");
            String newWord = scanner.next().toLowerCase();

            if (dictionary.containsKey(newWord)) {
                System.out.println("This word already exists!");
                return;
            }

            List<String> wordTranslations = dictionary.get(word);
            dictionary.remove(word);
            if (wordPopularity.containsKey(word)) {
                wordPopularity.remove(word);
            }

            dictionary.computeIfAbsent(newWord, k -> new ArrayList<>()).addAll(wordTranslations);
            System.out.println("Word Edited!");
        }
    }

    private void addTranslationToWord() {
        System.out.println("Enter Word");
        String word = scanner.next().toLowerCase();

        if (!dictionary.containsKey(word)) {
            System.out.printf("Word %s doesn't exist", word);
            return;
        }
        System.out.println("Enter new Translation");
        String trans = scanner.next().toLowerCase();
        dictionary.get(word).add(trans);
        System.out.println("Translation Added!");
    }

    private void replaceTranslation() {
        System.out.println("Enter Word");
        String word = scanner.next().toLowerCase();

        if (dictionary.containsKey(word)) {
            List<String> translations = dictionary.get(word);
            System.out.println("Translations: " + translations);

            System.out.print("\nEnter translation to replace: ");
            String oldTrans = scanner.next().toLowerCase();

            if (translations.contains(oldTrans)) {
                translations.remove(oldTrans);

                System.out.print("\nEnter new translation: ");
                String newTrans = scanner.next().toLowerCase();
                translations.add(newTrans);

                System.out.println("Translation replaced!");
            } else {
                System.out.println("Wrong Translation");
            }
        }
    }

    private void deleteTranslation() {
        System.out.println("Enter Word");
        String word = scanner.next().toLowerCase();

        if (dictionary.containsKey(word)) {
            List<String> translations = dictionary.get(word);
            System.out.println("Translations: " + translations);

            System.out.print("\nEnter translation to delete: ");
            String oldTrans = scanner.next().toLowerCase();

            if (translations.contains(oldTrans)) {
                translations.remove(oldTrans);

                System.out.println("Translation was removed!");
            } else {
                System.out.println("Wrong Translation");
            }
        }
    }

    private void readTranslation() {
        System.out.print("\nEnter word to find translation: ");
        String word = scanner.next().toLowerCase();

        if (dictionary.containsKey(word)) {
                                                        //дістає знач (тобто int)
            wordPopularity.putIfAbsent(word, wordPopularity.getOrDefault(word, 0) + 1);
            System.out.println("Translations for " + word + " " + dictionary.get(word));
        } else {
            System.out.println("Word not found");
        }

    }

    private void showTop10Popular() {
        System.out.println("\n-----Top 10 popular----");

        if (wordPopularity.isEmpty()) {
            System.out.println("\nNo word have been read!\n");
            return;
        }

        //entry set (на KeyValuePair) stream - доступ до LINQ
        wordPopularity.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(10)
                .forEach(e -> System.out.println(e.getKey() + " was read: " + e.getValue() + " times"));
    }

    private void showTop10Unpopular() {
        System.out.println("\n-----Top 10 unpopular----");

        if (wordPopularity.isEmpty()) {
            System.out.println("\nNo word have been read!\n");
            return;
        }

        wordPopularity.entrySet().stream()
                .sorted(Map.Entry.comparingByValue()).limit(10)
                .forEach(e -> System.out.println(e.getKey() + " was read: " + e.getValue() + " times"));
    }
}