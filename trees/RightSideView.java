/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class RightSideView {
  public List<Integer> rightSideView(TreeNode root) {
      List<Integer> result = new ArrayList<Integer>();
      if (root == null)
          return result;
      Queue<TreeNode> q = new LinkedList();
      q.add(root);
      q.add(null);
      TreeNode last = root;
      result.add(last.val);
      while (!q.isEmpty()) {
          if (q.peek() != null) {
              TreeNode node = q.poll();
              if (node.left != null) {
                  q.add(node.left);
                  last = node.left;
              }
              if (node.right != null) {
                  q.add(node.right);
                  last = node.right;
              }
          } else {
              TreeNode node = q.poll();
              if (q.isEmpty()) {
                  break;
              } else {
                  result.add(last.val);
                  q.add(null);
              }
          }
      }
      return result;
  }
}