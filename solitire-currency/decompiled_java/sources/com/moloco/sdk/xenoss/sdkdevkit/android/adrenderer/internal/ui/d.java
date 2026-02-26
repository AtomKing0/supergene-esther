package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.annotation.VisibleForTesting;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"ViewConstructor"})
public final class d extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final z f19798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f19799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final ImageButton f19800c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public h9.l<? super a.AbstractC0481a.c, k0> f19801d;

    public /* synthetic */ d(z zVar, Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.k kVar) {
        this(zVar, context, (i11 & 4) != 0 ? null : attributeSet, (i11 & 8) != 0 ? 0 : i10);
    }

    public static final void a(d this$0, View view) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.f19798a.a("https://cdn-f.adsmoloco.com/moloco-cdn/privacy.html");
    }

    public static final void b(d this$0, String url, View view) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(url, "$url");
        this$0.f19798a.a(url);
    }

    @VisibleForTesting
    @NotNull
    public final ImageButton getAdButton() {
        return this.f19800c;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10) {
            float f10 = getResources().getDisplayMetrics().density;
            this.f19800c.getLocationOnScreen(new int[2]);
            a.AbstractC0481a.c cVar = new a.AbstractC0481a.c(a.AbstractC0481a.c.EnumC0483a.AD_BADGE, new a.AbstractC0481a.f(r4[0] / f10, r4[1] / f10), new a.AbstractC0481a.g(this.f19800c.getWidth() / f10, this.f19800c.getHeight() / f10));
            h9.l<? super a.AbstractC0481a.c, k0> lVar = this.f19801d;
            if (lVar != null) {
                lVar.invoke(cVar);
            }
        }
    }

    public final void setOnButtonRenderedListener(@NotNull h9.l<? super a.AbstractC0481a.c, k0> listener) {
        kotlin.jvm.internal.t.i(listener, "listener");
        this.f19801d = listener;
    }

    public final void setPrivacyUrl(@NotNull final String url) {
        kotlin.jvm.internal.t.i(url, "url");
        this.f19800c.setOnClickListener(new View.OnClickListener() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.b(this.f19796a, url, view);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull z externalLinkHandler, @NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.t.i(externalLinkHandler, "externalLinkHandler");
        kotlin.jvm.internal.t.i(context, "context");
        this.f19798a = externalLinkHandler;
        this.f19799b = 12;
        ImageButton imageButton = new ImageButton(context);
        imageButton.setLayoutParams(new FrameLayout.LayoutParams(e.a(12, context), e.a(12, context)));
        imageButton.setImageResource(com.moloco.sdk.p.f18857e);
        imageButton.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageButton.setClipToOutline(true);
        imageButton.setBackground(null);
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.a(this.f19795a, view);
            }
        });
        this.f19800c = imageButton;
        addView(imageButton);
        imageButton.setContentDescription("Ad Badge");
        imageButton.setTag("Ad Badge");
    }
}
