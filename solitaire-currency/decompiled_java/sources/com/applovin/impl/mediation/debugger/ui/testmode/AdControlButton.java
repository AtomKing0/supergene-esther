package com.applovin.impl.mediation.debugger.ui.testmode;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.applovin.impl.i0;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.R;

/* JADX INFO: loaded from: classes2.dex */
public class AdControlButton extends RelativeLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final GradientDrawable f6141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Button f6142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.applovin.impl.a f6143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f6144d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private MaxAdFormat f6145e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f6146f;

    public interface a {
        void onClick(AdControlButton adControlButton);
    }

    public enum b {
        LOAD,
        LOADING,
        SHOW
    }

    public AdControlButton(Context context) {
        this(context, null, 0);
    }

    private int a(b bVar) {
        return b.LOAD == bVar ? i0.a(R.color.applovin_sdk_brand_color, getContext()) : b.LOADING == bVar ? i0.a(R.color.applovin_sdk_brand_color, getContext()) : i0.a(R.color.applovin_sdk_adControlbutton_brightBlueColor, getContext());
    }

    private String b(b bVar) {
        return b.LOAD == bVar ? "Load" : b.LOADING == bVar ? "" : "Show";
    }

    private void c(b bVar) {
        if (b.LOADING == bVar) {
            setEnabled(false);
            this.f6143c.a();
        } else {
            setEnabled(true);
            this.f6143c.b();
        }
        this.f6142b.setText(b(bVar));
        this.f6141a.setColor(a(bVar));
    }

    public b getControlState() {
        return this.f6144d;
    }

    public MaxAdFormat getFormat() {
        return this.f6145e;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar = this.f6146f;
        if (aVar != null) {
            aVar.onClick(this);
        }
    }

    public void setControlState(b bVar) {
        if (this.f6144d != bVar) {
            c(bVar);
        }
        this.f6144d = bVar;
    }

    public void setFormat(MaxAdFormat maxAdFormat) {
        this.f6145e = maxAdFormat;
    }

    public void setOnClickListener(a aVar) {
        this.f6146f = aVar;
    }

    public AdControlButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdControlButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.f6141a = gradientDrawable;
        Button button = new Button(getContext());
        this.f6142b = button;
        com.applovin.impl.a aVar = new com.applovin.impl.a(getContext(), 20, android.R.attr.progressBarStyleSmall);
        this.f6143c = aVar;
        b bVar = b.LOAD;
        this.f6144d = bVar;
        setBackgroundColor(0);
        FrameLayout frameLayout = new FrameLayout(context);
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1, 17));
        button.setOnClickListener(this);
        frameLayout.addView(button, new FrameLayout.LayoutParams(-1, -1, 17));
        gradientDrawable.setCornerRadius(20.0f);
        button.setBackground(gradientDrawable);
        a();
        aVar.setColor(-1);
        addView(aVar, new FrameLayout.LayoutParams(-1, -1, 17));
        c(bVar);
    }

    private void a() {
        this.f6142b.setTextColor(new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed}, new int[0]}, new int[]{i0.a(R.color.applovin_sdk_highlightTextColor, getContext()), -1}));
    }
}
