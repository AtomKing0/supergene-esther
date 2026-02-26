package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class q {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21451a;

        static {
            int[] iArr = new int[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.k.values().length];
            try {
                iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.k.Image.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.k.JS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f21451a = iArr;
        }
    }

    public static final void a(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.i iVar, @NotNull a0 vastResource, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.g htmlCssFixer) {
        String strA;
        t.i(iVar, "<this>");
        t.i(vastResource, "vastResource");
        t.i(htmlCssFixer, "htmlCssFixer");
        if (vastResource instanceof a0.c) {
            a0.c cVar = (a0.c) vastResource;
            int i10 = a.f21451a[cVar.a().a().ordinal()];
            if (i10 == 1) {
                strA = "<html><head></head><body style=\"margin:0;padding:0\"><img src=\"" + cVar.a().b() + "\" width=\"100%\" style=\"max-width:100%;max-height:100%;\" /></body></html>";
            } else {
                if (i10 != 2) {
                    throw new v8.q();
                }
                strA = "<script src=\"" + cVar.a().b() + "\"></script>";
            }
        } else if (vastResource instanceof a0.a) {
            strA = ((a0.a) vastResource).a().a();
        } else {
            if (!(vastResource instanceof a0.b)) {
                throw new v8.q();
            }
            strA = "<iframe frameborder=\"0\" scrolling=\"no\" marginheight=\"0\" marginwidth=\"0\" style=\"border: 0px; margin: 0px;\" width=100% height=100% src=\"" + ((a0.b) vastResource).a().a() + "\"></iframe>";
        }
        try {
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.k.a(iVar, htmlCssFixer.a(strA));
        } catch (Exception e10) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, "BaseWebView", e10.toString(), e10, false, 8, null);
        }
    }

    public static /* synthetic */ void b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.i iVar, a0 a0Var, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.g gVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            gVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.g();
        }
        a(iVar, a0Var, gVar);
    }
}
