
//BreadcrumbTrail class for Marist Mayhem
import java.util.ArrayList;
@SuppressWarnings("unused")

public class BreadcrumbTrail {

	private Object[] pickupCrumb = new Object[5];
	private int crumb = -1;
	private int maxSize;

	public void dropCrumb() {
		if (this.hasMoreCrumbs() == false) {
			crumb--;
		}
	}

	public void pickupCrumb(Object x) {
		crumb++;
		pickupCrumb[crumb] = x;
	}

	public Object currentCrumb() {
		if (this.hasMoreCrumbs()) {
			return null;
		}
		else {
		return pickupCrumb[crumb];
		}
	}

	public boolean hasMoreCrumbs() {
		return (crumb == -1);

	}
	
	public boolean hasNoMoreCrumbs() {
			return (crumb == maxSize - 1);
		}
}