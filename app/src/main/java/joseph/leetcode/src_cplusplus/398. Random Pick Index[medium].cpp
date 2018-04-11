class Solution {
public:
    vector<int> arr;
    Solution(vector<int> nums) {
        this -> arr = nums;
    }
    
    int pick(int target) {
    
        vector<int> index_arr;  
        for(int i = 0; i < arr.size(); i++)
        {
            if( target == arr[i]) index_arr.push_back(i);
        }
        int r = rand() % index_arr.size();
        return index_arr[r];
    }
};

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
