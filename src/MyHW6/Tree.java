package MyHW6;

public class Tree {
    private Node root;//корневой узел

    public void insert(Person person) {
        Node node = new Node();
        node.person = person;
        if (root == null)
            root = node;
        else {
            Node current = root;//текущий узел
            Node parent;//предыдущий узел
            while (true) {
                parent = current;
                if (person.id < current.person.id) {
                    current = current.leftChild;//переходим к левому потомку
                    if (current == null) {
                        parent.leftChild = node;
                        return;
                    }
                } else {
                    current = current.rightChild;//иначе присваиваем правого потомка
                    if (current == null) {
                        parent.rightChild = node;
                        return;
                    }
                }
            }
        }
    }

    public Node find(int key) {
        Node current = root;//обозначает узел, на котром мы находимся в данный момент
        while (current.person.id != key) {
            if (key < current.person.id)
                current = current.leftChild;//смотрим по левому потомку
            else
                current = current.rightChild;//иначе переходим на правого потомка
            if (current == null)// если в дереве нету такого элемента
                return null;
        }
        return current;
    }

    private void preOrder(Node rootNode) {
        if (rootNode != null) {
            rootNode.display();
            postOrder(rootNode.leftChild);
            postOrder(rootNode.rightChild);
        }
    }

    private void postOrder(Node rootNode) {
        if (rootNode != null) {
            postOrder(rootNode.leftChild);
            postOrder(rootNode.rightChild);
            rootNode.display();
        }
    }

    private void inOrder(Node rootNode) { //узел, по которому будем искать
        if (rootNode != null) {
            inOrder(rootNode.leftChild);
            rootNode.display();
            inOrder(rootNode.rightChild);
        }
    }

    public Node min() {
        Node current, last = null;
        current = root;//наш поиск начинается с самого корня
        while (current != null) {
            last = current;
            current = current.leftChild;//доходим до самого дальнего левого потомка и записываем
            //его в переменную  last(наш минимум)
        }
        return last;
    }
    public Node max() {
        Node current, last = null;
        current = root;//наш поиск начинается с самого корня
        while (current != null) {
            last = current;
            current = current.rightChild;//доходим до самого дальнего правого потомка и записываем
            //его в переменную  last(наш максимум)
        }
        return last;
    }

    public boolean delete(int id) {
        Node current = root;//узел на котором мы находимся сейчас
        Node parent = root;// наш родительский узел

        boolean isLeftChild = true;//удаляемый элемент это левый потомок или нет?

        while (current.person.id != id) {
            parent = current;
            if (id < current.person.id) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        }
        //если нету потомков
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (current.rightChild == null) {
            if (current == null) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                current.rightChild = current.leftChild;
                ;
            }
        } else if (current.leftChild == null) {
            if (current == null) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
                ;
            }
        } else { //если 2 преемника
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    //метод будет возвращать узел, являющийся преемником
    public Node getSuccessor(Node node) {
        Node successorParent = node;
        Node successor = node;
        Node current = node.rightChild;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != node.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = node.rightChild;
        }
        return successor;
    }

    //будет выводить наше дерево
    public void displayTree() {
        Node current = root;
        System.out.println("Симметричный");
        inOrder(root);
        System.out.println("Прямой");
        preOrder(root);
        System.out.println("Обратный");
        postOrder(current);

    }
}
