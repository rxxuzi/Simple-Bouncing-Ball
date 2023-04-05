import java.awt.{Color, Font, Graphics}
import javax.swing.JPanel
import scala.collection.mutable.ArrayBuffer

case class Core() extends JPanel{

  val ball = ArrayBuffer(Ball)
  private val startTime = System.currentTimeMillis()
  val rad = 50
  val speed = 3
  var r = true
  var d = true

  this.setFocusable(true)
  this.setBackground(Color.black)


  override def paintComponent(g: Graphics): Unit = {
    super.paintComponent(g)
    draw(g)
  }

  def calculateX(x: Int): Int = {
    if (x > getWidth - rad) r = false
    if (x < 0 ) r = true

    if (r) x + speed else x - speed
  }

  def calculateY(y: Int): Int = {
    if (y > getHeight - rad) d = false
    if (y < 0 ) d = true
    if (d) y + speed else y - speed
  }


  private def draw(g: Graphics): Unit = {
    val nowTime = System.currentTimeMillis()
    g.setColor(Color.white)
    val x = Main.x
    val y = Main.y

    g.fillOval(x,y,rad,rad)

    g.setColor(Color.yellow)
    g.setFont(new Font("Serif", Font.BOLD, 20))
    g.drawString((nowTime - startTime)+ "ms", 10 ,20)
    g.drawString("x: " + x + ", y: " + y, 10 ,35)

    Main.x = calculateX(x)
    Main.y = calculateY(y)

    sleep()
  }

  private def sleep(): Unit= {
    Thread.sleep(10)
    repaint()
  }
}

