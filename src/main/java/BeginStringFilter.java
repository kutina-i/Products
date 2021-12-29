public class BeginStringFilter implements Filter{
    private String pattern;

    public BeginStringFilter(String pattern)
    {
        if (pattern == null){
            throw new IllegalArgumentException("Пустая строка");
        }
        this.pattern = pattern;
    }

    public boolean apply(String str){
        if(str == null){
            throw new IllegalArgumentException("Пустая строка");
        }
        return str.startsWith(pattern);
    }


}
