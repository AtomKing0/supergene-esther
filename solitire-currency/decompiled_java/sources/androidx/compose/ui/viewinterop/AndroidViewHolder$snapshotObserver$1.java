package androidx.compose.ui.viewinterop;

import android.os.Looper;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: AndroidViewHolder.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidViewHolder$snapshotObserver$1 extends v implements l<h9.a<? extends k0>, k0> {
    final /* synthetic */ AndroidViewHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidViewHolder$snapshotObserver$1(AndroidViewHolder androidViewHolder) {
        super(1);
        this.this$0 = androidViewHolder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: invoke$lambda-0, reason: not valid java name */
    public static final void m3911invoke$lambda0(h9.a tmp0) {
        t.i(tmp0, "$tmp0");
        tmp0.invoke();
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(h9.a<? extends k0> aVar) {
        invoke2((h9.a<k0>) aVar);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull final h9.a<k0> command) {
        t.i(command, "command");
        if (this.this$0.getHandler().getLooper() == Looper.myLooper()) {
            command.invoke();
        } else {
            this.this$0.getHandler().post(new Runnable() { // from class: androidx.compose.ui.viewinterop.b
                @Override // java.lang.Runnable
                public final void run() {
                    AndroidViewHolder$snapshotObserver$1.m3911invoke$lambda0(command);
                }
            });
        }
    }
}
