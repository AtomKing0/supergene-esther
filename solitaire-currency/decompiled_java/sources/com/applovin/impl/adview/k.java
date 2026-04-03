package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.applovin.impl.x1;

/* JADX INFO: loaded from: classes2.dex */
public class k extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final x1 f4850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f4851b;

    interface a {
        void a();

        void onFailure();
    }

    public k(x1 x1Var, Context context) {
        super(context);
        this.f4850a = x1Var;
        setClickable(false);
        setFocusable(false);
    }

    public boolean a() {
        return this.f4851b;
    }

    public void b() {
        a(null);
    }

    public String getIdentifier() {
        return this.f4850a.b();
    }

    public void a(a aVar) {
        if (this.f4851b) {
            if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        Drawable drawableA = this.f4850a.a();
        if (drawableA == null) {
            if (aVar != null) {
                aVar.onFailure();
            }
        } else {
            setBackground(drawableA);
            this.f4851b = true;
            if (aVar != null) {
                aVar.a();
            }
        }
    }
}
