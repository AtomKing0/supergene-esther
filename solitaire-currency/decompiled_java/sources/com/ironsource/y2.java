package com.ironsource;

import android.content.Context;
import com.ironsource.mediationsdk.logger.IronLog;
import com.unity3d.mediation.LevelPlayAdSize;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class y2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f16241b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f16242c = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final h1 f16243a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return x8.b.a(Integer.valueOf(((LevelPlayAdSize) t11).getWidth()), Integer.valueOf(((LevelPlayAdSize) t10).getWidth()));
        }
    }

    public static final class c<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f16244a;

        public c(Comparator comparator) {
            this.f16244a = comparator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            int iCompare = this.f16244a.compare(t10, t11);
            return iCompare != 0 ? iCompare : x8.b.a(Integer.valueOf(((LevelPlayAdSize) t11).getHeight()), Integer.valueOf(((LevelPlayAdSize) t10).getHeight()));
        }
    }

    public y2(@NotNull h1 adSizeTools) {
        kotlin.jvm.internal.t.i(adSizeTools, "adSizeTools");
        this.f16243a = adSizeTools;
    }

    private final int a(Integer num, Context context) {
        if (num != null && num.intValue() < 0) {
            IronLog.API.info(h1.a(this.f16243a, "Width is invalid, screen width will be used", (String) null, 2, (Object) null));
        } else if (num != null) {
            return num.intValue();
        }
        return na.f14102a.b(context);
    }

    @Nullable
    public final LevelPlayAdSize a(@NotNull Context context, @Nullable Integer num) {
        int i10;
        LevelPlayAdSize levelPlayAdSizeCreateCustomSize;
        kotlin.jvm.internal.t.i(context, "context");
        if (!this.f16243a.d()) {
            IronLog.API.error(h1.a(this.f16243a, "The SDK must be successfully initialized to create an Adaptive Ad Size", (String) null, 2, (Object) null));
            return null;
        }
        int iA = a(num, context);
        int iB = this.f16243a.b(context);
        int iA2 = this.f16243a.a(iA);
        List<LevelPlayAdSize> listA = a();
        for (LevelPlayAdSize levelPlayAdSize : a(listA, iB, iA)) {
            if (levelPlayAdSize.getWidth() <= iA && (levelPlayAdSize.getHeight() <= iA2 || iA2 == -1)) {
                iA2 = Math.max(iA2, levelPlayAdSize.getHeight());
                break;
            }
        }
        levelPlayAdSize = null;
        if (levelPlayAdSize == null) {
            int height = ((LevelPlayAdSize) kotlin.collections.d0.t0(listA)).getHeight();
            i10 = height;
            levelPlayAdSizeCreateCustomSize = LevelPlayAdSize.Companion.createCustomSize(iA, height);
        } else {
            i10 = iA2;
            levelPlayAdSizeCreateCustomSize = levelPlayAdSize;
        }
        IronLog.INTERNAL.info(h1.a(this.f16243a, "Adaptive: " + iA + 'x' + i10 + " Fallback: " + levelPlayAdSizeCreateCustomSize, (String) null, 2, (Object) null));
        return new LevelPlayAdSize(iA, i10, "CUSTOM", true, levelPlayAdSizeCreateCustomSize);
    }

    private final List<LevelPlayAdSize> a() {
        return kotlin.collections.d0.I0(this.f16243a.b(), new c(new b()));
    }

    private final List<LevelPlayAdSize> a(List<LevelPlayAdSize> list, int i10, int i11) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            LevelPlayAdSize levelPlayAdSize = (LevelPlayAdSize) obj;
            if (levelPlayAdSize.getHeight() <= i10 && levelPlayAdSize.getWidth() <= i11) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
