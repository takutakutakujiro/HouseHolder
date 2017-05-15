
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/nishida-takuro/git/HouseHolder/AppHouse/conf/routes
// @DATE:Mon May 15 00:27:12 JST 2017


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
