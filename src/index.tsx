const ParsePdf = require('./NativeParsePdf').default;

export async function extractTextFromPdf(filePath: string): Promise<string> {
  return ParsePdf.extractTextFromPdf(filePath);
}
