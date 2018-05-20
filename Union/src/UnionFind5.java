// 进行find操作的时候进行路径压缩(path compression)

public class UnionFind5 implements UnionFind {
    private int[] parent;
    private int[] size;

    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("index is illegal");
        }
        while(parent[p] != p) {
            // path compression
            parent[p] = parent[parent[p]];
            p = parent[p];
        }

        return p;
    }

    public UnionFind5(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            // 默认自己和自己相连
            parent[i] = i;
            // 默认每个根节点下面只有它自己1个节点
            size[i] = 1;
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
        if (size[pRoot] > size[qRoot]) {
            parent[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        } else {
            parent[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        }
    }
}
