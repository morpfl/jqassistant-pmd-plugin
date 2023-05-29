package org.jqassistant.plugin.pmd.scanner;


import com.buschmais.jqassistant.core.scanner.api.Scanner;
import com.buschmais.jqassistant.core.scanner.api.Scope;
import com.buschmais.jqassistant.core.store.api.model.Descriptor;
import com.buschmais.jqassistant.plugin.common.api.scanner.AbstractScannerPlugin;
import lombok.extern.slf4j.Slf4j;
import net.sourceforge.pmd.PMD;
import net.sourceforge.pmd.PMDConfiguration;
import net.sourceforge.pmd.PmdAnalysis;
import org.jqassistant.plugin.pmd.model.PmdReport;

import java.io.File;
import java.io.IOException;
import java.time.format.TextStyle;
@Slf4j
public class PMDScannerPlugin extends AbstractScannerPlugin<PmdReport, PmdReport> {
    @Override
    public boolean accepts(PmdReport pmdReport, String s, Scope scope) throws IOException {
        return true;
    }

    @Override
    protected void configure() {
        log.info("Performing PMD analysis.");
        File pmdReportFile = new File(System.getProperty("user.dir") + "/pmd.xml");
        if(pmdReportFile.exists() && !pmdReportFile.isDirectory()){
            log.info("PMD analysis already been performed.");
            return;
        }
        PMDConfiguration configuration = new PMDConfiguration();
        configuration.addRuleSet(System.getProperty("user.dir") + "/jqassistant-pmd-metrics.xml");
        configuration.setInputPaths(System.getProperty("user.dir"));
        configuration.setReportFormat("xml");
        configuration.setReportFile(System.getProperty("user.dir") + "/pmd.xml");
        PmdAnalysis pmd = PmdAnalysis.create(configuration);
        pmd.performAnalysis();
    }

    @Override
    public PmdReport scan(PmdReport pmdReport, String s, Scope scope, Scanner scanner) throws IOException {
        return null;
    }
}
