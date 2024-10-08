// https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/description/

class RandomizedCollection {
    HashMap<Integer, HashSet<Integer>> map;
    ArrayList<Integer> li;
    Random rnd;
    public RandomizedCollection() {
        map = new HashMap<>();
        li = new ArrayList<>();
        rnd = new Random();
    }
    
    public boolean insert(int val) {
         if (map.containsKey(val)) {
            HashSet<Integer> set = map.get(val); // took the set
            set.add(li.size()); // append the index into it
            li.add(val); // add the value in the list of array
            return false;
        } else {
            HashSet<Integer> set = new HashSet<>();
            set.add(li.size()); // add the index
            li.add(val); // add the elem
            map.put(val, set); // put in the hash table
            return true;
        }
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;

        Set<Integer> set = map.get(val);
        if (set.isEmpty())
            return false;

        Iterator<Integer> itr = set.iterator();
        int indx = itr.next();
        itr.remove();

        if (set.isEmpty())
            map.remove(val);

        if (indx < li.size() - 1) {
            int lastElem = li.get(li.size() - 1);
            li.set(indx, lastElem);
            Set<Integer> lastElemSet = map.get(lastElem);
            lastElemSet.remove(li.size() - 1);
            lastElemSet.add(indx);

        }

        li.remove(li.size() - 1);
        return true;
    }
    
    public int getRandom() {
        return li.get(rnd.nextInt(li.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */