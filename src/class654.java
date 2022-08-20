/**
 * 654. 最大二叉树
 * 递归
 * 2ms 75$
 */
public class class654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums,0,nums.length-1);
    }
    private TreeNode construct(int [] nums , int left , int right){
        if(left>right){
            return null;
        }
        int max =left;
        for( int i=left+1;i<=right;i++){
            if (nums[i]>nums[max]){
                max = i ;
            }
        }
        TreeNode node = new TreeNode(nums[max]);
        node.left=construct(nums,left,max-1);
        node.right=construct(nums,max+1,right);
        return node;

    }
}
