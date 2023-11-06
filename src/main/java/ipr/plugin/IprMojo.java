package ipr.plugin;

import org.apache.maven.model.Contributor;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;


@Mojo(name = "ipr", defaultPhase = LifecyclePhase.PROCESS_CLASSES, threadSafe = true, aggregator = true)
public class IprMojo extends AbstractMojo {

    @Parameter(property = "visitor")
    private String visitor;
    @Parameter(defaultValue = "${project}")
    private MavenProject mavenProject;


    public void execute() {

        var visitorOptional = mavenProject.getDevelopers().stream()
                .map(Contributor::getName)
                .filter(name -> visitor.equalsIgnoreCase(name))
                .findFirst();

        if (visitorOptional.isPresent()) {
            System.out.println(this.getHomer());
            System.out.println("Hello " + visitor.toUpperCase() + "!!!");

        } else {
            System.out.println(getMo());
            System.out.println("You're not welcome here, " + visitor + "...");

        }
    }

    private String getHomer() {
        return "░░░░░░▄▄▄▄███▄▄▄▄░░░░░░░░░░░░░" + "\n" +
                "░░░▄▄█▀░░░░░░░░░▀▀▄▄░░░░░░░░░░" + "\n" +
                "░░█▀░░░░░░░░░░░░░░░▀█▄░░░░░░░░" + "\n" +
                "░█▀░░░░░░░░░░░░░░░░░░█▄░░░░░░░" + "\n" +
                "██░░░░░░░░░░░░░░░░░░░░█▄░░░░░░" + "\n" +
                "█░░░░░░░░░░░░░░░░░░░░░░█▄░░░░░" + "\n" +
                "██░░░░░░░░░░░░▄▄▄▄▄█▀▀▀██▄░░░░" + "\n" +
                "▀█░░░░░░░░░▄█▀▀░░▀▀█▄░░░░█▄░░░" + "\n" +
                "░█▄░▄░░░░░▄█░░░░░░░░█▄░█░░█░░░" + "\n" +
                "░▄█▄██▄░░░█▄░░██░░░░██▄▄▄██░░░" + "\n" +
                "░████░▀▀░░░█▄░░░░░░▄█░░░░░██░░" + "\n" +
                "░█░░██▄▄░░░░▀██▄▄██▀▄▄▄▄▄▄█░░░" + "\n" +
                "░░▄█▀░░░░░░░░░▄▄██▀▀▀▀▀▀▀░▀█▄░" + "\n" +
                "░░▀█░░░░░░░▄█▀▀░░░░░░░░░░░░░█▄" + "\n" +
                "░░░▀█▄▄█▀░█▀░░░░░░░░░░░░░░░▄█▀" + "\n" +
                "░░░░░░██░▄█░░░█▀██▀▀█▀██▀▀▀▀░░" + "\n" +
                "░░░░░▄█░░▀█░░▀█░█░░██░██░░░░░░" + "\n" +
                "░░░░██▀█▄░▀█▄░▀▀████▀▀██░░░░░░" + "\n" +
                "░░░░█░░░▀▀█▄▀█▄▄▄▄▄▄▄▄██▄░░░░░";
    }

    private String getMo() {
        return "⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢀⣀⣀⣀⠄⡀⢀⣀⣀⣀⡀" + "\n" +
                "⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢠⣤⣤⣤⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦" + "\n" +
                "⠄⠄⠄⠄⠄⠄⠄⠄⠄⢀⣠⣿⣿⣿⣿⣿⣿⡿⠛⠿⠟⠻⢿⣿⣿⡿⠋" + "\n" +
                "⠄⠄⠄⠄⠄⠄⠄⠄⠄⢸⣿⣿⣿⣿⣿⣿⠇⠄⠄⠄⠄⠄⠄⠄⠘⢷⡀" + "\n" +
                "⠄⠄⠄⠄⠄⠄⠄⠄⠄⣾⣿⣿⣿⣿⣿⠇⢀⣤⣤⣀⡀⠄⠄⢹⡆⠄⠙⢶⣄" + "\n" +
                "⠄⠄⠄⠄⠄⠄⠄⠄⠄⢿⣿⢾⣿⣿⡇⠄⠄⣷⣜⣋⣙⣛⣶⣾⣟⣷⡦⣄⣸⡇" + "\n" +
                "⠄⠄⠄⠄⠄⠄⠄⠄⢀⣼⣿⠟⠿⠿⠃⠄⠄⠉⠛⠛⠛⠋⣯⡄⢉⣛⣦⠞⠉" + "\n" +
                "⠄⠄⠄⠄⠄⠄⢀⣴⡟⠹⣯⠄⠄⣠⡄⠄⠄⠄⠄⠄⠄⠄⠈⠁⠨⡿⣿" + "\n" +
                "⠄⠄⠄⠄⣀⣰⠟⣦⣷⠄⠹⣆⠄⠛⠛⠛⠻⠶⣄⡀⠄⠄⠄⠄⠄⠄⠈⢧⡀" + "\n" +
                "⠄⠄⢠⡞⠋⠻⣦⠸⣽⡆⠄⠉⢣⣄⡀⠄⠄⣀⣬⣽⣢⣤⣀⠄⠄⠄⠄⢸⡇" + "\n" +
                "⠄⢰⠇⠄⠄⠄⠄⢷⢧⢳⡄⠄⢸⣿⣿⣶⣾⣿⡆⠄⠄⠄⠈⠙⠛⠶⠶⠞⠃" + "\n" +
                "⠄⡞⠄⠄⠄⠄⠄⠘⣾⢸⡟⣤⣼⣿⣿⢻⣿⣿⣟" + "\n" +
                "⢠⡇⠄⠄⠄⠄⠄⠄⢻⠘⣷⠈⠁⠈⣿⣼⠋⠉⠹⣆" + "\n" +
                "⢸⡇⠄⠄⣀⣀⣀⣀⣿⠸⢿⣀⣀⣀⡿⣿⠄⠄⠄⠹⡇" + "\n" +
                "⠈⢷⣟⡿⣯⡍⣉⠉⠛⢢⣤⠄⠄⠄⠄⣿⡴⠖⠒⣶⣽" + "\n" +
                "⠄⢸⡿⣷⠏⣼⠋⣠⣤⠶⠾⠛⠉⠉⠉⠉⠳⢦⠄⠘⡇" + "\n" +
                "⠄⡟⠹⣜⠦⠷⠴⠋⠄⠄⠄⣀⣤⡴⠚⠛⠉⠉⠁⢀⡇" + "\n" +
                "⢀⡇⠄⠉⠓⠶⠶⠶⠒⠚⠉⠉⠙⠲⢦⣤⣤⣤⣴⠞⡇" + "\n" +
                "⢸⡇⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣿⢸⢀⢸⡀⢸⡀" + "\n" +
                "⠘⡇⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣿⡼⢸⠄⡇⢸⡇" + "\n" +
                "⠄⡇⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠸⣷⣼⠄⡇⢸⡇" + "\n" +
                "⠄⢇⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢹⣾⢠⠇⢸⡇" + "\n" +
                "⠄⢸⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠈⢿⢻⠄⣸⡇" + "\n" +
                "⠄⢸⡇⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢸⡞⠛⠃" + "\n" +
                "⠄⠈⡇⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣷" + "\n" +
                "⠄⠄⢧⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣿" + "\n" +
                "⠄⠄⢸⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢸" + "\n" +
                "⠄⠄⢸⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣀⣠⣤⣴⠚" + "\n" +
                "⠄⠄⠈⢹⣷⣶⣶⣶⣶⡖⠒⠒⢻⣿⣿⣿⣿⣿" + "\n" +
                "⠄⠄⠄⢸⣿⣿⣿⣿⣿⡇⠄⠄⢸⣿⣿⣿⣿⣿" + "\n" +
                "⠄⠄⠄⣿⣿⣿⣿⣿⣿⡇⠄⠄⢸⣿⣿⣿⣿⣿" + "\n" +
                "⠄⠄⠄⣿⣿⣿⣿⣿⣿⡇⠄⠄⢸⣿⣿⣿⣿⣿" + "\n" +
                "⠄⠄⢰⣿⣿⣿⣿⣿⣿⠃⠄⠄⢸⣿⣿⣿⣿⣿" + "\n" +
                "⠄⠄⢸⣿⣿⣿⣿⣿⡿⠄⠄⠄⣼⣿⣿⣿⣿⡏" + "\n" +
                "⠄⠄⣿⣿⣿⣿⣿⣿⠇⠄⠄⢀⣿⣿⣿⣿⣿⣧⣤⣀⣀⡀" + "\n" +
                "⠄⢸⣿⣿⣿⣿⣿⣿⣀⡀⠄⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣤⡀" + "\n" +
                "⣰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⠿⣿⣿⣿⣿⣿⣿⠿⠇" + "\n" +
                "⠛⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷" + "\n" +
                "⠄⠄⠄⠉⠉⠉⠉⠉⠛⠛⠛⠛⠉⠉";
    }
}