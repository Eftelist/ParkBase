import me.eftelist.ParkBase.Base.Dependency;
import me.eftelist.ParkBase.Base.ParkBase;
import me.eftelist.ParkBase.Commands.Builders.Action;
import me.eftelist.ParkBase.Commands.Builders.CommandBuilder;
import me.eftelist.ParkBase.Commands.Builders.SubCommandBuilder;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Java extends ParkBase {

    @Override
    public void loadCommands() {
        addCommand(new CommandBuilder().setCommand("hi").addSubCommand(
                new SubCommandBuilder().name("world").action(
                        new Action() {
                            @Override
                            public void execute(@NotNull Player p) {
                                p.sendMessage("Hallo Wereld!");
                            }
                        }
                ).build()
        ).build());
    }

    @Override
    public void loadDependencies() {
        addDependency(new Dependency("ProtocolLib"));
    }

    @Override
    public void disable() {
        getLogger().info("Doei");
    }

    @Override
    public void enable() {
        getLogger().info("Hoi");
    }
}
