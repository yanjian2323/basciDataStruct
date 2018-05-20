// 路径压缩

public class UnionFind6 implements UnionFind {
    private int[] parent;
    private int[] rank;

    // 找到p的根节点
    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("index is illegal");
        }
        if(p != parent[p]) {
            parent[p] = find(parent[p]);
        }

        return parent[p];
    }

    public UnionFind6(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            // 默认自己和自己相连
            parent[i] = i;
            // 默认每个根节点下面只有它自己1个节点
            rank[i] = 1;
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

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        // 根据根节点下面的深度来判断谁指向谁
        if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        } else if(rank[pRoot] < rank[qRoot]){
            parent[pRoot] = qRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot]++;
        }
    }
}
