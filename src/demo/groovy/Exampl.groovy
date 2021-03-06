@Grab('org.codehaus.groovyfx:groovyfx:0.4.0')
import groovyx.javafx.beans.FXBindable
import javafx.fxml.FXML
import javafx.scene.control.TextField
import static groovyx.javafx.GroovyFX.start
import javafx.fxml.Initializable
import javafx.scene.control.Label
import javafx.event.ActionEvent

class QuickTest implements Initializable {
     @FXBindable String qtText = "Quick Test"
    def onClick = {
        println(qtText);
    } 

    @FXML
    private void formSubmit(ActionEvent event) {
        println "You clicked me!";        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }



}
String demo = new File ('demo1.fxml').getText('UTF-8')
//println(demo)

start {
    def qt = new QuickTest()

    stage(title: "GroovyFX Bind Demo", x: 100, y: 100, width: 400, height: 400, visible: true,
            style: "decorated", onHidden: { println "Close"}) {
        scene(fill: GROOVYBLUE) {
            vbox(spacing: 10, padding: 10) {
                TextField tf = textField(text: bind(qt.qtText()))
                button(text: "CLICK ME!", onAction: {qt.onClick()})
                fxml(demo)
            }
        }   
    }
}
