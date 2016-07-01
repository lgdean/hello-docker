import akka.actor.ActorSystem
import akka.event.Logging
import akka.http._
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer

trait HelloApp {
  implicit val system = ActorSystem("hello-actors")
  implicit val materializer = ActorMaterializer()

  import system.dispatcher

  val log = Logging(system, getClass)

  val route =
    pathSingleSlash {
      log.info("happy to serve you /")
      getFromResource("index.html");
    }

  val host = "0.0.0.0"
  val port = 8080
  val http = Http().bindAndHandle(
    route,
    host,
    port
  )

  http onFailure {
    case ex: Exception =>
      log.error(ex, "Failed to bind to {}:{}", host, port)
  }

  log.info("the hello app has started")
}

object Main extends App with HelloApp {
}

