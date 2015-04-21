@Grab('org.codehaus.groovyfx:groovyfx:0.4.0')
import groovyx.javafx.beans.FXBindable
import javafx.scene.control.TextField
import static groovyx.javafx.GroovyFX.start
import groovy.json.*

class QuickTest {
     @FXBindable def keyValueStore

    def QuickTest() {
        String jsonConfigFile = new File ('config.json').getText('UTF-8')
        def slurper = new JsonSlurper()
        keyValueStore = slurper.parseText(jsonConfigFile)
    };

    def writeConfig() {
        File jsonConfigFileModified = new File("config_modified.json")
        newFile1 << keyValueStore.toJson(jsonConfig)
    };

    def onClick = {
        println(qtText);
    }
}

String demo = new File ('superDemo.fxml').getText('UTF-8')
String file1= new File ('C:/MICROTEST/json/file1.json').getText('UTF-8')
start {
    def qt = new QuickTest()

    stage(title: "GroovyFX Bind Demo", x: 100, y: 100, width: 400, height: 400, visible: true,
            style: "decorated", onHidden: { println "Close"}) {
        scene(fill: GROOVYBLUE) {
            vbox(spacing: 10, padding: 10) {
                hbox(spacing: 10, padding: 10){
                  label(text: "person")
                  label(text: bind(qt.keyValueStore.person))
                }                
            }
        }   
    }
}

