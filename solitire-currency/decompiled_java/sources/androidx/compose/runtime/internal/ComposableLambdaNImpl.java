package androidx.compose.runtime.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Stable;
import h9.p;
import h9.x;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.r0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ComposableLambdaN.jvm.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
public final class ComposableLambdaNImpl implements ComposableLambdaN {

    @Nullable
    private Object _block;
    private final int arity;
    private final int key;

    @Nullable
    private RecomposeScope scope;

    @Nullable
    private List<RecomposeScope> scopes;
    private final boolean tracked;

    /* JADX INFO: renamed from: androidx.compose.runtime.internal.ComposableLambdaNImpl$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: ComposableLambdaN.jvm.kt */
    static final class AnonymousClass1 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ Object[] $args;
        final /* synthetic */ int $realParams;
        final /* synthetic */ ComposableLambdaNImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Object[] objArr, int i10, ComposableLambdaNImpl composableLambdaNImpl) {
            super(2);
            this.$args = objArr;
            this.$realParams = i10;
            this.this$0 = composableLambdaNImpl;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@NotNull Composer nc, int i10) {
            t.i(nc, "nc");
            Object[] array = kotlin.collections.p.j0(this.$args, o.u(0, this.$realParams)).toArray(new Object[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            Object obj = this.$args[this.$realParams + 1];
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
            int iIntValue = ((Integer) obj).intValue();
            Object[] objArr = this.$args;
            Object[] array2 = kotlin.collections.p.j0(objArr, o.u(this.$realParams + 2, objArr.length)).toArray(new Object[0]);
            if (array2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            ComposableLambdaNImpl composableLambdaNImpl = this.this$0;
            r0 r0Var = new r0(4);
            r0Var.b(array);
            r0Var.a(nc);
            r0Var.a(Integer.valueOf(iIntValue | 1));
            r0Var.b(array2);
            composableLambdaNImpl.invoke(r0Var.d(new Object[r0Var.c()]));
        }
    }

    public ComposableLambdaNImpl(int i10, boolean z10, int i11) {
        this.key = i10;
        this.tracked = z10;
        this.arity = i11;
    }

    private final int realParamCount(int i10) {
        int i11 = (i10 - 1) - 1;
        for (int i12 = 1; i12 * 10 < i11; i12++) {
            i11--;
        }
        return i11;
    }

    private final void trackRead(Composer composer) {
        RecomposeScope recomposeScope;
        if (!this.tracked || (recomposeScope = composer.getRecomposeScope()) == null) {
            return;
        }
        composer.recordUsed(recomposeScope);
        if (ComposableLambdaKt.replacableWith(this.scope, recomposeScope)) {
            this.scope = recomposeScope;
            return;
        }
        List<RecomposeScope> list = this.scopes;
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            this.scopes = arrayList;
            arrayList.add(recomposeScope);
            return;
        }
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (ComposableLambdaKt.replacableWith(list.get(i10), recomposeScope)) {
                list.set(i10, recomposeScope);
                return;
            }
        }
        list.add(recomposeScope);
    }

    private final void trackWrite() {
        if (this.tracked) {
            RecomposeScope recomposeScope = this.scope;
            if (recomposeScope != null) {
                recomposeScope.invalidate();
                this.scope = null;
            }
            List<RecomposeScope> list = this.scopes;
            if (list != null) {
                int size = list.size();
                for (int i10 = 0; i10 < size; i10++) {
                    list.get(i10).invalidate();
                }
                list.clear();
            }
        }
    }

    @Override // androidx.compose.runtime.internal.ComposableLambdaN, kotlin.jvm.internal.o
    public int getArity() {
        return this.arity;
    }

    public final int getKey() {
        return this.key;
    }

    @Override // androidx.compose.runtime.internal.ComposableLambdaN, h9.x
    @Nullable
    public Object invoke(@NotNull Object... args) {
        t.i(args, "args");
        int iRealParamCount = realParamCount(args.length);
        Object obj = args[iRealParamCount];
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.Composer");
        }
        Composer composer = (Composer) obj;
        Object[] array = kotlin.collections.p.j0(args, o.u(0, args.length - 1)).toArray(new Object[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        Object obj2 = args[args.length - 1];
        if (obj2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        int iIntValue = ((Integer) obj2).intValue();
        Composer composerStartRestartGroup = composer.startRestartGroup(this.key);
        trackRead(composerStartRestartGroup);
        int iDifferentBits = iIntValue | (composerStartRestartGroup.changed(this) ? ComposableLambdaKt.differentBits(iRealParamCount) : ComposableLambdaKt.sameBits(iRealParamCount));
        Object obj3 = this._block;
        if (obj3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.jvm.functions.FunctionN<*>");
        }
        r0 r0Var = new r0(2);
        r0Var.b(array);
        r0Var.a(Integer.valueOf(iDifferentBits));
        Object objInvoke = ((x) obj3).invoke(r0Var.d(new Object[r0Var.c()]));
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(args, iRealParamCount, this));
        }
        return objInvoke;
    }

    public final void update(@NotNull Object block) {
        t.i(block, "block");
        if (t.d(block, this._block)) {
            return;
        }
        boolean z10 = this._block == null;
        this._block = (x) block;
        if (z10) {
            return;
        }
        trackWrite();
    }
}
