package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui;

import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.t0;
import kotlin.collections.w;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class j implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final Map<a.AbstractC0481a.c.EnumC0483a, a.AbstractC0481a.c> f19870a = new LinkedHashMap();

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h
    public void g(@NotNull a.AbstractC0481a.c button) {
        kotlin.jvm.internal.t.i(button, "button");
        this.f19870a.put(button.c(), button);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h
    public void j(@NotNull a.AbstractC0481a.c.EnumC0483a buttonType) {
        kotlin.jvm.internal.t.i(buttonType, "buttonType");
        this.f19870a.remove(buttonType);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.i
    @NotNull
    public List<a.AbstractC0481a.c> p() {
        List listA = t0.A(this.f19870a);
        ArrayList arrayList = new ArrayList(w.v(listA, 10));
        Iterator it = listA.iterator();
        while (it.hasNext()) {
            arrayList.add((a.AbstractC0481a.c) ((v8.s) it.next()).d());
        }
        return arrayList;
    }
}
