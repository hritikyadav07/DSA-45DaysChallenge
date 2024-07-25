// https://leetcode.com/problems/simplify-path/description/


class Solution {
    public String simplifyPath(String path) {
        StringBuilder pathElements = new StringBuilder();
        String[] paths = path.split("/");
        for(String r:paths){
            if(r.equals("..") && pathElements.length()>1){
                int last = pathElements.lastIndexOf("/");
                pathElements = pathElements.delete(last, pathElements.length());
            }else if(r.equals(".")|| r.equals("..")){
                continue;
            } else if(r!="") {
                pathElements.append("/"+r);
            }
            System.out.println(pathElements);
        }
        if(pathElements.length()==0){
            return "/";
        }
        return pathElements.toString();
    }
}