package net.kmfish.sample.listitem;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import net.kmfish.multitypelistviewadapter.BaseListItem;
import net.kmfish.sample.R;
import net.kmfish.sample.model.TextModel;

/**
 * Created by kmfish on 2015/9/9.
 */
public class LineListItem1 extends BaseListItem<TextModel, LineListItem1.OnItem1ClickListener> {

    TextView tvName;
    TextView tvDesc;


    @Override
    public int onGetLayoutRes() {
        return R.layout.list_item1;
    }

    @Override
    public void bindViews(View convertView) {
        Log.d("item1", "bindViews:" + convertView);
        tvName = (TextView) convertView.findViewById(R.id.text_name);
        tvDesc = (TextView) convertView.findViewById(R.id.text_desc);

        tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != attachInfo) {
                    attachInfo.onNameClick(getData());
                }
            }
        });
        tvDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != attachInfo) {
                    attachInfo.onDescClick(getData());
                }
            }
        });

    }

    @Override
    public void updateView(TextModel model, int pos) {
        if (null != model) {
            Log.d("item1", "updateView model:" + model + "pos:" + pos);
            tvName.setText(model.getName());
            tvDesc.setText(model.getDesc());
        }
    }

    public interface OnItem1ClickListener {
        void onNameClick(TextModel model);
        void onDescClick(TextModel model);
    }
}
