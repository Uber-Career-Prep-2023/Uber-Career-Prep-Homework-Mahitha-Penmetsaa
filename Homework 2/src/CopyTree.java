public class CopyTree {
    public static TreeNode copyTree(TreeNode node) {

        if (node == null) {
            return null;
        }
        TreeNode returnNode = new TreeNode(node.val);


        returnNode.left = copyTree(node.left);
        returnNode.right = copyTree(node.right);

        return returnNode;
    }
    //time: o(n)
    //space: o(1)


}
