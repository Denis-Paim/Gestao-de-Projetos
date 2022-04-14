package denis.paim.easymed;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UsuarioDAO {

    public static void inserir(Context context, Usuario usuario) {
        ContentValues values = new ContentValues();
        values.put("usuario_nome", usuario.getNome());
        values.put("usuarioCpf", usuario.getCpf());
        values.put("telefone", usuario.getTelefone());
        values.put("endereco", usuario.getEndereco());
        values.put("dataNascimento", usuario.getDataNascimento());
        values.put("email", usuario.getEmail());
        values.put("usuario_senha", usuario.getSenha());

        Banco conn = new Banco(context);
        SQLiteDatabase db = conn.getWritableDatabase();

        db.insert("usuarios", null, values);
    }

    public boolean autenticarUsuario(Context context, Usuario usuario){
        Banco conn = new Banco(context);
        SQLiteDatabase db = conn.getReadableDatabase();

        String sql_busca_usuarios = "SELECT * from usuarios WHERE usuario_nome = " + "'" + usuario.getNome() + "'";
        Cursor c = db.rawQuery(sql_busca_usuarios, null);
        while(c.moveToNext()){
            if (usuario.getNome().equals(c.getString(c.getColumnIndex("usuario_nome")))){
                if (usuario.getSenha().equals(c.getString(c.getColumnIndex("usuario_senha")))){
                    return true;
                }
            }
        }

        return false;
    }
}

