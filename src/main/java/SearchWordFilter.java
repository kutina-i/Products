public class SearchWordFilter implements Filter {
    private char pattern;

    public SearchWordFilter(char a) {
        this.pattern = a;
    }

    public boolean apply(String str) {
       for(int i = 0; i < str.length(); i++){
        if(str.charAt(i) == pattern) return true;
       }
        return false;
    }
}