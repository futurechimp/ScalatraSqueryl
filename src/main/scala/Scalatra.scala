import org.scalatra.LifeCycle
import javax.servlet.ServletContext
import com.futurechimps.squeryli._

class Scalatra extends LifeCycle with init.DatabaseInit {

  override def init(context: ServletContext) {
    configureDb()
    context mount (new Articles, "/articles/*")
    context mount (new Users, "/users/*")
  }
}