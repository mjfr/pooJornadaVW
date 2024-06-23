package DaoHelper;

// Testando a implementação do "D" do "SOLID"
public interface DbConfig {
    String getUrl();
    String getUser();
    String getPassword();
    String getDbName();
}
