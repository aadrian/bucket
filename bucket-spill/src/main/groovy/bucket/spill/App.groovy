package bucket.spill

import org.fusesource.jansi.AnsiConsole
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import picocli.CommandLine

@CommandLine.Command(
        name = "./bin/bucket-spill",
        versionProvider =  ManifestVersionProvider.class,
        mixinStandardHelpOptions = true,
        description = "@|bold Bucket Spill|@ @|underline tool for GitBucket |@ project")
class App implements Runnable {
    private final static Logger LOG = LoggerFactory.getLogger(App.class);


    static void main(String[] args) {
        AnsiConsole.systemInstall()
        CommandLine.run(new App(), args)
        AnsiConsole.systemUninstall()
    }

    def static spill() {
        LOG.info("App.spill")
        cmd("pwd")
        cmd("mkdir repos")
        // cmd("cd repos")
        // git("git clone https://github.com/aadrian/selenium-example.git")
    }


    def static cmd(String cmd) {
        def sout = new StringBuilder(), serr = new StringBuilder()
        def proc = cmd.execute()
        proc.consumeProcessOutput(sout, serr)
        proc.waitForOrKill(1000)
        println "out> $sout err> $serr"
    }

    @Override
    void run() {
        LOG.info("App.run -> START")
        spill()
        LOG.info("App.run -> END")
    }
}
