import java.net.{URI, URLDecoder, URLEncoder}
import scala.swing._
import scala.swing.event.{ButtonClicked, EditDone}

/**
 * Created by hanxue on 9/17/13.
 */
object Encoder extends SimpleSwingApplication {
  def newField = new TextField {
    text = " "
    columns = 20
  }

//  val contents = newField
  val input = new TextField {
    text = ""
    columns = 50
  }

  val encode = new Button(" Encode ")
  val decode = new Button(" Decode ")

  def top = new MainFrame {
    title = "Encode / Decode URL"
    contents = new FlowPanel(input, encode, decode)
  }

  listenTo(encode, decode)
  reactions += {
    case ButtonClicked(`encode`) =>
      input.text = URLEncoder.encode(input.text, "UTF-8")
    case ButtonClicked(`decode`) =>
      input.text = new URI(input.text)getPath()
  }

}
