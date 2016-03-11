package jim.h.common.android.lib.zxing.sample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapter extends BaseAdapter {
    private ArrayList<ListItem> listData;
    private LayoutInflater layoutInflater;

    public CustomListAdapter(Context context, ArrayList<ListItem> listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.name_list, null);
            holder = new ViewHolder();

           // holder.photo = (ImageView) convertView.findViewById(R.id.photo);
            holder.mt = (TextView) convertView.findViewById(R.id.mt);
            holder.st = (TextView) convertView.findViewById(R.id.st);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ListItem newsItem = listData.get(position);
        holder.mt.setText(newsItem.getmt());
        holder.st.setText(newsItem.getst());

      /*  if (holder.photo != null) {
            new ImageDownloaderTask(holder.photo).execute(newsItem.getUrl());
        }*/

        return convertView;
    }

    static class ViewHolder {
       // ImageView photo;
    	TextView mt;
        TextView st;
    }
}
