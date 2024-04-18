package com.parsepdf;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextExtraction;

@ReactModule(name = ParsePdfModule.NAME)
public class ParsePdfModule extends NativeParsePdfSpec {
  public static final String NAME = "ParsePdf";

  public ParsePdfModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }

  @ReactMethod
  public void extractTextFromPdf(String filePath, Promise promise) throws IOException {
    String extractedText = "";
    try {
      File file = new File(filePath);
      PDDocument document = PDDocument.load(file);
      extractedText = PDFTextExtraction.getText(document);
      document.close();
    } catch (IOException e) {
      promise.reject(e);
      return;
    }
    promise.resolve(extractedText);
  }
}
