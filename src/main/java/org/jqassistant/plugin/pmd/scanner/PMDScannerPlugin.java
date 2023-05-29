package org.jqassistant.plugin.pmd.scanner;


import com.buschmais.jqassistant.core.scanner.api.Scanner;
import com.buschmais.jqassistant.core.scanner.api.Scope;
import com.buschmais.jqassistant.core.store.api.model.Descriptor;
import com.buschmais.jqassistant.plugin.common.api.scanner.AbstractScannerPlugin;
import net.sourceforge.pmd.PMD;

import java.io.IOException;
import java.time.format.TextStyle;

public class PMDScannerPlugin extends AbstractScannerPlugin {
    @Override
    public boolean accepts(Object o, String s, Scope scope) throws IOException {
        return true;
    }

    @Override
    public Descriptor scan(Object o, String s, Scope scope, Scanner scanner) throws IOException {
        String[] pmdArgs = new String[0];
        PMD.main(pmdArgs);
        return null;
    }
}
