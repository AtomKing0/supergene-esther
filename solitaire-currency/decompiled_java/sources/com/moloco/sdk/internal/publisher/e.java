package com.moloco.sdk.internal.publisher;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.q0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final Map<b0, q9.b> f17936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f17937b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17938a;

        static {
            int[] iArr = new int[b0.values().length];
            try {
                iArr[b0.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[b0.BANNER_TABLET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[b0.MREC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[b0.INTERSTITIAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[b0.REWARDED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[b0.NATIVE_BANNER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[b0.NATIVE_AD_MEDIATION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f17938a = iArr;
        }
    }

    public /* synthetic */ e(Map map, long j10, kotlin.jvm.internal.k kVar) {
        this(map, j10);
    }

    @NotNull
    public final Map<b0, q9.b> a() {
        return this.f17936a;
    }

    public final long b() {
        return this.f17937b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return kotlin.jvm.internal.t.d(this.f17936a, eVar.f17936a) && q9.b.l(this.f17937b, eVar.f17937b);
    }

    public int hashCode() {
        return (this.f17936a.hashCode() * 31) + q9.b.y(this.f17937b);
    }

    @NotNull
    public String toString() {
        return "AdCreatorConfiguration(adTimeouts=" + this.f17936a + ", defaultTimeoutDuration=" + ((Object) q9.b.I(this.f17937b)) + ')';
    }

    public e(Map<b0, q9.b> adTimeouts, long j10) {
        kotlin.jvm.internal.t.i(adTimeouts, "adTimeouts");
        this.f17936a = adTimeouts;
        this.f17937b = j10;
    }

    public /* synthetic */ e(Map map, long j10, int i10, kotlin.jvm.internal.k kVar) {
        long jS;
        if ((i10 & 1) != 0) {
            b0[] b0VarArrValues = b0.values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(n9.o.e(q0.d(b0VarArrValues.length), 16));
            for (b0 b0Var : b0VarArrValues) {
                switch (a.f17938a[b0Var.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                        jS = q9.d.s(5, q9.e.f33187e);
                        break;
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        jS = q9.d.s(15, q9.e.f33187e);
                        break;
                    default:
                        throw new v8.q();
                }
                linkedHashMap.put(b0Var, q9.b.g(jS));
            }
            map = linkedHashMap;
        }
        this(map, (i10 & 2) != 0 ? q9.d.s(5, q9.e.f33187e) : j10, null);
    }
}
