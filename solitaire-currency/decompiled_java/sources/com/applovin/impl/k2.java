package com.applovin.impl;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k2 extends BaseAdapter implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f5532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f5533b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map f5534c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f5535d;

    public interface a {
        void a(d2 d2Var, j2 j2Var);
    }

    protected k2(Context context) {
        this.f5532a = context.getApplicationContext();
    }

    protected j2 a() {
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return false;
    }

    protected abstract int b();

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public j2 getItem(int i10) {
        return (j2) this.f5533b.get(i10);
    }

    protected abstract List c(int i10);

    public void c() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.fa
            @Override // java.lang.Runnable
            public final void run() {
                this.f5213a.notifyDataSetChanged();
            }
        });
    }

    protected abstract int d(int i10);

    protected abstract j2 e(int i10);

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f5533b.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i10) {
        return getItem(i10).m();
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        i2 i2Var;
        j2 item = getItem(i10);
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(item.j(), viewGroup, false);
            i2Var = new i2();
            i2Var.f5367a = (TextView) view.findViewById(R.id.text1);
            i2Var.f5368b = (TextView) view.findViewById(R.id.text2);
            i2Var.f5369c = (ImageView) view.findViewById(com.applovin.sdk.R.id.imageView);
            i2Var.f5370d = (ImageView) view.findViewById(com.applovin.sdk.R.id.detailImageView);
            view.setTag(i2Var);
            view.setOnClickListener(this);
            view.setBackground(a(view));
        } else {
            i2Var = (i2) view.getTag();
        }
        i2Var.a(i10);
        i2Var.a(item);
        view.setEnabled(item.o());
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return j2.n();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i10) {
        return getItem(i10).o();
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        int i10;
        this.f5533b = new ArrayList();
        int iB = b();
        this.f5534c = new HashMap(iB);
        j2 j2VarA = a();
        if (j2VarA != null) {
            this.f5533b.add(j2VarA);
            i10 = 1;
        } else {
            i10 = 0;
        }
        for (int i11 = 0; i11 < iB; i11++) {
            int iD = d(i11);
            if (iD != 0) {
                this.f5533b.add(e(i11));
                this.f5533b.addAll(c(i11));
                this.f5534c.put(Integer.valueOf(i11), Integer.valueOf(i10));
                i10 += iD + 1;
            }
        }
        this.f5533b.add(new j4(""));
        super.notifyDataSetChanged();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i2 i2Var = (i2) view.getTag();
        j2 j2VarB = i2Var.b();
        d2 d2VarA = a(i2Var.a());
        a aVar = this.f5535d;
        if (aVar == null || d2VarA == null) {
            return;
        }
        aVar.a(d2VarA, j2VarB);
    }

    public void a(a aVar) {
        this.f5535d = aVar;
    }

    private d2 a(int i10) {
        for (int i11 = 0; i11 < b(); i11++) {
            Integer num = (Integer) this.f5534c.get(Integer.valueOf(i11));
            if (num != null) {
                if (i10 <= num.intValue() + d(i11)) {
                    return new d2(i11, i10 - (num.intValue() + 1));
                }
            }
        }
        return null;
    }

    private Drawable a(View view) {
        Drawable background = view.getBackground();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i0.a(com.applovin.sdk.R.color.applovin_sdk_highlightListItemColor, this.f5532a));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, gradientDrawable);
        stateListDrawable.addState(new int[0], background);
        return stateListDrawable;
    }
}
