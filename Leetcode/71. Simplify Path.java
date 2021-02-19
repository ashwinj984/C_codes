class Solution {
    public String simplifyPath(String path) {
        int i = 0;
		LinkedList<String> list = new LinkedList<>();
		while(i < path.length()){
			char ch = path.charAt(i);
			if(ch == '/') {
				while(i < path.length() && path.charAt(i) == '/') {
					i++;
				}
				continue;
			}else if(ch == '.') {
				StringBuilder sb = new StringBuilder();
				while(i < path.length() && path.charAt(i) != '/') {
					sb.append(path.charAt(i));
					i++;
				}
				
				if(sb.length() == 2) {
					i++;
					if(list.size() > 0) {
						list.removeLast();
					}
				}else if(sb.length() == 1) {
					//do nothing
				}else {
					list.add(sb.toString());
				}
			}else {
				StringBuilder sb = new StringBuilder();
				while(i < path.length()) {
					if(ch == '/') {
						break;
					}
					
					sb.append(ch);
					i++;
					if(i >= path.length()) {
						break;
					}
					ch = path.charAt(i);
				}
				list.add(sb.toString());
			}
	
		}
		StringBuilder sb = new StringBuilder();
		for(String s : list) {
			sb.append("/" + s);	
		}
		
		return (sb.length() == 0 ? "/" : sb.toString());
    }
}
