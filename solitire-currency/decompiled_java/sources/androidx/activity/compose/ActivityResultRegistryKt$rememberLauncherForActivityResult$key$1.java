package androidx.activity.compose;

import java.util.UUID;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ActivityResultRegistry.kt */
/* JADX INFO: loaded from: classes.dex */
final class ActivityResultRegistryKt$rememberLauncherForActivityResult$key$1 extends v implements h9.a<String> {
    public static final ActivityResultRegistryKt$rememberLauncherForActivityResult$key$1 INSTANCE = new ActivityResultRegistryKt$rememberLauncherForActivityResult$key$1();

    ActivityResultRegistryKt$rememberLauncherForActivityResult$key$1() {
        super(0);
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return UUID.randomUUID().toString();
    }
}
