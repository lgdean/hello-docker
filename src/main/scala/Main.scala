import akka.actor.ActorSystem
import akka.http._
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer

trait HelloApp {
  implicit val system = ActorSystem("hello-actors")
  implicit val materializer = ActorMaterializer()

  import system.dispatcher

  val route =
    pathSingleSlash {
      getFromResource("index.html");
    }

  Http().bindAndHandle(
    route,
    "localhost",
    8080
  )
}

object Main extends App with HelloApp {
}

