/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
	bool findTarget(TreeNode* root, int k) {

		vector<int> res;
		recursive(root, res);
        
        if(res.size()<=1) return false;
		for (int i = 0; i < res.size(); i++) 
		{
			int target = k - res[i];
			for (int j = 0 ; j < res.size(); j++) 
			{
				if(i==j) continue;
                if(res[j] == target) return true;
			}
		
		}

		return false;

	}

	void recursive(TreeNode* root, vector<int>& res)
	{
		if (!root) return;

		if (root->left) recursive(root->left, res);
		res.push_back(root->val);
		if (root->right) recursive(root->right, res);
	}
};
