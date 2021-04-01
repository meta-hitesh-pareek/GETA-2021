package GETA2021.DSA.DSAAssignment3;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Maintain the tree structure 
 * 
 * @since 10-03-2021
 * @author Hitesh Pareek
 */
public class Tree {
	static TreeNode currentDirectory;
	static TreeNode root;

	/**
	 * Initializes the tree structure
	 */
	Tree() {
		root = new TreeNode();
		currentDirectory = root;
	}

	/**
	 * Contains Node Information
	 * 
	 * @since 10-03-2021
	 * @author Hitesh Pareek
	 */
	class TreeNode {
		String name;
		List<TreeNode> folders;
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		String timeCreated;
		TreeNode parentNode;
		int totalFolder = 0;

		/**
		 * Initializes the node w
		 * 
		 * @param name
		 * @param parentNode
		 */
//		TreeNode(String name, TreeNode parentNode) {
//			this.name = name;
//			this.parentNode = parentNode;
//			folders = new ArrayList<TreeNode>();
//			parentNode = Tree.currentDirectory;
//		}

		TreeNode() {
			name = "root";
			timeCreated = format.format(new Date());
			folders = new ArrayList<TreeNode>();
			parentNode = null;
		}

		public TreeNode(String name) {
			this.name = name;
			timeCreated = format.format(new Date());
			folders = new ArrayList<TreeNode>();
			parentNode = Tree.currentDirectory;

		}

		public TreeNode addFolder(String folderName) {
			TreeNode subFolder = new TreeNode(folderName);
			folders.add(subFolder);
			totalFolder++;
			return subFolder;
		}
	}

}
