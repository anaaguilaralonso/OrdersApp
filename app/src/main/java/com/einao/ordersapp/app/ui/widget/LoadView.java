package com.einao.ordersapp.app.ui.widget;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.einao.ordersapp.R;
import com.einao.ordersapp.app.ui.viewmodel.LoadViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoadView extends RelativeLayout {

    @BindView(R.id.title)
    TextView title;

    public LoadView(Context context) {
        super(context);
        setup();
    }

    public LoadView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public LoadView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public LoadView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setup();
    }

    private void setup() {
        LayoutInflater.from(getContext()).inflate(R.layout.load_view, this);
        ButterKnife.bind(this);
    }

    public void setLoadViewModel(LoadViewModel loadViewModel){
        title.setText(loadViewModel.getName());
    }
}
