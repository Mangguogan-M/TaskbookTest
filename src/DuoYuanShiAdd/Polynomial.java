package DuoYuanShiAdd;

//ʵ����

public class Polynomial {
    //�洢����ʽ�õ�����
    private LinkedList list;
    private int Length=0;
    
    public int getLength() {
        return Length;
    }
    /**
     * ����ϵ���б�������ʾһԪ����ʽ����������
     */
    void CreatPolyn(term[] terms){
        list=new LinkedList();
        list.InitList();
        for (term term : terms) {
            //�ж��Ƿ������ָͬ������
           int j= locateElem(term);
           if (j!=-1){
               term it=(term)list.GetElem(j);
               term.setCoef(term.getCoef()+it.getCoef());
               list.ListDelete(j);
               list.ListInsert(j,term);
           }else {
               list.add(term);
               Length++;
           }
        }
    }
 
    void printPolyn(){
        for (int i = 1; i <=list.ListLength() ; i++) {
            term it=(term)list.GetElem(i);
            if (i!=list.ListLength()){
                System.out.print(it.getCoef()+"x"+it.expn+"+");
            }else {
                System.out.print(it.getCoef()+"x"+it.expn);
            }
        }
        System.out.println();
    }

 

 

    //�ж�����������û�����ϵ���ĺ���������У��������Ľڵ���ţ����û�У��򷵻�-1

    int locateElem(term term){

        for (int i = 1; i <=list.ListLength() ; i++) {

            term it=(term)list.GetElem(i);

            if (it.getExpn()==term.getExpn()){

                return i;

            }

        }

        return -1;

    }

 

    term getTerm(int i){

        return (term)list.GetElem(i);

    }

 

    void  addPolyn(Polynomial PolynomialB){

 

        int k=1;

        term[] terms=new term[PolynomialB.getLength()];

        while (k<=PolynomialB.getLength()){

            terms[k-1]= PolynomialB.getTerm(k);

            k++;

        }

 

 

        for (term term : terms) {

            //�ж��Ƿ������ָͬ������

            int j= locateElem(term);

            if (j!=-1){

                term it=(term)list.GetElem(j);

                term.setCoef(term.getCoef()+it.getCoef());

                list.ListDelete(j);

                list.ListInsert(j,term);

            }else {

                list.add(term);

                Length++;

            }

        }

 

    }

}


