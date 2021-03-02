package ru.job4j.collection;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        Info rsl = new Info(0, 0, 0);
        Map<Integer, User> tmp = current.stream()
                .collect(Collectors.toMap(
                        x -> x.id,
                        x -> x
                ));
        for (User result : previous) {
            if (tmp.containsKey(result.id)) {
                if (!tmp.get(result.id).name.equals(result.name)) {
                    rsl.changed++;
                }
            } else {
                rsl.deleted++;
            }
        }
        rsl.added = current.size() - previous.size() + rsl.deleted;
        return rsl;

    }

    public static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static class Info {
        private int added;
        private int changed;
        private int deleted;

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }

        public int getAdded() {
            return added;
        }

        public int getChanged() {
            return changed;
        }

        public int getDeleted() {
            return deleted;
        }
    }

}