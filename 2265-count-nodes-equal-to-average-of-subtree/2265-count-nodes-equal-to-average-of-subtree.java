class Solution {
    private int matchingNodes = 0;
    
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return matchingNodes;
    }
    
    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        
        int currentSum = node.val + left[0] + right[0];
        int currentCount = 1 + left[1] + right[1];
        
        if (node.val == currentSum / currentCount) {
            matchingNodes++;
        }
        
        return new int[]{currentSum, currentCount};
    }
}