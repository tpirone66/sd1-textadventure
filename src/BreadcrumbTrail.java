//BreadcrumbTrail class for Marist Mayhem
import java.util.ArrayList;
@SuppressWarnings("unused")

public class BreadcrumbTrail {
	
	static Object[] pickupCrumb = new Object[5];
	static int currCrumb;
	static int maxSize = 5;
	
	public static void startTrail() {
		int currCrumb = -1;
	}
	
	//push
	public static void dropCrumb(int currLoc) {
		if (hasNoMoreCrumbs() == false) {
			pickupCrumb[currCrumb] = currLoc;
			currCrumb++;
		}
		else {
			for (int i = 0; i < pickupCrumb.length - 1; i++) {
				pickupCrumb[i] = pickupCrumb[i + 1];
			}
			pickupCrumb[maxSize - 1] = currLoc;
		}
	}

	//pop
	public static int pickupCrumb() {
		int temp = (int) pickupCrumb[currCrumb];
		currCrumb--;
		return temp;
	}

	//top
	public Object currentCrumb() {
		if (currCrumb == -1) {
			return null;
		}
		else {
		return pickupCrumb[currCrumb];
		}
	}
	
	//isEmpty
	public boolean hasMoreCrumbs() {
		return (currCrumb == -1);

	}
	
	//isFull
	public static boolean hasNoMoreCrumbs() {
			return (currCrumb == maxSize - 1);
		}
}