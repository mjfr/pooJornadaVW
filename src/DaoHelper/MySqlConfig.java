package DaoHelper;

// Testando a implementação do "D" do "SOLID"
public class MySqlConfig implements DbConfig{
    private static final String DBNAME = "producaoconsumo";
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    @Override
    public String getDbName() {
        return DBNAME;
    }

    @Override
    public String getUrl() {
        return URL;
    }

    @Override
    public String getUser() {
        return USER;
    }

    @Override
    public String getPassword() {
        return PASSWORD;
    }
}
