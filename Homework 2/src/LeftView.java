public class LeftView {
    public static void leftView(TreeNode root) {

        if (root.left!=null){
            System.out.println(root.left.val);
            leftView(root.left);
        }
        if (root.right!=null){
            leftView(root.right);
        }
    }
}
