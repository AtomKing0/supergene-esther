package com.ironsource;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.p6;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class p6 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final du f14306a;

    public static final class a implements du {
        a() {
        }

        @Override // com.ironsource.du
        public void a(@NotNull View view, @NotNull FrameLayout.LayoutParams layoutParams) {
            kotlin.jvm.internal.t.i(view, "view");
            kotlin.jvm.internal.t.i(layoutParams, "layoutParams");
            final View childAt = p6.this.getChildAt(0);
            p6.this.addView(view, layoutParams);
            final p6 p6Var = p6.this;
            p6Var.postDelayed(new Runnable() { // from class: com.ironsource.kz
                @Override // java.lang.Runnable
                public final void run() {
                    p6.a.a(childAt, p6Var);
                }
            }, 1000L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(View view, p6 this$0) {
            kotlin.jvm.internal.t.i(this$0, "this$0");
            if (view != null) {
                this$0.removeView(view);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p6(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.t.i(context, "context");
        this.f14306a = new a();
    }

    @NotNull
    public final du getViewBinder() {
        return this.f14306a;
    }
}
