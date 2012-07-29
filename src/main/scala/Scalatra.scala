import org.scalatra.LifeCycle
import javax.servlet.ServletContext
import com.futurechimps.squeryli._
class Scalatra extends LifeCycle {

  override def init(context: ServletContext) {
    context mount (new Articles, "/articles*")
    context mount (new Users, "/users*")
  }
}