import java.util.*;

class RandomizedSet {

    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        map.put(val, list.size());
        list.add(val);

        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int index = map.get(val);
        int lastValue = list.get(list.size() - 1);

        list.set(index, lastValue);
        map.put(lastValue, index);

        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}

//Firstly I used set and converting it into list in getRandom() but it was not optimal
class RandomizedSet {
    Set<Integer> set;
    

    public RandomizedSet() {
        set=new HashSet<>();
        
    }
    
    public boolean insert(int val) {
        if(set.contains(val)){
            return false;
        }
        set.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(set.contains(val)){
            set.remove(val);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        List<Integer> list=new ArrayList<>(set);
        return list.get(ThreadLocalRandom.current().nextInt(0,set.size()));
    }
}

