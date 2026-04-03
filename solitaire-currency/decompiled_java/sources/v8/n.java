package v8;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: LazyJVM.kt */
/* JADX INFO: loaded from: classes5.dex */
public class n {

    /* JADX INFO: compiled from: LazyJVM.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f35200a;

        static {
            int[] iArr = new int[p.values().length];
            try {
                iArr[p.f35201a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[p.f35202b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[p.f35203c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f35200a = iArr;
        }
    }

    @NotNull
    public static <T> l<T> a(@NotNull h9.a<? extends T> initializer) {
        kotlin.jvm.internal.t.i(initializer, "initializer");
        kotlin.jvm.internal.k kVar = null;
        return new w(initializer, kVar, 2, kVar);
    }

    @NotNull
    public static <T> l<T> b(@NotNull p mode, @NotNull h9.a<? extends T> initializer) {
        kotlin.jvm.internal.t.i(mode, "mode");
        kotlin.jvm.internal.t.i(initializer, "initializer");
        int i10 = a.f35200a[mode.ordinal()];
        int i11 = 2;
        if (i10 == 1) {
            kotlin.jvm.internal.k kVar = null;
            return new w(initializer, kVar, i11, kVar);
        }
        if (i10 == 2) {
            return new v(initializer);
        }
        if (i10 == 3) {
            return new l0(initializer);
        }
        throw new q();
    }
}
