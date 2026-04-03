package oa;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ErrorCode.kt */
/* JADX INFO: loaded from: classes5.dex */
public enum b {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    SETTINGS_TIMEOUT(4),
    STREAM_CLOSED(5),
    FRAME_SIZE_ERROR(6),
    REFUSED_STREAM(7),
    CANCEL(8),
    COMPRESSION_ERROR(9),
    CONNECT_ERROR(10),
    ENHANCE_YOUR_CALM(11),
    INADEQUATE_SECURITY(12),
    HTTP_1_1_REQUIRED(13);


    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f32086b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f32102a;

    /* JADX INFO: compiled from: ErrorCode.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @Nullable
        public final b a(int i10) {
            for (b bVar : b.values()) {
                if (bVar.c() == i10) {
                    return bVar;
                }
            }
            return null;
        }
    }

    b(int i10) {
        this.f32102a = i10;
    }

    public final int c() {
        return this.f32102a;
    }
}
