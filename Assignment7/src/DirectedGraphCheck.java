import java.util.Scanner;

public class DirectedGraphCheck {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];

        // Read adjacency matrix
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        // Check if directed
        boolean directed = false;
        for(int i = 0; i < n && !directed; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] != matrix[j][i]){
                    directed = true;
                    break;
                }
            }
        }
        System.out.println("Which one?" + (directed ? "Directed graph" : "Undirected graph"));
    }
}
