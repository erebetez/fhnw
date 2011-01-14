package domain;

import java.util.Vector;

public class Pool {
	private Vector<Data> dataPool;

		public Pool(){
			dataPool = new Vector<Data>();
		}
		
		public boolean addData(Data data){
			return this.dataPool.add(data);
		}

		public int getDataCount() {
			return this.dataPool.size();
		}
		
		public Data getData(int idx) {
			if (idx < 0 || idx >= this.dataPool.size()) return null;
			return this.dataPool.get(idx);
		}

		@Override
		public String toString() {
			return "Pool [dataPool=" + dataPool + "]";
		}
	
	
}
