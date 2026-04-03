package com.ironsource;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.sdk.utils.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class cg extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f11573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private a f11574b;

    public interface a {
        void a(@NotNull fu fuVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cg(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.t.i(context, "context");
        this.f11573a = "ISNNativeAdContainer";
    }

    private final fu a() {
        return new fu(getVisibility() == 0, getWindowVisibility() == 0, isShown());
    }

    @Nullable
    public final a getListener$mediationsdk_release() {
        return this.f11574b;
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NotNull View changedView, int i10) {
        kotlin.jvm.internal.t.i(changedView, "changedView");
        Logger.i(this.f11573a, "onVisibilityChanged: " + i10);
        a aVar = this.f11574b;
        if (aVar != null) {
            aVar.a(a());
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        Logger.i(this.f11573a, "onWindowVisibilityChanged: " + i10);
        a aVar = this.f11574b;
        if (aVar != null) {
            aVar.a(a());
        }
    }

    public final void setListener$mediationsdk_release(@Nullable a aVar) {
        this.f11574b = aVar;
    }
}
