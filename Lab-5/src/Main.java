//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//
//import javax.lang.model.util.Elements;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
////TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
//// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//public class Main {
//    public static void main(String[] args) {
//        String url = "https://en.wikipedia.org/";
//        Document document=null;
//
//        try {
//            // Fetch the HTML content from the URL
//            document = Jsoup.connect(url).get();
//
//           // System.out.println(document.title()+ document.body());
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//
//        }
//        ArrayList<Element> allElements=document.getAllElements();
//        Element img=null;
//        int counter=0;
//        String key="";
//        for (Element element : allElements) {
//            if(element.tagName().equals("img")) {
//                img=element;
//                counter++;
//
//            }
//          //  System.out.println(element.tagName());
//        }
//        if(counter>5)
//        {
//            System.out.println("Tag is greater then 5");
//
//        }
//        else
//        {
//            System.out.println(counter);
//        }
//        Scanner sc=new Scanner(System.in);
//        System.out.println("Enter Keyword\n");
//        key=sc.nextLine();
//
//        for (Element element : allElements) {
//            if(element.tagName().equals(key)) {
//                img=element;
//                counter++;
//
//            }
//            //  System.out.println(element.tagName());
//        }
//        System.out.println("Frequence is "+counter);
//
//    }
//
//    public static Map<String, Integer> analyzeTags( ArrayList<Element> allElements) {
//        Map<String, Integer> tagFrequency = new HashMap<>();
//        int imgTagCounter = 0;
//
//        for (Element element : allElements) {
//            String tagName = element.tagName();
//
//            // Update the frequency count in the map
//            tagFrequency.put(tagName, tagFrequency.getOrDefault(tagName, 0) + 1);
//
//
//        }
//
//
//
//        return tagFrequency;
//    }
//}

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // URLs to analyze
        Scanner scanner = new Scanner(System.in);
        List<String> urls = new ArrayList<>();

        System.out.println("Enter URLs (enter 'done' when finished):");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) break;
            urls.add(input);
        }

        // User-defined keywords
        System.out.println("Enter keywords to check frequency (separate by space):");
        String[] keywords = scanner.nextLine().split(" ");

        for (String url : urls) {
            try {
                // Fetch and analyze each URL
                System.out.println("\nAnalyzing URL: " + url);
                analyzePage(url, keywords);
            } catch (IOException e) {
                System.out.println("Failed to analyze URL: " + url);
            }
        }
    }

    public static void analyzePage(String url, String[] keywords) throws IOException {
        Document document = Jsoup.connect(url).get();

        // Get all elements and analyze tag frequencies
        Elements allElements = document.getAllElements();
        Map<String, Integer> tagFrequency = new HashMap<>();
        int imgTagCounter = 0;

        // Count tag frequencies and track <img> tags
        for (Element element : allElements) {
            String tagName = element.tagName();
            tagFrequency.put(tagName, tagFrequency.getOrDefault(tagName, 0) + 1);

            if (tagName.equalsIgnoreCase("img")) {
                imgTagCounter++;
            }
        }

        // Check if more than 5 <img> tags exist
        if (imgTagCounter > 5) {
            System.out.println("Warning: More than 5 <img> tags found on the page!");
        }

        // Sort tag frequencies
        List<Map.Entry<String, Integer>> sortedTags = new ArrayList<>(tagFrequency.entrySet());
        sortedTags.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        // Display sorted tag frequencies
        System.out.println("\nTag Frequencies (sorted by count):");
        for (Map.Entry<String, Integer> entry : sortedTags) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Analyze keyword frequency
        String pageText = document.text().toLowerCase();
        Map<String, Integer> keywordFrequency = new HashMap<>();

        for (String keyword : keywords) {
            int keywordCount = pageText.split("\\b" + keyword.toLowerCase() + "\\b").length - 1;
            keywordFrequency.put(keyword, keywordCount);
        }

        // Display keyword frequencies
        System.out.println("\nKeyword Frequencies:");
        for (String keyword : keywords) {
            System.out.println(keyword + ": " + keywordFrequency.getOrDefault(keyword, 0));
        }
    }
}
