
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNParsePdfSpec.h"

@interface ParsePdf : NSObject <NativeParsePdfSpec>
#else
#import <React/RCTBridgeModule.h>

@interface ParsePdf : NSObject <RCTBridgeModule>
#endif

@end
