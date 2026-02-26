package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.moloco.sdk.internal.services.b0;
import com.moloco.sdk.internal.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.x;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class s extends View {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.t.i(context, "context");
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        setBackgroundColor(0);
    }

    @Nullable
    public final Object a(@NotNull MotionEvent motionEvent, @NotNull b0 b0Var, @Nullable String str, @Nullable String str2, @NotNull i iVar, @Nullable x<k0> xVar, @NotNull u uVar, @NotNull z8.d<? super k0> dVar) {
        Object objA;
        if (motionEvent.getAction() == 0) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.model.a aVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.model.a(kotlin.collections.p.M(iArr), kotlin.collections.p.e0(iArr), getHeight(), getWidth(), (int) (motionEvent.getX() + kotlin.collections.p.M(iArr)), (int) (motionEvent.getY() + kotlin.collections.p.e0(iArr)));
            if (str != null) {
                kotlin.coroutines.jvm.internal.b.a(u.a.a(uVar, str, System.currentTimeMillis(), null, 4, null));
            }
            if (str2 != null && (objA = b0Var.a(str2, aVar, iVar, xVar, dVar)) == a9.d.e()) {
                return objA;
            }
        }
        return k0.f35197a;
    }
}
