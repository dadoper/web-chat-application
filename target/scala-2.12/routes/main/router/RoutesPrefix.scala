
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/sqle/Desktop/CS/WebChatApplication/conf/routes
// @DATE:Sat Aug 12 15:12:00 ICT 2017


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
