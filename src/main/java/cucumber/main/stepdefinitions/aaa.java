package cucumber.main.stepdefinitions;

import com.mashape.unirest.http.Unirest;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jboiko on 04/12/2017.
 */
public class aaa {

    private static List<String> readUrl(String urlString) throws Exception {
        JSONObject jObject = new JSONObject(Unirest.get(urlString).asString().getBody().trim());
        List<String> results = new ArrayList<>();
        JSONArray jArray = jObject.getJSONArray("data");
        for (int x = 0; x < jArray.length(); x++) {
            JSONObject secondObject = jArray.getJSONObject(x);
            try {
                String title = secondObject.get("Title").toString();
                if (title != null) {
                    results.add(title);
                }
            } catch (NullPointerException w) {
            }
        }
        return results;
    }

    public static void main(String[] args) {
        try {
            List<String> unSorted = readUrl("https://jsonmock.hackerrank.com/api/movies/search");
            java.util.Collections.sort(unSorted);
            for (int x = 0; x < unSorted.size(); x++) {
                System.out.println(unSorted.get(x));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }











 /*
        int[][] numbers = {
                {2},
                {5, 7},
                {1, 8, 3},
                {6, 0, 9, 4}
    };

        int result = numbers[0][0];

        for (int i = 1; i < numbers.length; i++) {
            result += numbers[3][i];
        }

        System.out.println(numbers[2][1]);


        int[] arr = {4,5,6,7,8};
        System.out.println(findNumber(arr, 5));

        final int needle = 42;
        final int[] haystack = {1, 2, 3, 42};

// Spoiler alert: index == 3
        final int index = Ints.indexOf(haystack, needle);
        final boolean index2 = Ints.contains(haystack, needle);
        System.out.println(index2);
        */
    }
}
