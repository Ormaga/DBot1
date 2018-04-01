import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.util.DiscordException;

public class BaseBot {

    private static BaseBot INSTANCE;
    public IDiscordClient client;

    public static void main(String[] args) {
        args = constants.discordToken;
        if (args.length < 1)
            throw new IllegalArgumentException("This bot needs at least 1 argument!");

        INSTANCE = login(args[0]);

    }
    public BaseBot(IDiscordClient client) {
        this.client = client;
    }

    public static BaseBot login(String token) {
        BaseBot bot = null;

        ClientBuilder builder = new ClientBuilder();
        builder.withToken(token);
        try {
            IDiscordClient client = builder.login();
            bot = new BaseBot(client);
        } catch (DiscordException e) {
            System.err.println("Error occurred while logging in!");
            e.printStackTrace();
            builder.withToken(token);
        }

        return bot;

    }

}


