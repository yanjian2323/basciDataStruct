// 融合器,定义两个区间的计算规则
public interface  Merger<E> {
    E merge(E left, E right);
}
