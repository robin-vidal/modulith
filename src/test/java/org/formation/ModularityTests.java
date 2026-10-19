package org.formation;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

class ModularityTests {
    ApplicationModules modules = ApplicationModules.of(DemoModulithSb4Application.class);

    @Test
    void verifiesModuleStructure() {
        modules.verify();
    }

    @Test
    void generateDocumentation() throws Exception {
        new Documenter(modules).writeDocumentation();
    }
}
