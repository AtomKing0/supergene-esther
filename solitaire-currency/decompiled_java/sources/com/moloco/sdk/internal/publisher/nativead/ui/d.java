package com.moloco.sdk.internal.publisher.nativead.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.moloco.sdk.service_locator.a;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import h9.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"ViewConstructor"})
public final class d extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f18247a = new b(null);

    public static final class a extends v implements l<a.AbstractC0481a.c, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ i f18248g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(i iVar) {
            super(1);
            this.f18248g = iVar;
        }

        public final void a(@NotNull a.AbstractC0481a.c button) {
            t.i(button, "button");
            this.f18248g.g(button);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(a.AbstractC0481a.c cVar) {
            a(cVar);
            return k0.f35197a;
        }
    }

    public static final class b {
        public /* synthetic */ b(k kVar) {
            this();
        }

        public b() {
        }
    }

    public /* synthetic */ d(Context context, Uri uri, r rVar, h9.a aVar, z zVar, i iVar, int i10, k kVar) {
        this(context, uri, rVar, aVar, (i10 & 16) != 0 ? a.h.f18920a.d() : zVar, (i10 & 32) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.k.a() : iVar);
    }

    public static final void a(h9.a aVar, View view) {
        if (aVar != null) {
            aVar.invoke();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull Context context, @NotNull Uri imageUri, @NotNull r watermark, @Nullable final h9.a<k0> aVar, @NotNull z externalLinkHandler, @NotNull i buttonTracker) {
        super(context);
        t.i(context, "context");
        t.i(imageUri, "imageUri");
        t.i(watermark, "watermark");
        t.i(externalLinkHandler, "externalLinkHandler");
        t.i(buttonTracker, "buttonTracker");
        ImageView imageView = new ImageView(context);
        imageView.setImageURI(imageUri);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.moloco.sdk.internal.publisher.nativead.ui.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.a(aVar, view);
            }
        });
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.d dVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.d(externalLinkHandler, context, null, 0, 12, null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(20);
        dVar.setPadding(16, 0, 0, 16);
        dVar.setOnButtonRenderedListener(new a(buttonTracker));
        dVar.setLayoutParams(layoutParams);
        watermark.a(imageView);
        addView(imageView);
        addView(dVar);
    }
}
