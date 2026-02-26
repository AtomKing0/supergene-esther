package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SlidingWindow.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class b1 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: SlidingWindow.kt */
    @kotlin.coroutines.jvm.internal.f(c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", l = {34, 40, 49, 55, 58}, m = "invokeSuspend")
    static final class a<T> extends kotlin.coroutines.jvm.internal.k implements h9.p<o9.i<? super List<? extends T>>, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f29745j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f29746k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f29747l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f29748m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private /* synthetic */ Object f29749n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        final /* synthetic */ int f29750o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        final /* synthetic */ int f29751p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        final /* synthetic */ Iterator<T> f29752q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        final /* synthetic */ boolean f29753r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ boolean f29754s;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(int i10, int i11, Iterator<? extends T> it, boolean z10, boolean z11, z8.d<? super a> dVar) {
            super(2, dVar);
            this.f29750o = i10;
            this.f29751p = i11;
            this.f29752q = it;
            this.f29753r = z10;
            this.f29754s = z11;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            a aVar = new a(this.f29750o, this.f29751p, this.f29752q, this.f29753r, this.f29754s, dVar);
            aVar.f29749n = obj;
            return aVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00ad  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00b1  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00dc A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:47:0x00ec  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x012a  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x0134  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0154  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00a6 -> B:16:0x0058). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x011d -> B:59:0x0120). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x014b -> B:72:0x014e). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
            /*
                Method dump skipped, instruction units count: 365
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.b1.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o9.i<? super List<? extends T>> iVar, @Nullable z8.d<? super v8.k0> dVar) {
            return ((a) create(iVar, dVar)).invokeSuspend(v8.k0.f35197a);
        }
    }

    public static final void a(int i10, int i11) {
        String str;
        if (i10 > 0 && i11 > 0) {
            return;
        }
        if (i10 != i11) {
            str = "Both size " + i10 + " and step " + i11 + " must be greater than zero.";
        } else {
            str = "size " + i10 + " must be greater than zero.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    @NotNull
    public static final <T> Iterator<List<T>> b(@NotNull Iterator<? extends T> iterator, int i10, int i11, boolean z10, boolean z11) {
        kotlin.jvm.internal.t.i(iterator, "iterator");
        return !iterator.hasNext() ? e0.f29773a : o9.k.a(new a(i10, i11, iterator, z11, z10, null));
    }
}
