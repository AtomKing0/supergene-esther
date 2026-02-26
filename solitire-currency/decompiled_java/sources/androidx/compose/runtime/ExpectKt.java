package androidx.compose.runtime;

import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Expect.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ExpectKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.compose.runtime.ExpectKt$ThreadLocal$1, reason: invalid class name */
    /* JADX INFO: compiled from: Expect.kt */
    static final class AnonymousClass1<T> extends v implements h9.a<T> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        @Override // h9.a
        @Nullable
        public final T invoke() {
            return null;
        }
    }

    @NotNull
    public static final <T> ThreadLocal<T> ThreadLocal() {
        return new ThreadLocal<>(AnonymousClass1.INSTANCE);
    }

    public static final int postIncrement(@NotNull AtomicInt atomicInt) {
        t.i(atomicInt, "<this>");
        return atomicInt.add(1) - 1;
    }
}
