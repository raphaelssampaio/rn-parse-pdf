#import "ParsePdf.h"

@implementation ParsePdf

RCT_EXPORT_MODULE()

#ifdef RCT_NEW_ARCH_ENABLED

- (std::shared_ptr<facebook::react::TurboModule>)getTurboModule:
    (const facebook::react::ObjCTurboModule::InitParams &)params
{
    return std::make_shared<facebook::react::NativeParsePdfSpecJSI>(params);
}

- (RCTPromise *)extractTextFromPdf:(NSString *)filePath
                  resolve:(RCTPromiseResolveBlock)resolve
                  reject:(RCTPromiseRejectBlock)reject {
  
  NSURL *fileURL = [NSURL URLWithString:filePath];
  if (!fileURL) {
    reject(@"Arquivo PDF inválido", @"Caminho do arquivo não encontrado", nil);
    return nil;
  }
  
  PDFDocument *document = [PDFDocument documentWithURL:fileURL];
  if (!document) {
    reject(@"Falha ao carregar o PDF", @"Erro ao abrir o arquivo", nil);
    return nil;
  }
  
  NSMutableString *extractedText = [NSMutableString new];
  
  for (PDFPage *page in document.documentPages) {
    if (PDFPageRefIsInteractive(page.pageRef)) {
      
      PDFPageContent *pageContent = [page pageContent];
      if (pageContent) {
        
        [extractedText appendString:pageContent.string];
      }
    }
  }
  
  resolve(extractedText);
  
  return nil;
}

#endif

@end