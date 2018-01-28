import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * @author Adrien Audouard
 */

public class Dijkstra {
    public static void dijkstra(AgencyList agencyList, int n, int s) {
        LinkedList<Integer> res = new LinkedList<>();
        ArrayList<Integer> toTest = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            res.add(i, i == s ? 0 : -1);

            if (1 == 1) {
                if (agencyList.hasEdges(i)) {
                    if (agencyList.hasUniqueEdge(i, s)) {
                        res.add(i, agencyList.getWeight(i, s));
                    } else {
                        toTest.add(i);
                    }
                }
            } else {
                toTest.add(i);
            }

        }

        int last = s;
        int it = 0;
        while (!toTest.isEmpty()) {
            int lastCost = res.get(last);
            toTest.remove((Integer) last);

            for (int i : toTest) {
                it++;
                if (i == last) continue;

                int weight = agencyList.getWeight(last, i);

                if (weight == -1) {
                    continue;
                }

                int cost = lastCost == -1 ? 0 : lastCost;
                cost += weight;

                if (res.get(i) == -1 || res.get(i) > cost) {
                    res.set(i, cost);
                }
            }

            last = findMin(res, toTest);

            if (last == -1) break;
        }

        for (int i = 0; i < n; i++) {
            if (i == s) continue;

            System.out.print(res.get(i) + " ");
        }

        System.out.println();
        //System.out.println("it: " + it);
    }

    public static int findMin(LinkedList<Integer> linkedList, ArrayList<Integer> arrayList) {
        int min = -1;
        int minValue = Integer.MAX_VALUE;

        for (int i : arrayList) {
            if (linkedList.get(i) == -1) continue;

            if (linkedList.get(i) < minValue) {
                minValue = linkedList.get(i);
                min = i;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        FastReader fs = new FastReader();

        int t = fs.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = fs.nextInt();
            int m = fs.nextInt();

            AgencyList agencyList = new AgencyList(n);

            for(int a1 = 0; a1 < m; a1++){
                int x = fs.nextInt() - 1;
                int y = fs.nextInt() - 1;
                int r = fs.nextInt();

                agencyList.addEdges(x, y, r);

            }
            int s = fs.nextInt() - 1;

            dijkstra(agencyList, n, s);

        }
    }

    private static class AgencyList {
        private LinkedList<Pair<Integer, Integer>>[] agencyList;

        public AgencyList(int nodes) {
            this.agencyList = new LinkedList[nodes];

            for (int i = 0; i < nodes; i++) {
                this.agencyList[i] = new LinkedList<>();
            }
        }

        public void addEdges(int start, int end, int weight) {
            createEdges(start, end, weight);
            createEdges(end, start, weight);
        }

        private void createEdges(int start, int end, int weight) {
            Pair<Integer, Integer> pair = getEdges(start, end);

            if (pair == null) {
                this.agencyList[start].add(new Pair<>(end, weight));
            } else if (pair.getValue() > weight) {
                this.agencyList[start].remove(pair);

                this.agencyList[start].add(new Pair<>(end, weight));
            }
        }

        public boolean hasEdges(int node) {
            return agencyList[node] != null;
        }

        public int getWeight(int start, int end) {
            Pair<Integer, Integer> pair = getEdges(start, end);

            return pair == null ? -1 : pair.getValue();
        }

        public boolean hasUniqueEdge(int start, int end) {
            if (agencyList[start].size() != 1) return false;
            if (agencyList[start].getFirst().getKey() != end) return false;

            return true;
        }

        public Pair<Integer, Integer> getEdges(int start, int end) {
            for (Pair<Integer, Integer> pair : agencyList[start]) {
                if (pair.getKey() == end) return pair;
            }

            return null;
        }
    }

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}
