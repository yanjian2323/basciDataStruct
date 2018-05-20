public class UnionFind2 implements UnionFind {
    private int[] parent;

    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("index is illegal");
        }
        while(parent[p] != p) {
            p = parent[p];
        }

        return p;
    }

    public UnionFind2(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            // 默认自己和自己相连
            parent[i] = i;
        }
    }



    @Override
    public int getSize() {
        return parent.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // 未经优化的实现
    @Override public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        parent[pRoot] = parent[qRoot];
    }

}
