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
	TreeNode* convertBST(TreeNode* root) {
		
        if (!root) return root;

		vector<int> res;
		recursive(root, res);

		for (int i = res.size()-2; i >=0 ; i--) 
            res[i] = res[i] + res[i + 1];

		int i = 0;
		recursive(root, res, i);
		return root;

	}

	void recursive(TreeNode* root,vector<int>&res) 
	{
		if (!root) return;
		
        if (root->left) 
            recursive(root->left,res);
		
        res.push_back(root->val);
		
        if (root->right) 
            recursive(root->right,res);

	}

	void recursive(TreeNode* root, vector<int>&res,int& i) 
	{
		if (!root) 
            return;
		
        if (root->left) 
            recursive(root->left, res,i);
		
		root->val = res[i];  i++;
       
		if (root->right)
            recursive(root->right, res,i);
	}
};
