//BreadcrumbTrail class for Marist Mayhem
import java.util.ArrayList;
@SuppressWarnings("unused")

public class BreadcrumbTrail {
	
	Object[] pickupCrumb = new Object[5];
	int currCrumb;
	int maxSize = 5;
	
	public void startTrail() {
		int currCrumb = -1;
	}
	
	//push
	public void dropCrumb(int currLoc) {
		if (this.hasNoMoreCrumbs() == false) {
			pickupCrumb[currCrumb] = currLoc;
			currCrumb++;
		}
		else {
			currCrumb = -1;
		}
	}

	//pop
	public int pickupCrumb() {
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
	public boolean hasNoMoreCrumbs() {
			return (currCrumb == maxSize - 1);
		}
}