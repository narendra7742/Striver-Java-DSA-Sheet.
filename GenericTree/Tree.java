package GenericTree;

import java.util.*;

public class Tree {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    private static void display(Node node) {
        String str = node.data + "--> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ". ";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static int size(Node node) {
        int s = 0;
        for (Node child : node.children) {
            int cs = size(child);
            s = s + cs;
        }
        s = s + 1;
        return s;
    }

    public static int max(Node node) {
        int max = Integer.MIN_VALUE;
        for (Node child : node.children) {
            int cm = max(child);
            max = Math.max(cm, max);
        }
        max = Math.max(node.data, max);
        return max;
    }

    public static int heightOfTree(Node node) {
        int h = -1;
        for (Node child : node.children) {
            int ch = heightOfTree(child);
            h = Math.max(h, ch);
        }
        h = h + 1;
        return h;
    }

    public static void traversal(Node node) {
        System.out.println("Node pre " + node.data);
        for (Node child : node.children) {
            System.out.println("Edge pre " + node.data + "-" + child.data);
            traversal(child);
            System.out.println("Edge Post " + node.data + "-" + child.data);
        }
        System.out.println("Node Post " + node.data);
    }

    public static void levelOrderTraversal(Node node) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        while (q.size() > 0) {
            node = q.remove();
            System.out.print(node.data + " ");
            for (Node child : node.children) {
                q.add(child);
            }
        }
        System.out.println(". ");
    }

    public static void levelOrderLineWise(Node node) {
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(node);
        Queue<Node> cq = new ArrayDeque<>();
        while (mq.size() > 0) {
            node = mq.remove();
            System.out.print(node.data + " ");
            for (Node child : node.children) {
                cq.add(child);
            }
            if (mq.size() == 0) {
                mq = cq;
                cq = new ArrayDeque<>();
                System.out.println();
            }
        }

    }

    public static void mirrorTree(Node node) {
        for (Node child : node.children) {
            mirrorTree(child);
        }
        Collections.reverse(node.children);
    }

    public static void removeLeaves(Node node) {

        for (int i = node.children.size() - 1; i >= 0; i--) {
            Node child = node.children.get(i);
            if (child.children.size() == 0) {
                node.children.remove(child);
            }
        }

        for (Node child : node.children) {
            removeLeaves(child);
        }

    }

    public static void linearizeTree(Node node) {
        for (Node child : node.children) {
            linearizeTree(child);

        }

        while (node.children.size() > 1) {
            Node last = node.children.remove(node.children.size() - 1);
            Node sl = node.children.get(node.children.size() - 1);
            Node slt = getTail(sl);
            slt.children.add(last);
        }
    }

    private static Node getTail(Node node) {
        while (node.children.size() == 1) {
            node = node.children.get(0);
        }
        return node;
    }

    public static boolean findInt(Node node, int data) {
        if (node.data == data) {
            return true;
        }
        for (Node child : node.children) {
            boolean fic = findInt(child, data);
            if (fic) {
                return true;
            }
        }

        return false;
    }

    public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (node.data == data) {
            ans.add(data);
            return ans;
        }
        for (Node child : node.children) {
            ArrayList<Integer> arr = nodeToRootPath(child, data);
            if (arr.size() > 0) {
                arr.add(node.data);
                return arr;
            }
        }
        return new ArrayList<>();
    }

    public static boolean areMirror(Node n1, Node n2) {
        if (n1.children.size() != n2.children.size()) {
            return false;
        }
        for (int i = 0; i < n1.children.size(); i++) {
            int j = n1.children.size() - 1 - i;
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(j);
            if (areMirror(c1, c2) == false) {
                return false;
            }

        }
        return true;
    }


    public static void main(String[] args) {
        int[] arr = {10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1};
        System.out.println("Len " + arr.length);
        Node root = null;
        Stack<Node> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
//            System.out.println("arr  " + arr[i]);
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
//                    st.push(t);
                } else {
                    root = t;
                }
                st.push(t);
            }
        }
        display(root);
        System.out.println("Size of Nodes- " + size(root));
        System.out.println("Max of Nodes- " + max(root));
        System.out.println("Height of Tree- " + heightOfTree(root));
        traversal(root);
        levelOrderTraversal(root);
        levelOrderLineWise(root);
        mirrorTree(root);
        linearizeTree(root);
        display(root);
        System.out.println("Is integer find " + findInt(root, 50));
        System.out.println("Node path " + nodeToRootPath(root, 30));
    }
}
