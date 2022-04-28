package denis.paim.easymed;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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

    public static Consulta buscarConsultaByNome(Context context, String usuarioNome){

        Banco conn = new Banco(context);
        SQLiteDatabase db = conn.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM consultas WHERE usuario_nome =  " + usuarioNome, null);

        if( cursor.getCount() > 0 ){
            cursor.moveToFirst();

            Consulta consulta = new Consulta();
            consulta.setId(  cursor.getInt( 0 ) );
            consulta.setUsuarioNome( cursor.getString( 1 ));
            consulta.setMedicoNome( cursor.getString( 2 ));
            consulta.setEspecialidade( cursor.getString( 3 ));
            consulta.setData( cursor.getString( 4 ));
            consulta.setSala( cursor.getString( 5 ));

            return consulta;

        }else {
            return null;
        }
    }

}
