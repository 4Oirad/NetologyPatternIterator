import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Todos implements Iterable<String> {

    private List<String> primary = new ArrayList<>();
    private List<String> secondary = new ArrayList<>();

    public Todos addPrimary(String task) {
        primary.add(task);
        return this;
    }

    public List<String> getPrimary() {
        return primary;
    }

    public Todos addSecondary(String task) {
        secondary.add(task);
        return this;
    }

    public List<String> getSecondary() {
        return secondary;
    }


    @Override
    public Iterator<String> iterator() {

        return new Iterator<String>() {

            boolean isPrimary = true;
            int nextItem = 0;

            @Override
            public boolean hasNext() {
                if (isPrimary) {
                    if (nextItem < primary.size()) {
                        return true;
                    } else {
                        return !secondary.isEmpty();
                    }
                } else {
                    return nextItem < secondary.size();
                }

            }

            @Override
            public String next() {
                if (isPrimary) {
                    if (nextItem < primary.size()) {
                        String task = primary.get(nextItem);
                        nextItem++;
                        return task;
                    } else {
                        isPrimary = false;
                        String task = secondary.get(0);
                        nextItem = 1;
                        return task;
                    }
                } else {
                    String task = secondary.get(nextItem);
                    nextItem++;
                    return task;
                }
            }
        };
    }
}