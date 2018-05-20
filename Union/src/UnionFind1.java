public class UnionFind1 implements UnionFind {
    private int[] ids;

    private int find(int p) {
        if (p < 0 || p >= ids.length) {
            throw new IllegalArgumentException("index is illegal");
        }
        return ids[p];
    }

    public UnionFind1(int n) {
        ids = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
    }

    @Override
    public int getSize() {
        return ids.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void union(int p, int q) {
        if (p < 0 || p >= ids.length || q < 0 || q >= ids.length) {
            throw new IllegalArgumentException("index is illegal");
        }
        int pValue = find(p);
        int qValue = find(q);
        if (pValue == qValue) return;
        for (int i = 0; i < getSize(); i++) {
            if (ids[i] == pValue) {
                ids[i] = qValue;
            }
        }
    }
}
