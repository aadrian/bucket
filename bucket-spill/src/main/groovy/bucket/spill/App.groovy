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

    @CommandLine.Option(names = [ "-c", "--conf" ], defaultValue = "./conf/conf.yml", description = 'configuration file (default: ${DEFAULT-VALUE})')
    File conf

    /**
     * Available actions:
     *  <ul>
     *     <li>spill - check out all repos a user has</li>
     *     <li>list-groups - lists all groups a user has</li>
     *     <li>list-repos - lists all repos a user has</li>
     *     <li>list-issues - lists all issues a user is allowed to see</li>
     *  </ul>
     */
    @CommandLine.Option(names = ["-a", "--action"],
            required = true,
            completionCandidates = ActionCandidates.class,
            description = 'Action to execute: ${COMPLETION-CANDIDATES}',
            showDefaultValue = CommandLine.Help.Visibility.ALWAYS)
    private String action = "spill"

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

    /**
     * Defined candidates for the action.
     */
    static class ActionCandidates extends ArrayList<String> {
        public ActionCandidates() {
            super(Arrays.asList(
                    "spill",
                    "list-groups",
                    "list-repos",
                    "list-issues"
            ));
        }
    }

}
