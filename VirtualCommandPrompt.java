package GETA2021.DSA.DSAAssignment3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import GETA2021.DSA.DSAAssignment3.Tree.TreeNode;

public class VirtualCommandPrompt {

	String prompt = "R:/"; // When the shell start this prompt will be shown
	Tree structure = new Tree();

	/*
	 * Unicode symbols UTF-8
	 */
	char a = '\u251c';
	char b = '\u2500';
	char c = '\u2502';
	char d = '\u2514';

	/*
	 * | \u251c --> |- |
	 * 
	 * \u2500 --> -
	 * 
	 * | \u2502 -->| |
	 * 
	 * \u2514 --> | -
	 */

	/**
	 * Make a new directory
	 * 
	 * @param name
	 */
	public void makeDirectory(String name) {
		System.out.print(prompt);
		Tree.currentDirectory.addFolder(name);
	}

	/**
	 * Prints the structure of the directories
	 * 
	 * @param folders
	 * @param subFolders
	 */
	public void tree() {
		Queue<TreeNode> folders = new LinkedList<TreeNode>();
		if (Tree.currentDirectory.folders.size() > 0) {
			TreeNode currentNode = Tree.currentDirectory;
			depthFirstSearch(folders, currentNode);
			System.out.println("./n");

			int subFolders = currentNode.folders.size();
			String format = "" + d + b;
			int level = -1;
			while (folders.size() > 0) {
				TreeNode temp = folders.poll();
				if (temp == null) {
					level -= 1;
					if (level == -1) {
						subFolders--;
					}
				} else {
					level++;
					// the for loop is for number of spaces to be print
					for (int index = 0; index < 4 * level; index++) {
						if (index == 0 && subFolders > 1) {
							System.out.print(c);
						} else {
							System.out.print(" ");
						}
					}
					System.out.println(format + " " + temp.name);
				}
			}
			System.out.print("\n");
		}
	}

	/**
	 * Change the queue of sub folders and folders
	 * 
	 * @param folders
	 * @param currentNode
	 */
	public void depthFirstSearch(Queue<TreeNode> folders, TreeNode currentNode) {
		if (currentNode.folders.size() > 0) {
			for (int index = 0; index < currentNode.folders.size(); index++) {
				folders.add(currentNode.folders.get(index));
				depthFirstSearch(folders, currentNode.folders.get(index));
				// add null in the queue when the level of directories change
				folders.add(null);
			}
		}
	}

	/**
	 * Finds path of the folder in the sub folders recursively and store in a
	 * list
	 * 
	 * @param currentNode
	 * @param name
	 * @param pathList
	 * @param currentPath
	 */
	public void findPaths(TreeNode currentNode, String name,
			List<String> pathList, String currentPath) {
		for (TreeNode current : currentNode.folders) {
			if (current.name.contains(name)) {
				pathList.add(currentPath + "/" + current.name);
			} else {
				findPaths(current, name, pathList, currentPath + "/"
						+ current.name);
			}
		}
	}

	/**
	 * Find path of directory specified by user and print the specified path
	 * 
	 * @param currentNode
	 * @param name
	 */
	public void findFile(TreeNode currentNode, String name) {
		List<String> pathList = new ArrayList<String>();
		String currentPath = "./";
		findPaths(Tree.currentDirectory, name, pathList, currentPath);
		for (String path : pathList) {
			System.out.println(path);
		}
	}

	/**
	 * Goes back to the parent directory
	 */
	public void back() {
		if (Tree.currentDirectory != Tree.root) {

			TreeNode currentNode = Tree.currentDirectory;
			Tree.currentDirectory = currentNode.parentNode;
			prompt = prompt.replaceAll("/" + currentNode.name + ">", "");
			System.out.print(prompt);
		}
	}

	/**
	 * Shows file in the current folder
	 */
	public void showFile() {
		for (TreeNode node : Tree.currentDirectory.folders) {
			System.out.println(node.timeCreated + " " + node.name);
		}
	}

	/**
	 * Change directory and moves to the specified folder
	 * 
	 * @param folderName
	 */
	public void changeDirectory(String folderName) {

		for (TreeNode directory : Tree.currentDirectory.folders) {
			if (directory.name.equals(folderName)) {
				Tree.currentDirectory = directory;
				prompt += "/" + folderName + ">";
				System.out.println(prompt);
				return;
			}
		}
		System.out.println("Folder does not exist");
	}

	/**
	 * 
	 * Asks operation from the user
	 * 
	 * @param command
	 * @param argument
	 * @return false if user wants to exit
	 */
	public boolean selectOperation(String command, String argument) {
		if ("mkdir".equals(command)) {
			makeDirectory(argument);
			return true;
		} else if ("ls".equals(command)) {
			showFile();
			return true;
		} else if ("cd".equals(command)) {
			changeDirectory(argument);
			return true;
		} else if ("bk".equals(command)) {
			back();
			return true;
		} else if ("find".equals(command)) {
			findFile(Tree.currentDirectory, argument);
		} else if ("tree".equals(command)) {
			tree();
			return true;
		} else if ("exit".equals(command)) {
			return false;
		} else {
			System.out.println("wrong command");
			return true;
		}
		return true;
	}

	/**
	 * Starts the Virtual CP
	 */
	public void startShell() {
		new Tree();

		Scanner userInput = new Scanner(System.in);
		System.out.println("Welcome to Vrtual Command Prompt");
		System.out.print(prompt);
		
		while (true) {
			String command = "";
			String argument = "";
			String input = userInput.nextLine().trim();
			boolean gotCommand = false;
			
			for (int index = 0; index < input.length(); index++) {
				char currentCharacter = input.charAt(index);
				if (input.charAt(index) != ' ' && !gotCommand) {
					command += currentCharacter;
				} else {
					gotCommand = true;
					if (currentCharacter != ' ') {
						argument += currentCharacter;
					}
				}
			}
			
			if (!selectOperation(command, argument)) {
				break;
			}
		}
	}
}
