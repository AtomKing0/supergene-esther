package com.applovin.impl;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: loaded from: classes2.dex */
public class p extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ViewGroup f6495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AppLovinSdkUtils.Size f6496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Activity f6497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private RelativeLayout f6498d;

    public p(ViewGroup viewGroup, AppLovinSdkUtils.Size size, Activity activity) {
        super(activity, R.style.Theme.Translucent.NoTitleBar);
        this.f6495a = viewGroup;
        this.f6496b = size;
        this.f6497c = activity;
        requestWindowFeature(1);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.f6498d.removeView(this.f6495a);
        super.dismiss();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(AppLovinSdkUtils.dpToPx(this.f6497c, this.f6496b.getWidth()), AppLovinSdkUtils.dpToPx(this.f6497c, this.f6496b.getHeight()));
        layoutParams.addRule(13);
        this.f6495a.setLayoutParams(layoutParams);
        int iDpToPx = AppLovinSdkUtils.dpToPx(this.f6497c, 60);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iDpToPx, iDpToPx);
        layoutParams2.addRule(14);
        layoutParams2.addRule(12);
        ImageButton imageButton = new ImageButton(this.f6497c);
        imageButton.setLayoutParams(layoutParams2);
        imageButton.setImageDrawable(this.f6497c.getResources().getDrawable(com.applovin.sdk.R.drawable.applovin_ic_x_mark));
        imageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageButton.setColorFilter(-1);
        imageButton.setBackground(null);
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.zb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f7930a.a(view);
            }
        });
        RelativeLayout relativeLayout = new RelativeLayout(this.f6497c);
        this.f6498d = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f6498d.setBackgroundColor(Integer.MIN_VALUE);
        this.f6498d.addView(imageButton);
        this.f6498d.addView(this.f6495a);
        this.f6498d.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.ac
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4742a.b(view);
            }
        });
        setContentView(this.f6498d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        dismiss();
    }
}
