/*
  url: https://leetcode.com/problems/binary-tree-level-order-traversal/description/
  
  Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

  For example:
  Given binary tree [3,9,20,null,null,15,7],
      3
    / \
    9  20
      /  \
    15   7
  return its level order traversal as:
  [
    [3],
    [9,20],
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
// int[] x = new int[num]

class BinaryTreeLevelOrderTraversal {
  public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> result = new ArrayList<>();
      if (root == null) return result;
      Queue<TreeNode> q = new LinkedList<>();
      q.add(root);
      q.add(null);
      result.add(new ArrayList<>(Arrays.asList(root.val)));
      List<Integer> temp = new ArrayList<>();
      while (!q.isEmpty()) {
          if (q.peek() != null) {
              TreeNode node = q.poll();
              if (node.left != null) {
                  temp.add(node.left.val);
                  q.add(node.left);
              }
              if (node.right != null) {
                  temp.add(node.right.val);
                  q.add(node.right);
              }
          } else {
              TreeNode node = q.poll();
              if (!q.isEmpty()) {
                  result.add(new ArrayList<>(temp));
                  temp.clear();
                  q.add(null);
              }
          }
      }
      return result;
  }
}