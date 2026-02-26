package o9;

import java.util.Iterator;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes5.dex */
public class m extends l {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a<T> implements g<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterator f32068a;

        public a(Iterator it) {
            this.f32068a = it;
        }

        @Override // o9.g
        @NotNull
        public Iterator<T> iterator() {
            return this.f32068a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Sequences.kt */
    static final class b<T> extends v implements h9.a<T> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ T f32069g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(T t10) {
            super(0);
            this.f32069g = t10;
        }

        @Override // h9.a
        @Nullable
        public final T invoke() {
            return this.f32069g;
        }
    }

    @NotNull
    public static <T> g<T> c(@NotNull Iterator<? extends T> it) {
        t.i(it, "<this>");
        return d(new a(it));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static <T> g<T> d(@NotNull g<? extends T> gVar) {
        t.i(gVar, "<this>");
        return gVar instanceof o9.a ? gVar : new o9.a(gVar);
    }

    @NotNull
    public static <T> g<T> e() {
        return d.f32050a;
    }

    @NotNull
    public static <T> g<T> f(@Nullable T t10, @NotNull h9.l<? super T, ? extends T> nextFunction) {
        t.i(nextFunction, "nextFunction");
        return t10 == null ? d.f32050a : new f(new b(t10), nextFunction);
    }

    @NotNull
    public static <T> g<T> g(@NotNull T... elements) {
        t.i(elements, "elements");
        return elements.length == 0 ? e() : kotlin.collections.p.C(elements);
    }
}
