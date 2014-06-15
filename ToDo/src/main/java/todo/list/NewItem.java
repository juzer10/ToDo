package todo.list;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Juzer on 15-Jun-14.
 */
public class NewItem extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //Custom ActionBar View
        getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getActionBar().setCustomView(R.layout.actionbar);

        setContentView(R.layout.todo_item);

        getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#4099FF")));

        EditText titleBox = (EditText) findViewById(R.id.title_box);
        EditText noteBox = (EditText) findViewById(R.id.note_box);
        Button reminderButton = (Button) findViewById(R.id.reminder);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.new_item, menu);
        return true;
    }
}
