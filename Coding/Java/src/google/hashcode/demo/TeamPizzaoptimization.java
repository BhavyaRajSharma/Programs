package google.hashcode.demo;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
public class TeamPizzaoptimization
{
    //    private static int gccount=0;
    private static int[] pizzaUsed;
    private static long[][] pizzaCache;
    private static Long MAX_SCORE = 0L;
    private static HashMap<Integer, List<Integer>> teamPizzaIndexList = new HashMap<>();
    private static HashMap<Integer, List<Integer>> finalList;
    private static ArrayList<String> lines = new ArrayList<>();
    private static void sendPizza(int oderCount, int pizzLeft, int teamIndex, int[] teams, String[] pizzas, HashMap<String, Integer> uniqueIngredients, long score)
    {
        if (pizzaCache[teamIndex][pizzLeft] != 0)
        {
            //            System.out.println("Calculating Max Score...");
            if (score > MAX_SCORE)
            {
                System.out.println("New Max Found : " + score);
                MAX_SCORE = score;
                finalList = new HashMap<>();
                for (Integer team : teamPizzaIndexList.keySet())
                {
                    if (teamPizzaIndexList.get(team).size() == 0)
                        continue;
                    finalList.put(team, new ArrayList<>(teamPizzaIndexList.get(team)));
                }
                System.out.println(finalList.size());
                for (Integer team : finalList.keySet())
                {
                    System.out.print(teams[team] + " ");
                    for (Integer Pizza : finalList.get(team))
                    {
                        System.out.print(Pizza + " ");
                    }
                    System.out.println();
                }
            }
        }
        else
        {
            //        gccount++;
            //        System.out.println("order count : "+oderCount+" pizzaLeft : "+pizzLeft+" teamIndex : "+teamIndex+" score : "+score);
            if (oderCount == 0)
            {
                score += (long) Math.pow(uniqueIngredients.size(), 2);
                for (int i = teamIndex + 1; i < teams.length; i++)
                {

                    //                System.out.println("Searching for more teams : ");
                    teamPizzaIndexList.put(new Integer(i), new ArrayList<>());
                    sendPizza(teams[i], pizzLeft, i, teams, pizzas, new HashMap<>(), score);
                    teamPizzaIndexList.remove(new Integer(i));
                    //                System.out.println("Searching complete for more teams : ");
                }
                System.gc();
            }
            if (oderCount == 0 && pizzLeft == 0)
            {
                //            System.out.println("Calculating Max Score...");
                if (score > MAX_SCORE)
                {
                    System.out.println("New Max Found : " + score);
                    MAX_SCORE = score;
                    finalList = new HashMap<>();
                    for (Integer team : teamPizzaIndexList.keySet())
                    {
                        if (teamPizzaIndexList.get(team).size() == 0)
                            continue;
                        finalList.put(team, new ArrayList<>(teamPizzaIndexList.get(team)));
                    }
                    System.out.println(finalList.size());
                    for (Integer team : finalList.keySet())
                    {
                        System.out.print(teams[team] + " ");
                        for (Integer Pizza : finalList.get(team))
                        {
                            System.out.print(Pizza + " ");
                        }
                        System.out.println();
                    }
                }
            }
            if (oderCount > 0)
            {
                for (int i = 0; i < pizzas.length; i++)
                {
                    if (pizzaUsed[i] == 0)
                    {
                        pizzaUsed[i] = 1;
                        for (String ingredients : pizzas[i].split(" "))
                        {
                            uniqueIngredients.put(ingredients, uniqueIngredients.getOrDefault(ingredients, 0) + 1);
                        }
                        teamPizzaIndexList.get(new Integer(teamIndex)).add(new Integer(i));
                        //                    System.out.println("Added pizza : "+i+" for team : "+teamIndex);
                        sendPizza(oderCount - 1, pizzLeft - 1, teamIndex, teams, pizzas, uniqueIngredients, score);
                        //                    System.out.println("Removed pizza : "+i+" for team : "+teamIndex);
                        teamPizzaIndexList.get(new Integer(teamIndex)).remove(new Integer(i));
                        for (String ingredients : pizzas[i].split(" "))
                        {
                            uniqueIngredients.put(ingredients, uniqueIngredients.get(ingredients) - 1);
                            if (uniqueIngredients.get(ingredients) == 0)
                                uniqueIngredients.remove(ingredients);
                        }
                        pizzaUsed[i] = 0;
                    }
                }
            }
        }
    }
    public static void serveTeams(int pizzaLeft, int[] teams, String[] pizzas)
    {
        for (int i = 0; i < teams.length; i++)
        {
            System.out.println("i:" + i);
            teamPizzaIndexList.put(new Integer(i), new ArrayList<>());
            sendPizza(teams[i], pizzaLeft, i, teams, pizzas, new HashMap<>(), 0L);
            teamPizzaIndexList.remove(new Integer(i));
        }
    }

    public static void takeInputs(String fileName)
    {
        File file = new File(fileName);

        try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8.name()))
        {
            while (sc.hasNextLine())
            {
                lines.add(sc.nextLine());
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        //        5 1 2 1
        //        3 onion pepper olive
        //        3 mushroom tomato basil
        //        3 chicken mushroom pepper
        //        3 tomato mushroom basil
        //        2 chicken basil

        String fileName = "C:\\Users\\bhavya.sharma1\\Desktop\\hashCode\\";
        fileName += "c_many_ingredients.in";
        //        fileName+="a_example";
        if (args.length > 0)
            takeInputs(args[0]);
        else
            takeInputs(fileName);
        String[] line1 = lines.get(0).split(" ");
        int t2 = Integer.valueOf(line1[1]);
        int t3 = Integer.valueOf(line1[2]);
        int t4 = Integer.valueOf(line1[3]);
        int pizzaCount = Integer.valueOf(line1[0]);
        int teamCounts = t2 + t3 + t4;
        System.out.println(t2 + " " + t3 + " " + t4);
        int[] teams = new int[teamCounts];
        for (int i = 0; i < t2; i++)
        {
            teams[i] = 2;
        }
        for (int i = 0; i < t3; i++)
        {
            teams[i + t2] = 3;
        }
        for (int i = 0; i < t4; i++)
        {
            teams[i + t2 + t3] = 4;
        }
        pizzaCache = new long[teamCounts][pizzaCount];
        pizzaUsed = new int[pizzaCount];
        String[] pizzas = new String[pizzaCount];
        String[] values;
        String line;
        for (int i = 0; i < pizzaCount; i++)
        {
            values = lines.get(i + 1).split(" ");
            line = "";
            for (int j = 1; j < values.length; j++)
            {
                line += values[j] + " ";
            }
            pizzas[i] = line;
        }
        //        for(int i=0;i<teams.length;i++){
        //            System.out.println(i+" "+teams[i]);
        //        }
        serveTeams(pizzaCount, teams, pizzas);
        System.out.println(MAX_SCORE);
        System.out.println(finalList.size());
        for (Integer team : finalList.keySet())
        {
            System.out.print(teams[team] + " ");
            for (Integer Pizza : finalList.get(team))
            {
                System.out.print(Pizza + " ");
            }
            System.out.println();
        }

    }
}

