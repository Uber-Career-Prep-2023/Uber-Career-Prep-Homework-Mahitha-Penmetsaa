public class isBST {

    public static boolean isBST(TreeNode root, long max, long min) {
        if (root == null) {
            return true;
        }

        if (root.val >= max || root.val <= min) {
            return false;
        }

        boolean left = isBST(root.left, root.val, min);
        boolean right = isBST(root.right, max, root.val);

        return left && right;
    }

}
