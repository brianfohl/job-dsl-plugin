package javaposse.jobdsl.dsl.helpers

import javaposse.jobdsl.dsl.JobType
import javaposse.jobdsl.dsl.WithXmlAction

class TerracottaHelper extends AbstractHelper {

    TerracottaHelper(List<WithXmlAction> withXmlActions, JobType type) {
        super(withXmlActions, type)
    }

    /**
     * Sets property file path for EnvInject plugin
     * @param String full path, usually monkeyshares
     */
    def envInjectPropertiesFile (String fileName) {
        execute {
            def propertiesNode = it / 'properties'
            propertiesNode  / 'EnvInjectJobProperty' / info / propertiesFilePath(fileName)
        }
    }
}