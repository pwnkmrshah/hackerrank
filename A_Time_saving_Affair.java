package coding;

import java.util.Scanner;

public class A_Time_saving_Affair {

	public static void main(String[] args) {
		

		Scanner s = new Scanner(System.in);
		
		
			int n = s.nextInt();
			int t = s.nextInt();
			int m = s.nextInt();
			int[][] data = new int[m][3];
			for (int i = 0; i < m; i++) {
				data[i][0] = s.nextInt() - 1;
				data[i][1] = s.nextInt() - 1;
//				data[i][2] = 6;
				data[i][2] = s.nextInt();
			}

			int present = 0;
			int first_present = present;

			int[] ans = new int[n];
			int[] visit = new int[n];

			for (int i = 0; i < n; i++) {
				ans[i] = 100000;
			}

			visit[present] = 1; // // 1 visited
			ans[present] = 0;

			int total_visited = 0;
			// int present =1;
			int check = 0;
			while (check == 0) {

				for (int i = 0; i < m; i++) {
					if (data[i][0] == present) {
						ans[data[i][1]] = Math.min(ans[data[i][1]],
								ans[present] + data[i][2]);
						// System.out.println("1" );
					}
					if (data[i][1] == present) {
						ans[data[i][0]] = Math.min(ans[data[i][0]],
								ans[present] + data[i][2]);
						// System.out.println("2");
					}

				}
				int min = 1000000;
				int previous_present = present;
				for (int i = 0; i < n; i++) {
					if (visit[i] == 0) {
						if (ans[i] <= min) {
							present = i;	
							min = ans[i];
						}
					}

				}
				visit[present] = 1;

				if (previous_present == present)
					check = 1;

				total_visited++;

				// System.out.println(" ");
			}

			for (int i = 0; i < n; i++) {
				if (i != first_present) {
					if (ans[i] == 100000)
						System.out.print("-1" + " ");
					else
						System.out.print(ans[i] + " ");

				}
			}

			System.out.println("");
			
			int final_ans = ans[ans.length-1];
			System.out.println(ans[ans.length-1]);
			
			System.out.println(final_ans + ((final_ans/t)*t));

		

	
		
		
	}

}
