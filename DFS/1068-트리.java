import java.io.*;
import java.util.*;

public class Main {
    private static class Node {
        int parent;
        int value;
        List<Integer> childNodes = new ArrayList<>();

        public Node(int parent, int value) {
            this.parent = parent;
            this.value = value;
        }

        public void setChild(int value) {
            this.childNodes.add(value);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeCount = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");

        List<Node> tree = new ArrayList<>(nodeCount);
        int delNode = Integer.parseInt(br.readLine());

        for(int i=0;i<nodeCount;i++) {
            // line[i] => parent
            // i => value
            int parentIdx = Integer.parseInt(line[i]);
            Node node = new Node(parentIdx, i);
            tree.add(node);
        }

        int root = -1;
        for (int i = 0; i < nodeCount; i++) {
            int parent = tree.get(i).parent;
            if (parent == -1) {
                root = i;
            } else {
                tree.get(parent).setChild(i);
            }
        }

        if(delNode == root) {
            System.out.println(0);
        } else {
            int count = dfs(tree, root, delNode);
            System.out.println(count);
        }
    }

    private static int dfs(List<Node> tree, int curNode, int delNode) {
        Node node = tree.get(curNode);
        int count = 0;
        // 삭제된 노드와 자식이 없는 경우(또는 유효한 자식이 삭제 노드밖에 없는 경우)
        if (node.childNodes.isEmpty()) {
            return 1;
        }
        boolean hasValidChild = false;
        for (int child : node.childNodes) {
            if (child == delNode) {
                continue;
            }
            hasValidChild = true;
            count += dfs(tree, child, delNode);
        }

        // 자식이 있었지만 전부 삭제되었거나 삭제 노드뿐이라면 현재 노드를 리프 노드로 간주
        if (!hasValidChild) {
            return 1;
        }

        return count;
    }


}



