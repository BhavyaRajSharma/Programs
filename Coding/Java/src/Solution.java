//import java.io.*;
//import java.math.*;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import org.json.*;
//import java.net.ProtocolException;
//
//import java.security.*;
//import java.text.*;
//import java.util.*;
//import java.util.concurrent.*;
//import java.util.function.*;
//import java.util.regex.*;
//import java.util.stream.*;
//
//import static java.util.stream.Collectors.joining;
//import static java.util.stream.Collectors.toList;
//
//class Result
//{
//
//    /*
//     * Complete the 'getTotalGoals' function below.
//     *
//     * The function is expected to return an INTEGER.
//     * The function accepts following parameters:
//     *  1. STRING team
//     *  2. INTEGER year
//     */
//
//    private static String getStringUrlForTeam1(String team, int year, int page)
//    {
//        return "https://jsonmock.hackerrank.com/api/football_matches?year=" + year + "&team1=" + team + "&page=" + page;
//    }
//    private static String getStringUrlForTeam2(String team, int year, int page)
//    {
//        return "https://jsonmock.hackerrank.com/api/football_matches?year=" + year + "&team2=" + team + "&page=" + page;
//    }
//    private static int getTotalGoalsForTeam1(String team, int year) throws IOException
//    {
//        int totalTeam1goal=0;
//        int page = 1;
//        String urlString = "";
//        HttpURLConnection con = null;
//        BufferedReader in = null;
//        boolean loopIn = true;
//        while (loopIn)
//        {
//            urlString = getStringUrlForTeam1(team, year, page);
//            URL url = new URL(urlString);
//            con = (HttpURLConnection) url.openConnection();
//            con.setRequestMethod("GET");
//            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//            String inputLine;
//            StringBuffer content = new StringBuffer();
//            while ((inputLine = in.readLine()) != null)
//            {
//                content.append(inputLine);
//            }
//            JSONObject obj = new JSONObject(content.toString());
//            int pageName = (int)(obj.getJSONObject("").getString("total_pages"));
//            System.out.println(pageName);
//        }
//        if (in != null)
//            in.close();
//        if (con != null)
//            con.disconnect();
//        return  0;
//    }
//    public static int getTotalGoals(String team, int year) throws IOException
//    {
//        getTotalGoalsForTeam1(team,year);
//        return 0;
//    }
//
//}
//public class Solution
//{
//
//}