package com.ironsource;

import android.content.Context;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.pq;
import java.util.Arrays;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class pq implements wm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final pq f14391a = new pq();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final sq f14392b = new sq();

    public static final class a implements hq {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ hq f14393a;

        a(hq hqVar) {
            this.f14393a = hqVar;
        }

        @Override // com.ironsource.hq
        public void a(@NotNull final bq sdkConfig) {
            kotlin.jvm.internal.t.i(sdkConfig, "sdkConfig");
            sq sqVar = pq.f14392b;
            final hq hqVar = this.f14393a;
            sqVar.a(new Runnable() { // from class: com.ironsource.a00
                @Override // java.lang.Runnable
                public final void run() {
                    pq.a.a(sdkConfig, hqVar);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(bq sdkConfig, hq listener) {
            kotlin.jvm.internal.t.i(sdkConfig, "$sdkConfig");
            kotlin.jvm.internal.t.i(listener, "$listener");
            pq.f14391a.a(sdkConfig, listener);
        }

        @Override // com.ironsource.hq
        public void a(@NotNull final dq error) {
            kotlin.jvm.internal.t.i(error, "error");
            sq sqVar = pq.f14392b;
            final hq hqVar = this.f14393a;
            sqVar.d(new Runnable() { // from class: com.ironsource.b00
                @Override // java.lang.Runnable
                public final void run() {
                    pq.a.a(hqVar, error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(hq listener, dq error) {
            kotlin.jvm.internal.t.i(listener, "$listener");
            kotlin.jvm.internal.t.i(error, "$error");
            listener.a(error);
        }
    }

    private pq() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Context context, iq initRequest, hq listener) {
        kotlin.jvm.internal.t.i(context, "$context");
        kotlin.jvm.internal.t.i(initRequest, "$initRequest");
        kotlin.jvm.internal.t.i(listener, "$listener");
        com.ironsource.mediationsdk.p pVarM = com.ironsource.mediationsdk.p.m();
        String strD = initRequest.d();
        IronSource.AD_UNIT[] ad_unitArr = (IronSource.AD_UNIT[]) initRequest.e().toArray(new IronSource.AD_UNIT[0]);
        List<IronSource.AD_UNIT> validAdUnitsList = pVarM.a(context, strD, false, (IronSource.AD_UNIT[]) Arrays.copyOf(ad_unitArr, ad_unitArr.length));
        kotlin.jvm.internal.t.h(validAdUnitsList, "validAdUnitsList");
        initRequest.a(validAdUnitsList);
        f14391a.a(context, initRequest, listener, true);
    }

    public final void c(@NotNull final Context context, @NotNull final iq initRequest, @NotNull final hq listener) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(initRequest, "initRequest");
        kotlin.jvm.internal.t.i(listener, "listener");
        f14392b.c(new Runnable() { // from class: com.ironsource.vz
            @Override // java.lang.Runnable
            public final void run() {
                pq.d(context, initRequest, listener);
            }
        });
    }

    @Override // com.ironsource.wm
    public void onInitFailed(@NotNull final IronSourceError error) {
        kotlin.jvm.internal.t.i(error, "error");
        f14392b.a(new Runnable() { // from class: com.ironsource.yz
            @Override // java.lang.Runnable
            public final void run() {
                pq.a(error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Context context, iq initRequest, hq listener) {
        kotlin.jvm.internal.t.i(context, "$context");
        kotlin.jvm.internal.t.i(initRequest, "$initRequest");
        kotlin.jvm.internal.t.i(listener, "$listener");
        f14391a.a(context, initRequest, listener, false);
    }

    public final void a(@NotNull final Context context, @NotNull final iq initRequest, @NotNull final hq listener) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(initRequest, "initRequest");
        kotlin.jvm.internal.t.i(listener, "listener");
        f14392b.c(new Runnable() { // from class: com.ironsource.wz
            @Override // java.lang.Runnable
            public final void run() {
                pq.b(context, initRequest, listener);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void a(android.content.Context r10, com.ironsource.iq r11, final com.ironsource.hq r12, boolean r13) {
        /*
            r9 = this;
            java.lang.String r0 = r11.f()
            r1 = 0
            if (r0 == 0) goto L14
            int r0 = r0.length()
            r2 = 1
            if (r0 <= 0) goto L10
            r0 = r2
            goto L11
        L10:
            r0 = r1
        L11:
            if (r0 != r2) goto L14
            goto L15
        L14:
            r2 = r1
        L15:
            if (r2 == 0) goto L23
            com.ironsource.mediationsdk.p r0 = com.ironsource.mediationsdk.p.m()
            java.lang.String r2 = r11.f()
            r0.t(r2)
            goto L3d
        L23:
            com.ironsource.iq r0 = new com.ironsource.iq
            java.lang.String r2 = r11.d()
            com.ironsource.mediationsdk.p r3 = com.ironsource.mediationsdk.p.m()
            java.lang.String r3 = r3.o()
            java.util.List r11 = r11.e()
            java.util.List r11 = kotlin.collections.t.R0(r11)
            r0.<init>(r2, r3, r11)
            r11 = r0
        L3d:
            com.ironsource.mediationsdk.p r2 = com.ironsource.mediationsdk.p.m()
            java.lang.String r4 = r11.d()
            java.util.List r0 = r11.e()
            com.ironsource.mediationsdk.IronSource$AD_UNIT[] r1 = new com.ironsource.mediationsdk.IronSource.AD_UNIT[r1]
            java.lang.Object[] r0 = r0.toArray(r1)
            com.ironsource.mediationsdk.IronSource$AD_UNIT[] r0 = (com.ironsource.mediationsdk.IronSource.AD_UNIT[]) r0
            int r1 = r0.length
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r1)
            r8 = r0
            com.ironsource.mediationsdk.IronSource$AD_UNIT[] r8 = (com.ironsource.mediationsdk.IronSource.AD_UNIT[]) r8
            r6 = 0
            r3 = r10
            r5 = r13
            r7 = r9
            com.ironsource.mediationsdk.logger.IronSourceError r13 = r2.a(r3, r4, r5, r6, r7, r8)
            if (r13 == 0) goto La5
            int r0 = r13.getErrorCode()
            r1 = 2020(0x7e4, float:2.83E-42)
            if (r0 != r1) goto L6c
            goto La5
        L6c:
            int r10 = r13.getErrorCode()
            r11 = 2040(0x7f8, float:2.859E-42)
            if (r10 != r11) goto L8c
            com.ironsource.mediationsdk.p r10 = com.ironsource.mediationsdk.p.m()
            com.ironsource.cr r10 = r10.h()
            if (r10 == 0) goto L9a
            com.ironsource.bq r11 = new com.ironsource.bq
            com.ironsource.jq r13 = new com.ironsource.jq
            r13.<init>(r10)
            r11.<init>(r13)
            r9.a(r11, r12)
            return
        L8c:
            int r10 = r13.getErrorCode()
            r11 = 2030(0x7ee, float:2.845E-42)
            if (r10 != r11) goto L9a
            com.ironsource.oq r10 = com.ironsource.oq.f14255a
            r10.e()
            return
        L9a:
            com.ironsource.sq r10 = com.ironsource.pq.f14392b
            com.ironsource.zz r11 = new com.ironsource.zz
            r11.<init>()
            r10.d(r11)
            return
        La5:
            com.ironsource.oq r13 = com.ironsource.oq.f14255a
            com.ironsource.pq$a r0 = new com.ironsource.pq$a
            r0.<init>(r12)
            r13.a(r10, r11, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.pq.a(android.content.Context, com.ironsource.iq, com.ironsource.hq, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(cr serverResponse) {
        kotlin.jvm.internal.t.i(serverResponse, "$serverResponse");
        oq.f14255a.a(new jq(serverResponse));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final bq bqVar, final hq hqVar) {
        if (com.ironsource.mediationsdk.p.m().a(false, bqVar.d())) {
            f14392b.d(new Runnable() { // from class: com.ironsource.uz
                @Override // java.lang.Runnable
                public final void run() {
                    pq.a(hqVar, bqVar);
                }
            });
        } else {
            f14392b.d(new Runnable() { // from class: com.ironsource.tz
                @Override // java.lang.Runnable
                public final void run() {
                    pq.a(hqVar);
                }
            });
        }
    }

    @Override // com.ironsource.wm
    public void a(@NotNull final cr serverResponse) {
        kotlin.jvm.internal.t.i(serverResponse, "serverResponse");
        f14392b.a(new Runnable() { // from class: com.ironsource.xz
            @Override // java.lang.Runnable
            public final void run() {
                pq.b(serverResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(hq listener) {
        kotlin.jvm.internal.t.i(listener, "$listener");
        listener.a(new dq(IronSourceError.ERROR_LEGACY_INIT_POST_FAILED, "An unknown error has occurred"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(hq listener, bq sdkInitResponse) {
        kotlin.jvm.internal.t.i(listener, "$listener");
        kotlin.jvm.internal.t.i(sdkInitResponse, "$sdkInitResponse");
        listener.a(sdkInitResponse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(hq listener, IronSourceError error) {
        kotlin.jvm.internal.t.i(listener, "$listener");
        kotlin.jvm.internal.t.h(error, "error");
        listener.a(new dq(error));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(IronSourceError error) {
        kotlin.jvm.internal.t.i(error, "$error");
        oq.f14255a.b(new dq(error));
    }
}
