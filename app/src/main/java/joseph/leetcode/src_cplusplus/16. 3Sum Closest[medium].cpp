class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        vector<int> tmp;
        int size = nums.size();
        
        vector<int> used(size,1);
        int final_a;
        int ans = INT_MAX;
        bool flag = false;
        backtracking(nums,tmp,used,ans,target,size,final_a,flag);
       
        return final_a;
        
    }
        
        void backtracking(vector<int>& nums,vector<int> &tmp,vector<int> &used,int &ans, const int target,int size ,int& final_a, bool& flag)
        {
            if(flag) return;
            
            if(tmp.size()==3)
            {
                int v = 0;
                for(int i=0; i<3;i++) v = v + tmp[i];
                if(!abs(v - target)) flag = true;
                if(abs(v - target) < ans)
                {
                    final_a = v;  
                    ans = abs(v - target);
                } 
                return ;
            }
            
            for(int i=0; i<size;i++)
            {
                if(used[i])
                {         
                    tmp.push_back(nums[i]);
                    used[i]=0;
                    backtracking(nums,tmp,used,ans,target,size,final_a,flag);
                    tmp.pop_back();
                    used[i] = 1;
                }
                
            }
        }
};
