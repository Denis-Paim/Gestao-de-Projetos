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

    public static Usuario buscaUsuario(Context context, String email) {

        Banco conn = new Banco(context);
        String sql_busca_pessoa = "SELECT * FROM usuarios WHERE email = " + "'" + email + "'";
        SQLiteDatabase db = conn.getReadableDatabase();

        Cursor c = db.rawQuery(sql_busca_pessoa, null);

        Usuario usuario = new Usuario();

        while(c.moveToNext()){

            usuario.setNome(c.getString(c.getColumnIndex("usuario_nome")));
            usuario.setCpf(c.getString(c.getColumnIndex("usuarioCpf")));
            usuario.setTelefone(c.getString(c.getColumnIndex("telefone")));
            usuario.setEndereco(c.getString(c.getColumnIndex("endereco")));
            usuario.setDataNascimento(c.getString(c.getColumnIndex("dataNascimento")));
            usuario.setEmail(c.getString(c.getColumnIndex("email")));

        }
//        db.close();
//        c.close();

        return usuario;

    }

    public boolean autenticarUsuario(Context context, Usuario usuario){
        Banco conn = new Banco(context);
        SQLiteDatabase db = conn.getReadableDatabase();

        String sql_busca_usuarios = "SELECT * from usuarios WHERE email = " + "'" + usuario.getEmail() + "'";
        Cursor c = db.rawQuery(sql_busca_usuarios, null);
        while(c.moveToNext()){
            if (usuario.getEmail().equals(c.getString(c.getColumnIndex("email")))){
                if (usuario.getSenha().equals(c.getString(c.getColumnIndex("usuario_senha")))){
                    return true;
                }
            }
        }

        return false;
    }
}

