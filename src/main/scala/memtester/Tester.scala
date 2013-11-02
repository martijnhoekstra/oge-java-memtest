package memtester

import com.redis._

object Tester {

    def main(args : Array[String]) {
      args.toList match {
        case heaps :: mems :: Nil => {
          val heap = heaps.toInt
          val mem = mems.toInt
          if (heap > mem) println(s"more heap than mem? Impossibru! $heap > $mem")
          writeSuccess(heap, mem)
        }
        case _ => println("you're doing it wrong")
      }
  }
    
    def writeSuccess(heap : Int, mem : Int) {
      println(s"we're running successfully with $heap heap and $mem mem")
      val r = new RedisClient("tools-redis", 6379)
      val got = r.get("javamemtest" + heap)
      if (got.isDefined )
      if (got.map(_.toInt).getOrElse(Int.MaxValue) > mem){
        println(s"wrote out key javamemtest$heap")
        r.set("javamemtest" + heap, mem)
      }
    }
}
