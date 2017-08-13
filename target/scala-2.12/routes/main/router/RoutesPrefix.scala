
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/sqle/Desktop/CS/Web-Chat-Application/conf/routes
// @DATE:Sun Aug 13 15:49:47 ICT 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
