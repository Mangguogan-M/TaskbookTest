/**  
* <p>Title: test.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) May 18, 2019</p>  
* @author ÂíÀ¤  
* @date May 18, 2019  
* @version 1.0  
*/ 
package ALGraph;

import Graph.Graph;

public class test {
	public static void main(String[] args) {
		Graph<Character> G = new Graph<Character>();
		G.CreateAdj();
		G.DisplayAdjMatrix();
	}

}
