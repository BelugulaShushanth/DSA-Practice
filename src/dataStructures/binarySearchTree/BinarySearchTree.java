package dataStructures.binarySearchTree;

import java.util.*;

public class BinarySearchTree {

    private Node root;

    public boolean insert(int value){
        Node newNode = new Node(value);
        if(root == null){
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true){
            if(newNode.value == temp.value){
                return false;
            }
            else if(newNode.value < temp.value){
                if(temp.left == null){
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            }
            else{
                if(temp.right == null){
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value){
        if (root == null) return false;
        Node temp = root;
        while (temp != null){
            if(value < temp.value){
                temp = temp.left;
            }
            else if(value > temp.value){
                temp = temp.right;
            }
            else{
                return true;
            }
        }
        return false;
    }

    public boolean rContains(int value){
        return rContains(root, value);
    }

    private boolean rContains(Node currentNode, int value){

        if(currentNode == null) return false;
        if(value == currentNode.value) return true;
        if(value < currentNode.value){
            return rContains(currentNode.left, value);
        }
        else{
            return rContains(currentNode.right, value);
        }

    }

    public void rInsert(int value){
        if (root == null) root = new Node(value);
        rInsert(root, value);
    }

    private Node rInsert(Node currentNode, int value){

        if(currentNode == null) return new Node(value);
        if(value < currentNode.value){
            currentNode.left = rInsert(currentNode.left, value);
        }
        else if(value > currentNode.value){
            currentNode.right = rInsert(currentNode.right, value);
        }
        return currentNode;
    }

    public void deleteNode(int value){
        deleteNode(root, value);
    }

    private Node deleteNode(Node currentNode, int value) {

        if(currentNode == null) return null;

        if (value < currentNode.value){
            currentNode.left = deleteNode(currentNode.left, value);
        }
        else if(value > currentNode.value){
            currentNode.right = deleteNode(currentNode.right, value);
        }
        else{
            if(currentNode.left == null && currentNode.right==null){
                return null;
            }
            else if(currentNode.right == null){
                currentNode = currentNode.left;
            }
            else if(currentNode.left == null){
                currentNode = currentNode.right;
            }
            else{
                int subTreeMin = minValue(currentNode.right);
                currentNode.value = subTreeMin;
                currentNode.right = deleteNode(currentNode.right, subTreeMin);
            }
        }
        return currentNode;
    }

    public int minValue(Node currentNode){
        while (currentNode.left != null){
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    public List<Integer> BFS(){
        Queue<Node> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        Node currentNode = root;
        queue.add(currentNode);
        while (!queue.isEmpty()){
            currentNode = queue.remove();
            result.add(currentNode.value);
            if (currentNode.left != null){
                queue.add(currentNode.left);
            }
            if(currentNode.right != null){
                queue.add(currentNode.right);
            }
        }
        return result;
    }

    public List<Integer> preOrderDFS(){
        List<Integer> result = new ArrayList<>();
        preOrderTraverse(result, root);
        return result;
    }

    private void preOrderTraverse(List<Integer> result, Node currentNode) {
        result.add(currentNode.value);
        if (currentNode.left != null){
            preOrderTraverse(result, currentNode.left);
        }
        if (currentNode.right != null){
            preOrderTraverse(result,currentNode.right);
        }
    }

    public List<Integer> postOrderDFS(){
        List<Integer> result = new ArrayList<>();
        postOrderTraverse(result, root);
        return result;
    }

    private void postOrderTraverse(List<Integer> result, Node currentNode) {
        if (currentNode.left != null){
            postOrderTraverse(result, currentNode.left);
        }
        if (currentNode.right != null){
            postOrderTraverse(result,currentNode.right);
        }
        result.add(currentNode.value);
    }

    public List<Integer> inOrderDFS(){
        List<Integer> result = new ArrayList<>();
        inOrderTraverse(result, root);
        return result;
    }

    private void inOrderTraverse(List<Integer> result, Node currentNode) {
        if (currentNode.left != null){
            inOrderTraverse(result, currentNode.left);
        }
        result.add(currentNode.value);
        if (currentNode.right != null){
            inOrderTraverse(result,currentNode.right);
        }
    }

    public List<Integer> inOrderDFSSimple(){
        List<Integer> list = preOrderDFS();
        Collections.sort(list);
        return list;
    }

}
