package com.unity3d.player;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;

/* JADX INFO: loaded from: classes4.dex */
final class P extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Button f23979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected EditText f23980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Context f23981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected Rect f23982d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected Rect f23983e;

    public P(Context context, EditText editText) {
        super(context);
        this.f23980b = editText;
        this.f23981c = context;
        this.f23982d = new Rect(16, 16, 16, 16);
        this.f23983e = new Rect(0, 0, 0, 0);
        createUI();
        setBackgroundColor(-1);
    }

    protected void createUI() {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        Button button = new Button(this.f23981c);
        this.f23979a = button;
        button.setId(View.generateViewId());
        this.f23979a.setText(this.f23981c.getResources().getIdentifier("ok", TypedValues.Custom.S_STRING, "android"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(11);
        this.f23979a.setLayoutParams(layoutParams);
        this.f23979a.setBackgroundColor(0);
        addView(this.f23979a);
        this.f23980b.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(15);
        layoutParams2.addRule(0, this.f23979a.getId());
        this.f23980b.setLayoutParams(layoutParams2);
        addView(this.f23980b);
        Rect rect = this.f23982d;
        setPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.f23979a.setOnClickListener(onClickListener);
    }
}
