package com.ironsource;

import java.util.List;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class yq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final String f16341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final List<String> f16342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f16343c;

    public yq(@Nullable String str, @Nullable List<String> list, boolean z10) {
        this.f16341a = str;
        this.f16342b = list;
        this.f16343c = z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a() {
        /*
            r7 = this;
            boolean r0 = r7.f16343c
            r1 = 0
            r2 = 2
            r3 = 0
            r4 = 1
            if (r0 == 0) goto L38
            java.util.List<java.lang.String> r0 = r7.f16342b
            if (r0 == 0) goto L68
            boolean r5 = r0.isEmpty()
            if (r5 == 0) goto L13
            goto L34
        L13:
            java.util.Iterator r0 = r0.iterator()
        L17:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L34
            java.lang.Object r5 = r0.next()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r6 = r7.f16341a
            if (r6 == 0) goto L2f
            boolean r5 = p9.h.K(r6, r5, r3, r2, r1)
            if (r5 != r4) goto L2f
            r5 = r4
            goto L30
        L2f:
            r5 = r3
        L30:
            if (r5 == 0) goto L17
            r0 = r4
            goto L35
        L34:
            r0 = r3
        L35:
            if (r0 != r4) goto L68
            goto L67
        L38:
            java.util.List<java.lang.String> r0 = r7.f16342b
            if (r0 == 0) goto L68
            boolean r5 = r0.isEmpty()
            if (r5 == 0) goto L43
            goto L64
        L43:
            java.util.Iterator r0 = r0.iterator()
        L47:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L64
            java.lang.Object r5 = r0.next()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r6 = r7.f16341a
            if (r6 == 0) goto L5f
            boolean r5 = p9.h.P(r6, r5, r3, r2, r1)
            if (r5 != r4) goto L5f
            r5 = r4
            goto L60
        L5f:
            r5 = r3
        L60:
            if (r5 == 0) goto L47
            r0 = r4
            goto L65
        L64:
            r0 = r3
        L65:
            if (r0 != r4) goto L68
        L67:
            r3 = r4
        L68:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.yq.a():boolean");
    }

    @Nullable
    public final String b() {
        return this.f16341a;
    }

    public /* synthetic */ yq(String str, List list, boolean z10, int i10, kotlin.jvm.internal.k kVar) {
        this(str, list, (i10 & 4) != 0 ? false : z10);
    }
}
