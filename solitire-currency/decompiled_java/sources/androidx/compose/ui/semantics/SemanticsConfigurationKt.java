package androidx.compose.ui.semantics;

import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SemanticsConfiguration.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SemanticsConfigurationKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.compose.ui.semantics.SemanticsConfigurationKt$getOrNull$1, reason: invalid class name */
    /* JADX INFO: compiled from: SemanticsConfiguration.kt */
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

    @Nullable
    public static final <T> T getOrNull(@NotNull SemanticsConfiguration semanticsConfiguration, @NotNull SemanticsPropertyKey<T> key) {
        t.i(semanticsConfiguration, "<this>");
        t.i(key, "key");
        return (T) semanticsConfiguration.getOrElseNullable(key, AnonymousClass1.INSTANCE);
    }
}
