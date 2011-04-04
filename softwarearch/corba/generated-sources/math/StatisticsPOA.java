package math;


/**
* math/StatisticsPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Statistics.idl
* Montag, 4. April 2011 14:35 Uhr MESZ
*/

public abstract class StatisticsPOA extends org.omg.PortableServer.Servant
 implements math.StatisticsOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("setNumbers", new java.lang.Integer (0));
    _methods.put ("getAverage", new java.lang.Integer (1));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // math/Statistics/setNumbers
       {
         double numbers[] = math.StatisticsPackage.NumberSeqHelper.read (in);
         this.setNumbers (numbers);
         out = $rh.createReply();
         break;
       }

       case 1:  // math/Statistics/getAverage
       {
         double $result = (double)0;
         $result = this.getAverage ();
         out = $rh.createReply();
         out.write_double ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:math/Statistics:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Statistics _this() 
  {
    return StatisticsHelper.narrow(
    super._this_object());
  }

  public Statistics _this(org.omg.CORBA.ORB orb) 
  {
    return StatisticsHelper.narrow(
    super._this_object(orb));
  }


} // class StatisticsPOA