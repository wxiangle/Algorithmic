import java.util.ArrayList;
import java.util.Stack;

class TreeBinary {
    public static void main(String[] args) {
        TreeNode rootTreeNode = new TreeNode(0);
        TreeNode rootTreeNodeLeft1 = new TreeNode(-1);
        TreeNode rootTreeNodeLeft2 = new TreeNode(-2);
        TreeNode rootTreeNodeRight1 = new TreeNode(1);
        TreeNode rootTreeNodeRight2 = new TreeNode(2);

        rootTreeNode.left = rootTreeNodeLeft1;
        rootTreeNodeLeft1.left = rootTreeNodeLeft2;
        rootTreeNode.right = rootTreeNodeRight1;
        rootTreeNodeRight1.right = rootTreeNodeRight2;
        rootTreeNodeLeft1.right = new TreeNode(-3);

        ArrayList<Integer> list = preorderTraversal2(rootTreeNode);
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                System.out.print("" + list.get(i));
            } else {
                System.out.print("," + list.get(i));
            }
        }

    }

    // 二叉树中序遍历 方法一
    public static ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> rusultList = new ArrayList<Integer>();
        if (root == null) {
            return rusultList;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode node = stack.pop();
                rusultList.add(node.val);
                root = node.right;
            }
        }
        return rusultList;
    }

    // 二叉树中序遍历 方法二
    public static ArrayList<Integer> inorderTraversal2(TreeNode root) {
        ArrayList<Integer> rusultList = new ArrayList<Integer>();
        if (root == null) {
            return rusultList;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root );
                root = root.left;
            }
            TreeNode rightNode = stack.pop();
            rusultList.add(rightNode.val);
            root = rightNode.right;
        }
        return rusultList;
    }

    // 二叉树前序遍历 方法一
    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> rusultList = new ArrayList<Integer>();
        if (root == null) {
            return rusultList;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                rusultList.add(root.val);
                stack.push(root);
                root = root.left;
            } else {
                TreeNode node = stack.pop();
                root = node.right;
            }
        }
        return rusultList;
    }


    // 二叉树前序遍历 方法二
    public static ArrayList<Integer> preorderTraversal2(TreeNode root) {
        ArrayList<Integer> rusultList = new ArrayList<Integer>();
        if (root == null) {
            return rusultList;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (root != null || !stack.isEmpty()) {
            while(root != null ){
                stack .push(root );
                rusultList.add(root.val);
                root = root.left;
            }
            TreeNode node = stack.pop();
            root =  node.right;    
        }
        return rusultList;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
