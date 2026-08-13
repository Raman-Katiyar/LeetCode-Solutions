class Solution {
    static class Node {
        int max;    
        int pref;   
        int suff;       
        char leftChar;  
        char rightChar; 
        int len;        
    }

    private Node[] tree;
    private char[] chars;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        int k = queryIndices.length;
        this.chars = s.toCharArray();
        this.tree = new Node[4 * n]; 
        build(0, 0, n - 1);

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            int idx = queryIndices[i];
            char newChar = queryCharacters.charAt(i);

            chars[idx] = newChar;
            update(0, 0, n - 1, idx, newChar);
            result[i] = tree[0].max;
        }

        return result;
    }
    private void build(int nodeIdx, int start, int end) {
        tree[nodeIdx] = new Node();
        tree[nodeIdx].len = end - start + 1;
        if (start == end) {
            char c = chars[start];
            tree[nodeIdx].max = 1;
            tree[nodeIdx].pref = 1;
            tree[nodeIdx].suff = 1;
            tree[nodeIdx].leftChar = c;
            tree[nodeIdx].rightChar = c;
            return;
        }

        int mid = start + (end - start) / 2;
        int leftChild = 2 * nodeIdx + 1;
        int rightChild = 2 * nodeIdx + 2;

        build(leftChild, start, mid);
        build(rightChild, mid + 1, end);

        merge(tree[nodeIdx], tree[leftChild], tree[rightChild]);
    }

    private void update(int nodeIdx, int start, int end, int targetIdx, char newChar) {
        if (start == end) {
            tree[nodeIdx].leftChar = newChar;
            tree[nodeIdx].rightChar = newChar;
            return;
        }

        int mid = start + (end - start) / 2;
        int leftChild = 2 * nodeIdx + 1;
        int rightChild = 2 * nodeIdx + 2;

        if (targetIdx <= mid) {
            update(leftChild, start, mid, targetIdx, newChar);
        } else {
            update(rightChild, mid + 1, end, targetIdx, newChar);
        }

        merge(tree[nodeIdx], tree[leftChild], tree[rightChild]);
    }

    private void merge(Node parent, Node left, Node right) {
        parent.leftChar = left.leftChar;
        parent.rightChar = right.rightChar;
        parent.max = Math.max(left.max, right.max);
        parent.pref = left.pref;
        parent.suff = right.suff;

        if (left.rightChar == right.leftChar) {
            parent.max = Math.max(parent.max, left.suff + right.pref);
            if (left.pref == left.len) {
                parent.pref = left.len + right.pref;
            }
            if (right.suff == right.len) {
                parent.suff = right.len + left.suff;
            }
        }
    }
}