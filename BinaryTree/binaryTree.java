package BinaryTree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class binaryTree {
    public static class Node {
        int data;
        Node left, right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static void displayBinary(Node node) {
        if (node == null) {
            return;
        }
        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += "<-" + node.data + "->";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);
        displayBinary(node.left);
        displayBinary(node.right);
    }

    public static int size(Node node) {
        if (node == null) {
            return 0;
        }
        int ls = size(node.left);
        int rs = size(node.right);
        int ts = ls + rs + 1;
        return ts;

    }

    public static int sum(Node node) {
        if (node == null) {
            return 0;
        }
        int lsm = sum(node.left);
        int rsm = sum(node.right);
        int tsm = lsm + rsm + node.data;
        return tsm;
    }

    public static int maxNode(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        int lm = maxNode(node.left);
        int rm = maxNode(node.right);
        int tm = Math.max(node.data, Math.max(lm, rm));
        return tm;
    }

    public static int heightOfNode(Node node) {
        if (node == null) {
            return -1;
        }
        int lh = heightOfNode(node.left);
        int rh = heightOfNode(node.right);
        int th = Math.max(lh, rh) + 1;
        return th;
    }

    public static void traversalOfNode(Node node) {
        if (node == null) {
            return;
        }
        System.out.println("PreOrder-" + node.data);
        traversalOfNode(node.left);
        System.out.println("In-Oredr-" + node.data);
        traversalOfNode(node.right);
        System.out.println("PostOrder-" + node.data);
    }

    public static void levelOrderTraversal(Node node) {
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(node);
        while (mq.size() > 0) {
            int count = mq.size();
            for (int i = 0; i < count; i++) {
                node = mq.remove();
                System.out.print(node.data + " ");
                if (node.left != null) {
                    mq.add(node.left);
                }
                if (node.right != null) {
                    mq.add(node.right);
                }
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};

        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);
        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    Node ln = new Node(arr[idx], null, null);
                    top.node.left = ln;
                    Pair lp = new Pair(ln, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }
                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    Node rn = new Node(arr[idx], null, null);
                    top.node.right = rn;
                    Pair rp = new Pair(rn, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }
                top.state++;
            } else {
                st.pop();
            }
        }

        displayBinary(root);
        System.out.println("Size of nodes - " + size(root));
        System.out.println("Sum of nodes - " + sum(root));
        System.out.println("Max of nodes - " + maxNode(root));
        System.out.println("Height of nodes - " + heightOfNode(root));
        traversalOfNode(root);
        levelOrderTraversal(root);

    }

}
