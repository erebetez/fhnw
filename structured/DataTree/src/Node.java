
// baum N = (2^s)-1 elemente, n ist anzahl ebene, N anzahl knoten
// s = log2(N)

class Node{
   int data;
   Node L;
   Node R;
   
   Node buildTree(int[] a, int start, int end) {
	   if (start == end)
		   return null;
	   
	   Node result = new Node();
	   
	   int mitte = (start+end)/2;
	   
	   result.data = a[mitte];
	   
	   result.L = buildTree(a, start, mitte -1);
	   result.R = buildTree(a, mitte + 1, end);
	   
	   return result;
   }
   
   
} 


