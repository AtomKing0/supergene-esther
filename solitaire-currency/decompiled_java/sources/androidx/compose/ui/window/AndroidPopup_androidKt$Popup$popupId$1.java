package androidx.compose.ui.window;

import h9.a;
import java.util.UUID;
import kotlin.jvm.internal.v;

/* JADX INFO: compiled from: AndroidPopup.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidPopup_androidKt$Popup$popupId$1 extends v implements a<UUID> {
    public static final AndroidPopup_androidKt$Popup$popupId$1 INSTANCE = new AndroidPopup_androidKt$Popup$popupId$1();

    AndroidPopup_androidKt$Popup$popupId$1() {
        super(0);
    }

    @Override // h9.a
    public final UUID invoke() {
        return UUID.randomUUID();
    }
}
