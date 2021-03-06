package com.iqmsoft.vertx.scala

import io.vertx.lang.scala.ScalaVerticle
import io.vertx.scala.ext.web.Router

import scala.concurrent.Future

class HttpVerticle extends ScalaVerticle {

  override def startFuture(): Future[Unit] = {

    val router = Router.router(vertx)

    val route = router
      .get("/hello")
      .handler(_.response().end("Hello lovely world!"))

    vertx
      .createHttpServer()
      .requestHandler(router.accept)
      .listenFuture(8666, "0.0.0.0")
      .map(_ => ())
  }
}
