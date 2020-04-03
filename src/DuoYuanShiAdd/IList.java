package DuoYuanShiAdd;

public interface IList<T> {

    /**
     * ����һ���յ����Ա� ���г�ʼ��
     */
    void InitList();

    /**
     * �������Ա�
     */
    IList DestroyList();

    /**
     * �����Ա�����Ϊ�ձ�
     */
    IList ClearList();

    /**
     * �ж����Ա��Ƿ�Ϊ��
     */
    Boolean ListEmpty();

    /**
     * �������Ա���Ԫ�صĸ���
     */
    Integer ListLength();

    /**
     * ��ȡ���Ա��е�i��Ԫ��
     */
    T GetElem(Integer i);

    /**
     * ����Ԫ�ػ�ȡ����λ������ж�����ϣ��򷵻ص�һ�������û���򷵻�0
     */
    Integer LocateElem(T e);

    /**
     * ��ȡ��Ԫ�ص���һ��Ԫ��
     */
    T PriorElem(T e);
    /**
     *��ȡ��Ԫ�ص���һ��Ԫ��
     */
    T NextElem(T e);
    /**
     * ��ָ��λ�ò���Ԫ��
     */
    IList ListInsert(Integer i, T e);

    /**
     *ɾ��ָ��λ�õ�Ԫ��
     */
    IList ListDelete(Integer i);

    /**
     * �������е�Ԫ��
     */
    void  ListTraverse();

    /**
     * �ϲ��������Ա� �ϲ����ظ���Ԫ��
     */
    IList Union(IList list);

    /**
     * ���յ���˳��ϲ��������Ա�
     */
    IList MergeList(IList list);

    /**
     * ��β������Ԫ��
     */
    void add(T e);

}
