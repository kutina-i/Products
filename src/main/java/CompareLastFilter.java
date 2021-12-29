public class CompareLastFilter implements Filter {
    private char pattern;

    public CompareLastFilter(char a) {
        this.pattern = a;
    }

    public boolean apply(String str) {
        if(str.charAt(str.length()-1) == pattern) return true;
        return false;
    }
}