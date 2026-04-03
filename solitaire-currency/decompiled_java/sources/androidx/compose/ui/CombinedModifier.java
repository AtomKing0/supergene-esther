package androidx.compose.ui;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import h9.l;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Modifier.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class CombinedModifier implements Modifier {
    public static final int $stable = 0;

    @NotNull
    private final Modifier inner;

    @NotNull
    private final Modifier outer;

    /* JADX INFO: renamed from: androidx.compose.ui.CombinedModifier$toString$1, reason: invalid class name */
    /* JADX INFO: compiled from: Modifier.kt */
    static final class AnonymousClass1 extends v implements p<String, Modifier.Element, String> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(2);
        }

        @Override // h9.p
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final String mo4invoke(@NotNull String acc, @NotNull Modifier.Element element) {
            t.i(acc, "acc");
            t.i(element, "element");
            if (acc.length() == 0) {
                return element.toString();
            }
            return acc + ", " + element;
        }
    }

    public CombinedModifier(@NotNull Modifier outer, @NotNull Modifier inner) {
        t.i(outer, "outer");
        t.i(inner, "inner");
        this.outer = outer;
        this.inner = inner;
    }

    @Override // androidx.compose.ui.Modifier
    public boolean all(@NotNull l<? super Modifier.Element, Boolean> predicate) {
        t.i(predicate, "predicate");
        return this.outer.all(predicate) && this.inner.all(predicate);
    }

    @Override // androidx.compose.ui.Modifier
    public boolean any(@NotNull l<? super Modifier.Element, Boolean> predicate) {
        t.i(predicate, "predicate");
        return this.outer.any(predicate) || this.inner.any(predicate);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof CombinedModifier) {
            CombinedModifier combinedModifier = (CombinedModifier) obj;
            if (t.d(this.outer, combinedModifier.outer) && t.d(this.inner, combinedModifier.inner)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.Modifier
    public <R> R foldIn(R r10, @NotNull p<? super R, ? super Modifier.Element, ? extends R> operation) {
        t.i(operation, "operation");
        return (R) this.inner.foldIn(this.outer.foldIn(r10, operation), operation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.Modifier
    public <R> R foldOut(R r10, @NotNull p<? super Modifier.Element, ? super R, ? extends R> operation) {
        t.i(operation, "operation");
        return (R) this.outer.foldOut(this.inner.foldOut(r10, operation), operation);
    }

    public int hashCode() {
        return this.outer.hashCode() + (this.inner.hashCode() * 31);
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return a.a(this, modifier);
    }

    @NotNull
    public String toString() {
        return '[' + ((String) foldIn("", AnonymousClass1.INSTANCE)) + ']';
    }
}
