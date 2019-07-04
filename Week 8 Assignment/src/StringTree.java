import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StringTree {

	private Node root;

	public void add(String word) {

		Node temp = new Node(word);
		// if first word
		if (root == null) {
			root = temp;
		} else {
			Node p = root;
			Node previous = root;
			// loop for find location
			while (p != null) {
				previous = p;
				// compare the word
				int compW = word.compareTo(p.value);
				if (compW < 0) {
					p = p.left;
				} else {
					p = p.right;
				}
			}
			// set previous
			int compPrev = word.compareTo(previous.value);
			if (compPrev > 0) {
				previous.right = temp;
			} else {
				previous.left = temp;
			}
		}
	}

	private void inOrder(Node binTree) {
		if (binTree != null) {
			inOrder(binTree.left);
			System.out.print(binTree.value + " ");
			inOrder(binTree.right);
		}
	}

	public void printTree() {
		inOrder(root);
	}

	public static void main(String[] args) throws FileNotFoundException {

		StringTree tree = new StringTree();
		// working directory
		System.out.println(System.getProperty("user.dir"));
		// file to use from working directory

		File file = new File(System.getProperty("user.dir") + "/Vegetables.txt");
		Scanner scanner = new Scanner(file);

		while (scanner.hasNextLine()) {

			String line = scanner.nextLine();

			String[] words = line.split(" ");

			for (String word : words) {

				tree.add(word);

			}

		}
		// print the names
		tree.printTree();
	}

}
