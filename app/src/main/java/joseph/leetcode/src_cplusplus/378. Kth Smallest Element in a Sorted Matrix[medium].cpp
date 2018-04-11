class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        int row = matrix.size();
        int col = matrix[0].size();
        
        vector<int> res;
        
        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
                res.push_back(matrix[i][j]);
            }
        }
        
        sort(res.begin(),res.end());
        
        return res[k-1];
    }
};
