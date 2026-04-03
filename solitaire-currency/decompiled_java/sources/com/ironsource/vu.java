package com.ironsource;

import com.ironsource.k7;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public abstract class vu<Smash extends k7<?>> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public static final a f15970g = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f15971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f15972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final List<Smash> f15973c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final List<Smash> f15974d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final List<Smash> f15975e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final List<Smash> f15976f;

    public static final class a {

        /* JADX INFO: renamed from: com.ironsource.vu$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0273a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f15977a;

            static {
                int[] iArr = new int[ru.values().length];
                try {
                    iArr[ru.DEFAULT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ru.BIDDER_SENSITIVE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f15977a = iArr;
            }
        }

        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final <Smash extends k7<?>> vu<Smash> a(@NotNull ru loadingStrategy, int i10, boolean z10, @NotNull List<? extends Smash> waterfall) {
            kotlin.jvm.internal.t.i(loadingStrategy, "loadingStrategy");
            kotlin.jvm.internal.t.i(waterfall, "waterfall");
            int i11 = C0273a.f15977a[loadingStrategy.ordinal()];
            if (i11 == 1) {
                return new w9(i10, z10, waterfall);
            }
            if (i11 == 2) {
                return new p7(i10, z10, waterfall, false, 8, null);
            }
            throw new v8.q();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public vu(int i10, boolean z10, @NotNull List<? extends Smash> waterfall) {
        kotlin.jvm.internal.t.i(waterfall, "waterfall");
        this.f15971a = i10;
        this.f15972b = z10;
        this.f15973c = waterfall;
        this.f15974d = new ArrayList();
        this.f15975e = new ArrayList();
        this.f15976f = new ArrayList();
    }

    private final int a(Smash smash) {
        return smash.i().k();
    }

    private final int b() {
        Integer num;
        List<Smash> list = this.f15973c;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((k7) obj).y()) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            Integer numValueOf = Integer.valueOf(a((k7) it.next()));
            while (it.hasNext()) {
                Integer numValueOf2 = Integer.valueOf(a((k7) it.next()));
                if (numValueOf.compareTo(numValueOf2) > 0) {
                    numValueOf = numValueOf2;
                }
            }
            num = numValueOf;
        } else {
            num = null;
        }
        if (num != null) {
            return num.intValue();
        }
        return Integer.MAX_VALUE;
    }

    @NotNull
    public final List<Smash> c() {
        return this.f15974d;
    }

    public abstract void c(@NotNull Smash smash);

    public final int d() {
        return this.f15974d.size() + this.f15975e.size() + this.f15976f.size();
    }

    public boolean e() {
        return d() >= this.f15971a;
    }

    private final boolean b(Smash smash) {
        return b() < a(smash);
    }

    @NotNull
    public final List<Smash> a() {
        return this.f15976f;
    }

    public final void d(@NotNull Smash smash) {
        IronLog ironLog;
        String str;
        IronLog ironLog2;
        StringBuilder sb;
        String str2;
        List<Smash> list;
        kotlin.jvm.internal.t.i(smash, "smash");
        if (!smash.x()) {
            if (smash.y()) {
                IronLog.INTERNAL.verbose(smash.g().name() + " - Smash " + smash.k() + " is already loaded");
                list = this.f15975e;
            } else {
                if (smash.z()) {
                    ironLog2 = IronLog.INTERNAL;
                    sb = new StringBuilder();
                    sb.append(smash.g().name());
                    sb.append(" - Smash ");
                    sb.append(smash.k());
                    str2 = " still loading";
                } else if (smash.A().get()) {
                    ironLog2 = IronLog.INTERNAL;
                    sb = new StringBuilder();
                    sb.append(smash.g().name());
                    sb.append(" - Smash ");
                    sb.append(smash.k());
                    str2 = " marked as loading candidate";
                } else {
                    if (!this.f15972b || !b(smash)) {
                        c(smash);
                        return;
                    }
                    ironLog = IronLog.INTERNAL;
                    str = smash.g().name() + " - Smash " + smash.k() + " is not better than already loaded smashes";
                }
                sb.append(str2);
                ironLog2.verbose(sb.toString());
                list = this.f15976f;
            }
            list.add(smash);
            return;
        }
        ironLog = IronLog.INTERNAL;
        str = smash.g().name() + " - smash " + smash.k() + " is failed to load";
        ironLog.verbose(str);
    }
}
