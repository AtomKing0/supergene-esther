package t9;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u9.l0;
import v8.k0;

/* JADX INFO: compiled from: ChannelFlow.kt */
/* JADX INFO: loaded from: classes5.dex */
final class z<T> implements s9.i<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final z8.g f34186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Object f34187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final h9.p<T, z8.d<? super k0>, Object> f34188c;

    /* JADX INFO: compiled from: ChannelFlow.kt */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.internal.UndispatchedContextCollector$emitRef$1", f = "ChannelFlow.kt", l = {212}, m = "invokeSuspend")
    static final class a extends kotlin.coroutines.jvm.internal.l implements h9.p<T, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f34189j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        /* synthetic */ Object f34190k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ s9.i<T> f34191l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(s9.i<? super T> iVar, z8.d<? super a> dVar) {
            super(2, dVar);
            this.f34191l = iVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            a aVar = new a(this.f34191l, dVar);
            aVar.f34190k = obj;
            return aVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f34189j;
            if (i10 == 0) {
                v8.u.b(obj);
                Object obj2 = this.f34190k;
                s9.i<T> iVar = this.f34191l;
                this.f34189j = 1;
                if (iVar.emit(obj2, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
            }
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(T t10, @Nullable z8.d<? super k0> dVar) {
            return ((a) create(t10, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    public z(@NotNull s9.i<? super T> iVar, @NotNull z8.g gVar) {
        this.f34186a = gVar;
        this.f34187b = l0.b(gVar);
        this.f34188c = new a(iVar, null);
    }

    @Override // s9.i
    @Nullable
    public Object emit(T t10, @NotNull z8.d<? super k0> dVar) {
        Object objB = f.b(this.f34186a, t10, this.f34187b, this.f34188c, dVar);
        return objB == a9.d.e() ? objB : k0.f35197a;
    }
}
