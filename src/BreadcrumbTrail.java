
//BreadcrumbTrail class for Marist Mayhem
import java.util.ArrayList;

public class BreadcrumbTrail {

	private Object[] pickupCrumb = new Object[5];
	private int crumb = -1;

	public void dropCrumb() {
		if (this.hasMoreCrumb() == false) {
			crumb--;
		}
	}

	public void pickupCrumb(Object x) {

	}

	public Object currentCrumb() {
		return pickupCrumb[crumb];

	}

	public boolean hasMoreCrumb() {
		return false;

	}
}
