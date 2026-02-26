package com.ironsource;

import android.content.Context;
import com.ironsource.mediationsdk.model.InterstitialPlacement;
import com.ironsource.mediationsdk.model.Placement;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface ui extends al, tg {
    void a(Context context, boolean z10);

    void a(Map<String, String> map);

    void a(boolean z10);

    String b(Context context);

    void b();

    void c();

    void d();

    boolean e(String str);

    InterstitialPlacement g(String str);

    void h(String str);

    Placement i(String str);
}
