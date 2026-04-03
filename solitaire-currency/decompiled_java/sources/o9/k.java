package o9;

import java.util.Iterator;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: SequenceBuilder.kt */
/* JADX INFO: loaded from: classes5.dex */
public class k {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Sequences.kt */
    public static final class a<T> implements g<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h9.p f32067a;

        public a(h9.p pVar) {
            this.f32067a = pVar;
        }

        @Override // o9.g
        @NotNull
        public Iterator<T> iterator() {
            return k.a(this.f32067a);
        }
    }

    @NotNull
    public static <T> Iterator<T> a(@NotNull h9.p<? super i<? super T>, ? super z8.d<? super k0>, ? extends Object> block) {
        t.i(block, "block");
        h hVar = new h();
        hVar.h(a9.c.a(block, hVar, hVar));
        return hVar;
    }

    @NotNull
    public static <T> g<T> b(@NotNull h9.p<? super i<? super T>, ? super z8.d<? super k0>, ? extends Object> block) {
        t.i(block, "block");
        return new a(block);
    }
}
