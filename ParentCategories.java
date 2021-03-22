import java.util.ArrayList;
import java.util.List;

/**
 * Stores the information of the parent categories
 *
 * @since 21-03-2021
 * @author Hitesh Pareek
 */
public class ParentCategories {

	static List<ParentCategories> categoryList = new ArrayList<ParentCategories>();
	String categoryName;
	int numberOfChildCategories;

	/**
	 * Initializes the name and child categories of parent categories
	 * 
	 * @param categoryName
	 * @param numberOfChildCategories
	 */
	public ParentCategories(String categoryName, int numberOfChildCategories) 
	{
		if(categoryName==null) {
			throw new NullPointerException("Category name can not be null");
		}
		if(numberOfChildCategories<0) {
			throw new IllegalArgumentException("Number of Child categories can not be a negative value");
		}
		
		this.categoryName = categoryName;
		this.numberOfChildCategories = numberOfChildCategories;
	}

	/**
	 * Gets the category name
	 * 
	 * @return categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * Sets the name of the category
	 * 
	 * @param categoryName
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * Get the number of child categories
	 * 
	 * @return numberodChildCategories
	 */
	public int getNumberOfChildCategories() {
		return numberOfChildCategories;
	}

	/**
	 * Set the number of child categories
	 * 
	 * @param numberOfChildCategories
	 */
	public void setNumberOfChildCategories(int numberOfChildCategories) {
		this.numberOfChildCategories = numberOfChildCategories;
	}
}
