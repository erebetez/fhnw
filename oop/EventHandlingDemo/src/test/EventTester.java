//EventTester.java
package test;

import gui.*;

public class EventTester {
   public static void main(String[] args) {
      ApplicationListener applicationListener 
         = new ApplicationListener();
      EventDelegationDemo eventDelegation =
         new EventDelegationDemo("EventDelegation", applicationListener);
   }
}

