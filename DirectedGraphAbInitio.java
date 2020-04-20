import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class DirectedGraphAbInitio {

    private ArrayList<LinkedList<Integer>> vertices;
    int V;
    int[] outDegree;
    int[] hash;

    DirectedGraphAbInitio(int numOfV) {
        vertices = new ArrayList<>(); // vertices named from 0 to numOfV-1

        for (int i = 0; i < numOfV; i++) {
            vertices.add(new LinkedList<>());

        }
        V = numOfV;
    }

    public void addEdge(int v1, int v2) {
        vertices.get(v1).add(v2);

    }

    public void addVertex() {
        vertices.add(V, new LinkedList<>());
        V++;


    }

    public void deleteAllEdge(int v) {
        for (int i = 0; i < V; i++) {
            if (vertices.get(i).contains(v)) {
                vertices.get(i).remove(v);

            }

            if (i == v) {
                vertices.set(i, new LinkedList<>());

            }
        }
    }


    public void deleteOneEdge(int v1, int v2) {
        vertices.get(v1).remove((Integer) v2);

    }

    public void transpose() {
        ArrayList<LinkedList<Integer>> temp = vertices;
        vertices = new ArrayList<>(); // vertices named from 0 to numOfV-1

        for (int i = 0; i < V; i++) {
            vertices.add(new LinkedList<>());
        }
        for (int i = 0; i < V; i++) {
            LinkedList<Integer> adj = temp.get(i);
            for (Integer integer : adj) {
                addEdge(integer, i);
            }
        }
    }


    public void complement() {
        ArrayList<LinkedList<Integer>> temp = vertices;
        vertices = new ArrayList<>(); // vertices named from 0 to numOfV-1

        for (int i = 0; i < V; i++) {
            vertices.add(new LinkedList<>());
        }
        for (int i = 0; i < V; i++) {
            LinkedList<Integer> ll = temp.get(i);
            for (int j = 0; j < V; j++) {
                if (!ll.contains(j) && i != j) addEdge(i, j);
            }

        }


    }

    public void computeHashNOutDeg() {
        hash = new int[V];
        outDegree = new int[V];
        for (int i = 0; i < V; i++) {
            int sum = 0;
            int seven = 1;
            ArrayList<Integer> arr = new ArrayList<>(vertices.get(i));
            Collections.sort(arr);
            outDegree[i] = arr.size();
            for (int v : arr) {
                sum += seven * v;
                seven *= 7;
            }


            hash[i] = sum % 1000000007;
        }

    }

    public static void main(String[] args) {
        FastReader s = new FastReader();
        //Scanner s = new Scanner(System.in);
        int V = s.nextInt();
        int E = s.nextInt();
        int Q = s.nextInt();
        DirectedGraphAbInitio G = new DirectedGraphAbInitio(V);
        for (int i = 0; i < E; i++) {
            G.addEdge(s.nextInt(), s.nextInt());
        }
        for (int i = 0; i < Q; i++) {
            switch (s.nextInt()) {
                case 1:
                    G.addVertex();
                    break;
                case 2:
                    G.addEdge(s.nextInt(), s.nextInt());
                    break;
                case 3:
                    G.deleteAllEdge(s.nextInt());
                    break;
                case 4:
                    G.deleteOneEdge(s.nextInt(), s.nextInt());
                    break;
                case 5:
                    G.transpose();
                    break;
                case 6:
                    G.complement();
                    break;
                default:
                    break;
            }

        }

        System.out.println(G.V);

        G.computeHashNOutDeg();
        for (int v = 0; v < G.V; v++) {
            System.out.println(G.outDegree[v] + " " + G.hash[v]);
        }


    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
