/*

url: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]

*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BinaryTreeZigZagLevelOrderTraversal {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      List<List<Integer>> result = new ArrayList<>();
      if(root == null) return result;
      Queue<TreeNode> q = new LinkedList<>();
      q.add(root);
      result.add(new ArrayList<Integer>(Arrays.asList(root.val)));
      int count = 1;
      while (q.peek() != null) {
          ArrayList<Integer> temp = new ArrayList();
          int size = q.size();
          for(int i = 0; i < size; i++) {
              TreeNode node = q.poll();
              if (node.left != null) {
                  q.add(node.left);
                  temp.add(node.left.val);
              }
              if (node.right != null) {
                  q.add(node.right);
                  temp.add(node.right.val);
              }
          }
          if(temp.size() > 0){
              if(count%2 == 1)
                  Collections.reverse(temp);
              result.add(temp);
              count++;
          }
      }
      return result;
  }
}