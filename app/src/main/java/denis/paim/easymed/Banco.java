package denis.paim.easymed;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Banco extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "EasyMed";
    private static final int VERSAO = 1;

    public Banco(Context context) {
        super(context, NOME_BANCO, null ,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( "CREATE TABLE IF NOT EXISTS usuarios (  " +
                "  id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ,  " +
                "  usuario_nome TEXT NOT NULL , " +
                "  usuarioCpf TEXT, " +
                "  telefone TEXT, " +
                "  endereco TEXT, " +
                "  dataNascimento TEXT, " +
                "  email TEXT, " +
                "  usuario_senha TEXT NOT NULL) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
