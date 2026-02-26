package io.ktor.utils.io.internal;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ReadWriteBufferState.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final ByteBuffer f26844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final i f26845b;

    /* JADX INFO: compiled from: ReadWriteBufferState.kt */
    public static final class a extends g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        public static final a f26846c = new a();

        private a() {
            super(h.a(), h.b(), null);
        }

        @NotNull
        public String toString() {
            return "IDLE(empty)";
        }
    }

    /* JADX INFO: compiled from: ReadWriteBufferState.kt */
    public static final class b extends g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private final c f26847c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull c initial) {
            super(initial.f26844a, initial.f26845b, null);
            t.i(initial, "initial");
            this.f26847c = initial;
        }

        @NotNull
        public final c g() {
            return this.f26847c;
        }

        @Override // io.ktor.utils.io.internal.g
        @NotNull
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public d c() {
            return this.f26847c.h();
        }

        @Override // io.ktor.utils.io.internal.g
        @NotNull
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public C0577g d() {
            return this.f26847c.j();
        }

        @NotNull
        public String toString() {
            return "IDLE(with buffer)";
        }
    }

    /* JADX INFO: compiled from: ReadWriteBufferState.kt */
    public static final class c extends g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private final ByteBuffer f26848c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        private final ByteBuffer f26849d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NotNull
        private final b f26850e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @NotNull
        private final d f26851f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @NotNull
        private final C0577g f26852g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @NotNull
        private final e f26853h;

        public /* synthetic */ c(ByteBuffer byteBuffer, int i10, int i11, kotlin.jvm.internal.k kVar) {
            this(byteBuffer, (i11 & 2) != 0 ? 8 : i10);
        }

        @Override // io.ktor.utils.io.internal.g
        @NotNull
        public ByteBuffer a() {
            return this.f26849d;
        }

        @Override // io.ktor.utils.io.internal.g
        @NotNull
        public ByteBuffer b() {
            return this.f26848c;
        }

        @NotNull
        public final b g() {
            return this.f26850e;
        }

        @NotNull
        public final d h() {
            return this.f26851f;
        }

        @NotNull
        public final e i() {
            return this.f26853h;
        }

        @NotNull
        public final C0577g j() {
            return this.f26852g;
        }

        @Override // io.ktor.utils.io.internal.g
        @NotNull
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public d c() {
            return this.f26851f;
        }

        @Override // io.ktor.utils.io.internal.g
        @NotNull
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public C0577g d() {
            return this.f26852g;
        }

        @NotNull
        public String toString() {
            return "Initial";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull ByteBuffer backingBuffer, int i10) {
            super(backingBuffer, new i(backingBuffer.capacity() - i10), null);
            t.i(backingBuffer, "backingBuffer");
            if (!(backingBuffer.position() == 0)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(backingBuffer.limit() == backingBuffer.capacity())) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            ByteBuffer byteBufferDuplicate = backingBuffer.duplicate();
            t.h(byteBufferDuplicate, "backingBuffer.duplicate()");
            this.f26848c = byteBufferDuplicate;
            ByteBuffer byteBufferDuplicate2 = backingBuffer.duplicate();
            t.h(byteBufferDuplicate2, "backingBuffer.duplicate()");
            this.f26849d = byteBufferDuplicate2;
            this.f26850e = new b(this);
            this.f26851f = new d(this);
            this.f26852g = new C0577g(this);
            this.f26853h = new e(this);
        }
    }

    /* JADX INFO: compiled from: ReadWriteBufferState.kt */
    public static final class d extends g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private final c f26854c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull c initial) {
            super(initial.f26844a, initial.f26845b, null);
            t.i(initial, "initial");
            this.f26854c = initial;
        }

        @Override // io.ktor.utils.io.internal.g
        @NotNull
        public ByteBuffer a() {
            return this.f26854c.a();
        }

        @Override // io.ktor.utils.io.internal.g
        @NotNull
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public e d() {
            return this.f26854c.i();
        }

        @Override // io.ktor.utils.io.internal.g
        @NotNull
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public b e() {
            return this.f26854c.g();
        }

        @NotNull
        public String toString() {
            return "Reading";
        }
    }

    /* JADX INFO: compiled from: ReadWriteBufferState.kt */
    public static final class e extends g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private final c f26855c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(@NotNull c initial) {
            super(initial.f26844a, initial.f26845b, null);
            t.i(initial, "initial");
            this.f26855c = initial;
        }

        @Override // io.ktor.utils.io.internal.g
        @NotNull
        public ByteBuffer a() {
            return this.f26855c.a();
        }

        @Override // io.ktor.utils.io.internal.g
        @NotNull
        public ByteBuffer b() {
            return this.f26855c.b();
        }

        @Override // io.ktor.utils.io.internal.g
        @NotNull
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public C0577g e() {
            return this.f26855c.j();
        }

        @Override // io.ktor.utils.io.internal.g
        @NotNull
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public d f() {
            return this.f26855c.h();
        }

        @NotNull
        public String toString() {
            return "Reading+Writing";
        }
    }

    /* JADX INFO: compiled from: ReadWriteBufferState.kt */
    public static final class f extends g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        public static final f f26856c = new f();

        private f() {
            super(h.a(), h.b(), null);
        }

        @NotNull
        public String toString() {
            return "Terminated";
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.internal.g$g, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ReadWriteBufferState.kt */
    public static final class C0577g extends g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private final c f26857c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0577g(@NotNull c initial) {
            super(initial.f26844a, initial.f26845b, null);
            t.i(initial, "initial");
            this.f26857c = initial;
        }

        @Override // io.ktor.utils.io.internal.g
        @NotNull
        public ByteBuffer b() {
            return this.f26857c.b();
        }

        @Override // io.ktor.utils.io.internal.g
        @NotNull
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public e c() {
            return this.f26857c.i();
        }

        @Override // io.ktor.utils.io.internal.g
        @NotNull
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public b f() {
            return this.f26857c.g();
        }

        @NotNull
        public String toString() {
            return "Writing";
        }
    }

    public /* synthetic */ g(ByteBuffer byteBuffer, i iVar, kotlin.jvm.internal.k kVar) {
        this(byteBuffer, iVar);
    }

    @NotNull
    public ByteBuffer a() {
        throw new IllegalStateException(("read buffer is not available in state " + this).toString());
    }

    @NotNull
    public ByteBuffer b() {
        throw new IllegalStateException(("write buffer is not available in state " + this).toString());
    }

    @NotNull
    public g c() {
        throw new IllegalStateException(("ByteChannel[state: " + this + "] Concurrent reading is not supported").toString());
    }

    @NotNull
    public g d() {
        throw new IllegalStateException(("ByteChannel[state: " + this + "] Concurrent writing is not supported").toString());
    }

    @NotNull
    public g e() {
        throw new IllegalStateException(("Unable to stop reading in state " + this).toString());
    }

    @NotNull
    public g f() {
        throw new IllegalStateException(("Unable to stop writing in state " + this).toString());
    }

    private g(ByteBuffer byteBuffer, i iVar) {
        this.f26844a = byteBuffer;
        this.f26845b = iVar;
    }
}
