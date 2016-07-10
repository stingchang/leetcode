/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 /**
 * @author: Sting chang
 */
public class Q257_BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root == null)
            return list;
            
        String path = root.val+"";
        if(root.left == null && root.right == null){
            list.add(path);   
        } else {
            if(root.left != null)
                createPathLists(root.left, path+"->", list);
            if(root.right != null)
                createPathLists(root.right, path+"->", list);            
        }
        
        return list;    
    }
    // pass in current path and current node
    public void createPathLists(TreeNode root, String curPath, List<String> list){
        String path = curPath + root.val;
        if(root.left == null && root.right ==null){
            list.add(path);
            return;
        } 
        if(root.left != null){
            createPathLists(root.left, path+"->", list);
        }
        if(root.right != null){
            createPathLists(root.right, path+"->", list);
        }
    }
}
