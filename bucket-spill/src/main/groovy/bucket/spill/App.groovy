/*
 * This Groovy source file was generated by the Gradle 'init' task.
 */
package bucket.spill

class App {
    String getGreeting() {
        return 'Hello world.'
    }

    static void main(String[] args) {
        spill()
    }

    def static spill() {
        println "---------------->App.spill START!"
        cmd("pwd")
        cmd("mkdir repos")
        // cmd("cd repos")
        // git("git clone https://github.com/aadrian/selenium-example.git")
        println "---------------->App.spill END!"
    }


    def static cmd(String cmd) {
        def sout = new StringBuilder(), serr = new StringBuilder()
        def proc = cmd.execute()
        proc.consumeProcessOutput(sout, serr)
        proc.waitForOrKill(1000)
        println "out> $sout err> $serr"
    }
}
