
public class NestedIterator implements Iterator<Integer> {

    ArrayList<Integer> list;
    int index;
    public NestedIterator(List<NestedInteger> nestedList) {
        list  = new ArrayList<>();
        index = 0;
        
        nestedList.forEach(n -> flat(n));
    }

    private void flat(NestedInteger nestedInteger){
        if(nestedInteger.isInteger()){
            list.add(nestedInteger.getInteger());
        } else{
            nestedInteger.getList().forEach(n -> flat(n));
        }
    } 
    @Override
    public Integer next() {
        index++;
        return list.get(index - 1);
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }
}
