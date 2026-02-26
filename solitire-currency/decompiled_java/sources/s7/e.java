package s7;

import h9.l;
import java.io.IOException;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.b2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v7.g;
import v7.h;
import v8.k0;
import z8.g;

/* JADX INFO: compiled from: HttpClient.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: compiled from: HttpClient.kt */
    static final class a extends v implements l<Throwable, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ v7.b f33629g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(v7.b bVar) {
            super(1);
            this.f33629g = bVar;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Throwable th) throws IOException {
            invoke2(th);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable Throwable th) throws IOException {
            this.f33629g.close();
        }
    }

    @NotNull
    public static final <T extends g> s7.a a(@NotNull h<? extends T> engineFactory, @NotNull l<? super b<T>, k0> block) {
        t.i(engineFactory, "engineFactory");
        t.i(block, "block");
        b bVar = new b();
        block.invoke(bVar);
        v7.b bVarA = engineFactory.a(bVar.c());
        s7.a aVar = new s7.a(bVarA, bVar, true);
        g.b bVar2 = aVar.getCoroutineContext().get(b2.O7);
        t.f(bVar2);
        ((b2) bVar2).J(new a(bVarA));
        return aVar;
    }
}
