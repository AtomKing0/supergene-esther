package w7;

import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v7.h;
import v8.k0;

/* JADX INFO: compiled from: Android.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements h<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f35435a = new a();

    private a() {
    }

    @Override // v7.h
    @NotNull
    public v7.b a(@NotNull l<? super d, k0> block) {
        t.i(block, "block");
        d dVar = new d();
        block.invoke(dVar);
        return new b(dVar);
    }
}
