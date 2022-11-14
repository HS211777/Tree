import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<Node> tree = new ArrayList<>();
        createArr(nums,5);
        System.out.println(nums);
        createTree(tree,nums);
        ArrayList<Node> traversed = preorderTraversal(tree);
        for (int i = 0; i < traversed.size(); i++){
            System.out.print(traversed.get(i).getValue());
            System.out.print(" ");
        }
        System.out.println("ended");
    }

    public static int randNum(){
        Random r = new Random();
        int max = 100;
        int min = 1;
        return r.nextInt(max)+min;
    }

    public static void createArr(ArrayList<Integer> array, int length){
        for (int i = 0; i < length; i++){
            array.add(randNum());
        }
    }

    public static void createTree(ArrayList<Node> tree, ArrayList<Integer> nums){
        for (int i = 0; i < nums.size(); i++){
            Node myNode = new Node(nums.get(i));

            if (tree.isEmpty()){ // this is for root node
                tree.add(myNode);
            }
            else{
                boolean valid = false;
                Node currentNode = tree.get(0);
                while (!valid){
                    if (myNode.getValue() < currentNode.getValue()){
                        try{
                            if (currentNode.getLeft() != null){}
                            currentNode.setLeft(myNode);
                            tree.add(myNode);
                            //System.out.println(tree);
                            valid = true;
                        }
                        catch (NullPointerException e){
                            currentNode = currentNode.getLeft(); //current node becomes left child
                        }
                    }
                    else{
                        try{
                            if (currentNode.getRight() != null){}
                            currentNode.setRight(myNode);
                            tree.add(myNode);
                            valid = true;
                            //System.out.println(tree);
                        }
                        catch (NullPointerException e){
                            currentNode = currentNode.getRight(); //current node becomes right child
                        }
                    }
                }
            }
        }
    }

    public static ArrayList<Node> preorderTraversal(ArrayList<Node> tree){
        ArrayList<Node> traversed = new ArrayList<>();
        ArrayList<Node> stack = new ArrayList<>();

        Node mynode = tree.get(0);
        traversed.add(mynode);
        stack.add(mynode);
        while (traversed.size() < tree.size()){
            try{
                if (stack.get(stack.size()-1).getLeft() != null ){}
                mynode = stack.get(stack.size()-1).getLeft();
                traversed.add(mynode);
                stack.add(mynode);
            }
            catch (NullPointerException e){
                try{
                    if (stack.get(stack.size()-1).getRight() != null){}
                    mynode = stack.get(stack.size()-1).getRight();
                    traversed.add(mynode);
                    stack.add(mynode);
                }
                catch (NullPointerException f){
                    stack.remove(stack.size()-1); //pops item from stack
                }
            }
        }
        return traversed;
    }

}