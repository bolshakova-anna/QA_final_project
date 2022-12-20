package utils;

public class UserTestBot {
    private static String login;
    private static String password;
    private static String Name;

    public UserTestBot(String login, String password, String name){
        UserTestBot.login = login;
        UserTestBot.password = password;
        Name = name;
    }

    public static String getLogin() {
        return login;
    }

    public static String getPassword() {
        return password;
    }

}
