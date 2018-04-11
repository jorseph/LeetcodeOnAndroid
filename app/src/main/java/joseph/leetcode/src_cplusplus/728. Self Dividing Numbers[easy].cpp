class Solution {
public:
    vector<int> selfDividingNumbers(int left, int right) {
        
        vector<int> res; 
        
        for(int i=left; i<=right; i++)
        {
            int tmp_value = i;
            while(true)
            {
                int r = tmp_value % 10;
                if(r==0 || i%r!=0) break;
              
                tmp_value /= 10;
                if(tmp_value<=0)
                {
                    res.push_back(i);
                    break;  
                } 
            } 
        }
        
        return res;
    }
};
