package androidx.compose.ui.window;

import h9.a;
import java.util.UUID;
import kotlin.jvm.internal.v;

/* JADX INFO: compiled from: AndroidDialog.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidDialog_androidKt$Dialog$dialogId$1 extends v implements a<UUID> {
    public static final AndroidDialog_androidKt$Dialog$dialogId$1 INSTANCE = new AndroidDialog_androidKt$Dialog$dialogId$1();

    AndroidDialog_androidKt$Dialog$dialogId$1() {
        super(0);
    }

    @Override // h9.a
    public final UUID invoke() {
        return UUID.randomUUID();
    }
}
