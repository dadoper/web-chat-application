
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/sqle/academic/cs/summer-java/web-chat-application/conf/routes
// @DATE:Sun Aug 20 08:41:35 ICT 2017


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
