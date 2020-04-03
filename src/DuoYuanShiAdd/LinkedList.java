package DuoYuanShiAdd;

public class LinkedList<T> implements IList {

    //ͷ�ڵ�
    private LNode<T> tnode;
    private Integer length = 0;
    //��ǰ�ڵ�
    private LNode<T> cnode;

    //β�ͽڵ�
    private LNode<T> taillNode;

    public LNode<T> getTnode() {
        return tnode;
    }

    @Override
    public void InitList() {
        tnode = new LNode<>(); //��ʼ��ͷ�ڵ�
        taillNode = tnode;
    }

    @Override
    public IList DestroyList() {

        tnode.setNext(null);
        length = 0;  //����Ӧ������list����Ϊnull ��javaû����������
        taillNode = tnode;
        return this;
    }

    @Override
    public IList ClearList() {
        cnode = tnode.getNext();
        while (cnode.getNext() != null) {
            cnode = cnode.getNext();
            cnode.setData(null);
            length--;
        }
        taillNode = tnode;
        return this;
    }

    @Override
    public Boolean ListEmpty() {
        if (length != 0) {
            return Boolean.FALSE;
        } else {
            return Boolean.TRUE;
        }
    }

    @Override
    public Integer ListLength() {
        return this.length;
    }

    @Override
    public Object GetElem(Integer i) {
        cnode = tnode.getNext();
        while (i - 1 > 0) {
            cnode = cnode.getNext();
            i--;
        }
        return cnode.getData();
    }

    @Override
    public Integer LocateElem(Object e) {
        cnode = tnode.getNext();
        int i = 1;
        while (cnode != null && !e.equals(cnode.getData())) {
            i++;
            cnode = cnode.getNext();
        }
        if (cnode == null) {
            return -1;
        }
        return i;
    }

    @Override
    public Object PriorElem(Object e) {
        cnode = tnode.getNext();

        LNode<T> pnode = null;

        while (!e.equals(cnode.getData())) {
            pnode = cnode; //��һ���ڵ�
            cnode = cnode.getNext();
        }
        return pnode.getData();

    }

    @Override
    public Object NextElem(Object e) {
        cnode = tnode.getNext();
        while (!e.equals(cnode.getData())) {
            cnode = cnode.getNext();
        }
        return cnode.getNext().getData();

    }

    @Override
    public IList ListInsert(Integer i, Object e) {

        LNode<T> newNode = new LNode<>();
        newNode.setData((T) e);
        cnode = tnode.getNext();


        if (i==1){
            tnode.setNext(newNode);
            newNode.setNext(cnode);
            length++;
            return this;
        }



        /**
         * �����һλ����
         */
        if (i.equals(this.length)) {

            newNode.setNext(null);
            newNode.setData(taillNode.getData());
            taillNode.setData((T) e);
            taillNode.setNext(newNode);
            taillNode = newNode;
            return this;
        }




        while (i > 2) {
            cnode = cnode.getNext();
            i--;
        }

        newNode.setNext(cnode.getNext());
        cnode.setNext(newNode);

        length++;


        return this;
    }

    //todo �޸ĺ������ɾ��
    @Override
    public IList ListDelete(Integer i) {
        cnode=tnode.getNext();
        if (cnode==null){
            return null;
        }

        int j=2;
        if (i==1){
            tnode.setNext(cnode.getNext());
            length--;
            return this;
        }

        while (cnode.getNext()!=null){
            if (i==j){
                cnode.setNext(cnode.getNext().getNext());
                length--;
                return this;
            }
            j++;
            cnode=cnode.getNext();
        }

        if (i==j){
            cnode.setNext(null);
            length--;
            taillNode=cnode;
        }

        return null;
    }

    @Override
    public void ListTraverse() {
        cnode = tnode.getNext();
        while (cnode.getNext() != null) {
            if (cnode.getData() != null) {
                System.out.print(cnode.getData() + ",");
            }
            cnode = cnode.getNext();
        }
        System.out.print(cnode.getData() + ",");
        System.out.println();

    }

    /**
     * �ϲ��������Ա��в��ظ���Ԫ��
     *
     * @param list
     * @return
     */
    @Override
    public IList Union(IList list) {
        for (int i = 1; i <= list.ListLength(); i++) {
            if ((this.LocateElem(list.GetElem(i))) == -1) {

                LNode<T> newNode = new LNode<>();
                taillNode.setNext(newNode);
                newNode.setData((T) list.GetElem(i));
                newNode.setNext(null);
                taillNode = newNode;
                this.length++;
            }
        }

        return this;
    }

    @Override
    public IList MergeList(IList list) {
        LinkedList<T> LB = (LinkedList<T>) list;
        //����֪�������б��Ƿǵݼ����е�����ºϲ�
        //Ҫ��ϲ�֮���Ƿǵݼ�����
        //��������鲢 Ҫ�벻�����������Ա�һ��������������ʵ�� �͵��õ�ָ�� ֪���ڵ��λ��
        LNode<T> pb = LB.getTnode().getNext();
        LNode<T> pa = this.getTnode().getNext();
        cnode = tnode;  //��ǰ�ڵ�
        this.length = this.length + list.ListLength();

        while (pa != null && pb != null) {
            if ((Integer) pa.getData() <= (Integer) pb.getData()) {
                cnode.setNext(pa);
                cnode = pa;
                pa = pa.getNext();
            } else {
                cnode.setNext(pb);
                cnode = pb;
                pb = pb.getNext();
            }

        }

        if (pa == null) {
            cnode.setNext(pb);
        } else {
            cnode.setNext(pa);
        }

        return list;
    }

    @Override
    public void add(Object e) {
        cnode = tnode.getNext();

        LNode<T> newNode = new LNode<>();
        newNode.setNext(null);
        newNode.setData((T) e);

        if (cnode != null) {
            while (cnode.getNext() != null) {
                cnode = cnode.getNext();
            }

            cnode.setNext(newNode);

        } else {
            tnode.setNext(newNode);
        }
        taillNode = newNode;

        this.length++;


    }


    /**
     * ���������   ����ÿ����һ�� ������β����ǰ����
     */
    public void Reversal() {
        cnode = tnode.getNext();
        if (cnode.getNext() == null) {
            return;
        }
        //��һ���ڵ�
        LNode<T> firstNode = new LNode<>();

        firstNode.setNext(null);
        firstNode.setData(cnode.getData());
        tnode.setNext(firstNode);

        cnode = cnode.getNext();

        while (cnode != null) {   //��Ϊ���һ���ڵ��next��null

            LNode<T> newNode = new LNode<>();
            newNode.setData(cnode.getData());
            newNode.setNext(tnode.getNext());
            tnode.setNext(newNode);
            cnode = cnode.getNext();
        }


    }
    /**
     * β�ڵ�ĺô�  ���Ը�����ҵ�β���ڵ�  ȱ����������˴���ĸ��Ӷ�  ��Ҫ�ڲ����ɾ��ʱ���β�ڵ����ά��
     */
}
