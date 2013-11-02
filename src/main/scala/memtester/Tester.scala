package memtester

import com.redis._

object Tester {

    def main(args : Array[String]) {
      args.toList match {
        case heaps :: mems :: Nil => {
          val heap = heaps.toInt
          val mem = mems.toInt
          writeSuccess(heap, mem)
        }
        case _ => println("you're doing it wrong")
      }
  }
    
    def writeSuccess(heap : Int, mem : Int) {
      
      val r = new RedisClient("tools-redis", 6379)
      r.set("javamemtest" + heap, mem)
      
    }
}
