// **********************************************************************
//
// Copyright (c) 2003-2004 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

#ifndef ICE_SLICE_CHECKSUM_H
#define ICE_SLICE_CHECKSUM_H

#include <Ice/SliceChecksumDict.h>

namespace Ice
{

extern ICE_API const SliceChecksumDict sliceChecksums;

}

namespace IceInternal
{

class SliceChecksumInit : public IceUtil::noncopyable
{
public:

    SliceChecksumInit(const char*[]);
};

}

#endif
