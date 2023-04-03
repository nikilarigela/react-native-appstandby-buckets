
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNAppstandbyBucketsSpec.h"

@interface AppstandbyBuckets : NSObject <NativeAppstandbyBucketsSpec>
#else
#import <React/RCTBridgeModule.h>

@interface AppstandbyBuckets : NSObject <RCTBridgeModule>
#endif

@end
