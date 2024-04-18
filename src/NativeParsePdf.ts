import type { TurboModule } from 'react-native';
import { TurboModuleRegistry } from 'react-native';

export interface Spec extends TurboModule {
  extractTextFromPdf(filePath: string): Promise<string>;
}

export default TurboModuleRegistry.getEnforcing<Spec>('ParsePdf');
