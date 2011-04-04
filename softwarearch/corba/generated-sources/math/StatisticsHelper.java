package math;


/**
* math/StatisticsHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Statistics.idl
* Montag, 4. April 2011 14:35 Uhr MESZ
*/

abstract public class StatisticsHelper
{
  private static String  _id = "IDL:math/Statistics:1.0";

  public static void insert (org.omg.CORBA.Any a, math.Statistics that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static math.Statistics extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (math.StatisticsHelper.id (), "Statistics");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static math.Statistics read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_StatisticsStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, math.Statistics value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static math.Statistics narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof math.Statistics)
      return (math.Statistics)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      math._StatisticsStub stub = new math._StatisticsStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static math.Statistics unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof math.Statistics)
      return (math.Statistics)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      math._StatisticsStub stub = new math._StatisticsStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
