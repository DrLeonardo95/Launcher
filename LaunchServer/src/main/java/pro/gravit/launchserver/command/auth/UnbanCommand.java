package pro.gravit.launchserver.command.auth;

import pro.gravit.launcher.HWID;
import pro.gravit.launchserver.LaunchServer;
import pro.gravit.launchserver.command.Command;

import java.util.List;

public class UnbanCommand extends Command {
    public UnbanCommand(LaunchServer server) {
        super(server);
    }

    @Override
    public String getArgsDescription() {
        return "[username]";
    }

    @Override
    public String getUsageDescription() {
        return "Unban username for HWID";
    }

    @Override
    public void invoke(String... args) throws Exception {
        verifyArgs(args, 1);
        List<HWID> target = server.config.hwidHandler.getHwid(args[0]);
        server.config.hwidHandler.unban(target);
    }
}