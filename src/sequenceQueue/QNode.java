/**  
* <p>Title: QNode.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.baidudu.com</p>  
* @author shenlan  
* @date Mar 25, 2019  
* @version 1.0  
*/ 
package sequenceQueue;

/**  
* <p>Title: QNode</p>  
* <p>Description: 客户信息存储描述</p>  
* @author 马坤  
* @date Mar 25, 2019  
*/
public class QNode {
	public int arrive;
	public int treat;
	public QNode(int a, int t) {
		arrive = a;
		treat = t;
	}
}
