import org.scalatra.LifeCycle
import javax.servlet.ServletContext
import com.futurechimps.squeryli._
import com.futurechimps.squeryli.data._

class Scalatra extends LifeCycle with DatabaseInit {

  override def init(context: ServletContext) {
    configureDb()
    context mount (new Articles, "/*")
  }
  
  override def destroy(context:ServletContext) {
    closeDbConnection()
  }
}