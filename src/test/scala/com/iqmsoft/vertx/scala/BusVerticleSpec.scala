package com.iqmsoft.vertx.scala

import org.scalatest._
import com.iqmsoft.vertx.scala.BusVerticle

class BusVerticleSpec extends VerticleTesting[BusVerticle] with Matchers {

  "BusVerticle" should "reply to a message" in {
    val future = vertx
        .eventBus()
        .sendFuture[String]("testAddress", "msg")

    future.map(res => res.body() should equal("Hello World!"))
  }

}
