package JZoffer;
import java.util.*;
public class problem25 {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
    	ArrayList<ArrayList<Integer>> allPaths = new ArrayList<ArrayList<Integer>>();
    	if (root == null) {
    	 return allPaths;
     } else {
    	 ArrayList<Integer> path = new ArrayList<Integer>();
    	 findCore(allPaths, path, root, target);
    	 return allPaths;
     }
    }
    	
    public void findCore(ArrayList<ArrayList<Integer>> allPaths, ArrayList<Integer> path, TreeNode cur, int target) {
    	if (cur != null) {
    		path.add(Integer.valueOf(cur.val));
    	} else {
    		return;
    	}
    	if (cur.left == null && cur.right == null) {
    		Integer sum = Integer.valueOf(0);
    		Iterator<Integer> itr = path.iterator();
    		while(itr.hasNext()) {
    			sum += itr.next();
    		}
    		if (sum == Integer.valueOf(target)) {
    			ArrayList<Integer> newPath = new ArrayList<Integer>();
    			Iterator<Integer> itr1 = path.iterator();
    			while(itr1.hasNext()) {
    				newPath.add(itr1.next());
    			}
    			allPaths.add(newPath);
    		} 
    	}
    	findCore(allPaths, path, cur.left, target);
    	findCore(allPaths, path, cur.right, target);
    	path.remove(path.size() - 1);
    }
    	
    

}
