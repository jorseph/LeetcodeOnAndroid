class Solution {
public:
    vector<int> constructRectangle(int area) {
        if(area<0) vector<int>{};

        for(int i=sqrt(area); i>0; i--)
        {
            if(area%i==0)
            {
               return vector<int>{area/i,i};
            }  
        }
    }
};
