/**BreadcrumbTrail class for Marist Mayhem*/

//anywhere it mentions @SupressWarnings, ignore it

import java.util.ArrayList;
import java.util.Stack;

@SuppressWarnings("unused")

public class BreadcrumbTrail {

	// variables
	static int[] pickupCrumb = new int[10];
	static int currCrumb;
	static int maxSize = 10;

	// starts a new breadcrumb trail where one cannot backtrack at the start of
	// the game
	public static void startTrail() {
		currCrumb = -1;
	}

	// push
	public static void dropCrumb(int currLoc) {
		if (hasNoMoreCrumbs() == false) {
			pickupCrumb[currCrumb + 1] = currLoc;
			currCrumb++;
		} else {
			for (int i = 0; i < pickupCrumb.length - 1; i++) {
				pickupCrumb[i] = pickupCrumb[i + 1];
			}
			pickupCrumb[maxSize - 1] = currLoc;
		}
	}

	// pop
	public static int pickupCrumb() {
		int temp = (int) pickupCrumb[currCrumb];
		currCrumb--;
		return temp;
	}

	// top
	@SuppressWarnings("null")
	public static int currentCrumb() {
		if (currCrumb == -1) {
			return (Integer) null;
		} else {
			return pickupCrumb[currCrumb];
		}
	}

	// isEmpty
	public static boolean hasMoreCrumbs() {
		return (currCrumb == -1);
	}

	// isFull
	public static boolean hasNoMoreCrumbs() {
		return (currCrumb == maxSize - 1);
	}
}