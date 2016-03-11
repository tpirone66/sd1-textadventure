//BreadcrumbTrail class for MArist Mayhem
import java.util.ArrayList;

public class BreadcrumbTrail {
	
	private Object[] pickupCrumb;
	private int crumb;
	
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
