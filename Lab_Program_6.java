package cn;
import java.util.*;

public class P7
{
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args)
    {
        int V, E = 0, checkNegative;
        int w[][] = new int[20][20];
        int edge[][] = new int[50][2];

        System.out.println("Enter the number of vertices:");
        V = in.nextInt();

        System.out.println("Enter the weight matrix");
        for (int i = 0; i < V; i++)
        {
            for (int j = 0; j < V; j++)
            {
                w[i][j] = in.nextInt();
                if (w[i][j] != 0)
                {
                    edge[E][0] = i;
                    edge[E][1] = j;
                    E++;
                }
            }
        }

        checkNegative = bellmanFord(w, V, E, edge);

        if (checkNegative == 1)
        {
            System.out.println("\nNo negative weight cycle exists\n");
        }
        else
        {
            System.out.println("\nNegative weight cycle exists\n");
        }
    }

    public static int bellmanFord(int w[][], int V, int E, int edge[][])
    {
        int u, v, S, flag = 1;
        int distance[] = new int[20];
        int parent[] = new int[20];

        for (int i = 0; i < V; i++)
        {
            distance[i] = 999;
            parent[i] = -1;
        }

        System.out.println("Enter the source vertex (0 to " + (V - 1) + "):");
        S = in.nextInt();
        distance[S] = 0;

        for (int i = 0; i < V - 1; i++)
        {
            for (int k = 0; k < E; k++)
            {
                u = edge[k][0];
                v = edge[k][1];

                if (distance[u] != 999 && distance[u] + w[u][v] < distance[v])
                {
                    distance[v] = distance[u] + w[u][v];
                    parent[v] = u;
                }
            }
        }

        for (int k = 0; k < E; k++)
        {
            u = edge[k][0];
            v = edge[k][1];

            if (distance[u] != 999 && distance[u] + w[u][v] < distance[v])
            {
                flag = 0;
                break;
            }
        }

        if (flag == 1)
        {
            for (int i = 0; i < V; i++)
            {
                System.out.println("Vertex " + i + " → Cost = " + distance[i] + ", Parent = " + parent[i]);
            }
        }

        return flag;
    }
}
