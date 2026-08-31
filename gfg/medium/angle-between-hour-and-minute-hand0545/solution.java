class Solution {
    public double getAngle(String s) {
        int hr = 0 ;
        int min = 0 ;
        if(s.charAt(0) == '0'){
            hr += s.charAt(1) - '0';
        }
        else {
            hr += s.charAt(0) - '0';
            hr *= 10;
            hr += s.charAt(1) - '0' ;
        }
        if(hr > 12)
            hr = hr -12;
        if(s.charAt(3) == '0') {
            min += s.charAt(4) - '0';
        } else {
            min += s.charAt(3) - '0';
            min *= 10;
            min += s.charAt(4) - '0';
        }
        
        double res = Math.abs( 30.0 * hr - 5.5 * min );
        if(res <= 180)
            return res;
        else 
            return 360.0 - res;
        
    }
}