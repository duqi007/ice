// **********************************************************************
//
// Copyright (c) 2003
// ZeroC, Inc.
// Billerica, MA, USA
//
// All Rights Reserved.
//
// Ice is free software; you can redistribute it and/or modify it under
// the terms of the GNU General Public License version 2 as published by
// the Free Software Foundation.
//
// **********************************************************************

package Ice;

public abstract class AMI_Object_ice_invoke extends IceInternal.OutgoingAsync
{
    public abstract void ice_response(boolean ok, byte[] outParams);
    public abstract void ice_exception(LocalException ex);

    public final void __invoke(IceInternal.Reference ref, String operation, OperationMode mode,
			       byte[] inParams, java.util.Map context)
    {
	try
	{
	    __prepare(ref, operation, mode, context);
	    __os.writeBlob(inParams);
	    __os.endWriteEncaps();
	}
	catch(LocalException ex)
	{
	    __finished(ex);
	    return;
	}
	__send();
    }

    protected final void __response(boolean ok) // ok == true means no user exception.
    {
	byte[] outParams;
	try
	{
	    int sz = __is.getReadEncapsSize();
	    outParams = __is.readBlob(sz);
	}
	catch(LocalException ex)
	{
	    __finished(ex);
	    return;
	}
	ice_response(ok, outParams);
    }
}
