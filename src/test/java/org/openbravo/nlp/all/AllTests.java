package org.openbravo.nlp.all;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openbravo.nlp.finder.ActivityFinderShould;
import org.openbravo.nlp.finder.ParticipantFinderShould;
import org.openbravo.nlp.printer.ParticipantPrinterShould;
import org.openbravo.nlp.processor.ActivityProcessorShould;
import org.openbravo.nlp.processor.FunctionCompositionShould;
import org.openbravo.nlp.processor.ParticipantProcessorShould;

@RunWith(Suite.class)

@Suite.SuiteClasses({ ParticipantPrinterShould.class, //
    ParticipantFinderShould.class, //
    FunctionCompositionShould.class, //
    ParticipantProcessorShould.class, //
    ActivityProcessorShould.class, //
    ActivityFinderShould.class })

public class AllTests {
}
