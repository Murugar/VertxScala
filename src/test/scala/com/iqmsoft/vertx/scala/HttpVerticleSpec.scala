package com.iqmsoft.vertx.scala

import org.scalatest.Matchers
import com.iqmsoft.vertx.scala.HttpVerticle

import scala.concurrent.Promise

class HttpVerticleSpec extends VerticleTesting[HttpVerticle] with Matchers {

  "HttpVerticle" should "bind to 8666 and answer with 'world'" in {
    val promise = Promise[String]

    vertx.createHttpClient()
      .getNow(8666, "127.0.0.1", "/hello",
        r => {
          r.exceptionHandler(promise.failure)
          r.bodyHandler(b => promise.success(b.toString))
        })

    promise.future.map(res => res should equal("Hello lovely world!"))
  }

}
