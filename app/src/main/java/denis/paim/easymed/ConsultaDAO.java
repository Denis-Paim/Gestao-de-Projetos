package denis.paim.easymed;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO {

    public static void marcarConsulta(Context context, Consulta consulta) {
        ContentValues values = new ContentValues();
        values.put("usuario_nome", consulta.getUsuarioNome());
        values.put("medico_nome", consulta.getMedicoNome());
        values.put("especialidade", consulta.getEspecialidade());
        values.put("data", consulta.getData());
        values.put("horario", consulta.getHorario());
        values.put("sala", consulta.getSala());

        Banco conn = new Banco(context);
        SQLiteDatabase db = conn.getWritableDatabase();

        db.insert("consultas", null, values);

    }

    public static void editar(Context context, Consulta consulta){
        ContentValues values = new ContentValues();
        values.put("usuario_nome", consulta.getUsuarioNome());
        values.put("medico_nome", consulta.getMedicoNome());
        values.put("especialidade", consulta.getEspecialidade());
        values.put("data", consulta.getData());
        values.put("horario", consulta.getHorario());
        values.put("sala", consulta.getSala());

        Banco conn = new Banco(context);
        SQLiteDatabase db = conn.getWritableDatabase();

        db.update("consultas", values, " usuario_nome = " + consulta.getUsuarioNome(), null);

    }



    public static List<Consulta> retornarTodos(Context context){

        Banco conn = new Banco(context);
        String sql_busca_todos = "SELECT * FROM consultas";
        SQLiteDatabase db = conn.getReadableDatabase();

        List<Consulta> consultaList = new ArrayList<>();

        Cursor c = db.rawQuery(sql_busca_todos, null);
        while(c.moveToNext()){
            Consulta consulta = new Consulta();
            consulta.setId(c.getInt(c.getColumnIndex("id")));
            consulta.setUsuarioNome(c.getString(c.getColumnIndex("usuario_nome")));
            consulta.setMedicoNome(c.getString(c.getColumnIndex("medico_nome")));
            consulta.setEspecialidade(c.getString(c.getColumnIndex("especialidade")));
            consulta.setData(c.getString(c.getColumnIndex("data")));
            consulta.setHorario(c.getString(c.getColumnIndex("horario")));
            consulta.setSala(c.getString(c.getColumnIndex("sala")));
            consultaList.add(consulta);

        }
        c.close();
        return consultaList;
    }


    public static Consulta buscaPessoa(Context context, String nome) {

        Banco conn = new Banco(context);
        String sql_busca_pessoa = "SELECT * FROM consultas WHERE usuario_nome = " + "'" + nome + "'";
        SQLiteDatabase db = conn.getReadableDatabase();

        Cursor c = db.rawQuery(sql_busca_pessoa, null);

        Consulta consulta = new Consulta();

        while(c.moveToNext()){

                consulta.setUsuarioNome(c.getString(c.getColumnIndex("usuario_nome")));
                consulta.setMedicoNome(c.getString(c.getColumnIndex("medico_nome")));
                consulta.setEspecialidade(c.getString(c.getColumnIndex("especialidade")));
                consulta.setData(c.getString(c.getColumnIndex("data")));
                consulta.setHorario(c.getString(c.getColumnIndex("horario")));
                consulta.setSala(c.getString(c.getColumnIndex("sala")));

        }
//        db.close();
//        c.close();

        return consulta;

    }


    public static List<Consulta> buscaPessoaList(Context context, String nome) {

        Banco conn = new Banco(context);
        String sql_busca_pessoa = "SELECT * FROM consultas WHERE usuario_nome = " + "'" + nome + "'";
        SQLiteDatabase db = conn.getReadableDatabase();

        Cursor c = db.rawQuery(sql_busca_pessoa, null);

        List<Consulta> consultaList = new ArrayList<>();

        while(c.moveToNext()){

            Consulta consulta = new Consulta();
            consulta.setId(c.getInt(c.getColumnIndex("id")));
            consulta.setUsuarioNome(c.getString(c.getColumnIndex("usuario_nome")));
            consulta.setMedicoNome(c.getString(c.getColumnIndex("medico_nome")));
            consulta.setEspecialidade(c.getString(c.getColumnIndex("especialidade")));
            consulta.setData(c.getString(c.getColumnIndex("data")));
            consulta.setHorario(c.getString(c.getColumnIndex("horario")));
            consulta.setSala(c.getString(c.getColumnIndex("sala")));

            consultaList.add(consulta);

        }
        db.close();
        c.close();

        return consultaList;
    }


}
