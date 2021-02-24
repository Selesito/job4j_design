package ru.job4j.tree;

import java.util.*;
import java.util.function.Predicate;

class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> rsl  = findBy(parent);
        if (rsl.isEmpty() || findBy(child).isPresent()) {
            return false;
        }
        return rsl.get().getChildren().add(new Node<>(child));
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Predicate<Node<E>> temp = s -> s.getValue().equals(value);
        return findByPredicate(temp);
    }

    public boolean isBinary() {
        Predicate<Node<E>> temp = s -> s.getChildren().size() > 2;
        return findByPredicate(temp).isEmpty();
    }

    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (condition.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.getChildren());
        }
        return rsl;
    }
}
