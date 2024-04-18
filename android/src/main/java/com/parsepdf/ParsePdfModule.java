package com.parsepdf;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;

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


  // Example method
  // See https://reactnative.dev/docs/native-modules-android
  @Override
  public double multiply(double a, double b) {
    return a * b;
  }
}
