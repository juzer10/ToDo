package todo.list;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Juzer on 3/5/14.
 */
public class DrawerItemClickListener extends Activity implements ListView.OnItemClickListener {
    Context context;
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        selectItem(position);
    }

    private void selectItem(int position) {
        ToDoList tdl = new ToDoList();
        tdl.dra(position);
    }
}
