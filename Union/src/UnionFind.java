public interface UnionFind {
    boolean isConnected(int p, int q);//2个元素是否相连
    void union(int p, int q);//连接2个元素
    int getSize();
}
