package javaposse.jobdsl.dsl.helpers

import javaposse.jobdsl.dsl.JobType
import javaposse.jobdsl.dsl.WithXmlAction

class MatrixHelper extends AbstractHelper {

    MatrixHelper(List<WithXmlAction> withXmlActions, JobType type) {
        super(withXmlActions, type)
    }

    /**
     * Sets JDK axes for multi-configuration (matrix) jobs.
     * @param jdks String array of JDK versions
     */
    def jdkAxis (String[] jdkArray) {
        execute {
            def jdkAxisNode = it / axes / 'hudson.matrix.JDKAxis'
            jdkAxisNode / name('jdk')
            jdkArray.each { jdk ->
                jdkAxisNode / values << string(jdk)
            }
        }
    }

    /**
     * Sets TextAxis name for multi-configuration (matrix) jobs.
     * @param String array of App Server versions
     */
    def textAxisName (String nameString) {
        execute {
            def textAxisNode = it / axes / 'hudson.matrix.TextAxis'
            textAxisNode / name(nameString)
        }
    }

    /**
     * Sets TextAxis values for multi-configuration (matrix) jobs.
     * @param String array of App Server versions
     */
    def textAxisValues (String[] valueArray) {
        execute {
            def textAxisNode = it / axes / 'hudson.matrix.TextAxis'
            valueArray.each { value ->
                textAxisNode / values << string(value)
            }
        }
    }

}