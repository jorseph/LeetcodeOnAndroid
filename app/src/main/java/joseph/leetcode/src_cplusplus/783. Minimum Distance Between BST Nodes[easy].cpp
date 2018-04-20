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
    int minDiffInBST(TreeNode* root) {
        if(!root) return 0;
        
        vector<int> res;
        recursive(root,res);
        int ans = INT_MAX;
        for(int i=1; i<res.size(); i++) ans = abs(res[i] - res[i-1]) < ans ? abs(res[i] - res[i-1]) : ans;
            
        return ans;
        
    }
    
    void recursive(TreeNode* root,vector<int> &res)
    {
        if(!root) return ;
        if(root->left) recursive(root->left,res);
        res.push_back(root->val);
        if(root->right) recursive(root->right,res);
    }
};
