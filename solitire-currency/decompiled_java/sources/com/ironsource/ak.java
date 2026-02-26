package com.ironsource;

import com.ironsource.mediationsdk.model.InterstitialPlacement;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.po;
import com.ironsource.uc;
import com.unity3d.mediation.LevelPlay;
import com.unity3d.mediation.LevelPlayAdSize;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class ak extends bq {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11299a;

        static {
            int[] iArr = new int[LevelPlay.AdFormat.values().length];
            try {
                iArr[LevelPlay.AdFormat.REWARDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LevelPlay.AdFormat.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LevelPlay.AdFormat.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LevelPlay.AdFormat.NATIVE_AD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f11299a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ak(@NotNull bq sdkConfig) {
        super(sdkConfig);
        kotlin.jvm.internal.t.i(sdkConfig, "sdkConfig");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x007a A[PHI: r8
      0x007a: PHI (r8v18 java.lang.Boolean) = (r8v4 java.lang.Boolean), (r8v13 java.lang.Boolean), (r8v19 java.lang.Boolean) binds: [B:28:0x0078, B:34:0x00a3, B:25:0x006d] A[DONT_GENERATE, DONT_INLINE]] */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.ironsource.c7.b a(@org.jetbrains.annotations.NotNull java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = "adUnitId"
            kotlin.jvm.internal.t.i(r8, r0)
            com.ironsource.jq r0 = r7.g()
            com.ironsource.n8 r0 = r0.a()
            com.ironsource.m6 r0 = r0.b()
            java.util.Map r1 = r0.a()
            java.lang.Object r1 = r1.get(r8)
            com.ironsource.m6$b r1 = (com.ironsource.m6.b) r1
            if (r1 == 0) goto L24
            java.lang.Integer r1 = r1.b()
            if (r1 == 0) goto L24
            goto L2e
        L24:
            com.ironsource.m6$b r1 = r0.b()
            java.lang.Integer r1 = r1.b()
            if (r1 == 0) goto L33
        L2e:
            int r1 = r1.intValue()
            goto L35
        L33:
            r1 = 60
        L35:
            java.util.Map r2 = r0.a()
            java.lang.Object r2 = r2.get(r8)
            com.ironsource.m6$b r2 = (com.ironsource.m6.b) r2
            r3 = 0
            if (r2 == 0) goto L49
            java.lang.Boolean r2 = r2.d()
            if (r2 == 0) goto L49
            goto L53
        L49:
            com.ironsource.m6$b r2 = r0.b()
            java.lang.Boolean r2 = r2.d()
            if (r2 == 0) goto L58
        L53:
            boolean r2 = r2.booleanValue()
            goto L5d
        L58:
            if (r1 <= 0) goto L5c
            r2 = 1
            goto L5d
        L5c:
            r2 = r3
        L5d:
            java.util.Map r4 = r0.a()
            java.lang.Object r8 = r4.get(r8)
            com.ironsource.m6$b r8 = (com.ironsource.m6.b) r8
            if (r8 == 0) goto L70
            java.lang.Boolean r8 = r8.e()
            if (r8 == 0) goto L70
            goto L7a
        L70:
            com.ironsource.m6$b r8 = r0.b()
            java.lang.Boolean r8 = r8.e()
            if (r8 == 0) goto L7f
        L7a:
            boolean r3 = r8.booleanValue()
            goto La6
        L7f:
            com.ironsource.jq r8 = r7.g()
            com.ironsource.n8 r8 = r8.a()
            com.ironsource.s3 r8 = r8.a()
            com.ironsource.q3 r8 = r8.a()
            java.util.Map r8 = r8.a()
            com.unity3d.mediation.LevelPlay$AdFormat r0 = com.unity3d.mediation.LevelPlay.AdFormat.BANNER
            java.lang.Object r8 = r8.get(r0)
            com.ironsource.p r8 = (com.ironsource.p) r8
            if (r8 == 0) goto La2
            java.lang.Boolean r8 = r8.a()
            goto La3
        La2:
            r8 = 0
        La3:
            if (r8 == 0) goto La6
            goto L7a
        La6:
            if (r3 == 0) goto Lab
            com.ironsource.c7$c r8 = com.ironsource.c7.c.TIMED_SHOW
            goto Lad
        Lab:
            com.ironsource.c7$c r8 = com.ironsource.c7.c.TIMED_LOAD
        Lad:
            com.ironsource.c7$b r0 = new com.ironsource.c7$b
            long r3 = (long) r1
            r5 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 * r5
            r0.<init>(r8, r3, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.ak.a(java.lang.String):com.ironsource.c7$b");
    }

    @NotNull
    public final eo b(@NotNull ok tools) {
        kotlin.jvm.internal.t.i(tools, "tools");
        return new eo(tools, g().a().c().d());
    }

    @NotNull
    public final List<LevelPlayAdSize> h() {
        List<String> listA = g().a().b().b().a();
        ArrayList arrayList = new ArrayList(kotlin.collections.w.v(listA, 10));
        Iterator<T> it = listA.iterator();
        while (it.hasNext()) {
            arrayList.add(LevelPlayAdSize.Companion.createAdSize$mediationsdk_release((String) it.next()));
        }
        return arrayList;
    }

    public final long i() {
        long jC = g().a().c().c().c();
        return jC > 0 ? TimeUnit.MINUTES.toMillis(jC) : jC;
    }

    public final float j() {
        return g().a().b().b().c();
    }

    public final boolean k() {
        c1 c1VarA = d().c().a();
        return c1VarA != null && c1VarA.a();
    }

    public final boolean l() {
        return g().a().a().d();
    }

    @Nullable
    public final Placement a(@NotNull LevelPlay.AdFormat adFormat, @Nullable String str) {
        InterstitialPlacement interstitialPlacementA;
        String str2;
        kotlin.jvm.internal.t.i(adFormat, "adFormat");
        int i10 = a.f11299a[adFormat.ordinal()];
        if (i10 == 1) {
            pp ppVarF = d().c().f();
            if (ppVarF != null) {
                Placement placementA = ppVarF.a(str);
                if (placementA == null) {
                    placementA = ppVarF.a();
                }
                if (placementA != null) {
                    return new Placement(placementA.getPlacementId(), placementA.getPlacementName(), placementA.isDefault(), placementA.getRewardName(), placementA.getRewardAmount(), placementA.getPlacementAvailabilitySettings());
                }
            }
            throw new IllegalStateException("Error getting " + adFormat + " configurations");
        }
        if (i10 == 2) {
            hi hiVarD = d().c().d();
            if (hiVarD == null || (interstitialPlacementA = hiVarD.a(str)) == null) {
                return null;
            }
            kotlin.jvm.internal.t.h(interstitialPlacementA, "getInterstitialPlacement(placementName)");
            return new Placement(interstitialPlacementA);
        }
        if (i10 == 3) {
            n6 n6VarC = d().c().c();
            if (n6VarC == null) {
                throw new IllegalStateException("Error getting " + adFormat + " configurations");
            }
            b7 b7VarA = n6VarC.a(str);
            if (b7VarA == null) {
                b7VarA = n6VarC.j();
                str2 = "config.defaultBannerPlacement";
            } else {
                str2 = "config.getBannerPlacemen…ig.defaultBannerPlacement";
            }
            kotlin.jvm.internal.t.h(b7VarA, str2);
            return new Placement(b7VarA);
        }
        if (i10 != 4) {
            throw new v8.q();
        }
        jl jlVarE = d().c().e();
        if (jlVarE != null && str != null) {
            ul ulVarA = jlVarE.a(str);
            if (ulVarA == null) {
                ulVarA = jlVarE.e();
            }
            if (ulVarA != null) {
                return new Placement(ulVarA);
            }
        }
        throw new IllegalStateException("Error getting " + adFormat + " configurations");
    }

    @NotNull
    public final uc.a b(@NotNull String adUnitId) {
        kotlin.jvm.internal.t.i(adUnitId, "adUnitId");
        g().a().c();
        return new uc.a(uc.c.MANUAL_LOAD);
    }

    @NotNull
    public final q1 a(@NotNull ok tools) {
        kotlin.jvm.internal.t.i(tools, "tools");
        return new q1(tools, g().a().c().a());
    }

    @NotNull
    public final List<rm> b(@NotNull LevelPlay.AdFormat adFormat) {
        Map<String, po.b> mapA;
        Set<String> setKeySet;
        List<rm> listC0;
        kotlin.jvm.internal.t.i(adFormat, "adFormat");
        po.a aVar = g().d().a().get(adFormat);
        if (aVar != null && (mapA = aVar.a()) != null && (setKeySet = mapA.keySet()) != null) {
            ArrayList arrayList = new ArrayList(kotlin.collections.w.v(setKeySet, 10));
            Iterator<T> it = setKeySet.iterator();
            while (it.hasNext()) {
                arrayList.add(b(adFormat, (String) it.next()));
            }
            List listX = kotlin.collections.w.x(arrayList);
            if (listX != null && (listC0 = kotlin.collections.d0.c0(listX)) != null) {
                return listC0;
            }
        }
        return kotlin.collections.v.l();
    }

    @NotNull
    public final List<String> a(@NotNull LevelPlay.AdFormat adFormat) {
        Map<String, po.b> mapA;
        Set<String> setKeySet;
        List<String> listP0;
        kotlin.jvm.internal.t.i(adFormat, "adFormat");
        po.a aVar = g().d().a().get(adFormat);
        return (aVar == null || (mapA = aVar.a()) == null || (setKeySet = mapA.keySet()) == null || (listP0 = kotlin.collections.d0.P0(setKeySet)) == null) ? kotlin.collections.v.l() : listP0;
    }

    @NotNull
    public final List<rm> b(@NotNull LevelPlay.AdFormat adFormat, @NotNull String adUnitId) {
        Map<String, po.b> mapA;
        po.b bVar;
        List<String> listA;
        kotlin.jvm.internal.t.i(adFormat, "adFormat");
        kotlin.jvm.internal.t.i(adUnitId, "adUnitId");
        po.a aVar = g().d().a().get(adFormat);
        if (aVar == null || (mapA = aVar.a()) == null || (bVar = mapA.get(adUnitId)) == null || (listA = bVar.a()) == null) {
            return kotlin.collections.v.l();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listA.iterator();
        while (it.hasNext()) {
            rm rmVar = g().e().a().get((String) it.next());
            if (rmVar != null) {
                arrayList.add(rmVar);
            }
        }
        return arrayList;
    }

    public final boolean a(@NotNull String adUnitId, @NotNull LevelPlay.AdFormat adFormat) {
        Map<String, po.b> mapA;
        kotlin.jvm.internal.t.i(adUnitId, "adUnitId");
        kotlin.jvm.internal.t.i(adFormat, "adFormat");
        po.a aVar = g().d().a().get(adFormat);
        return (aVar == null || (mapA = aVar.a()) == null || !mapA.containsKey(adUnitId)) ? false : true;
    }
}
