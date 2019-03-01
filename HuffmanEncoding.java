import java.util.*;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Comparator;
public class HuffmanEncoding {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        String sentence = in .nextLine();

        int[] array = new int[256]; //an array to store all the frequencies

        for (int i = 0; i < sentence.length(); i++) { //go through the sentence
            array[(int) sentence.charAt(i)]++; //increment the appropriate frequencies
        }

        PriorityQueue < Tree > PQ = new PriorityQueue < Tree > (); //make a priority queue to hold the forest of trees

        for (int i = 0; i < array.length; i++) { //go through frequency array
            if (array[i] > 0) { //print out non-zero frequencies - cast to a char





                //FILL THIS IN:

                //MAKE THE FOREST OF TREES AND ADD THEM TO THE PQ

                //create a new Tree
                //set the cumulative frequency of that Tree
                //insert the letter as the root node
                //add the Tree into the PQ
                 Node hn = new Node();

             hn.letter = hn.smallestLetter = (char)i;

            	Tree tr = new Tree();
            	tr.root = hn;
            	tr.frequency = array[i];
            // add functions adds
            // the huffman node to the queue.
            PQ.add(tr);
        }
      }



        while (PQ.size() > 1) { //while there are two or more Trees left in the forest




            //FILL THIS IN:

            //IMPLEMENT THE HUFFMAN ALGORITHM

            //when you're making the new combined tree, don't forget to assign a default root node (or else you'll get a null pointer exception)
            //if you like, to check if everything is working so far, try printing out the letter of the roots of the two trees you're combining
	    //remember to check the smallest letter to decide which branch to put on the left, and which on the right
                  Tree x = PQ.poll();


            // second min extarct.
            Tree y = PQ.poll();

            // new node f which is equal
            Node n = new Node();

            // to the sum of the frequency of the two nodes
            // assigning values to the f node.
            n.leftChild = x.root;
            n.rightChild = y.root;
            n.smallestLetter = (char)Math.min(x.root.smallestLetter,y.root.smallestLetter);

            Tree t = new Tree();
            t.root = n;
            t.frequency = x.frequency + y.frequency;

            PQ.add(t);




        }

        Tree HuffmanTree = PQ.poll(); //now there's only one tree left - get its codes




        //FILL THIS IN:

        //get all the codes for the letters and print them out
        //call the getCode() method on the HuffmanTree Tree object for each letter in the sentence
			String ans = "";
            for(char c: sentence.toCharArray()){
            	ans += HuffmanTree.getCode(c);
            }

            System.out.println(ans);



    }
}

class Node {


    public char letter = '@'; //stores letter
    public char smallestLetter = '@';  //a nice idea it to track the smallest letter in the tree in a special variable like this

    public Node leftChild; // this node's left child
    public Node rightChild; // this node's right child


} // end class Node





class Tree implements Comparable < Tree > {
    public Node root; // first node of tree
    public int frequency = 0;

    public Tree() // constructor
    {
        root = null;
    } // no nodes in tree yet

    //the PriorityQueue needs to be able to somehow rank the objects in it
    //thus, the objects in the PriorityQueue must implement an interface called Comparable
    //the interface requires you to write a compareTo() method so here it is:

    public int compareTo(Tree object) {
        if (frequency - object.frequency > 0) { //compare the cumulative frequencies of the tree
            return 1;
        } else if (frequency - object.frequency < 0) {
            return -1; //return 1 or -1 depending on whether these frequencies are bigger or smaller
        } else {
            // Sort based on letters
            char a = this.root.smallestLetter;
            char b = object.root.smallestLetter;

            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            }
            return 0;
        }
    }

    String path = "error"; //this variable will track the path to the letter we're looking for

    public String getCode(char letter) { //we want the code for this letter

        return this._getCode(letter, this.root, ""); //return the path that results
    }

    private String _getCode(char letter, Node current, String path) {
        if (current == null) {
            return null;
        }
        if (current.letter == letter) {
            return path;
        }

        String leftPath = this._getCode(letter, current.leftChild, path + "0");
        if (leftPath != null) {
            return leftPath;
        }

        String rightPath = this._getCode(letter, current.rightChild, path + "1");
        return rightPath;
    }

} // end class Tree