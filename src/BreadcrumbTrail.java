//BreadcrumbTrail class for Marist Mayhem
import java.util.ArrayList;
@SuppressWarnings("unused")

public class BreadcrumbTrail {
	
	public void ArrayStack() {
		Object[] pickupCrumb = new Object[5];
		int crumb = -1;
		int maxSize;
	}

	public void dropCrumb(int crumb) {
		if (this.hasMoreCrumbs(crumb) == false) {
			crumb--;
		}
	}

	public void pickupCrumb(int crumb, Object[] pickupCrumb, Object x) {
		crumb++;
		pickupCrumb[crumb] = x;
	}

	public Object currentCrumb(Object[] pickupCrumb, int crumb) {
		if (this.hasMoreCrumbs(crumb)) {
			return null;
		}
		else {
		return pickupCrumb[crumb];
		}
	}

	public boolean hasMoreCrumbs(int crumb) {
		return (crumb == -1);

	}
	
	public boolean hasNoMoreCrumbs(int crumb, int maxSize) {
			return (crumb == maxSize - 1);
		}
}