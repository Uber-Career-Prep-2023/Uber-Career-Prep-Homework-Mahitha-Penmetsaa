public class BinarySearchTree {

    TreeNode root;
    int min(TreeNode root){
        if (root.left!=null){
            return min(root.left);
        }
        return root.val;
    };
    int max(TreeNode root){
        if (root.right!=null){
            return max(root.right);
        }
        return root.val;
    };
    boolean contains(TreeNode root, int val){
        if(root.val==val){
            return true;
        }
        if(root.val>val){
            return contains(root.right, val);
        }
        if(root.val<val){
            return contains(root.left,val);
        }

        return false;
    };
    void insert(int val){
        if(this.root=null){
            this.root=new Node(val);
            return;}
        Node curr=this.root;
        while(true){
            if(val==curr.val){
                return;}
            else if(val<curr.val){
                if(root.left==null){
                    root.left=new Node(val);
                    return;}

                else{
                    if(root.right==null){
                        root.right=new Node(val);
                        return ;
                    }
                    else{
                        root=root.right;}}}
        }


};
    int delete(int val){
        public int delete(int val) {
            if (root == null) {
                return null;
            }
            TreeNode current = root;
            Node parent = null;
            while (current != null) {
                if (current.val == val) {
                    if (current.left == null && current.right == null) {
                        if (parent == null) {
                            root = null;
                        } else if (parent.left == current) {
                            parent.left = null;
                        } else {
                            parent.right = null;
                        }
                    } else if (current.left == null) {
                        if (parent == null) {
                            root = current.right;
                        } else if (parent.left == current) {
                            parent.left = current.right;
                        } else {
                            parent.right = current.right;
                        }
                    } else if (current.right == null) {
                        if (parent == null) {
                            root = current.left;
                        } else if (parent.left == current) {
                            parent.left = current.left;
                        } else {
                            parent.right = current.left;
                        }
                    } else {
                        Node min = current.right;
                        while (min.left != null) {
                            min = min.left;
                        }
                        int temp = min.val;
                        delete(min.val);
                        current.val = temp;
                    }
                    return val;
                } else if (current.val > val) {
                    parent = current;
                    current = current.left;
                } else {
                    parent = current;
                    current = current.right;
                }
            }
            return null;
        }
}//had trouble with the delete implementation but attempted


}
