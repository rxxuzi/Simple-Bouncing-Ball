
import javax.swing.{JFrame, JPanel}
object Main {
  var x = 100
  var y = 100
  def main(args: Array[String]): Unit = {
    println("Hello world!")

    val jf = new JFrame()
    val jp = new JPanel()
    jf.setVisible(true)
    jf.setDefaultCloseOperation(3)
    jf.setTitle("Bounce")
    jf.add {
      Core()
    }
    jf.setSize(750, 750)

  }
}