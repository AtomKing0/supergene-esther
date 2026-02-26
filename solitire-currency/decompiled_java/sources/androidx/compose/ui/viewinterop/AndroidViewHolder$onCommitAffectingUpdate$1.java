package androidx.compose.ui.viewinterop;

import android.os.Handler;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: AndroidViewHolder.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidViewHolder$onCommitAffectingUpdate$1 extends v implements l<AndroidViewHolder, k0> {
    final /* synthetic */ AndroidViewHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidViewHolder$onCommitAffectingUpdate$1(AndroidViewHolder androidViewHolder) {
        super(1);
        this.this$0 = androidViewHolder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: invoke$lambda-0, reason: not valid java name */
    public static final void m3910invoke$lambda0(h9.a tmp0) {
        t.i(tmp0, "$tmp0");
        tmp0.invoke();
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(AndroidViewHolder androidViewHolder) {
        invoke2(androidViewHolder);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull AndroidViewHolder it) {
        t.i(it, "it");
        Handler handler = this.this$0.getHandler();
        final h9.a aVar = this.this$0.runUpdate;
        handler.post(new Runnable() { // from class: androidx.compose.ui.viewinterop.a
            @Override // java.lang.Runnable
            public final void run() {
                AndroidViewHolder$onCommitAffectingUpdate$1.m3910invoke$lambda0(aVar);
            }
        });
    }
}
