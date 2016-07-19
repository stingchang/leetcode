/**
 * @author stingchang
 * */
package com.leet.q051;

import java.util.ArrayList;
import java.util.List;

public class Q054_SpitalMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return list;

		int col = matrix[0].length;
		int row = matrix.length;
		int minSide = Math.min(row, col);

		int round = minSide / 2;
		// System.out.println("row = "+row+", col = "+col+", minSide =
		// "+minSide+", round = "+round);
		for (int i = 0; i < round; i++) {
			// System.out.println(i + ", c = " + (col - 2 * i) + ", r = " + (row
			// - 2 * i));
			traverse(list, matrix, i, i, col - 2 * i, row - 2 * i);
		}

		// * * * * *
		// * * * * *
		// * * * * *
		if (minSide % 2 == 1) {
			// System.out.println("here");
			traverseSingleLayer(list, matrix, minSide / 2, minSide / 2, col - 2 * round, row - 2 * round);
		}
		System.out.println("\nlist = " + list);
		return list;
	}

	public void traverseSingleLayer(List<Integer> list, int[][] matrix, int a, int b, int c, int r) {
		if (c > 1) {
			// horizontal
			System.out.print("\nhorozhontal: ");
			for (int i = 0; i < c; i++) {
				list.add(matrix[a][b + i]);
				System.out.print(matrix[a][b + i] + " ");
			}
		} else if (r > 1) {

			// vertical
			System.out.print("\nvertical: ");
			for (int i = 0; i < r; i++) {
				list.add(matrix[a + i][b]);
				System.out.print(matrix[a + i][b] + " ");
			}
		}
		// case: [[1]]
		else {
			list.add(matrix[a][b]);
		}

	}

	public void traverse(List<Integer> list, int[][] matrix, int a, int b, int c, int r) {
		// up
		System.out.print("up: ");
		for (int i = 0; i < c - 1; i++) {
			list.add(matrix[a][b + i]);
			System.out.print(matrix[a][b + i] + " ");
		}
		// right
		System.out.print("\nri: ");
		for (int i = 0; i < r - 1; i++) {
			list.add(matrix[a + i][b + c + -1]);
			System.out.print(matrix[a + i][b + c + -1] + " ");
		}
		// bottom
		System.out.print("\nbo: ");
		for (int i = c - 1; i > 0; i--) {
			list.add(matrix[a + r - 1][b + i]);
			System.out.print(matrix[a + r - 1][b + i] + " ");
		}
		// left
		System.out.print("\nle: ");
		for (int i = r - 1; i > 0; i--) {
			list.add(matrix[a + i][b]);
			System.out.print(matrix[a + i][b] + " ");
		}
		// System.out.print("\nright: ");
		// System.out.println(list);
	}

	public static void main(String[] args) {
		Q054_SpitalMatrix q = new Q054_SpitalMatrix();
		int[][] m = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		q.spiralOrder(m);
	}
}

// 1. find out how many rounds we need to traverse: floor of (shorter side)/2
// 3 rounds
// * * * * *
// * * * * *
// * * * * *
// * * * * *
// * * * * *
// 2 rounds
// * * * * *
// * * * * *
// * * * * *
// * * * * *

// 2. each round we traverse four sides of 'sub' array
// ------|
// | |
// | |
// |------
// a method traverse four sides of the matrix, upper left point (a,b), row = r,
// column = c
// [a][b]~[a+c-2][b], [a+c-1][b]~[a+c-1][b+r-2], [a+c-1][b+r-1]~[a][b+r-1],
// [a+c-1][b]~[a-1][b]
