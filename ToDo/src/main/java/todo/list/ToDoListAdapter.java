package todo.list;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by Juzer on 3/11/14.
 */
public class ToDoListAdapter extends BaseAdapter{
    private final Context mContext;
    public ToDoListAdapter(Context ctx) {
        mContext = ctx;
    }

    public int getCount() {
        return 1;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
